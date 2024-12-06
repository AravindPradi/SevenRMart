package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.PageUtility;

public class ManageNewsPage {
    public WebDriver driver;
    public PageUtility pageutility;

    public ManageNewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.pageutility = new PageUtility();
    }
    
    @FindBy(xpath = "//a[@class=' nav-link' and .//p[text()='Manage product']]") private WebElement clickManageNewsMenu;
    @FindBy(xpath = "//h4[@class=\"card-title\" and text()='Manage News']") private WebElement manageNewsPage;
    @FindBy(xpath = "//a[@class=\"btn btn-rounded btn-danger\"]") private WebElement addNewsButton ;
    @FindBy(xpath = "//h3[@class='card-title' and text()='Enter News Informations']") private WebElement addNewsPage ;
    @FindBy(xpath = "//textarea[@id='news']") private WebElement addNewsInputField;
    @FindBy(xpath = "//button[@name='create']") private WebElement saveButton;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") private WebElement saveAlert;
    
    
    public void clickOnManageNews() {
        clickManageNewsMenu.click();
    }
    
    public void isManageNewsPage(String url) {
    	pageutility.navigateToURL(url, driver);
    	manageNewsPage.isDisplayed();
    }
    
    public void isAddNewsButton() {
    	addNewsButton.click();
    }
    
    public void isAddNewsPage() {
    	addNewsPage.isDisplayed();
    }
    
    public void addNewsIntoField(String data) {
		addNewsInputField.sendKeys(data);
	}
    
    public void clickSaveButton() {
    	saveButton.click();
    }
    
    public boolean isSuccessMessage() {
    	return saveAlert.isDisplayed();
    }
    

}
