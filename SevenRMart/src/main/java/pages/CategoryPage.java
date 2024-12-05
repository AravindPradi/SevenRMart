package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utility.PageUtility;

public class CategoryPage {
	public WebDriver driver;
	public PageUtility pageutility;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		this.pageutility = new PageUtility(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, 'nav-link') and .//p[text()='Category']]")
	private WebElement clickCategoryMenu;
	@FindBy(xpath = "//h4[@class='card-title' and text()='List Categories']")
	private WebElement categoryPageVisible;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary' and @onclick='click_button(2)']")
	private WebElement clickSearchButton;
	@FindBy(xpath = "//input[@class='form-control' and @name='un' and @placeholder='Category']")
	private WebElement searchInputField;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix' and @name='Search' and @value='sr']")
	private WebElement searchCategoryButtonClick;

	public void clickCategoryMenu(String url) {
		pageutility.navigateToURL(url);
		clickCategoryMenu.click();
	}

	public boolean isCategoryPage() {
		return categoryPageVisible.isDisplayed();
	}

	public void openSearch() {
		clickSearchButton.click();
	}

	public boolean searchCategory(String categoryName) {
		searchInputField.sendKeys(categoryName);
		searchCategoryButtonClick.click();
		return true;
	}
}
