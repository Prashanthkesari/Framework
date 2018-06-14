package pageClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tekSystems.automation.SeleniumAutomation.GlobalFunctions;

public class WorldBankProjects {
	WebDriver driver;
	WebDriverWait wait;

	public WorldBankProjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
		this.driver = driver;
	}

	GlobalFunctions globalFunctions = new GlobalFunctions();

	@FindBy(xpath = "//*[text()='What We Do']")
	private WebElement WhatWeDolink;

	@FindBy(xpath = "//a[@href = 'http://projects.worldbank.org/country?lang=en&page=']")
	private WebElement ByCountry;

	@FindBy(xpath = "//a[(@class='regionTitle') and text()='South Asia']/ancestor::tr/following-sibling::tr/td/a")
	@CacheLookup
	private List<WebElement> data;

	@FindBy(xpath = "//*[text()='South Africa']")
	private WebElement Table;

	@FindBy(xpath = "//*[@class='country'][1]//td/a")
	private List<WebElement> country;

	@FindBy(xpath = "//*[@class='lending-amount'][1]")
	private WebElement Operationsvalue;

	@FindBy(xpath = "//*[text()='Projects & Operations']")
	private WebElement ProjectandOperations;

	@FindBy(xpath = "//*[text()='Browse by Country/Area']")
	private WebElement Browse;

	public void navigatetoProjectPage() throws Exception {

		globalFunctions.Click(WhatWeDolink, "WhatWeDolink");
		globalFunctions.Click(ByCountry, "byCountrylink");
	}

	public HashMap<String, Double> getOperationsValue(String Region) throws Exception {
		double val2 = 0;
		double val3 = 0;

		List<WebElement> we = driver.findElements(By.xpath(
				"//a[(@class='regionTitle') and text()='" + Region + "']/ancestor::tr/following-sibling::tr/td/a"));
		System.out.println("Countries in current " + Region + " " + we.size());
		HashMap<String, Double> map = new HashMap<>();
		
		for (int i = 0; i <6; i++) {
			
			
			List<WebElement> we1 = driver.findElements(By.xpath(
					"//a[(@class='regionTitle') and text()='" + Region + "']/ancestor::tr/following-sibling::tr/td/a"));
			String countryA = we1.get(i).getText();
			System.out.println(countryA);
			globalFunctions.Click(we1.get(i), "Click on country");
			wait.until(ExpectedConditions.visibilityOf(Operationsvalue));
			String amount = Operationsvalue.getText();
			String[] words = amount.split(" ");
			String amount1 = removeLastCharOptional(words[1]);
			amount1 = amount1.replaceAll(",", "");
			Double val = Double.parseDouble(amount1);
			System.out.println(val);

			if (val > val2) {
				val2 = val;
			}

			if (i == 0) {
				val3 = val;
			}
			if (val < val3) {
				val3 = val;
			}
			map.put(countryA, val);
			System.out.println(map);
			driver.navigate().back();
		}

		System.out.println(map);
		System.out.println(val2);
		System.out.println(val3);
		System.out.println("Higest value is : " + getKeyFromValue(map, val2));
		System.out.println("Lowest value is : " + getKeyFromValue(map, val3));
//		TreeMap<Double, String> treeMap = new TreeMap<Double, String>(map);
//		System.out.println(treeMap);
		return map;

	}
	
	
	
	public TreeMap<Double, String> sortCoutriesOnValue(HashMap<Double,String> map){
		TreeMap<Double, String> treeMap = new TreeMap<Double, String>(map);
		System.out.println(treeMap);
		//int sizeofTree = treeMap.size();
		System.out.println("Printing least val in sorted "+treeMap.entrySet().stream().findAny().get().getValue());
		System.out.println("Printing least val in sorted "+treeMap.entrySet().stream().findFirst().get().getValue());
		
		return treeMap;		
	}

	
	public static Object getKeyFromValue(HashMap<String, Double> hm, Object value) {
		for (Object o : hm.keySet()) {
			if (hm.get(o).equals(value)) {
				return o;
			}
		}
		return null;
	}

	public String removeLastCharOptional(String s) {
		return (String) Optional.ofNullable(s).filter(str -> str.length() != 0)
				.map(str -> str.substring(0, str.length() - 1)).orElse(s);
	}

}
