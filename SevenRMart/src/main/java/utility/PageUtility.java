package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void clickAndHoldOnElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).perform();
	}

	public void actionClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.click(element).perform();
	}

	public void doubleClickElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void sendText(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void rightClickAndHoldOnElement(WebElement element, WebDriver driver, String text) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element, text).perform();
	}

	public void sendTexttoUppercase(WebElement element, WebDriver driver, String text) {
		Actions actions = new Actions(driver);
		actions.keyDown(element, Keys.SHIFT).sendKeys(text).perform();
	}

	public void navigateToURL(String url, WebDriver driver) {
		driver.navigate().to(url);
	}

	public void sendKeys(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
		Select select = new Select(dropdownElement);
		select.selectByVisibleText(visibleText);
	}

	public void selectDropdownByValue(WebElement dropdownElement, String value) {
		Select select = new Select(dropdownElement);
		select.selectByValue(value);
	}

	public void selectDropdownByIndex(WebElement dropdownElement, int index) {
		Select select = new Select(dropdownElement);
		select.selectByIndex(index);
	}

	public String getElementText(WebElement element) {
		return element.getText();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void javaScriptExecutorSample(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,370)", "");
	}

	public void javaScriptExecutorSample2(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void javaScriptExecutorSample3(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}

	public void javaScriptExecutorSample4(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void javaScriptExecutorSample5(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void clearField(WebElement inputField) {
		inputField.clear();
	}

}
