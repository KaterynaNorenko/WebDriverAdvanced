package com.cucumber.junit.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import com.cucumber.junit.pages.*;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DesktopCheckoutForGuestUserSteps {
    private final HomePage homePage = new HomePage();
    private final SearchResults searchResults = new SearchResults();
    private final CartPage cartPage = new CartPage();
    private final SignInRegister signInRegister = new SignInRegister();
    private final CheckoutShipment checkoutShipment = new CheckoutShipment();

    @Given("I open the Initial Home Page")
    public void openHomePage() {
        homePage.openAcceleratorWebsite();
    }

    @And("I click on advanced btn")
    public void enableOpenPage() {
        homePage.getAdvancedButton().click();
    }

    @And("I click on proceed link")
    public void proceedOpenPage() {
        homePage.getProceedLink().click();
    }

    @And("I search for {string}")
    public void searchForItem(String productNumber) {
        homePage.getSearchInput(productNumber);
    }

    @And("I am redirected to a {string} results page")
    public void redirectToSearchResults(String page) {
        assertThat(searchResults.getSearchResultsPageUrl().contains(page))
                .overridingErrorMessage("Redirect to Search Page was unsuccessful")
                .isTrue();
    }

    @And("Search results contain the following products")
    public void searchResultsContainProducts(List<String> expectedProducts) {
        assertThat(searchResults.areProductsPresentInResults(expectedProducts, searchResults.getSearchResultsByXpath()))
                .overridingErrorMessage("Results do not contain expected products")
                .isTrue();
    }

    @And("I apply the following search filters")
    public void applySearchFilters() {
        searchResults.applySearchFilters();
    }

    @And("Search results contain only the following products")
    public void searchResultsContainOnlyTheFollowingProducts(List<String> expectedProducts) {
        assertThat(searchResults.areProductsPresentInResultsAreOnlyOnes(expectedProducts, searchResults.getSearchResultsByXpath()))
                .overridingErrorMessage("Results do not contain expected products")
                .isTrue();
    }

    @And("I click Add to cart button for product with name EOS 40D BODY")
    public void clickAddToCartButtonForProductWithName() {
        searchResults.getAddToCartButton().click();
    }

    @And("I select Checkout in cart pop-up")
    public void selectCheckoutInCartPopUp() {
        searchResults.getCheckoutButton().click();
    }

    @And("I am redirected to a {string} page")
    public void redirectToCartPage(String page) {
        assertThat(cartPage.getCartPageUrl().contains(page))
                .overridingErrorMessage("Redirect to Cart Page was unsuccessful")
                .isTrue();
    }

    @And("Cart order summary is as following:")
    public void cartOrderSummaryIsFollowing(@Transpose Map<String, String> expectedValuesInCartOrderSummary) {
        assertThat(cartPage.getCartOrderTax())
                .overridingErrorMessage("Cart Tax is not as expected")
                .isEqualToIgnoringCase(expectedValuesInCartOrderSummary.get(cartPage.getCartOrderTaxTitle()));

        assertThat(cartPage.getCartOrderTotal())
                .overridingErrorMessage("Cart Total is not as expected")
                .isEqualToIgnoringCase(expectedValuesInCartOrderSummary.get(cartPage.getCartOrderTotalTitle()));
    }

    @And("I click Checkout button on Cart page")
    public void clickCheckoutButtonOnCartPage() {
        cartPage.getCheckoutButton().click();
    }

    @And("I checkout as a new customer with email {string}")
    public void checkoutAsANewCustomerWithEmail(String email) {
        signInRegister.inputEmail(email);
    }

    @And("I perform email confirmation {string}")
    public void performEmailConfirmation(String email) {
        signInRegister.inputEmailConfirmation(email);
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummaryIsAsFollowing(@Transpose Map<String, String> expectedValuesInOrderSummary) {
        assertThat(checkoutShipment.getOrderSubtotal())
                .overridingErrorMessage("Order Subtotal is not as expected")
                .isEqualToIgnoringCase(expectedValuesInOrderSummary.get(checkoutShipment.getOrderSubtotalTitle()));

        assertThat(checkoutShipment.getOrderDiscount())
                .overridingErrorMessage("Order Discount is not as expected")
                .isEqualToIgnoringCase(expectedValuesInOrderSummary.get(checkoutShipment.getOrderDiscountTitle()));

        assertThat(checkoutShipment.getOrderTax())
                .overridingErrorMessage("Order Tax is not as expected")
                .isEqualToIgnoringCase(expectedValuesInOrderSummary.get(checkoutShipment.getOrderTaxTitle()));

        assertThat(checkoutShipment.getOrderTotal())
                .overridingErrorMessage("Order Total is not as expected")
                .isEqualToIgnoringCase(expectedValuesInOrderSummary.get(checkoutShipment.getOrderTotalTitle()));
    }

    @And("I select the COUNTRY&REGION {string} manually")
    public void selectCountryRegionManually(String country) {
        checkoutShipment.getCountryRegionDropDown(country);
    }

    @And("I click the next button")
    public void clickTheNextButton() {
        checkoutShipment.getNextButtonAddress();
    }

    @And("the following validation messages are displayed for shipping address")
    public void verifyValidationMessagesAreDisplayedForShippingAddress(Map<String, String> expectedValidationMessages) {
        assertThat(checkoutShipment.getFirstNameErrorMessage())
                .overridingErrorMessage("First Name error message is not as expected")
                .isEqualToIgnoringCase(expectedValidationMessages.get(checkoutShipment.getFirstNameTitle()));

        assertThat(checkoutShipment.getLastNameErrorMessage())
                .overridingErrorMessage("Last Name error message is not as expected")
                .isEqualToIgnoringCase(expectedValidationMessages.get(checkoutShipment.getLastNameTitle()));

        assertThat(checkoutShipment.getAddressLine1ErrorMessage())
                .overridingErrorMessage("Address Line error message is not as expected")
                .isEqualToIgnoringCase(expectedValidationMessages.get(checkoutShipment.getAddressLine1Title()));

        assertThat(checkoutShipment.getCityErrorMessage())
                .overridingErrorMessage("City error message is not as expected")
                .isEqualToIgnoringCase(expectedValidationMessages.get(checkoutShipment.getCityTitle()));

        assertThat(checkoutShipment.getPostCodeErrorMessage())
                .overridingErrorMessage("Post Code error message is not as expected")
                .isEqualToIgnoringCase(expectedValidationMessages.get(checkoutShipment.getPostCodeTitle()));
    }

    @And("I fill delivery address information manually:")
    public void fillDeliveryAddressInformationManually(@Transpose Map<String, String> deliveryAddressInformation) {
        checkoutShipment.fillAddressInformation(deliveryAddressInformation);
    }

    @When("I press Next button on checkout")
    public void pressNextButtonOnCheckout() {
        checkoutShipment.getNextButtonAddress();
    }

    @And("I confirm Shipment Method by pressing another Next button")
    public void confirmShipmentMethodByPressingAnotherNextButton() {
        checkoutShipment.getNextButtonShipment().click();
    }

    @And("I enter my card details")
    public void enterMyCardDetails(Map<String, String> cardDetails) {
        checkoutShipment.enterCardDetails(cardDetails);
    }
}
