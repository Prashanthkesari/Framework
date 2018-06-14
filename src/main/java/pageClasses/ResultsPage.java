package pageClasses;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tekSystems.automation.SeleniumAutomation.GlobalFunctions;


public class ResultsPage {
	WebDriver driver;
	WebDriverWait wait;

	public ResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
		this.driver = driver;

	}

	GlobalFunctions globalFunctions = new GlobalFunctions();

	@FindBy(xpath = "(//a[@class='priceSort'])[2]")
	private WebElement priceSort;

	@FindBy(xpath = "//a[@class='priceSort current sortAsc']")
	private WebElement priceSortAsc;

	@FindBy(xpath = "//a[@class='hotelDetails' and @data-hash='#highlights']")
	private List<WebElement> hotelsList;

	public void sortbyPrice() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(priceSort));
		globalFunctions.Click(priceSort, "sortbyPrice");
		wait.until(ExpectedConditions.elementToBeClickable(priceSortAsc));
		globalFunctions.Click(priceSortAsc, "sortAsc");
		globalFunctions.Click(hotelsList.get(0), "highestPriceHotel");

	}

	public void hotelNames() throws Exception {
		
		System.out.println(hotelsList.size());
		wait.until(ExpectedConditions.visibilityOfAllElements(hotelsList));
		for (int i = 0; i < hotelsList.size(); i++) {
			
			System.out.println(globalFunctions.retryingGettext(hotelsList.get(i),"fetching hotelname"));

		}

	}

}
