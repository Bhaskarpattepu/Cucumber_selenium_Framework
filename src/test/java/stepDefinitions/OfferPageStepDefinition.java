package stepDefinitions;

import PageObject.LandingPage;
import PageObject.OffersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.GenericUtils;
import utils.TestContextSetup;

import java.time.Duration;

public class OfferPageStepDefinition {
    String LandingPageProductName;
    String offerpageProductName;
//Single Responsibility Principle Loosly coupled
    TestContextSetup testContextSetup;
    public OfferPageStepDefinition(TestContextSetup testContextSetup)
    {
     this.testContextSetup=  testContextSetup;
    }
    public void SwitchToOffersPage()
    {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.SelectTopDeals();
        testContextSetup.genericUtils.SwitchWindowtoChild();
    }
    @Then("^user searched for (.+) shortname in offers page to check if product exist with same name$")
    public void user_searched_for_shortname_in_offers_page_to_check_if_product_exist(String shortName) {
        SwitchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOfferPage();
        offersPage.SearchItem(shortName);
        offerpageProductName = offersPage.getProductName();
    }


    @And("Validate product name in offers page matches with Landing page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        //Assert.assertEquals(testContextSetup.LandingPageProductName,offerpageProductName);

        String ActualText = testContextSetup.LandingPageProductName;
        String Expected = offerpageProductName;
        Assert.assertEquals(ActualText,Expected);
    }
}
