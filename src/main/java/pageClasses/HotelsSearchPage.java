package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tekSystems.automation.SeleniumAutomation.GlobalFunctions;

public class HotelsSearchPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HotelsSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
		this.driver = driver;
		
	}

	GlobalFunctions globalFunctions = new GlobalFunctions();
	
	@FindBy(id="Tags")
	private WebElement LocationSearch;
	
	@FindBy(xpath="//input[contains(@title, 'Check-in date')]")
	private WebElement CheckIn;
	
	@FindBy(xpath="//input[contains(@title, 'Check-out date')]")
	private WebElement CheckOut;
	
	@FindBy(xpath="//a[@class='ui-state-default ui-state-highlight ui-state-active ']")
	private WebElement CurrentDate;
	
	
	@FindBy(xpath="//*[@class='ui-state-default ui-state-active ']")
	private WebElement checkoutDate;	
			
	
	@FindBy(id="SearchHotelsButton")
	private WebElement SearchButton;
	
	@FindBy(xpath = "(//optgroup/option)[2]")
	private WebElement cities;
	
	
	@FindBy(xpath="//*[@id='ui-id-1']/li/following::li/a[1]")
	private WebElement auto;
	
	
	
	public void searchForHotels() throws Exception{
		driver.findElement(By.id("Tags")).sendKeys("Hyderabad");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ui-id-1']/li/following::li/a[1]")));
		auto.click();
		globalFunctions.Click(CheckIn, "CheckIn");
		globalFunctions.Click(CurrentDate, "Currentdate");
		globalFunctions.Click(CheckOut, "CheckOut");
		globalFunctions.Click(checkoutDate, "checkoutDate");
		globalFunctions.Click(SearchButton, "Search");
				
	}

}
