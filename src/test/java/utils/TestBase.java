package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    protected WebDriver driver;
    public WebDriver WebDriverManager() throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(file);
        String Url =prop.getProperty("QAUrl");
        String browser_property_from_config_file = prop.getProperty("browser");
        String browser_property_from_maven_cmd_line=System.getProperty("browser");
        //result = testCondition ? value1 : value2

        String browser = browser_property_from_maven_cmd_line!= null ? browser_property_from_maven_cmd_line : browser_property_from_config_file;

        if(driver==null)
        {
            if(browser.equalsIgnoreCase("chrome"))
            {
                driver= new ChromeDriver();

            }
            else if(browser.equalsIgnoreCase("firefox"))
            {
                driver= new FirefoxDriver();
            }
            else {
                System.out.println("given browser property is invalid");
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(Url);
            driver.manage().window().maximize();
        }
      return driver;
    }
}
