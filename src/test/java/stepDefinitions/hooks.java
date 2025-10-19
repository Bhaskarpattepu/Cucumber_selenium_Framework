package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestBase;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class hooks {

    TestContextSetup testContextSetup;

    public hooks(TestContextSetup testContextSetup)
    {

        this.testContextSetup=testContextSetup;
    }

    @After
    public void AfterScenario() throws IOException
    {
        testContextSetup.testBase.WebDriverManager().quit();
    }


    // after Every step controller comes here
    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        WebDriver driver =testContextSetup.testBase.WebDriverManager();
        if(scenario.isFailed())
        {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File sourcepath = ts.getScreenshotAs(OutputType.FILE);
            byte[] filecontent = FileUtils.readFileToByteArray(sourcepath);
            scenario.attach(filecontent,"image/png","image");
        }
    }
}
