package org.tekSystems.automation.SeleniumAutomation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

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
		extent = new ExtentReports(
				"D:\\Java\\WrkspaceEclipse\\SeleniumAutomation\\report\\ExtentReport.html", true);
		extent.loadConfig(new File("D:\\Java\\WrkspaceEclipse\\SeleniumAutomation\\extent-config.xml"));
		
		String driverPath = "D:/Java/WrkspaceEclipse/line/";
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
//		String url = gF.readData("C:/Users/pkesari/Desktop/sample.xml", "//dev/url");
		String url = gF.readData("C:/Users/pkesari/Desktop/worldBanktestinput.xml", "//dev/url");
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	public void reportTest(Method method) {
		test = extent.startTest(this.getClass().getSimpleName() + "::" + method.getName());
	}

	@BeforeMethod
	public void launchApplication(Method method) {
		reportTest(method);
	}
	
	public static String getScreenhot(String screenshotName) throws Exception {
//		SecureRandom random = new SecureRandom();
//		 int dateName = random.nextInt(100000);
		 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		 String fileName = screenshotName+dateName+".png";
		 String destination = System.getProperty("user.dir") + "/report/"+screenshotName+dateName+".png";
		 File finalDestination = new File(destination);
		 FileUtils.copyFile(source, finalDestination);
		 return fileName;
		 }
		
//	@AfterMethod
//	 public void getResult(ITestResult result) throws Exception{
//		System.out.println("in get result metond "+result.getStatus() + result.getName());
//		if(result.getStatus() == ITestResult.SUCCESS){
//			
//			
//		  test.log(LogStatus.FAIL, "Test step Failed is "+result.getName());
//		 //test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
//	 //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
//	                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 
//	                        String screenshotPath = getScreenhot(result.getName());
//	 //To add it in the extent report 
//	                        test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
//	 }else if(result.getStatus() == ITestResult.SKIP){
//		 test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
//	 }
//	}
	
	public void resultLogSuccess(ITestResult result) throws Exception{
		if(result.getStatus() == ITestResult.SUCCESS){
			
			
//		  test.log(LogStatus.PASS, "Test step Failed is "+result.getName());
		  //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
	      String screenshotPath = getScreenhot(result.getName());
	      
	 //To add it in the extent report 
	       test.log(LogStatus.PASS, test.addScreenCapture(screenshotPath));
	 }else if(result.getStatus() == ITestResult.SKIP){
		 test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	 }
	
	}
	
	
	public void resultLogFailure(ITestResult result) throws Exception{
			if(result.getStatus() == ITestResult.FAILURE){
				
				
//			  test.log(LogStatus.FAIL, "Test step Failed is "+result.getName());
			  //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
		      String screenshotPath = getScreenhot(result.getName());
		 //To add it in the extent report 
		       test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		 }else if(result.getStatus() == ITestResult.SKIP){
			 test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		 }
	 
	 }
	
	/*
	 * This is used to set getStatus value to 1, which is success cases
	 */
	
	public void iTestResultsSuccess() throws Exception{
		ITestResult temp = new ITestResult() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public int compareTo(ITestResult o) {
				return 0;
			}
			
			@Override
			public void setAttribute(String name, Object value) {
				
			}
			
			@Override
			public Object removeAttribute(String name) {
					return null;
			}
			
			@Override
			public Set<String> getAttributeNames() {
				return null;
			}
			
			@Override
			public Object getAttribute(String name) {
				return null;
			}
			
			@Override
			public void setThrowable(Throwable throwable) {
			}
			
			@Override
			public void setStatus(int status) {
				}
			
			@Override
			public void setParameters(Object[] parameters) {
				}
			
			@Override
			public void setEndMillis(long millis) {
				}
			
			@Override
			public boolean isSuccess() {
					return false;
			}
			
			@Override
			public Throwable getThrowable() {
				return null;
			}
			
			@Override
			public String getTestName() {
				return null;
			}
			
			@Override
			public ITestContext getTestContext() {
				return null;
			}
			
			@Override
			public IClass getTestClass() {
				return null;
			}
			
			@Override
			public int getStatus() {
				return 1;
			}
			
			@Override
			public long getStartMillis() {
				return 0;
			}
			
			@Override
			public Object[] getParameters() {
				return null;
			}
			
			@Override
			public String getName() {
				return "click";
			}
			
			@Override
			public ITestNGMethod getMethod() {
				return null;
			}
			
			@Override
			public String getInstanceName() {
				return null;
			}
			
			@Override
			public Object getInstance() {
				return null;
			}
			
			@Override
			public String getHost() {
				return null;
			}
			
			@Override
			public long getEndMillis() {
				return 0;
			}
		};
		resultLogSuccess(temp);
	}
	
	
	public void iTestResultsFailure() throws Exception{
		ITestResult temp = new ITestResult() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public int compareTo(ITestResult o) {
				return 0;
			}
			
			@Override
			public void setAttribute(String name, Object value) {
				
			}
			
			@Override
			public Object removeAttribute(String name) {
					return null;
			}
			
			@Override
			public Set<String> getAttributeNames() {
				return null;
			}
			
			@Override
			public Object getAttribute(String name) {
				return null;
			}
			
			@Override
			public void setThrowable(Throwable throwable) {
			}
			
			@Override
			public void setStatus(int status) {
				}
			
			@Override
			public void setParameters(Object[] parameters) {
				}
			
			@Override
			public void setEndMillis(long millis) {
				}
			
			@Override
			public boolean isSuccess() {
					return false;
			}
			
			@Override
			public Throwable getThrowable() {
				return null;
			}
			
			@Override
			public String getTestName() {
				return null;
			}
			
			@Override
			public ITestContext getTestContext() {
				return null;
			}
			
			@Override
			public IClass getTestClass() {
				return null;
			}
			
			@Override
			public int getStatus() {
				return 2;
			}
			
			@Override
			public long getStartMillis() {
				return 0;
			}
			
			@Override
			public Object[] getParameters() {
				return null;
			}
			
			@Override
			public String getName() {
				return null;
			}
			
			@Override
			public ITestNGMethod getMethod() {
				return null;
			}
			
			@Override
			public String getInstanceName() {
				return null;
			}
			
			@Override
			public Object getInstance() {
				return null;
			}
			
			@Override
			public String getHost() {
				return null;
			}
			
			@Override
			public long getEndMillis() {
				return 0;
			}
		};
		resultLogFailure(temp);
	}
	
	@AfterTest
	public void endReport(){
		// ending test
		 //endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(test);
		
	}
	
	@AfterSuite
	public void afterSuite() {
		extent.flush();
		extent.close();
		driver.get("D:\\Java\\WrkspaceEclipse\\SeleniumAutomation\\report\\ExtentReport.html");
	}

	
	

}
