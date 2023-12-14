package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class VideoConsultant {
	private final WebDriver driver;
	@FindBy(xpath = "//a[text()='Hyderabad']")
	WebElement mostSelectedCities;
	
	@FindBy(xpath = "//div[@class='SpecialityDetails_webSearch__33jRh']//div[@class='SpecialtySearch_userLocation__zIa9i']")
	WebElement dropdownElement;
	
	
    public VideoConsultant(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMostSelectedCities() {
//        WebElement mostSelectedCities = driver.findElement(By.xpath("//a[text()='Hyderabad']"));
        mostSelectedCities.click();
    }
    public void clickUserLocationDropdown() {
//        WebElement dropdownElement = driver.findElement(By.xpath("//div[@class='SpecialityDetails_webSearch__33jRh']//div[@class='SpecialtySearch_userLocation__zIa9i']"));
        dropdownElement.click();
    }

    public void selectCityFromDropdown(String cityName) {
        WebElement dropdownElement = driver.findElement(By.xpath("//div[@class='SpecialityDetails_webSearch__33jRh']//button//span[text()='" + cityName + "']"));
        dropdownElement.click();
    }

}
