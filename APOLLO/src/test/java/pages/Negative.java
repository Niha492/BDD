package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Negative {
	WebDriver driver;
	@FindBy(xpath="//div[@class='SpecialityDetails_webSearch__33jRh']//input[@class='MuiInputBase-input MuiInput-input' and @placeholder='Search doctors or specialities']")
	WebElement filter;
	@FindBy(xpath="//p[text()='Sorry, We could not find Doctors for you ']")
	List<WebElement> elements;
	
    public Negative(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void navigateToConsultPage() throws InterruptedException {
        driver.get("https://www.apollo247.com/doctors/doctors-in-hyderabad-dcity");
        Thread.sleep(5000);
    }

    public void enterInvalidData(String searchData) {
//        WebElement filter = driver.findElement(By.xpath("//div[@class='SpecialityDetails_webSearch__33jRh']//input[@class='MuiInputBase-input MuiInput-input' and @placeholder='Search doctors or specialities']"));
        filter.sendKeys(searchData);
    }

    public boolean areDoctorsNotFound() {
//        List<WebElement> elements = driver.findElements(By.xpath("//p[text()='Sorry, We could not find Doctors for you ']"));
        return elements.size() != 0;
    }
}
