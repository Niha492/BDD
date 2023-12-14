package steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.FilterPOM;
import pages.LoginPage;
import pages.Negative;
import pages.SortByCheckboxPOM;
import pages.VideoConsultant;
import io.cucumber.java.en.Then;

public class StepDefinition {
	WebDriver driver = null;
    LoginPage loginPage;
    VideoConsultant videoConsultant;
    SortByCheckboxPOM sortByCheckboxPOM;
    FilterPOM filterPOM;
    Negative negative;
    @Given("User is on Apollo App login page")
    public void user_is_on_apollo_app_login_page() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//		driver.get("https://www.apollo247.com/login?continue=/specialties");
		loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
	}

	@When("User enters valid mobil number and otp")
	public void User_enters_valid_mobil_number_and_otp() throws InterruptedException {
		loginPage.enterMobileNumber("9705162289");
        loginPage.clickVideoConsultLink();
        Thread.sleep(10000);
	}

	@When("User clicks on the login button")
	public void User_clicks_on_the_login_button() throws InterruptedException {
		loginPage.clickVideoConsultLink();
		
	}
	@Then("User is in Consult page")
	public void User_is_in_Consult_page() throws InterruptedException {
		Thread.sleep(10000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		System.out.println("https://www.apollo247.com/specialties" == currentUrl);
		
	}


	@Given("User select the All Cities from Most Searched Cities")
	public void user_clicks_on_welcome_link() throws InterruptedException {
		Thread.sleep(10000);
		videoConsultant=new VideoConsultant(driver);
		videoConsultant.clickMostSelectedCities();
        Thread.sleep(10000);
        List<WebElement> elements = driver.findElements(By.xpath("//h1[contains(text(),'Best Doctors in ')]"));
        if (elements.size() != 0) {
            System.out.println("Element is present in the DOM.");
        } else {
            System.out.println("Element is not present in the DOM.");
        }
	}
	@When("select the City from All Cities dropdown")
	public void select_the_City_from_All_Cities_dropdown() throws InterruptedException {
		videoConsultant.clickUserLocationDropdown();
        Thread.sleep(3000);
        videoConsultant.selectCityFromDropdown("Chennai");
        Thread.sleep(3000);
		
	}

	@Then("User can see list of doctors")
	public void logout_link_is_displayed() {
		List<WebElement> elements = driver.findElements(By.xpath("//h1[contains(text(),'Best Doctors in ')]"));
		if (elements.size() != 0) {
		    System.out.println("Element is present in the DOM.");
		} else {
		    System.out.println("Element is not present in the DOM.");
		}
	}
	
	
	
	
	@Given("User is on Consult Page")
	public void User_is_on_Consult_Page() {
		
		filterPOM = new FilterPOM(driver);
		filterPOM.navigateToConsultPage();
	}
	@When("User clicks on Filters")
	public void User_clicks_on_Filters() throws InterruptedException {
		filterPOM.clickFilters();
		
	}
	@And("^Enter (.*) and (.*) and (.*) and (.*)$")
	public void Enter_Availability_Fees_Gender_Language(String availability, String fees,String gender,String language) {
		filterPOM.applyFilters(availability, fees, gender, language);
	}
	@Then("Filters applied to the Consult page")
	public void Filters_applied_to_the_Consult_page() {
		filterPOM.applyFilters();
	}
	
	
	@Given("User is on Consult page")
	public void User_is_on_Consult_page() throws InterruptedException{
		driver.get("https://www.apollo247.com/doctors/doctors-in-hyderabad-dcity");
		Thread.sleep(5000);
		
	}
	@When("User click on Book Hospital Visit")
	public void User_selects_the_doctor(){
		WebElement Visit = driver.findElement(By.xpath(
				"//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3']//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 MuiGrid-grid-md-12 MuiGrid-grid-lg-6'][1]//span[text()='Book Hospital Visit']"));
		Visit.click();
	}
//	@And("User click on Book Hospital Visit")
//	public void User_click_on_Book_Hospital_Visit(){
//		
//	}
	@Then("User will Navigate to the Date and Time page")
	public void User_will_Navigate_to_the_Date_and_Time_page(){
		
		List<WebElement> elements = driver.findElements(By.xpath("//p[text()='28']"));
        if (elements.size() != 0) {
            System.out.println("Element is present in the DOM.");
        } else {
            System.out.println("Element is not present in the DOM.");
        }
		
		
	}
	
	@Given("user is on consult page")
	public void user_is_on_consult_page() throws InterruptedException {
		negative =new Negative(driver);
		negative.navigateToConsultPage();
//		driver.get("https://www.apollo247.com/doctors/doctors-in-hyderabad-dcity");
//		Thread.sleep(5000);
		
	}
	@When("User enters invalid data")
	public void User_enters_invalid_data() {
		negative.enterInvalidData("kjashggrewuigfsd");
	}
	@Then("Doctors not found")
	public void Doctors_not_found(){
		if (negative.areDoctorsNotFound()) {
            System.out.println("Doctors not found");
        } else {
            System.out.println("Doctors found.");
        }
	}
	
	
	
	@Given("User is on Consultpage")
	public void User_is_on_Consultpage() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.apollo247.com/doctors/doctors-in-hyderabad-dcity");
		Thread.sleep(5000);
		WebElement Visit = driver.findElement(By.xpath(
				"//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3']//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 MuiGrid-grid-md-12 MuiGrid-grid-lg-6'][1]//span[text()='Book Hospital Visit']"));
		Visit.click();
	}
	@When("User enters Date and Time")
	public void User_enters_Date_and_Time() throws InterruptedException {
		
	}
	@And("click on procced button and user is on Add New Member page")	
	public void click_on_procced_button_and_user_is_on_Add_New_Member_page() throws InterruptedException {
		Thread.sleep(3000);
		WebElement proceed = driver.findElement(By.xpath(
				"//span[text()='Proceed']"));
		proceed.click();
		Thread.sleep(5000);
	}
	@And("^enter (.*) and (.*) and (.*) and (.*)$")
	public void enter_FullName_LastName_DateofBirth_Gender(String fname, String lname, String Dob, String Gender) {
		WebElement fName = driver.findElement(By.xpath(
				"//input[@placeholder='First Name']"));
		fName.sendKeys(fname);
		WebElement lName = driver.findElement(By.xpath(
				"//input[@placeholder='Last name']"));
		lName.sendKeys(lname);
		WebElement dob = driver.findElement(By.xpath(
				"//input[@placeholder='dd/mm/yyyy']"));
		dob.sendKeys(Dob);
		
		WebElement gender = driver.findElement(By.xpath(
				"//span[text()="+Gender+"]"));
		gender.click();
		
	}
	@And("click on drop down and select relation")
	public void click_on_drop_down_and_select_relation() throws InterruptedException {
		WebElement relation = driver.findElement(By.xpath(
				"//div[text()='Other']"));
		relation.click();
		Thread.sleep(5000);
		WebElement relation_sister = driver.findElement(By.xpath(
				"//li[text()='Sister']"));
		relation_sister.click();
		Thread.sleep(5000);
	}
	@And("enter Gamail and click on save button")
	public void enter_Gamail_and_click_on_save_button() throws InterruptedException {
		WebElement email = driver.findElement(By.xpath(
				"//input[@placeholder='name@email.com']"));
		email.sendKeys("sirisha@gmail.com");
		
		Thread.sleep(3000);
	}
	@Then("User is navigate to payment page")
	public void User_is_navigate_to_payment_page() throws InterruptedException {
		WebElement save = driver.findElement(By.xpath(
				"//span[text()='Save']"));
		save.click();
		
		Thread.sleep(3000);
		
		WebElement confirm = driver.findElement(By.xpath(
				"//span[text()='CONFIRM']"));
		confirm.click();
		
	}
	

}


//public class StepDefinition {
//	WebDriver driver = null;
////	expectedConsultantPageUrl=;
//
//	@Given("user is on login page")
//	public void user_is_on_login_page() {
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.get("https://www.apollo247.com/login?continue=/specialties");
//
//	}
//
//	@When("user enters username and password")
//	public void user_enters_username_and_password() throws InterruptedException {
//		WebElement mobileNumberInput = driver.findElement(By.xpath("//input[@name='mobileNumber']"));
//		mobileNumberInput.sendKeys("6361177968");
//		WebElement videoConsultLink = driver.findElement(By.xpath("//span[@class='icon-ic_arrow_forward']"));
//		videoConsultLink.click();
//		Thread.sleep(10000);
//	}
//
//	@When("clicks on login button")
//	public void clicks_on_login_button() {
//		WebElement videoConsultLink = driver.findElement(By.xpath("//span[@class='icon-ic_arrow_forward']"));
//		videoConsultLink.click();
//		System.out.println("clicking on otp");
//	}
//
//	@Then("user is navigated to the homepage")
//	public void user_is_navigated_to_the_homepage() throws InterruptedException {
//		String currentUrl = driver.getCurrentUrl();
//		System.out.println(currentUrl);
//		System.out.println("https://www.apollo247.com/specialties" == currentUrl);
//		
//	}
//
//
//	@When("User select the All Cities from Most Searched Cities")
//	public void user_clicks_on_welcome_link() throws InterruptedException {
//		Thread.sleep(10000);
//		WebElement most_Selected_Cities = driver.findElement(By.xpath("//a[text()='Hyderabad']"));
//		most_Selected_Cities.click();
//		Thread.sleep(10000);
//		List<WebElement> elements = driver.findElements(By.xpath("//h1[contains(text(),'Best Doctors in ')]"));
//		if (elements.size() != 0) {
//		    System.out.println("Element is present in the DOM.");
//		} else {
//		    System.out.println("Element is not present in the DOM.");
//		}
//	}
//	@And("select the City from All Cities dropdown")
//	public void select_the_City_from_All_Cities_dropdown() throws InterruptedException {
//		WebElement dropdownElement1 = driver.findElement(By.xpath("//div[@class='SpecialityDetails_webSearch__33jRh']//div[@class='SpecialtySearch_userLocation__zIa9i']"));
//		dropdownElement1.click();
//		
//		Thread.sleep(3000);
//		WebElement dropdownElement = driver.findElement(By.xpath("//div[@class='SpecialityDetails_webSearch__33jRh']//button//span[text()='Chennai']"));
//		dropdownElement.click();
//		Thread.sleep(3000);
//		
//	}
//
//	@Then("User can see list of doctors")
//	public void logout_link_is_displayed() {
//		List<WebElement> elements = driver.findElements(By.xpath("//h1[contains(text(),'Best Doctors in ')]"));
//		if (elements.size() != 0) {
//		    System.out.println("Element is present in the DOM.");
//		} else {
//		    System.out.println("Element is not present in the DOM.");
//		}
//	}
//
//}
