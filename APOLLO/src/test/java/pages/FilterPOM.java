package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterPOM {
	private final WebDriver driver;

	@FindBy(xpath = "//span[text()='Filters']")
	WebElement filter;

	@FindBy(xpath = "//span[text()='Availability']")
	WebElement clickAvailability;

	@FindBy(xpath = "//span[text()='Fees']")
	WebElement clickFees;
	
	@FindBy(xpath = "//span[text()='Gender']")
	WebElement clickGender;

	@FindBy(xpath = "//span[text()='Language']")
	WebElement clickLanguage;

	@FindBy(xpath = "//span[text()='Apply Filters']")
	WebElement applyFilter;

	public FilterPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToConsultPage() {
		driver.get("https://www.apollo247.com/doctors/doctors-in-hyderabad-dcity");
	}

	public void clickFilters() throws InterruptedException {
		Thread.sleep(5000);
//        WebElement filter = driver.findElement(By.xpath("//span[text()='Filters']"));
		filter.click();
	}

	public void applyFilters(String availability, String fees, String gender, String language) {
		System.out.println(availability + availability.length());
		System.out.println(fees + fees.length());
		System.out.println(gender + gender.length());
		System.out.println(language + language.length());

//        WebElement clickAvailability = driver.findElement(By.xpath("//span[text()='Availability']"));
		clickAvailability.click();

		WebElement selectAvailability = driver.findElement(By.xpath("//span[text()=" + availability + "]"));
		selectAvailability.click();

//        WebElement clickFees = driver.findElement(By.xpath("//span[text()='Fees']"));
		clickFees.click();

		WebElement selectFees = driver.findElement(By.xpath("//span[text()=" + fees + "]"));
		selectFees.click();

//        WebElement clickGender = driver.findElement(By.xpath("//span[text()='Gender']"));
		clickGender.click();

		WebElement selectGender = driver.findElement(By.xpath("//span[text()=" + gender + "]"));
		selectGender.click();

//        WebElement clickLanguage = driver.findElement(By.xpath("//span[text()='Language']"));
		clickLanguage.click();

		WebElement selectLanguage = driver.findElement(By.xpath("//span[text()=" + language + "]"));
		selectLanguage.click();
	}

	public void applyFilters() {
//        WebElement applyFilter = driver.findElement(By.xpath("//span[text()='Apply Filters']"));
		applyFilter.click();
	}

}
