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
        if(driver==null)
        {
            if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
            {
                driver= new ChromeDriver();

            }
            else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
            {
                driver= new FirefoxDriver();
            }
            else {
                System.out.println("given browser property is invalid");
            }
            String Url =prop.getProperty("QAUrl");
            driver.get(Url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

        }
      return driver;
    }
}
