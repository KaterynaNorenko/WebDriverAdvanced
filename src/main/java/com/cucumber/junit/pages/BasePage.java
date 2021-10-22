package com.cucumber.junit.pages;

import com.cucumber.junit.util.WebDriverWaiters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.cucumber.junit.driver.DriverManager.getDriver;
import static com.cucumber.junit.util.ActionsManager.newAction;
import static com.cucumber.junit.util.JsExecutorManager.executeJsScript;
import static com.cucumber.junit.util.SelectManager.newSelect;
import static org.openqa.selenium.Keys.ENTER;

import java.util.List;
import java.util.stream.Collectors;


public class BasePage extends WebDriverWaiters {

	public BasePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement findElement(By by) {
		return getDriver().findElement(by);
	}

	public List<WebElement> findElements(By by) {
		return getDriver().findElements(by);
	}

	public void waitForElementIsClickable(By by) {
		waitUntilElementClickable(by);
	}

	public void waitForElementIsVisible(By by) {
		waitUntilElementVisible(by, 10);
	}

	public void jsScrollByPixels(String pixelsUp, String pixelsDown) {
		executeJsScript("window.scrollBy(arguments[0], arguments[1])", pixelsUp, pixelsDown);
	}

	public void clickElement(By by) {
		getDriver().findElement(by).click();
	}

	public void getElementSendKeys(By by, String value) {
		newAction().moveToElement(findElement(by)).click().sendKeys(value).perform();
	}

	public void getElementSendKeysEnter(By by, String value) {
		newAction().moveToElement(findElement(by)).click().sendKeys(value).sendKeys(ENTER).perform();
	}

	public void getElementDoSelectByVisibleText(By by, String value) {
		newSelect(by).selectByVisibleText(value);
	}

	public String getElementGetText(By by) {
		return getDriver().findElement(by).getText();
	}

	public List<String> getResults(By by) {
		return findElements(by)
				.stream()
				.map(WebElement::getText)
				.collect(Collectors.toList());
	}

	public void findElementByDynamicXpath(String xpath, String value) {
		findElement(By.xpath(String.format(xpath, value))).click();
	}
}