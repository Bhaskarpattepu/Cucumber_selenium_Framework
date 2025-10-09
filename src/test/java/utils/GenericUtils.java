package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class GenericUtils {
    WebDriver driver;
    public GenericUtils(WebDriver driver)
    {
        this.driver=driver;
    }
    public void SwitchWindowtoChild()
    {
        String Parentwindow = driver.getWindowHandle();
        Set<String> allwindows = driver.getWindowHandles();
        for(String window : allwindows)
        {
            if(!window.equals(Parentwindow))
            {
                System.out.println("Switching window before");
                driver.switchTo().window(window);
                System.out.println("Switching window after");
                break;
            }
        }
    }
}
