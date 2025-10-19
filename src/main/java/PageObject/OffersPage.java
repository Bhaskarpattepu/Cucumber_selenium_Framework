package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OffersPage {
    WebDriver driver;
    public OffersPage(WebDriver driver)
    {
        this.driver=driver;
    }
    By search = By.xpath("//input[@id='search-field']");
    By ProductName1 = By.cssSelector("tr td:nth-child(1)");
    public void SearchItem(String name)
    {
        System.out.println("SearchItem of offerspage");
        driver.findElement(search).sendKeys(name);
    }
    public String getProductName()
    {
        System.out.println("getProductname if offerpage");
        String productname =driver.findElement(ProductName1).getText();
        if(productname.equalsIgnoreCase("No data"))
        {
            System.out.println("Product that found in landing page doesnot found in Offers page");
        }
        return productname;
    }
}
