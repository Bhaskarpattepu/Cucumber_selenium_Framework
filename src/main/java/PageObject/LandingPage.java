package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    public WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        this.driver=driver;
    }

    By search = By.xpath("//input[@type='search']");
    By ProductName = By.cssSelector("h4.product-name");
    By image = By.xpath("//img[@src='./images/tomato.jpg']");
    By topdeals=By.linkText("Top Deals");

public void SearchItem(String name)
{
    System.out.println("Search item of Landingpage");
    driver.findElement(search).sendKeys(name);
}
public String getProductName()
{
    String pname="";
    try{

        System.out.println("getProductname of landingpage");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(ProductName,"Tomato - 1 Kg"));
        pname = driver.findElement(ProductName).getText();
        System.out.println(pname);
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
    return pname;
}
    public void SelectTopDeals()
    {
        System.out.println("Select top deals of Landing page");
        driver.findElement(topdeals).click();
       }

}
