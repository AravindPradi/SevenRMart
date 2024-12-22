package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageUsers;
import utility.LoginUtility;
import utility.RandomUtility;

public class ManageUsersTest extends Base {

	@Test
	public void verifyUserToAccessManageUserAndAddNewUser() {

		String username = "admin";
		String password = "admin";

		RandomUtility random = new RandomUtility();
		String data = random.createRandomUsername();
		String passkey = random.createRandomPassword();

		LoginUtility loginUtility = new LoginUtility(driver);
		loginUtility.succesfulLogin(username, password);

		ManageUsers manageUsers = new ManageUsers(driver);
		manageUsers.clickAdminUsersMenu();
		manageUsers.clickManageUsers();
		manageUsers.manageUsersPageDisplayed();
		manageUsers.isAddButtonClicked();
		manageUsers.isUsernameField(data);
		manageUsers.isPasswordField(passkey);
		manageUsers.isUserTypeDropdown();
		manageUsers.saveButtonClicked();
		boolean saveAlert = manageUsers.successMessageDisplayed();
		Assert.assertTrue(saveAlert, "User is unable access manage user page");

	}
}
