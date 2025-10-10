package stepDefinitions;

import PageObject.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
    public WebDriver driver;
    String LandingPageProductName;
    TestContextSetup testContextSetup;
    public LandingPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }
    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
    }

    @When("^user searched with shortname (.+) and Extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.SearchItem(shortName);
        testContextSetup.LandingPageProductName= landingPage.getProductName().split("-")[0].trim();
    }

}
