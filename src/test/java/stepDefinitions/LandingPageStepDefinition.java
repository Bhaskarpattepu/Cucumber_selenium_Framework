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

public class LandingPageStepDefinition {
    public WebDriver driver;
    String LandingPageProductName;
    String offerpageProductName;
    TestContextSetup testContextSetup;
    public LandingPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }


    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
        testContextSetup.driver= new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user searched with shortname {string} and Extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
        testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        WebDriverWait wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.cssSelector("h4.product-name"), shortName.substring(0, 3))
        );
        testContextSetup.LandingPageProductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
    }

}
