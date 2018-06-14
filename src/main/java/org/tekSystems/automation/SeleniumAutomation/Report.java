package org.tekSystems.automation.SeleniumAutomation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report extends TekBase {

	public GlobalFunctions gF;
	ExtentTest tempExtentTest = new ExtentTest("testName", "description");

	public void logReportPass(String description) throws Exception {
		try{
		test.log(LogStatus.PASS, "Successfully clicked on" + description);
		String screenshotName = getScreenhot();
		test.log(LogStatus.PASS, test.addScreenCapture(screenshotName));
		}catch (Exception e){
			System.out.println(e);
		}
		
	}

	public void logReportFail(String description) throws Exception {

		test.log(LogStatus.FAIL, "Click failed on" + description);
		String screenshotName = getScreenhot();
		test.log(LogStatus.FAIL, test.addScreenCapture(screenshotName));
	}

//	@BeforeMethod
//	public void launchApplication(Method method) {
//		reportTest(method);
//	}

	public String getScreenhot() throws Exception {
		// SecureRandom random = new SecureRandom();
		// int dateName = random.nextInt(100000);
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String fileName = dateName + ".png";
		String destination = System.getProperty("user.dir") + "/report/" + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return fileName;
	}

}
