package testscript;

import org.testng.annotations.Test;

import pages.ManageFooterTextPage;
import utility.LoginUtility;

public class ManageFooterTest extends Base {
	
	
	@Test(description = "Verify user to access manage footer text page and able to edit", groups = {"regression"})
	public void verifyUserToAccessAndEditManageFooterTextPage() {
		
		String username = "admin";
		String password = "admin";
		
		LoginUtility login = new LoginUtility(driver);
		login.succesfulLogin(username, password);
		
		ManageFooterTextPage footerTextPage = new ManageFooterTextPage(driver);
		footerTextPage.clickManageFooterText();
		footerTextPage.isManageFooterTextPage();
		footerTextPage.clickActionButton();
		
	}

}
