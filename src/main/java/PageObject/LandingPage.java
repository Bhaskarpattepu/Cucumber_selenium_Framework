package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LandingPage {
    public WebDriver driver;
    List<String> list;
    String gname;
    public LandingPage(WebDriver driver)
    {
        this.driver=driver;
    }
    By search = By.xpath("//input[@type='search']");
    By ProductName = By.cssSelector("h4.product-name");
    By image = By.xpath("//img[@src='./images/tomato.jpg']");
    By topdeals=By.linkText("Top Deals");

    public List<String> listofproducts()
    {
        List<String> list = new ArrayList<>();
        List<WebElement> list1 = driver.findElements(ProductName);
        for(WebElement el : list1)
        {
            String product = el.getText();
            list.add(product);
        }
        return list;
    }
public void SearchItem(String name)
{
    System.out.println("Search item of Landingpage");
    list = listofproducts();
    for(String li : list)
    {
        if(li.trim().contains(name))
        {
            gname=li;
            break;
        }
    }
    driver.findElement(search).sendKeys(name);
}
public String getProductName()
{
    String pname="";
    try{
        System.out.println("getProductname of landingpage");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(ProductName,gname));
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
