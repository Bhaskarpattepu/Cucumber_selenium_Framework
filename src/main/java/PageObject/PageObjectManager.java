package PageObject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    public LandingPage landingpage;
    public OffersPage offerpage;
    public PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }
    public LandingPage getLandingPage()
    {
        landingpage= new LandingPage(driver);
        return landingpage;
    }
    public OffersPage getOfferPage()
    {
        offerpage= new OffersPage(driver);
        return offerpage;
    }
}
