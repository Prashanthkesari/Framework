package org.tekSystems.automation.SeleniumAutomation;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.InputSource;

import com.relevantcodes.extentreports.LogStatus;

public class GlobalFunctions extends TekBase {

	public WebDriver driver;

	public enum ActionTypes {
		MaximizeWindow, Click
	};

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

	public void Click(WebElement Element, String description) throws Exception {
		try {
			// Wait wait = new FluentWait(driver)
			// .withTimeout(timeout, SECONDS)
			// .pollingEvery(timeout, SECONDS)
			// .ignoring(Exception.class);
			//
			// WebElement foo= wait.until(new Function< driver, WebElement>() {
			// public WebElement applyy(WebDriver driver) {
			// return driver.findElement(By.id("foo"));
			// }
			// });
			Element.click();
			test.log(LogStatus.PASS, "Successfully clicked on" + description);
			iTestResultsSuccess();

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "click falied on" + description);
			iTestResultsFailure();

		}
	}

	public void navigateBack() {
		driver.navigate().back();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("history.go(-1);", new Object[0]);
	}

	
	
	// public boolean Click(WebElement Element, String description){
	// if(Element.isDisplayed()){
	// Element.click();
	// test.log(LogStatus.PASS, "Successfully clicked on" +description);
	// return true;
	// }
	// else{
	//
	// test.log(LogStatus.FAIL, "click falied on" +description);
	// return false;
	// }
	// }

	/*
	 * This method selects dropdown values based parameter data. Parameter
	 * selectby is the dropdown values identifier.
	 */
	public boolean selectValueBy(WebElement Element, String selectby, String data) {

		Select selectBy = new Select(Element);

		try {
			switch (selectby) {
			case ("index"):
				selectBy.selectByIndex(Integer.parseInt(data));
				test.log(LogStatus.PASS, "Successfully selected " + data + "from dropdown");
				iTestResultsSuccess();
				break;

			case ("value"):
				selectBy.selectByValue(data);
				test.log(LogStatus.PASS, "Successfully selected " + data + "from dropdown");
				iTestResultsSuccess();
				break;

			case ("text"):
				selectBy.selectByVisibleText(data);
				test.log(LogStatus.PASS, "Successfully selected " + data + "from dropdown");
				iTestResultsSuccess();
				break;

			default:
				test.log(LogStatus.FAIL, data + " not available in dropdown");

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, data + " not selected from dropdown");
			return false;
		}
	}

	public boolean Type(WebElement Element, String text, String description) {
		try {

			Element.sendKeys(text);
			test.log(LogStatus.PASS, text + " typed in  " + description);
			iTestResultsSuccess();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, text + " not typed in " + description);
			return false;
		}
	}

	public boolean verifyText(WebElement element, String data) {
		try {
			element.getText().equalsIgnoreCase(data);
			iTestResultsSuccess();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean logOut(WebElement element) {
		try {
			element.click();
			test.log(LogStatus.PASS, " Log out successful ");
			iTestResultsSuccess();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, " Log out failed ");
			return false;
		}
	}

}
