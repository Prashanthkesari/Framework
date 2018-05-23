package org.tekSystems.automation.SeleniumAutomation;

import org.testng.annotations.Test;

import pageClasses.WorldBankProjects;


public class WorldBankAssignment extends TekBase{
	

	@Test
	public void login() throws Exception{
		
			
		WorldBankProjects getData = new WorldBankProjects(driver);
		getData.getOperationsValue();
	}
	
	
	

}
