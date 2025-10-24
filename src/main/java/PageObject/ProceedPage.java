package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProceedPage {
    WebDriver driver;
    ProceedPage(WebDriver driver)
    {
        this.driver=driver;
    }
    By Selectcountry = By.xpath("//select");
    By ckeckbox = By.xpath("//input[@class='chkAgree']");
    By buttonproceeed = By.xpath("//button[contains(@text(),Proceed)]");
    By Successfultext = By.xpath("//div[@class='wrapperTwo']");
    public void ClickSelect()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Selectcountry));
        WebElement ele = driver.findElement(Selectcountry);
        Select sel = new Select(ele);
        sel.selectByVisibleText("India");
    }
    public void Selectcheckbox()
    {
        driver.findElement(ckeckbox).click();
    }
    public void Selectproceed()
    {
        driver.findElement(buttonproceeed).click();
    }
    public String Successfultestcapture()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Successfultext));
        String SuccessText = element.getText().toLowerCase().trim();
        return SuccessText;
    }
}
