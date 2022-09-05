package pageobject.object;

import org.openqa.selenium.WebDriver;
import static pageobject.helpers.Locators.getLocator;

public class InformationBoxPage extends PageBase{
    private WebDriver driver;

    public InformationBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean informationBoxPageIsVisible() throws Exception {
        LOG.info("Checking that informationBoxPage is visible");
        if (driver.findElement(getLocator("InformationBoxPage.aboutUsPageLink")).isDisplayed() &&
                driver.findElement(getLocator("InformationBoxPage.deliveryInformationPageLink")).isDisplayed() &&
                driver.findElement(getLocator("InformationBoxPage.privacyPolicyLink")).isDisplayed() &&
                driver.findElement(getLocator("InformationBoxPage.termsAndConditionsPageLink")).isDisplayed() &&
                driver.findElement(getLocator("InformationBoxPage.discountsAndPromotionsPageLink")).isDisplayed()
                ) {
            return  true;
        }
        else return false;

    }

}
