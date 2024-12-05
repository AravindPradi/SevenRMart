package testscript;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base {
    
    @Test(description = "This is to verify valid credentials", groups = {"smoke"}, priority = 1)
    public void validCredetials() 
    {
    	String username = ExcelUtility.getString(1, 0, "LoginPage");
    	String password = ExcelUtility.getString(1, 1, "LoginPage");
    	LoginPage loginpage = new LoginPage(driver);
    	loginpage.enterUsernameOnUsernameField(username);
    	loginpage.enterPasswordOnPasswordField(password);
    	loginpage.clickSignInButton();
    	boolean isNavigatedToDashboard = loginpage.isLoginSuccess();
    	Assert.assertTrue(isNavigatedToDashboard,"User is unable to login with valid credentials");
    	
    	
    }
    
    
    @Test(description = "This is to verify user login with correct username and wrong password",groups = {"regression"}, priority = 2)
    public void verifyUserLoginWithCorrectUsernameAndWrongPassword() {
    	String username = "admin";
    	String password = "wrongpassword";
    	LoginPage loginpage = new LoginPage(driver);
    	loginpage.enterUsernameOnUsernameField(username);
    	loginpage.enterPasswordOnPasswordField(password);
    	loginpage.clickSignInButton();
    	boolean isRedirectedToDashboard = loginpage.isAlertMessageAvailable();
    	Assert.assertTrue(isRedirectedToDashboard, "User is able to login with invalid credentials");
    	
    }
    
    @Test(description = "This is to verify user login with incorrect username and incorrect password" , groups= {"smoke", "regression"}, priority = 3)
    public void verifyUserLoginWithIncorrectUsernameAndIncorrectPassword() {
    	String username = "wrongusername";
    	String password = "wrongpassword";
    	LoginPage loginpage = new LoginPage(driver);
    	loginpage.enterUsernameOnUsernameField(username);
    	loginpage.enterPasswordOnPasswordField(password);
    	loginpage.clickSignInButton();
    	boolean isRedirectedToDashboard = loginpage.isAlertMessageAvailable();
    	Assert.assertTrue(isRedirectedToDashboard, "User is able to login with invalid credentials");
    	
    }
    
    @Test(description = "This is to verify the user login with incorrect username and correct password",groups = {"regression"}, priority = 4)
    public void verifyUserLoginWithIncorrectUsernameAndCorrectPassword() {
    	String username = "wrongusername";
    	String password = "admin";
    	LoginPage loginpage = new LoginPage(driver);
    	loginpage.enterUsernameOnUsernameField(username);
    	loginpage.enterPasswordOnPasswordField(password);
    	loginpage.clickSignInButton();
    	boolean isRedirectedToDashboard = loginpage.isAlertMessageAvailable();
    	Assert.assertTrue(isRedirectedToDashboard, "User is able to login with invalid credentials");
    	
    }
     
} 