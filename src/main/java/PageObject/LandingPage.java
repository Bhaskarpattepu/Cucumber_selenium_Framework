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
    By topdeals=By.linkText("Top Deals");
    By increment = By.cssSelector("a.increment");
    By addToCart = By.cssSelector(".product-action button");
public void SearchItem(String name)
{
    System.out.println("Search item of Landingpage");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    WebElement searchbox = driver.findElement(search);
    searchbox.clear();
    searchbox.sendKeys(name);

// Retry-safe wait with maximum 2 attempts
    List<WebElement> products = new ArrayList<>();
    int maxRetries = 2;
    int attempts = 0;

//    try {
        while (attempts < maxRetries)
        {
            try {
                List<WebElement> elements = wait.until(driver1 -> {
                    List<WebElement> listElements = driver1.findElements(ProductName);
                    if (listElements.size() > 0) {
                        // Check visibility to detect stale elements
                        for (WebElement e : listElements) {
                            e.isDisplayed();
                        }
                        return listElements;
                    }
                    return null;
                });
                products = elements;
                break; // Success, exit retry loop
            } catch (Exception e)
            {
                attempts++;
                System.out.println("Stale element detected, retrying... attempt " + attempts);
                if (attempts >= maxRetries)
                {
                    System.out.println("Max retries reached for stale elements");
                    break;
                }
            }
        }

// If timeout or no products found
    if (products == null || products.isEmpty())
    {
        System.out.println("No products found for: " + name);
    }
    // Else collect product names
    else
    {
        list = new ArrayList<>();
        for (WebElement el : products) {
            list.add(el.getText());
        }
    }
// Try to find the matching product
    gname = null;
    if(list != null)
    {
        for (String li : list) {
            System.out.println("Found product: " + li);
            if (li.trim().toLowerCase().contains(name.toLowerCase())) {
                gname = li;
                break;
            }
        }
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
