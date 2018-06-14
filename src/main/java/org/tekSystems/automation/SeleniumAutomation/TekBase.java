package org.tekSystems.automation.SeleniumAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPathExpressionException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TekBase {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	public GlobalFunctions gF;

	@BeforeSuite
	public void initializeWebDriver() throws XPathExpressionException {
		gF = new GlobalFunctions();
		extent = new ExtentReports("D:\\Java\\WrkspaceEclipse\\SeleniumAutomation\\report\\ExtentReport.html", true);
		extent.loadConfig(new File("D:\\Java\\WrkspaceEclipse\\SeleniumAutomation\\extent-config.xml"));

		String driverPath = "D:/Java/WrkspaceEclipse/line/";
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		
		String url = gF.readData("C:/Users/pkesari/Desktop/sample.xml", "//dev/url");
		//String url = gF.readData("C:/Users/pkesari/Desktop/worldBanktestinput.xml", "//dev/url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	

	@BeforeMethod
	public void reportTest(Method method) {
		test = extent.startTest(this.getClass().getSimpleName() + "::" + method.getName());
		test.log(LogStatus.PASS, "detausks");
	}

	@AfterMethod
	public void endReport() {
		// ending test
		// endTest(logger) : It ends the current test and prepares to create
		// HTML report
		extent.endTest(test);

	}

	@AfterSuite
	public void afterSuite() {
		extent.flush();
		extent.close();
		// driver.get("D:\\Java\\WrkspaceEclipse\\SeleniumAutomation\\report\\ExtentReport.html");
	}

}
