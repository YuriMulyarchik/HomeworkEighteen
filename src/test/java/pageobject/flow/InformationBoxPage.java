package pageobject.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InformationBoxPage {
    private WebDriver driver;

    private By aboutUsPageLink = By.cssSelector(".content [href='https://litecart.stqa.ru/en/about-us-i-1']");
    private By deliveryInformationPageLink =
            By.cssSelector(".content [href='https://litecart.stqa.ru/en/delivery-information-i-2']");
    private By privacyPolicyLink = By.cssSelector(".content [href='https://litecart.stqa.ru/en/privacy-policy-i-3']");
    private By termsAndConditionsPageLink =
            By.cssSelector(".content [href='https://litecart.stqa.ru/en/terms-conditions-i-4']");
    private By discountsAndPromotionsPageLink =
            By.cssSelector(".content [href='https://litecart.stqa.ru/en/skidki-i-akcii-i-5']");

    public InformationBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public InformationBoxPage verifyThatInformationBoxPageIsVisible() {
        Assert.assertTrue(driver.findElement(aboutUsPageLink).isDisplayed() &&
                driver.findElement(deliveryInformationPageLink).isDisplayed() &&
                driver.findElement(privacyPolicyLink).isDisplayed() &&
                driver.findElement(termsAndConditionsPageLink).isDisplayed() &&
                driver.findElement(discountsAndPromotionsPageLink).isDisplayed(), "InformationBoxPage " +
                "is invisible");
        return this;
    }
}
