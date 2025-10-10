package utils;

import PageObject.LandingPage;
import PageObject.PageObjectManager;
import org.openqa.selenium.WebDriver;
import stepDefinitions.LandingPageStepDefinition;

import java.io.IOException;

public class TestContextSetup{
//these two variables are shared with another stepdefinition file
    public String  LandingPageProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;
    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
        genericUtils = new GenericUtils(testBase.WebDriverManager());
    }

}

