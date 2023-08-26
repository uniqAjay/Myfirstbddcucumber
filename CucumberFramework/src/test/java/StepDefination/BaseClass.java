package StepDefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.*;

import PageObject.AddCustPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfigue;


public class BaseClass {

	public WebDriver driver;
	public LoginPage loginpage;
	public AddCustPage AddCustpg;
	public SearchCustomerPage sc;
	public static Logger log; 
	public ReadConfigue readconfigue;
	
	public String RandomNameGenrator() {
		
		 return(RandomStringUtils.randomAlphabetic(5));
		
	}
}
