package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SubCategoryPage;
import utility.ExcelUtility;
import utility.FileUploadUtility;
import utility.LoginUtility;
import utility.RandomUtility;
import constants.Constants;

public class SubCategoryTest extends Base {

	@Test(description = "This is to verify user able to access, view and add a new subcategory", groups = {"regression"})
	public void verifyUserAbleToViewAndAddNewSubCategory() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String url_1 = "https://groceryapp.uniqassosiates.com/admin/list-sub-category";

		RandomUtility random = new RandomUtility();
		String sub_cat_name = random.createRandomProductNames();
		String filepath = Constants.SUB_CATEGORY_FILE_UPLOAD;

		LoginUtility loginUtility = new LoginUtility(driver);
		loginUtility.succesfulLogin(username, password);

		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		FileUploadUtility fileUploadUtility = new FileUploadUtility();

		subcategorypage.clickAddNewButton(url_1);
		subcategorypage.clickCategoryDropdown();
		subcategorypage.enterSubCategoryName(sub_cat_name);
		subcategorypage.imageUploadedTo(filepath, fileUploadUtility);
		subcategorypage.clickSaveButton();
		boolean subCategorysaved = subcategorypage.isSuccessMessage();
		Assert.assertTrue(subCategorysaved, "Not able to load subcategory page and unable to create a sub category");
	}
}
