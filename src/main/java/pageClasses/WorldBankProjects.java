package pageClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tekSystems.automation.SeleniumAutomation.GlobalFunctions;

public class WorldBankProjects {
	
	public WorldBankProjects(WebDriver driver){
		PageFactory.initElements(driver, this);		
	}
	
	GlobalFunctions globalFunctions = new GlobalFunctions(); 
	public WebDriver driver;
	

	@FindBy(xpath = "//*[text()='What We Do']")
	@CacheLookup
	private WebElement WhatWeDolink;
	
	@FindBy(xpath = "//a[@href = 'http://projects.worldbank.org/country?lang=en&page=']")
	@CacheLookup
	private WebElement ByCountry;
	
	
	@FindBy(xpath = "//table[@class='country'][1]//td/a")
	@CacheLookup
	private List<WebElement> data;
	
	@FindBy(xpath = "//*[@class='lending-amount'][1]")
	@CacheLookup
	private WebElement Operationsvalue;
	
	
	
	
	
	public void getOperationsValue() throws Exception{
		globalFunctions.Click(WhatWeDolink, "WhatWeDolink");
		globalFunctions.Click(ByCountry, "byCountrylink");
		
		
	
		
		//System.out.println(Operationsvalue.getText());
//		data.get(0).click();
//		System.out.println("Pass");
	System.out.println(data.size());
		int i;
		for(i=1; i<=data.size();i++){
			System.out.println(data.get(i).getText());
			
			data.get(i).click();
			Thread.sleep(20000);
				
		//	String amount = Operationsvalue.getText();
		//	System.out.println(amount);
			globalFunctions.navigateBack();
			
			Thread.sleep(10000);
			//driver.navigate().to("http://projects.worldbank.org/country?lang=en&page=");
			System.out.println("pass");
			//value.add(data.get(i).getText());
			//System.out.println(value.add(data.get(i).getText()));
			
		}
	}
	
}
