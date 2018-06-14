package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tekSystems.automation.SeleniumAutomation.GlobalFunctions;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	GlobalFunctions globalFunctions = new GlobalFunctions();

	@FindBy(xpath = "//*[@class='login']")
	@CacheLookup
	private WebElement signButton;

	@FindBy(xpath = "//*[@class='logout']")
	@CacheLookup
	private WebElement signOut;

	@FindBy(id = "email")
	@CacheLookup
	private WebElement userNameTextbox;

	@FindBy(id = "passwd")
	@CacheLookup
	private WebElement passwordTextbox;

	@FindBy(xpath = "//*[@id='SubmitLogin']")
	@CacheLookup
	private WebElement submitButton;

	@FindBy(xpath = "//*[@title='Contact Us']")
	@CacheLookup
	private WebElement contactus;

	@FindBy(id = "id_contact")
	@CacheLookup
	private WebElement subjectDropdown;

	public void Login(String Username, String Password, String value, String data) throws Exception {

		Thread.sleep(5000);
		globalFunctions.Click(signButton, "Sign Button");
		globalFunctions.Type(userNameTextbox, globalFunctions.readData("C:/Users/pkesari/Desktop/sample.xml", Username),
				"userNameTextbox");
		globalFunctions.Type(passwordTextbox, globalFunctions.readData("C:/Users/pkesari/Desktop/sample.xml", Password),
				"passwordTextbox");
		globalFunctions.Click(submitButton, "Submit Button");
		globalFunctions.Click(contactus, "Contact Us");
		globalFunctions.selectValueBy(subjectDropdown, value, data, "subjectDropdown");
		Thread.sleep(5000);
		globalFunctions.logOut(signOut, "signOut");

	}

}
