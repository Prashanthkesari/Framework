package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tekSystems.automation.SeleniumAutomation.GlobalFunctions;

public class CleartripHomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CleartripHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
		this.driver = driver;
	}

	GlobalFunctions globalFunctions = new GlobalFunctions();
	
	@FindBy(xpath="//*[text()='Hotels']/parent::li")
	private WebElement Hotellink;
	
	public void naviagtetoHotels() throws Exception{
		globalFunctions.Click(Hotellink, "HotelLink");
		
	}
	
	
}
