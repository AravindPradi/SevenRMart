package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtility;

public class ManageFooterTextPage {
	
	public WebDriver driver;
	public WaitUtility waitUtility;
	
	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='Manage Footer Text']") private WebElement manageFooterText;
	@FindBy(xpath = "//h4[text()='Footer Text']") private WebElement verifyHeader;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']") private WebElement actionButton;
	@FindBy(xpath = "//h3[text()='Footer Text Informations']") private WebElement editPage ;
	
	public void clickManageFooterText() {
		waitUtility.waitForElement(driver, manageFooterText);
		manageFooterText.click();
	}
	
	public void isManageFooterTextPage() {
		waitUtility.waitForElement(driver, manageFooterText);
		verifyHeader.isDisplayed();
	}
	
	public void clickActionButton() {
		waitUtility.waitForElement(driver,actionButton);
		actionButton.click();
	}
	
	public void editFooterPage() {
		waitUtility.waitForElement(driver, editPage);
		editPage.isDisplayed();
	}
	

}







































