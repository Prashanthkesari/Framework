package org.tekSystems.automation.SeleniumAutomation;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.InputSource;

import org.tekSystems.automation.SeleniumAutomation.Report;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GlobalFunctions {

	public WebDriver driver;

	Report tempReport = new Report();
	ExtentTest tempExtentTest = new ExtentTest("testName", "description");

	/*
	 * This method reads data from the specified filePath based on the xpath
	 * provided and returns xpathResult.
	 */
	public String readData(String filePath, String xpath) throws XPathExpressionException {
		String xpathResult = null;
		try {
			XPath Xpath = XPathFactory.newInstance().newXPath();
			InputSource inputSource = new InputSource(filePath);
			xpathResult = Xpath.evaluate(xpath, inputSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xpathResult;
	}

	public String getText(WebElement element){
		String text = element.getText();
		return text;
		
	}
	
	
	public String retryingGettext(WebElement element, String description) throws Exception {
		String  country = null;
		     int attempts = 0;
		     while(attempts < 4) {
		         try {
		        	  country =  element.getText();
		          tempReport.logReportPass(description);
		                 break;
		         } catch(StaleElementReferenceException e) {
		          e.printStackTrace();
		          tempExtentTest.log(LogStatus.FAIL, "click falied on" + description);
		    
		         }
		         attempts++;
		     }
		     return country;
		 }
	
	
	public void Click(WebElement Element, String description) throws Exception {
		
		try {
			
			Element.click();
			tempReport.logReportPass(description);

		} catch (Exception e) {
			System.out.println("catch error" + e);
			tempExtentTest.log(LogStatus.FAIL, "click falied on" + description);
			

		}
	}
	
	

	/*
	 * public void navigateBack() { driver.navigate().back(); //
	 * JavascriptExecutor js = (JavascriptExecutor) driver; //
	 * js.executeScript("history.go(-1);", new Object[0]); }
	 * 
	 * 
	 * 
	 * // public boolean Click(WebElement Element, String description){ //
	 * if(Element.isDisplayed()){ // Element.click(); //
	 * test.log(LogStatus.PASS, "Successfully clicked on" +description); //
	 * return true; // } // else{ // // test.log(LogStatus.FAIL,
	 * "click falied on" +description); // return false; // } // }
	 * 
	 * /* This method selects dropdown values based parameter data. Parameter
	 * selectby is the dropdown values identifier.
	 */
	public boolean selectValueBy(WebElement Element, String selectby, String data, String description) {

		Select selectBy = new Select(Element);

		try {
			switch (selectby) {
			case ("index"):
				selectBy.selectByIndex(Integer.parseInt(data));
				tempExtentTest.log(LogStatus.PASS, "Successfully selected " + data + "from dropdown");
				tempReport.logReportPass(description);
				break;

			case ("value"):
				selectBy.selectByValue(data);
				tempReport.logReportPass(description);
				break;

			case ("text"):
				selectBy.selectByVisibleText(data);
				tempReport.logReportPass(description);
				break;

			default:
				tempExtentTest.log(LogStatus.FAIL, data + " not available in dropdown");

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tempExtentTest.log(LogStatus.FAIL, data + " not selected from dropdown");
			return false;
		}
	}

	
	
	
	public boolean Type(WebElement Element, String text, String description) {
		try {

			Element.sendKeys(text);
			tempReport.logReportPass(description);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tempExtentTest.log(LogStatus.FAIL, text + " not typed in " + description);
			return false;
		}
	}

	public boolean verifyText(WebElement element, String data) {
		try {
			element.getText().equals(data);
			// tempReport.logReportPass(description);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean logOut(WebElement element, String description) {
		try {
			element.click();
			tempReport.logReportPass(description);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tempExtentTest.log(LogStatus.FAIL, " Log out failed ");
			return false;
		}
	}

}
