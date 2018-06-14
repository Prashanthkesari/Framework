package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tekSystems.automation.SeleniumAutomation.GlobalFunctions;

public class HotelsSearchPage2 {

	WebDriver driver;
	WebDriverWait wait;

	public HotelsSearchPage2(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
		this.driver = driver;

	}

	GlobalFunctions globalFunctions = new GlobalFunctions();

	@FindBy(id = "Tags")
	private WebElement LocationSearch;

	@FindBy(xpath = "//input[contains(@title, 'Check-in date')]")
	private WebElement CheckIn;

	@FindBy(xpath = "//input[contains(@title, 'Check-out date')]")
	private WebElement CheckOut;

	@FindBy(xpath = "//a[@class='ui-state-default ui-state-highlight ui-state-active ']")
	private WebElement CurrentDate;

	@FindBy(xpath = "//*[@class='ui-state-default ui-state-active ']")
	private WebElement checkoutDate;

	@FindBy(id = "SearchHotelsButton")
	private WebElement SearchButton;

	@FindBy(xpath = "(//optgroup/option)[2]")
	private WebElement cities;

	@FindBy(xpath = "//*[@id='ui-id-1']/li/following::li/a[1]")
	private WebElement auto;

	@FindBy(xpath = "//table[@class='calendar']//td/a")
	private List<WebElement> date;

	@FindBy(xpath = "(//*[@class='ui-datepicker-year'])[1]")
	private WebElement yearElement;

	@FindBy(xpath = "(//*[@class='ui-datepicker-month'])[1]")
	private WebElement monthElement;

	@FindBy(xpath = "//*[@class='ui-state-default ']")
	private List<WebElement> dateElement;

	public void searchForHotels() throws Exception {
		driver.findElement(By.id("Tags")).sendKeys("Hyderabad");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ui-id-1']/li/following::li/a[1]")));
		auto.click();
		globalFunctions.Click(CheckIn, "CheckIn");
		selectDateinCalender1("2019", "January", "10");
//		String year = "2019";
//		String month = "March";
//		String day = "23";
//
//		do {
//
//			driver.findElement(By.xpath("//*[@class='nextMonth '] ")).click();
//
//		} while (!((yearElement.getText().equals(year)) & (monthElement.getText().equals(month))));
//
//		for (int i = 0; i < dateElement.size(); i++) {
//			while (dateElement.get(i).getText().equals(day))
//				
//			{
//				globalFunctions.Click(dateElement.get(i), "");
//			}
//		}
//
//		for (int i = 0; i < date.size(); i++) {
//			System.out.println(date.get(i).getText());
//		}

		//globalFunctions.Click(CurrentDate, "Currentdate");
		//globalFunctions.Click(CheckOut, "CheckOut");
		selectDateinCalender1("2019", "January", "31");
		//globalFunctions.Click(checkoutDate, "checkoutDate");
		globalFunctions.Click(SearchButton, "Search");

	}
	
	public void selectDateinCalender(String year, String month ,	String day) throws Exception{
		while (!((yearElement.getText().equals(year)) & (monthElement.getText().equals(month)))) {

			driver.findElement(By.xpath("//*[@class='nextMonth '] ")).click();

		} 

		for (int i = 0; i < dateElement.size(); i++) {
			while (dateElement.get(i).getText().equals(day))
				
			{
				globalFunctions.Click(dateElement.get(i), "");
			}
		}
		
		
	}

	
	public void selectDateinCalender1(String year, String month ,	String day) throws Exception{
		while (!(yearElement.getText().equals(year))) {
			
			while(!(monthElement.getText().equals(month))){

			driver.findElement(By.xpath("//*[@class='nextMonth '] ")).click();
			}
		} 

		for (int i = 0; i < dateElement.size(); i++) {
			while (dateElement.get(i).getText().equals(day))
				
			{
				globalFunctions.Click(dateElement.get(i), "");
			}
		}
		
		
	}
}
