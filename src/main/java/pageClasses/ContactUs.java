package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tekSystems.automation.SeleniumAutomation.GlobalFunctions;

public class ContactUs {
	public ContactUs(WebDriver driver){
		PageFactory.initElements(driver, this);		
	}
	
	GlobalFunctions globalFunctions = new GlobalFunctions(); 
	
	@FindBy(xpath = "//*[@class='login']")
	@CacheLookup
	private WebElement signButton;
	
	

}
