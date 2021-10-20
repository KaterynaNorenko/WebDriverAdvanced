package com.cucumber.junit.pages;

import org.openqa.selenium.*;

import static com.cucumber.junit.util.ActionsManager.newAction;

public class SignInRegister extends BasePage {
    private static final By EMAIL_INPUT = By.xpath("//input[@id='guest.email']");
    private static final By EMAIL_INPUT_CONFIRMATION = By.xpath("//input[@id='guest.confirm.email']");

    public void inputEmail(String email) {
        newAction().moveToElement(findElement(EMAIL_INPUT)).click().sendKeys(email).sendKeys(Keys.ENTER).perform();
    }

    public void inputEmailConfirmation(String email) {
        newAction().moveToElement(findElement(EMAIL_INPUT_CONFIRMATION)).click().sendKeys(email).sendKeys(Keys.ENTER).perform();
    }
}
