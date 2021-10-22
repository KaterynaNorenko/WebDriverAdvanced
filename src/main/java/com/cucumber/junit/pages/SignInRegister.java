package com.cucumber.junit.pages;

import org.openqa.selenium.*;


public class SignInRegister extends BasePage {
	private static final By EMAIL_INPUT = By.xpath("//input[@id='guest.email']");
	private static final By EMAIL_INPUT_CONFIRMATION = By.xpath("//input[@id='guest.confirm.email']");

	public void inputEmail(String email) {
		getElementSendKeys(EMAIL_INPUT, email);
	}

	public void inputEmailConfirmation(String email) {
		getElementSendKeysEnter(EMAIL_INPUT_CONFIRMATION, email);
	}
}