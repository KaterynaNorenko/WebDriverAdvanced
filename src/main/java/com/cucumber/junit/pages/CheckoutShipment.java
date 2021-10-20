package com.cucumber.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.cucumber.junit.util.JsExecutorManager.executeJsScript;
import static com.cucumber.junit.util.SelectManager.newSelect;

import java.util.Map;

public class CheckoutShipment extends BasePage {
    private static final By ORDER_SUBTOTAL = By.cssSelector(".subtotal span");
    private static final By ORDER_TOTAL = By.cssSelector(".totals span");
    private static final By ORDER_TAX = By.cssSelector("div.tax > span");
    private static final By DISCOUNTS = By.cssSelector(".subtotals__item--state-discount > span");
    private static final By COUNTRY_REGION_DROPDOWN = By.xpath("//select[@id='address.country']");
    private static final By NEXT_BTN_ADDRESS = By.xpath("//button[@id='addressSubmit']");
    private static final By NEXT_BTN_SHIPMENT = By.xpath("//button[@id='deliveryMethodSubmit']");
    private static final By CARD_TYPE_DROPDOWN = By.xpath("//*[@id='card_cardType']");
    private static final By NAME_ON_CARD = By.xpath("//*[@id='card_nameOnCard']");
    private static final By CARD_NUMBER = By.xpath("//*[@id='card_accountNumber']");
    private static final By EXPIRY_YEAR_DROPDOWN = By.xpath("//*[@id='ExpiryYear']");
    private static final By EXPIRY_MONTH_DROPDOWN = By.xpath("//*[@id='ExpiryMonth']");
    private static final By CVV = By.xpath("//*[@id='card_cvNumber']");
    private static final By FIRST_NAME_ERROR_MESSAGE = By.xpath("//*[@id='firstName.errors']");
    private static final By LAST_NAME_ERROR_MESSAGE = By.xpath("//*[@id='lastName.errors']");
    private static final By ADDRESS_LINE1_ERROR_MESSAGE = By.xpath("//*[@id='line1.errors']");
    private static final By CITY_ERROR_MESSAGE = By.xpath("//*[@id='townCity.errors']");
    private static final By POST_CODE_ERROR_MESSAGE = By.xpath("//*[@id='postcode.errors']");
    private static final By FIRST_NAME = By.xpath("//*[@id='address.firstName']");
    private static final By LAST_NAME = By.xpath("//*[@id='address.surname']");
    private static final By ADDRESS_LINE1 = By.xpath("//*[@id='address.line1']");
    private static final By CITY = By.xpath("//*[@id='address.townCity']");
    private static final By POST_CODE = By.xpath("//*[@id='address.postcode']");

    private static final String ORDER_SUBTOTAL_TITLE = "Sub Total";
    private static final String DISCOUNTS_TITLE = "Discounts";
    private static final String ORDER_TAX_TITLE = "Tax";
    private static final String ORDER_TOTAL_TITLE = "Total";
    private static final String FIRST_NAME_TITLE = "First Name";
    private static final String LAST_NAME_TITLE = "Last Name";
    private static final String ADDRESS_LINE1_TITLE = "Address Line1";
    private static final String CITY_TITLE = "City";
    private static final String POST_CODE_TITLE = "Post Code";
    private static final String CARD_TYPE_TITLE = "Card Type";
    private static final String NAME_ON_CARD_TITLE = "Name on Card";
    private static final String CARD_NUMBER_TITLE = "Card Number";
    private static final String EXPIRY_YEAR_TITLE = "Expiry Year";
    private static final String EXPIRY_MONTH_TITLE = "Expiry Month";
    private static final String CVV_TITLE = "CVV";

    public String getOrderSubtotal() {
        return findElement(ORDER_SUBTOTAL).getText();
    }

    public String getOrderTotal() {
        return findElement(ORDER_TOTAL).getText();
    }

    public String getOrderTax() {
        return findElement(ORDER_TAX).getText();
    }

    public String getOrderDiscount() {
        return findElement(DISCOUNTS).getText();
    }

    public void getCountryRegionDropDown(String country) {
        newSelect(COUNTRY_REGION_DROPDOWN).selectByVisibleText(country);
    }

    public WebElement getNextButtonShipment() {
        return findElement(NEXT_BTN_SHIPMENT);
    }

    public WebElement getCardTypeDropDown() {
        return findElement(CARD_TYPE_DROPDOWN);
    }

    public void getNameOnCard(String nameOnCard) {
        findElement(NAME_ON_CARD).sendKeys(nameOnCard);
    }

    public void getCardNumber(String cardNumber) {
        findElement(CARD_NUMBER).sendKeys(cardNumber);
    }

    public void getExpiryYearDropDown(String expiryYear) {
        newSelect(EXPIRY_YEAR_DROPDOWN).selectByVisibleText(expiryYear);
    }

    public void getExpiryMonthDropDown(String expiryMonth) {
        newSelect(EXPIRY_MONTH_DROPDOWN).selectByVisibleText(expiryMonth);
    }

    public void getCvv(String cvv) {
        findElement(CVV).sendKeys(cvv);
    }

    public String getFirstNameErrorMessage() {
        return findElement(FIRST_NAME_ERROR_MESSAGE).getText();
    }

    public String getLastNameErrorMessage() {
        return findElement(LAST_NAME_ERROR_MESSAGE).getText();
    }

    public String getAddressLine1ErrorMessage() {
        return findElement(ADDRESS_LINE1_ERROR_MESSAGE).getText();
    }

    public String getCityErrorMessage() {
        return findElement(CITY_ERROR_MESSAGE).getText();
    }

    public String getPostCodeErrorMessage() {
        return findElement(POST_CODE_ERROR_MESSAGE).getText();
    }

    public void getFirstName(String firstName) {
        findElement(FIRST_NAME).sendKeys(firstName);
    }

    public void getLastName(String lastName) {
        findElement(LAST_NAME).sendKeys(lastName);
    }

    public void getAddressLine1(String addressLine1) {
        findElement(ADDRESS_LINE1).sendKeys(addressLine1);
    }

    public void getCity(String city) {
        findElement(CITY).sendKeys(city);
    }

    public void getPostCode(String postCode) {
        findElement(POST_CODE).sendKeys(postCode);
    }

    public String getOrderSubtotalTitle() {
        return ORDER_SUBTOTAL_TITLE;
    }

    public String getOrderDiscountTitle() {
        return DISCOUNTS_TITLE;
    }

    public String getOrderTaxTitle() {
        return ORDER_TAX_TITLE;
    }

    public String getOrderTotalTitle() {
        return ORDER_TOTAL_TITLE;
    }

    public String getFirstNameTitle() {
        return FIRST_NAME_TITLE;
    }

    public String getLastNameTitle() {
        return LAST_NAME_TITLE;
    }

    public String getAddressLine1Title() {
        return ADDRESS_LINE1_TITLE;
    }

    public String getCityTitle() {
        return CITY_TITLE;
    }

    public String getPostCodeTitle() {
        return POST_CODE_TITLE;
    }

    public String getCardTypeTitle() {
        return CARD_TYPE_TITLE;
    }

    public String getNameOnCardTitle() {
        return NAME_ON_CARD_TITLE;
    }

    public String getCardNumberTitle() {
        return CARD_NUMBER_TITLE;
    }

    public String getExpiryYearTitle() {
        return EXPIRY_YEAR_TITLE;
    }

    public String getExpiryMonthTitle() {
        return EXPIRY_MONTH_TITLE;
    }

    public String getCvvTitle() {
        return CVV_TITLE;
    }

    public void getNextButtonAddress() {
        waitUntilBtnClickable(NEXT_BTN_ADDRESS);
        executeJsScript("window.scrollBy(0,650)");
        findElement(NEXT_BTN_ADDRESS).click();
    }

    public void fillAddressInformation(Map<String, String> deliveryAddressInformation) {
        findElement(FIRST_NAME).sendKeys(deliveryAddressInformation.get(FIRST_NAME_TITLE));
        findElement(LAST_NAME).sendKeys(deliveryAddressInformation.get(LAST_NAME_TITLE));
        findElement(ADDRESS_LINE1).sendKeys(deliveryAddressInformation.get(ADDRESS_LINE1_TITLE));
        findElement(CITY).sendKeys(deliveryAddressInformation.get(CITY_TITLE));
        findElement(POST_CODE).sendKeys(deliveryAddressInformation.get(POST_CODE_TITLE));
    }

    public void enterCardDetails(Map<String, String> addressInformation) {
        executeJsScript("window.scrollBy(0,500)");
        newSelect(CARD_TYPE_DROPDOWN).selectByVisibleText(addressInformation.get(CARD_TYPE_TITLE));
        findElement(NAME_ON_CARD).sendKeys(addressInformation.get(NAME_ON_CARD_TITLE));
        findElement(CARD_NUMBER).sendKeys(addressInformation.get(CARD_NUMBER_TITLE));
        newSelect(EXPIRY_YEAR_DROPDOWN).selectByVisibleText(addressInformation.get(EXPIRY_YEAR_TITLE));
        newSelect(EXPIRY_MONTH_DROPDOWN).selectByVisibleText(addressInformation.get(EXPIRY_MONTH_TITLE));
        findElement(CVV).sendKeys(addressInformation.get(CVV_TITLE));
    }
}
