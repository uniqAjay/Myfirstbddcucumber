package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
	WebDriver driver;
	
	public SearchCustomerPage(WebDriver Cdriver) {
		
		driver = Cdriver;
		PageFactory.initElements(Cdriver, this);
		
	}

	@FindBy(xpath = "//input[@id='SearchEmail']") WebElement Email;
	@FindBy(xpath = "//button[@id='search-customers']") WebElement SearchButton;
	@FindBy(xpath = "//table[@id='customers-grid']") WebElement ResultTable;
	@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr") List<WebElement> TableRows;
	
	
	public void EnterEmail(String EmailAdd) {
		
		Email.sendKeys(EmailAdd);
	}
	
	public void ClickOnSearchButton() {
		
		SearchButton.click();
		
	}
	
	public boolean SearchCustomerByEmail(String Custemail) {
		boolean FoundEmail = false;
		
	int count =	TableRows.size();
	
		for(int i = 1; i<=count; i++) {
			WebElement Actualemails = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr["+ i +"]//td[2]"));
			String Actualemail = Actualemails.getText();
			if(Actualemail.equals(Custemail)) {
				FoundEmail = true;
			}
		}
		
			return FoundEmail;
	}
	
	
}
