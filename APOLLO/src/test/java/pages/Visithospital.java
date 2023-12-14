package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Visithospital {
	private final WebDriver driver;
	
	@FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3']//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 MuiGrid-grid-md-12 MuiGrid-grid-lg-6'][1]//span[text()='Book Hospital Visit']")
	WebElement visit;
	
	@FindBy(xpath="//span[text()='Proceed']")
	WebElement proceed;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@placeholder='Last name']")
    WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='dd/mm/yyyy']")
    WebElement dateOfBirth;
    
	@FindBy(xpath="//div[text()='Other']")
    WebElement relation;
	
	@FindBy(xpath="//li[text()='Sister']")
    WebElement relationSister;
    
	@FindBy(xpath="//input[@placeholder='name@email.com']")
    WebElement emailInput;
    
	
	@FindBy(xpath="//span[text()='Save']")
    WebElement save;
    
	@FindBy(xpath="//span[text()='CONFIRM']")
    WebElement confirm;
	
	
	
	
	public Visithospital(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void navigateToConsultationPage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.apollo247.com/doctors/doctors-in-hyderabad-dcity");
        Thread.sleep(5000);
//        WebElement visit = driver.findElement(By.xpath(
//                "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3']//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 MuiGrid-grid-md-12 MuiGrid-grid-lg-6'][1]//span[text()='Book Hospital Visit']"));
        visit.click();
    }

    public void enterDateAndTime() {
        // Implement the code for entering Date and Time
    }

    public void clickProceedButton() throws InterruptedException {
        Thread.sleep(3000);
//        WebElement proceed = driver.findElement(By.xpath("//span[text()='Proceed']"));
        proceed.click();
        Thread.sleep(5000);
    }

    public void enterMemberDetails(String fName, String lName, String dob, String gender) {
//        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstName.sendKeys(fName);
//        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last name']"));
        lastName.sendKeys(lName);
//        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']"));
        dateOfBirth.sendKeys(dob);
        WebElement genderElement = driver.findElement(By.xpath("//span[text()='" + gender + "']"));
        genderElement.click();
    }

    public void selectRelation() throws InterruptedException {
//        WebElement relation = driver.findElement(By.xpath("//div[text()='Other']"));
        relation.click();
        Thread.sleep(5000);
//        WebElement relationSister = driver.findElement(By.xpath("//li[text()='Sister']"));
        relationSister.click();
        Thread.sleep(5000);
    }

    public void enterEmailAndSave(String email) throws InterruptedException {
//        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='name@email.com']"));
        emailInput.sendKeys(email);
        Thread.sleep(3000);
    }

    public void navigateToPaymentPage() throws InterruptedException {
//        WebElement save = driver.findElement(By.xpath("//span[text()='Save']"));
        save.click();
        Thread.sleep(3000);

//        WebElement confirm = driver.findElement(By.xpath("//span[text()='CONFIRM']"));
        confirm.click();
    }
}
