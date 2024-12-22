package utility;

import org.openqa.selenium.WebDriver;

import pages.LoginPage;

public class LoginUtility {

	public WebDriver driver;

	public LoginUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void succesfulLogin(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();
		loginpage.isLoginSuccess();
	}

}
