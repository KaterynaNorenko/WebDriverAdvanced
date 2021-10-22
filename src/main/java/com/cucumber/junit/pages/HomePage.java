package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;

import org.openqa.selenium.By;


public class HomePage extends BasePage {
	private static final String ACCELERATOR_URL = "https://ecsc00a08ec4:9002/yacceleratorstorefront/?site=electronics";
	private static final By SEARCH_INPUT = By.xpath("//*[@id='js-site-search-input']");

	public void openAcceleratorWebsite() {
		DriverManager.getDriver().get(ACCELERATOR_URL);
	}

	public void getSearchInput(String productNumber) {
		waitForElementIsClickable(SEARCH_INPUT);
		getElementSendKeysEnter(SEARCH_INPUT, productNumber);
	}
}