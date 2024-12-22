package testscript;

import org.testng.annotations.Test;

import pages.ManageContactPage;
import utility.ExcelUtility;
import utility.LoginUtility;

public class ManageContactTest extends Base {

	@Test(description = "This is to verify user to access contact us  page, view and edit", groups = { "regression" })
	public void verifyUserAbleToAccessManageContactAndEdit() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");

		LoginUtility loginUtility = new LoginUtility(driver);
		loginUtility.succesfulLogin(username, password);

		ManageContactPage manageContact = new ManageContactPage(driver);
		manageContact.isMangeContactPage();
		manageContact.clickActionButton();
		manageContact.isContactUsPage();
		manageContact.enterPhoneNumber();
		manageContact.enterEmail();
		manageContact.enterAddress();
		manageContact.enterDeliveryTime();
		manageContact.scrollDown();
		manageContact.isUpdateButton();
	}

}
