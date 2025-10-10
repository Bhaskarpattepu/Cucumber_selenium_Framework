package stepDefinitions;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utils.TestBase;
import utils.TestContextSetup;

import java.io.IOException;

public class hooks {

    TestContextSetup testContextSetup;

    public hooks(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }
    @After
    public void AfterScenario() throws IOException {
        testContextSetup.testBase.WebDriverManager().quit();
    }
}
