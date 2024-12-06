package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ManageUsers {
	public WebDriver driver;
	
	public ManageUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(., 'Admin Users')]/ancestor::li[@class='nav-item has-treeview']") private WebElement adminUsers;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement manageUsers;
	@FindBy(xpath = "//h1[text()='Admin Users']") private WebElement isManageUsersPage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") private WebElement addNewButton;
	@FindBy(xpath = "//input[@name=\"username\"]") private WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']") private WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']") private WebElement userType;
	@FindBy(xpath = "//button[@name='Create']") private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") private WebElement successMessage;

	public void clickAdminUsersMenu() {
		adminUsers.click();
	}
	
	public void clickManageUsers() {
		manageUsers.click();
	}
	
	public void manageUsersPageDisplayed() {
		isManageUsersPage.isDisplayed();
	}
	
	public void isAddButtonClicked() {
		
		addNewButton.click();
	}
	
	public void isUsernameField(String data) {
		usernameField.sendKeys(data);
	}
	
	public void isPasswordField(String passkey) {
		passwordField.sendKeys(passkey);
	}
	
	public void isUserTypeDropdown() {
		Select select = new Select(userType);
        select.selectByIndex(3);
	}
	
	public void saveButtonClicked() {
		saveButton.click();
	}
	
	public boolean successMessageDisplayed() {
		return successMessage.isDisplayed();
	}
}
