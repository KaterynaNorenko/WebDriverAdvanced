package com.cucumber.junit.steps;
import static org.assertj.core.api.Assertions.assertThat;
import com.cucumber.junit.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateOrderSteps {
    private final HomePage homePage = new HomePage();
    private final SearchResults searchResults = new SearchResults();
    private final CartPage cartPage = new CartPage();
    private final SignInRegister signInRegister = new SignInRegister();
    private final CheckoutShipment checkoutShipment = new CheckoutShipment();

    @Given("the user opens Accelerator website")
    public void openAcceleratorWebsite() {
        homePage.openAcceleratorWebsite();
    }

    @When("the user clicks on advanced btn")
    public void enableOpenPage() {
        homePage.getAdvancedButton().click();
    }

    @And("the user clicks on proceed link")
    public void proceedOpenPage() {
        homePage.getProceedLink().click();
    }

    @And("the user searches for a product with number {string}")
    public void searchForItem(String productNumber) {
        homePage.getSearchInput(productNumber);
    }

    @And("the user adds item to order")
    public void addItemToOrder() {
        searchResults.getAddToOrderButton().click();
    }

    @And("the user clicks on checkout button")
    public void clickOnCheckoutButton() {
        searchResults.getCheckoutButton().click();
    }

    @And("the user clicks on checkout button on cart page")
    public void clickOnCheckoutButtonCartPage() {
        cartPage.getCheckoutButton().click();
    }

    @And("the user inputs email {string}")
    public void inputEmail(String email) {
        signInRegister.inputEmail(email);
    }

    @And("the user performs email confirmation {string}")
    public void performEmailConfirmation(String email) {
        signInRegister.inputEmailConfirmation(email);
    }

    @Then("order subtotal is displayed and equals {string}")
    public void verifyOrderSubtotalPresence(String expectedSubtotal) {
        assertThat(checkoutShipment.getOrderSubtotal())
                .overridingErrorMessage("Order Subtotal is not as expected")
                .isEqualToIgnoringCase(expectedSubtotal);
    }

    @And("order total is displayed and equals {string}")
    public void verifyOrderTotalPresence(String expectedTotal) {
        assertThat(checkoutShipment.getOrderTotal())
                .overridingErrorMessage("Order Total is not as expected")
                .isEqualToIgnoringCase(expectedTotal);
    }

    @And("order tax is displayed and equals {string}")
    public void verifyOrderTaxPresence(String expectedTax) {
        assertThat(checkoutShipment.getOrderTax())
                .overridingErrorMessage("Order Tax is not as expected")
                .isEqualToIgnoringCase(expectedTax);
    }
}
