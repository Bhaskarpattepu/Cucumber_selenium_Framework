package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    public WebDriver WebDriverManager()
    {
        if(driver==null)
        {
            driver= new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
            driver.manage().window().maximize();
        }
      return driver;
    }
}
