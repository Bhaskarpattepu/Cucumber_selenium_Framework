package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    public WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        this.driver=driver;
    }
    By cartBag = By.cssSelector("[alt='Cart']");
    By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By promoBtn = By.cssSelector(".promoBtn");
    By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

    public void CheckoutItems() throws InterruptedException {
        driver.findElement(cartBag).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        driver.findElement(checkOutButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
    }
    public boolean promobuttondisplayed()
    {
        boolean Promobuttonisdisplay = driver.findElement(promoBtn).isDisplayed();
        return Promobuttonisdisplay ;
    }

    public boolean orderbuttonisdisplayed()
    {
        boolean orderbuttondisplay = driver.findElement(placeOrder).isDisplayed();
        return orderbuttondisplay;
    }
    public void ClickPromocodebutton()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(promoBtn));
        driver.findElement(promoBtn).click();
    }
    public void PlaceOrderclick()
    {
        driver.findElement(placeOrder).click();
    }

}
