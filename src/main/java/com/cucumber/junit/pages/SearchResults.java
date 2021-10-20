package com.cucumber.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.cucumber.junit.util.ActionsManager.newAction;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResults extends BasePage {
    private static final String SEARCH_RESULTS_PAGE_URL = "https://ecsc00a08ec4:9002/yacceleratorstorefront/electronics/en/search/?text={searchText}";
    private static final By ADD_TO_ORDER_BTN = By.xpath("//form[@id='addToCartForm1934793']/descendant::button[@type='submit']");
    private static final By CHECKOUT_BTN = By.xpath("//a[@href='/yacceleratorstorefront/electronics/en/cart' and @class='btn btn-primary btn-block add-to-cart-button']");
    private static final By ADD_TO_CART_BTN = By.cssSelector("#addToCartForm1225694 > button");
    private static final By SEARCH_RESULTS_PRODUCTS = By.xpath("//*[@class='product__list--name']");
    private static final By RESULTS = By.xpath("//div[@class='results']");
    private static final By SHOP_BY_PRICE_FILTER = By.xpath("//span[contains(text(), '$500-$999')]/preceding::span[@class='facet__list__mark'][1]");
    private static final By SHOP_BY_MEGAPIXELS_FILTER = By.xpath("//span[contains(text(), '10 - 10')]/preceding::span[@class='facet__list__mark'][1]");
    private static final By SHOP_BY_BRAND_FILTER = By.xpath("//a[contains(@href, 'Abrand') and contains (text(), 'Canon')]");

    public WebElement getAddToOrderButton() {
        return findElement(ADD_TO_ORDER_BTN);
    }

    public WebElement getCheckoutButton() {
        return findElement(CHECKOUT_BTN);
    }

    public WebElement getAddToCartButton() {
        return findElement(ADD_TO_CART_BTN);
    }

    public String getSearchResultsPageUrl() {
        return SEARCH_RESULTS_PAGE_URL;
    }

    public String getSearchResultsPageUrlWithParams(String searchText) {
        return SEARCH_RESULTS_PAGE_URL.replace("{searchText}", searchText.replace(" ", "+"));
    }

    public List<String> getSearchResultsByXpath() {
        waitUntilElementVisible(RESULTS, 10);
        return findElements(SEARCH_RESULTS_PRODUCTS).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean areProductsPresentInResults(List<String> expectedProducts, List<String> actualProducts) {
        for (String expectedProduct : expectedProducts) {
            for (String actualProduct : actualProducts) {
                if (expectedProduct.matches(actualProduct)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean areProductsPresentInResultsAreOnlyOnes(List<String> expectedProducts, List<String> actualProducts) {
        return actualProducts.containsAll(expectedProducts);
    }

    public void applySearchFilters() {
        newAction().moveToElement(findElement(SHOP_BY_PRICE_FILTER)).click().perform();
        waitUntilElementVisible(RESULTS, 10);
        newAction().moveToElement(findElement(SHOP_BY_MEGAPIXELS_FILTER)).click().perform();
        waitUntilElementVisible(RESULTS, 10);
        newAction().moveToElement(findElement(SHOP_BY_BRAND_FILTER)).click().perform();
        waitUntilElementVisible(RESULTS, 10);
    }
}