package utils;

import PageObject.LandingPage;
import PageObject.PageObjectManager;
import org.openqa.selenium.WebDriver;
import stepDefinitions.LandingPageStepDefinition;

public class TestContextSetup{
//these two variables are shared with another stepdefinition file
    public String  LandingPageProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;
    public TestContextSetup()
    {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
        genericUtils = new GenericUtils(testBase.WebDriverManager());
    }

}

