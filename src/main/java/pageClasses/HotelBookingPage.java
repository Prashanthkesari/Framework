package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tekSystems.automation.SeleniumAutomation.GlobalFunctions;

public class HotelBookingPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public HotelBookingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
		this.driver = driver;
		
	}

	GlobalFunctions globalFunctions = new GlobalFunctions();
	
	@FindBy(xpath="//input[@value='Continue adding traveler']")
	private WebElement addingTraveller;
	
	@FindBy(id="LoginContinueBtn_1")
	private WebElement continueonEmail;
	
	@FindBy(xpath="//small[@class='hint ugly errorLabel']")
	private WebElement errorOnEmail;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement emailifField;
	
	@FindBy(id="travellerBtn")
	private WebElement continueonTraveller;
	
	@FindBy(xpath="//*[text()='Name of guest']/following::input[@name='lastName']/following-sibling::small")
	private WebElement erroronGuestName;
	
	@FindBy(xpath="//*[text()='Mobile no.']/following::input[@id='mobileNumber']/following::small[@class='hint ugly errorLabel']")
	private WebElement erroronMobileno;
	
	@FindBy(id="contactSalutation")
	private WebElement title;
	
	@FindBy(id="contactFirstName")
	private WebElement firstName;
	
	@FindBy(id="contactLastName")
	private WebElement lastName;
	
	@FindBy(xpath="//*[@id='mobileNumber' and @name='contact1']")
	private WebElement mobileNumber;
	
	@FindBy(id="creditCardNumberDisp")
	private WebElement creditCardno;

	@FindBy(id="CcExpirationMonth")
	private WebElement creditCardMonth;
	
	@FindBy(id="CcExpirationYear")
	private WebElement creditCardYear;
	
	@FindBy(xpath="(//*[@name='bill_name'])[1]")
	private WebElement cardHolderName;
	
	@FindBy(id="cvvCode")
	private WebElement cvvCode;
	
	@FindBy(id="paymentSubmit")
	private WebElement makePaymentButton;
	
	@FindBy(xpath="//*[text()='Credit card no.']/following::small[@id='CCNotAccepted']")
	private WebElement erroronCCno;
	
	public void bookingHotel() throws Exception{
		globalFunctions.Click(addingTraveller, "add TravellerButton");
		
						
		
	}
	public void emailAddress() throws Exception{
		wait.until(ExpectedConditions.elementToBeClickable(continueonEmail));
		globalFunctions.Click(continueonEmail, "continueonEmail");
		globalFunctions.verifyText(errorOnEmail, "You missed this");
		globalFunctions.Type(emailifField, "random@test.com", "emailIdField");
		globalFunctions.Click(continueonEmail, "continueonEmailaftererror");
	}
	

	public void guestDetails() throws Exception{
		wait.until(ExpectedConditions.elementToBeClickable(continueonTraveller));
		globalFunctions.Click(continueonTraveller, "continueonTraveller");
		globalFunctions.verifyText(erroronGuestName, "You missed this");
		globalFunctions.verifyText(erroronMobileno, "You missed this");
		globalFunctions.selectValueBy(title, "value", "Mr", "titleof Traveller");
		globalFunctions.Type(firstName, globalFunctions.readData("C:/Users/pkesari/Desktop/sample.xml", "//firstname"), "FirstName");
		globalFunctions.Type(lastName, globalFunctions.readData("C:/Users/pkesari/Desktop/sample.xml", "//lastname"), "LastName");
		globalFunctions.Type(mobileNumber, globalFunctions.readData("C:/Users/pkesari/Desktop/sample.xml", "//mobileno"), "mobilenumber");
		globalFunctions.Click(continueonTraveller, "continueonTravelleraftererror");
	}
	
	public void paymentverification() throws Exception{
		wait.until(ExpectedConditions.elementToBeClickable(creditCardno));
		globalFunctions.Type(creditCardno, globalFunctions.readData("C:/Users/pkesari/Desktop/sample.xml", "//cardnumber"), "testcreditcardno");
		globalFunctions.selectValueBy(creditCardMonth, "value", globalFunctions.readData("C:/Users/pkesari/Desktop/sample.xml", "//cardmonth"), "monthofCreditCard");
		globalFunctions.selectValueBy(creditCardYear, "value", globalFunctions.readData("C:/Users/pkesari/Desktop/sample.xml", "//cardyear"), "creditcardYear");
		globalFunctions.Type(cardHolderName, globalFunctions.readData("C:/Users/pkesari/Desktop/sample.xml", "//cardname"), "ccholdername");
		globalFunctions.Type(cvvCode, globalFunctions.readData("C:/Users/pkesari/Desktop/sample.xml", "//cvv"), "cvvcode");
		globalFunctions.Click(makePaymentButton, "makePaymentbutton");
		globalFunctions.verifyText(erroronCCno, "Sorry, we couldn't recognise the card you provided. Please use another card.");
	}
}
