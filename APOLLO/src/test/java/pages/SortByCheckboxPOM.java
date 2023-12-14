package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortByCheckboxPOM {
	private final WebDriver driver;
	@FindBy(xpath="//span[@class='Filters_sortByHeading___2Csq']")
	WebElement sortBy;
	
	@FindBy(xpath="//li[text()='Availability']")
	WebElement selectAvailability;
	
	@FindBy(name="onlineconsults")
	WebElement selectCheckBox;

	public SortByCheckboxPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToConsultPage() {
		driver.get("https://www.apollo247.com/doctors/doctors-in-hyderabad-dcity");
	}

	public void clickSortByCheckbox() throws InterruptedException {
		Thread.sleep(5000);
//		WebElement sortBy = driver.findElement(By.xpath("//span[@class='Filters_sortByHeading___2Csq']"));
		sortBy.click();

//		WebElement selectAvailability = driver.findElement(By.xpath("//li[text()='Availability']"));
		selectAvailability.click();

//		WebElement selectCheckBox = driver.findElement(By.name("onlineconsults"));
		selectCheckBox.click();
	}

	public boolean isSortByCheckboxApplied() throws InterruptedException {
		Thread.sleep(5000);
		return "https://www.apollo247.com/doctors/doctors-in-hyderabad-dcity".equals(driver.getCurrentUrl());
	}
}
