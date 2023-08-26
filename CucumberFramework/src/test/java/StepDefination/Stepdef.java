package StepDefination;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageObject.AddCustPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfigue;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdef extends BaseClass{

	
	@Before
	public void setup() throws IOException {
		
		 readconfigue = new ReadConfigue(); 
		 log = LogManager.getLogger("Stepdef");
		
		String browser =  readconfigue.GetBrowserValue();
		
		
		switch (browser.toLowerCase()) {
		
		case "chrome" :
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox" :
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "edge" :
		    
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
			default : 
			driver = null;
			break;
		    
		}
		
		log.info("Execution started");
		
	}

@Given("User Launch Chrome browser")
public void user_launch_chrome_browser() {
	loginpage = new LoginPage(driver);
	 AddCustpg= new AddCustPage(driver);
	 sc = new SearchCustomerPage(driver);
	 log.info("Chrome browser started");
	 
	
	
}
@When("User opens URL {string}")
public void user_opens_url(String URL) {
	driver.get(URL);
	
 
}

@When("User enters Email as {string}")
public void user_enters_email_as(String email){
	loginpage.enterusrname(email);
    
}

@When("Users enters password as {string}")
public void users_enters_password_as(String password) {
    loginpage.enterpassword(password);
}

@When("Click on Login")
public void click_on_login() {
	loginpage.clickonlogin();
	
}
@Then("Page Title should be {string}")
public void page_title_should_be(String ExpectedResult) throws InterruptedException {
	Thread.sleep(3000);
    
	String ActualResult = driver.getTitle();
	 
	if(ActualResult.equals(ExpectedResult)) {
		Assert.assertTrue(true);

	}else {
		Assert.assertFalse(false);
		
	}
   
}


////////////////////////Add New Customer//////////////////////////


@When("User click on Customer menu")
public void user_click_on_customer_menu() {
	AddCustpg.burgermenu();
}

@When("Click on customers menu")
public void click_on_customers_menu() throws InterruptedException {
	AddCustpg.CustMenu();
	Thread.sleep(2000);
	
   
}

@When("Click on customers menu item")
public void click_on_customers_menu_item() {
   AddCustpg.CustMenuItem();
}

@When("Click on add new button")
public void click_on_add_new_button() throws InterruptedException {
	AddCustpg.AddNewCust();
   
}

@Then("User can view add customer page")
public void user_can_view_add_customer_page() {
	
	String ActualResult = driver.getTitle();
	String ExpectedResult = "Add a new customer / nopCommerce administration";
	if(ActualResult.equals(ExpectedResult))
	{
		Assert.assertTrue(true);
		
	}
		else
		{
			Assert.assertTrue(false);
			log.warn("Expected result is diffrent for page title");
		}
		
	}
  


@When("User enters info for new customer")
public void user_enters_info_for_new_customer() {
	
    AddCustpg.EnterCustInfo();
    AddCustpg.EnterGender("Male");
    AddCustpg.Vendor();
    
    
}

@When("Click on save button")
public void click_on_save_button() {
	AddCustpg.Save();
   
}


@Then("User can view confirmation message {string}")
public void user_can_view_confirmation_message(String ExpectedResult) {
   String ActuaResult= driver.findElement(By.tagName("Body")).getText();
    if(ActuaResult.contains(ExpectedResult)) {
    	Assert.assertTrue(true);
    	
    	log.warn("Body message is correct");
    }
    
    else {
    	Assert.assertTrue(false);
    	log.warn("Body message is diffrent");
    }
	
}

@Then("close browser")
public void close_browser() {
   driver.close();
}

//----------------Search Customer------------

@When("Enter customer email")
public void enter_customer_email() {
	sc.EnterEmail("victoria_victoria@nopCommerce.com");
   
}

@When("User click on search button")
public void user_click_on_search_button() throws InterruptedException {
   sc.ClickOnSearchButton();
    Thread.sleep(2000);
}

@When("user should found result in the search table")
public void user_should_found_result_in_the_search_table() {
	String Custemail ="victoria_victoria@nopCommerce.com";
	
	if(sc.SearchCustomerByEmail(Custemail)== true){
		Assert.assertTrue(true);
	 
	}else {
		
		 Assert.assertTrue(false);
	}
	
    
}


@When("Close browser")
public void close_browser1() {
	driver.close();

    
}


@After
public void endpoint(Scenario sc) throws IOException, InterruptedException {
	
	Thread.sleep(2000);
	
	if(sc.isFailed()==true) {
		
		String FilePath = "C:\\Users\\ajayg\\eclipse-workspace\\CucumberFramework\\target\\Cucumber-reports\\Screenshots\\test"+RandomNameGenrator()+".png";
		
		TakesScreenshot flash = ((TakesScreenshot)driver);
		File srcfile = flash.getScreenshotAs(OutputType.FILE);
		
		File DestFile = new File(FilePath);
		
		FileUtils.copyFile(srcfile, DestFile);
		
	}
	
	driver.quit();
	
	
}



}