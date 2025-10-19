package stepDefinitions;

import PageObject.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
    public WebDriver driver;
    String LandingPageProductName;
    TestContextSetup testContextSetup;
    LandingPage landingPage;
    public LandingPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }
    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
        Assert.assertTrue(landingPage.getTittleLandingPage().contains("GreenKart"));
    }

    @When("^user searched with shortname (.+) and Extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
        landingPage.SearchItem(shortName);
        testContextSetup.LandingPageProductName= landingPage.getProductName().split("-")[0].trim();
        String productname = testContextSetup.LandingPageProductName;
        if(productname.equalsIgnoreCase("No"))
        {
            Assert.assertTrue(false,"Searched product is not avaialble");
        }
        else
        {
            Assert.assertTrue(true,"Searched product or Related search product is available");
        }
    }

    @When("Added {string} items of the selected product to cart")
    public void Added_items_product(String quantity)
    {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }

}
