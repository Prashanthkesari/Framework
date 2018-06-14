package org.tekSystems.automation.SeleniumAutomation;

import org.testng.annotations.Test;

import pageClasses.WorldBankProjects;

public class WorldBankAssignment extends TekBase {

	@Test(enabled = false)
	public void login() throws Exception {

		WorldBankProjects worldBankProject = new WorldBankProjects(driver);
		worldBankProject.navigatetoProjectPage();
		worldBankProject.getOperationsValue("Middle East and North Africa");
		//worldBankProject.sortCoutriesOnValue(map);
	}

}
