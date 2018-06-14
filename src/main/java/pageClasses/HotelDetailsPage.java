package pageClasses;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tekSystems.automation.SeleniumAutomation.GlobalFunctions;

public class HotelDetailsPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public HotelDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
		this.driver = driver;
		
	}

	GlobalFunctions globalFunctions = new GlobalFunctions();
	
	@FindBy(xpath="//a[@class='button booking bookHotel']")
	private WebElement bookthisHotel;
	
	public void switchtoHotelPage() throws Exception{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    globalFunctions.Click(bookthisHotel, "Book this hotel link");
	}


}
