package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ManageNewsPage;
import utility.LoginUtility;
import utility.RandomUtility;

public class ManageNewsTest extends Base {

	@Test(description = "This is to verify user to access manage news page, view and add a new news", groups = {"regression"})
	public void verifyUserToViewAndAddInManageNewsPage() {
		String username = "admin";
		String password = "admin";
		String url = "https://groceryapp.uniqassosiates.com/admin/list-news";
		
		LoginUtility loginUtility = new LoginUtility(driver);
		loginUtility.succesfulLogin(username, password);
		RandomUtility random = new RandomUtility();
		
		String data = random.createRandomNews();

		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.isManageNewsPage(url);
		manageNewsPage.isAddNewsButton();
		manageNewsPage.isAddNewsPage();
		manageNewsPage.addNewsIntoField(data);
		manageNewsPage.clickSaveButton();
		boolean newsSaveSuccess = manageNewsPage.isSuccessMessage();
		Assert.assertTrue(newsSaveSuccess, "User is not able to access Manage News page and unable to create new data");
		
	}
}
