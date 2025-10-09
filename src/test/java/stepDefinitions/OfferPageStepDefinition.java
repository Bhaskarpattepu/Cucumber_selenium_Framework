package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.TestContextSetup;

import java.time.Duration;
import java.util.Set;

public class OfferPageStepDefinition {
    String LandingPageProductName;
    String offerpageProductName;
    //Spring Framework , EJB
//Single Responsibility Principle
    //Loosly coupled
    TestContextSetup testContextSetup;


    public OfferPageStepDefinition(TestContextSetup testContextSetup)
    {
     this.testContextSetup=  testContextSetup;

    }



    @Then("user searched for {string} shortname in offers page to check if product exist with same name")
    public void user_searched_for_shortname_in_offers_page_to_check_if_product_exist(String shortName) {
        SwitchToOffersPage();
        testContextSetup.driver.findElement(By.id("search-field")).sendKeys(shortName);
        offerpageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();


    }
    public void SwitchToOffersPage()
    {
        //offer page -> Enter -> Grabtext
        //if switched to offer page -> skip below part
        //if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
        String Parentwindow = testContextSetup.driver.getWindowHandle();
        int currentWindowcount = testContextSetup.driver.getWindowHandles().size();
        testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
        WebDriverWait wait = new WebDriverWait(testContextSetup.driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(currentWindowcount+1));
        Set<String> allwindows = testContextSetup.driver.getWindowHandles();

        for(String window : allwindows)
        {
            if(!window.equals(Parentwindow))
            {
                testContextSetup.driver.switchTo().window(window);
                break;
            }
        }
    }

    @And("Validate product name in offers page matches with Landing page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(testContextSetup.LandingPageProductName,offerpageProductName);
        System.out.println(testContextSetup.LandingPageProductName);
    }
}
