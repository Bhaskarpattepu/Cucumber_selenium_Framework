package stepDefinitions;

import PageObject.CheckoutPage;
import PageObject.LandingPage;
import PageObject.OffersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.TestContextSetup;

public class CheckOutPageStepDefinition {
    public CheckoutPage checkoutPage;
//Single Responsibility Principle Loosly coupled
    TestContextSetup testContextSetup;
    public CheckOutPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=  testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
    public void user_proceed_to_checkout(String name) throws InterruptedException {
        checkoutPage.CheckoutItems();
        Assert.assertTrue(checkoutPage.promobuttondisplayed());
        Assert.assertTrue(checkoutPage.orderbuttonisdisplayed());
        //Assignment Assertion to extract name from screen and compare with name Assignment
    }

    @Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo()
    {
        checkoutPage.PlaceOrderclick();
    }
}
