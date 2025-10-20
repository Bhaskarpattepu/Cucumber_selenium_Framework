package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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
    By topdeals=By.linkText("Top Deals");
    By increment = By.cssSelector("a.increment");
    By addToCart = By.cssSelector(".product-action button");
public void SearchItem(String name)
{
    System.out.println("Search item of Landingpage");
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    WebElement searchbox = driver.findElement(search);
    searchbox.clear();
    searchbox.sendKeys(name);
    Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(StaleElementReferenceException.class)
            .ignoring(NoSuchElementException.class);

    List<WebElement> products = wait.until(driver -> {
        List<WebElement> elems = driver.findElements(ProductName);
        List<WebElement> visibleElems = new ArrayList<>();
        for (WebElement e : elems) {
            if (e.isDisplayed()) {
                visibleElems.add(e);
            }
        }
        return visibleElems.size() > 0 ? visibleElems : null;  // wait if empty
    });

    gname = null; // reset global product name
    for (WebElement product : products) {
        if (product.getText().toLowerCase().contains(name.toLowerCase())) {
            gname = product.getText();
            System.out.println("Found product: " + gname);
            product.click();  // click if needed
            break;
        }
    }

    if (gname == null) {
        System.out.println("No matching product found for: " + name);
    }
}
public String getProductName()
{
    String pname="";
    try{
        System.out.println("getProductname of landingpage");
        if(gname!= null)
        {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(ProductName,gname));
            pname = driver.findElement(ProductName).getText();
            System.out.println(pname);
        }
        else
            return "No - matchingproduct";
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage()+"User is in catch of getProductname of landind page");
    }
    return pname;
}
    public void SelectTopDeals()
    {
        System.out.println("Select top deals of Landing page");
        driver.findElement(topdeals).click();
    }

    public String getTittleLandingPage()
    {
        return driver.getTitle();
    }

    public void incrementQuantity(int quantity)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            if(gname!=null)
            {
                for (int i = 0; i < quantity; i++) {
                    WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(increment));
                    plusButton.click();
                }
            }
    }

    public void addToCart()
    {
        if(gname!=null)
        {
            driver.findElement(addToCart).click();
        }
    }
}
