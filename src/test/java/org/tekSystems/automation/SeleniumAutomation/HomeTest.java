package org.tekSystems.automation.SeleniumAutomation;

import org.testng.annotations.*;

import pageClasses.HomePage;

public class HomeTest extends TekBase {

	@Test(enabled = false)
	public void login() throws Exception {

		HomePage homepage = new HomePage(driver);
		homepage.Login("//dev/userid", "//dev/password", "text", "Customer service");

	}

}
