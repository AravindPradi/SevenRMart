package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utility.PageUtility;
import utility.RandomUtility;
import utility.WaitUtility;

public class ManageContactPage {
	public WebDriver driver;
	WaitUtility waitutility=new WaitUtility();
	RandomUtility random = new RandomUtility();
	PageUtility pageUtility = new PageUtility();
	
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//p[text()='Manage Contact']") private WebElement manageContactPage;
	@FindBy(xpath = "//a[@class=\"btn btn-sm btn btn-primary btncss\"]") private WebElement actionButton;
	@FindBy(xpath = "//h3[@class='card-title']") private WebElement contactUsPage;
	@FindBy(xpath = "//input[@id='phone']") private WebElement phoneInputField; 
	@FindBy(xpath = "//input[@id='email']") private WebElement emailInputField;  
	@FindBy(xpath = "//textarea[@name='address']") private WebElement addressField;
	@FindBy(xpath = "//textarea[@name='del_time']") private WebElement deliveryTime;
	@FindBy(xpath = "//i[@class='fa fa-save']") private WebElement saveButton;
	
	
	public void isMangeContactPage() {
		waitutility.waitForElement(driver, manageContactPage);
		manageContactPage.click();
	}
	
	public void clickActionButton() {
		waitutility.waitForElement2(driver, actionButton);
		actionButton.click();
	}
	
	public void isContactUsPage() {
		waitutility.FluentWait(driver, contactUsPage);
		contactUsPage.isDisplayed();
	}
	
	public void enterPhoneNumber() {
		pageUtility.clearField(phoneInputField);
		String phone = random.createRandomPhoneNumber();
		phoneInputField.sendKeys(phone);
	}
	
	public void enterEmail() {
		pageUtility.clearField(emailInputField);
		String email = random.createRandomEmail();
		emailInputField.sendKeys(email);
	}
	
	public void enterAddress() {
		pageUtility.clearField(emailInputField);
		String address = random.createRandomAddress();
		emailInputField.sendKeys(address);
	}
	
	public void enterDeliveryTime() {
		pageUtility.clearField(deliveryTime);
		int randomTime = random.createRandomTime();
		String time = String.valueOf(randomTime);
		deliveryTime.sendKeys(time);
	}
	
	public void scrollDown() {
    	waitutility.waitForElement3(driver, "//a[@class='btn btn-default btn-fix']");
    	pageUtility.javaScriptExecutorSample(driver);
    }

	
	public boolean isUpdateButton() {
		try {
			saveButton.click();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
 }
