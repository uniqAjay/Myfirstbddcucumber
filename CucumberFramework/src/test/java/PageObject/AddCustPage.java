package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StepDefination.BaseClass;

public class AddCustPage extends BaseClass{
	
	WebDriver driver;

	public AddCustPage (WebDriver cdriver)
	{
		
		driver = cdriver;
		
		PageFactory.initElements(cdriver, this);
	}
	
	
	
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")WebElement ClickOnCustMenu;
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")WebElement ClickOnCustMenuItem;
	@FindBy(xpath = "//a[@href='/Admin/Customer/Create']") WebElement ClickOnAddCustButton;
	@FindBy(xpath = "//input[@id='Email']")WebElement EnterEmail;
	@FindBy(xpath = "//input[@id='Password']")WebElement EnterPassword;
	@FindBy(xpath = "//input[@id='FirstName']") WebElement EnterFirstName;
	@FindBy(xpath = "//input[@id='LastName']")WebElement EnterLastName;
	@FindBy(xpath = "//input[@id='Gender_Male']") WebElement GenderMale;
	@FindBy(xpath = "//input[@id='Gender_Female']") WebElement GenderFemale;
	@FindBy(xpath = "//input[@id='DateOfBirth']")WebElement EnterBirthdayDate;
	@FindBy(xpath = "//input[@id='Company']") WebElement EnterCopmanyName;
//	@FindBy(xpath = "//span[@aria-label='delete']")WebElement Delete;
//	@FindBy(xpath = "//input[@role='listbox']")WebElement CustomerRole;
	@FindBy(xpath = "//select[@id='VendorId']")WebElement VendorId;
	@FindBy(xpath = "//button[@name='save']")WebElement SaveButton;
	@FindBy(xpath = "//a[@id='nopSideBarPusher']")WebElement BurgerMenu;
	
	
	
    public void burgermenu() {
		BurgerMenu.click();
			
		}
	 public void CustMenu() throws InterruptedException {
		 Thread.sleep(2000);
		ClickOnCustMenu.click();
	 }
	
	 public void CustMenuItem() {
	  ClickOnCustMenuItem.click();
		
	}
	 
	public void AddNewCust() throws InterruptedException {
		
		ClickOnAddCustButton.click();
		Thread.sleep(1000);
	}
	
	public void EnterCustInfo() {
		EnterEmail.sendKeys(RandomNameGenrator()+"@allianz.com");
		EnterPassword.sendKeys("Ajay@9898");
		EnterCopmanyName.sendKeys("test");
		EnterLastName.sendKeys("Person");
		EnterBirthdayDate.sendKeys("03/10/1999");
		EnterCopmanyName.sendKeys("TestCompny");
		
	}
	
	public void EnterGender(String Gender) {
		if(Gender.equals("Male"))
		{
			GenderMale.click();
		}
		else if(Gender.equals("Female"))
		 {
			GenderFemale.click();
		}
		else
		{
			GenderMale.click();
		}
		
		log.trace("gender");
		
	}
	
	public void Vendor() {
		Select sel = new Select(VendorId);
		sel.selectByVisibleText("Vendor 2");
		
		log.trace("vendor");
	}
	
	
	public void Save() {
		SaveButton.click();
	}

}

 



























