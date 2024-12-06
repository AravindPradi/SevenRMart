package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.PageUtility;

public class LoginPage {
	
	public WebDriver driver;
	public PageUtility pageutility;
	
	public LoginPage(WebDriver driver) {    //constructor
		this.driver = driver;
	
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//input[@name='username']") private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']") private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']") private WebElement signinbutton;
	@FindBy(xpath="//p[text()='Dashboard']") private WebElement dashboard;
	@FindBy(xpath="//div[contains(@class,'alert-danger')]") private WebElement login_failed;

	

	public void enterUsernameOnUsernameField(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterPasswordOnPasswordField(String password) {
		
		passwordField.sendKeys(password);
	}
	
	public void clickSignInButton() {
		pageutility = new PageUtility();
		pageutility.actionClick(driver, signinbutton);
	}
	
	public boolean isLoginSuccess() {
		try {
			return dashboard.isDisplayed();
		}catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean isAlertMessageAvailable() {
		boolean isAlertAvailable = login_failed.isDisplayed();
		return isAlertAvailable;
	}

}       