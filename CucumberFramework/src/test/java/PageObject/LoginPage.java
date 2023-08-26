package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;	
	
	public LoginPage(WebDriver cdriver) {
		
		driver = cdriver;
		PageFactory.initElements(cdriver,this);
	}
	
	@FindBy(id ="Email")
	WebElement emailfield;
	
	@FindBy(id ="Password") 
	WebElement passwordfield;
	
	@FindBy(xpath="//button[@type='submit']")
    WebElement login;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	public void enterusrname(String enterusername ) {
		emailfield.clear();
		emailfield.sendKeys(enterusername);
		 
	}
	public void enterpassword(String enterpassword ) {
		passwordfield.clear();
		passwordfield.sendKeys(enterpassword);
		 
	}
	public void clickonlogin() {
		login.click();
		
	 }


	
}






