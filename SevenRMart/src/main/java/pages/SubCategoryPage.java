package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.FileUploadUtility;

public class SubCategoryPage {

    public WebDriver driver;

    public SubCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@class, 'nav-link') and .//p[text()='Sub Category']]") private WebElement clickSubCategoryMenu;
    @FindBy(xpath = "//h4[@class=\"card-title\" and text()='List Sub Categories']") private WebElement isSubCategoryPage;
    @FindBy(xpath = "//a[@onclick='click_button(1)' and contains(text(), 'New')]") private WebElement addNewButton;
    @FindBy(xpath = "//select[@id='cat_id']") private WebElement categoryDropdown;
    @FindBy(xpath = "//input[@id=\"subcategory\"]") private WebElement subCategeoryInput;
    @FindBy(xpath = "//input[@id=\"main_img\"]") private WebElement uploadImage;
    @FindBy(xpath = "//button[@name=\"create\"]") private WebElement saveButton;
    @FindBy(xpath = "//h5[normalize-space(text()= ' Sub Category Created Successfully')]") private WebElement successAlert;

    public void SubCategoryMenu(String url_1) {
        driver.navigate().to(url_1);
        clickSubCategoryMenu.click();
    }

    public boolean navigatedToSubCategoryPage() {
        return isSubCategoryPage.isDisplayed();
    }

    public void clickAddNewButton(String url_2) {
        driver.navigate().to(url_2);
        addNewButton.click();
    }

    public void clickCategoryDropdown() {
        Select select = new Select(categoryDropdown);
        select.selectByIndex(1);
    }

    public void enterSubCategoryName(String sub_cat_name) {
        subCategeoryInput.sendKeys(sub_cat_name);
    }

    public void imageUploadedTo(String filepath, FileUploadUtility fileUploadUtility){
        fileUploadUtility.verifyFileUploadusingSendKeys(uploadImage, filepath);
    }
    
    public void clickSaveButton() {
    	saveButton.click();
    }
    
    public boolean isSuccessMessage() {
		return successAlert.isDisplayed();
	}
}
