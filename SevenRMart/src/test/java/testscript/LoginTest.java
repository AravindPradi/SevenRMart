package testscript;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base {
    
    @Test(groups = {"smoke"}, priority = 1)
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
    
    
    @Test(groups = {"regression"})
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
    
    @Test(description = "This is to verify" , groups= {"smoke", "regression"})
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
    
    @Test
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