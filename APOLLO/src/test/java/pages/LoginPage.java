package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private final WebDriver driver;
	@FindBy(xpath="//input[@name='mobileNumber']")
	WebElement mobileNumberInput;
	
	@FindBy(xpath="//span[@class='icon-ic_arrow_forward']")
	WebElement videoConsultLink;
	
	
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get("https://www.apollo247.com/login?continue=/specialties");
    }

    public void enterMobileNumber(String mobileNumber) {
//        WebElement mobileNumberInput = driver.findElement(By.xpath("//input[@name='mobileNumber']"));
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void clickVideoConsultLink() {
//        WebElement videoConsultLink = driver.findElement(By.xpath("//span[@class='icon-ic_arrow_forward']"));
        videoConsultLink.click();
    }
    
}
