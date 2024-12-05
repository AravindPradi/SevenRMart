package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import utility.LoginUtility;

public class CategoryTest extends Base {

	@Test(description = "This is to verify user to access Category page, view and search", groups = {"regression"})
	public void verifyUserAbleToViewAndSearchInCategoryPage() {
		String username = "admin";
		String password = "admin";
		String categoryName = "Ergonomic Iron Hat";
		String url = "";

		LoginUtility loginUtility = new LoginUtility(driver);
		loginUtility.succesfulLogin(username, password);

		CategoryPage categoryPage = new CategoryPage(driver);
		categoryPage.clickCategoryMenu(url);
		categoryPage.isCategoryPage();
		categoryPage.openSearch();
		boolean isSearched = categoryPage.searchCategory(categoryName);
		Assert.assertTrue(isSearched, "User is unable to get the search result");
	}
}
