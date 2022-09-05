package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationBoxPage {
    private WebDriver driver;

    private static By aboutUsPageLink = By.cssSelector(".content [href='https://litecart.stqa.ru/en/about-us-i-1']");

    private static By deliveryInformationPageLink =
            By.cssSelector(".content [href='https://litecart.stqa.ru/en/delivery-information-i-2']");

    private static By privacyPolicyLink =
            By.cssSelector(".content [href='https://litecart.stqa.ru/en/privacy-policy-i-3']");

    private static By termsAndConditionsPageLink =
            By.cssSelector(".content [href='https://litecart.stqa.ru/en/terms-conditions-i-4']");

    private static By discountsAndPromotionsPageLink =
            By.cssSelector(".content [href='https://litecart.stqa.ru/en/skidki-i-akcii-i-5']");

    public static boolean informationBoxPageIsVisible(WebDriver driver) {
        if (driver.findElement(aboutUsPageLink).isDisplayed() &&
                driver.findElement(deliveryInformationPageLink).isDisplayed() &&
                driver.findElement(privacyPolicyLink).isDisplayed() &&
                driver.findElement(termsAndConditionsPageLink).isDisplayed() &&
                driver.findElement(discountsAndPromotionsPageLink).isDisplayed()
                ) {
            return  true;
        }
        else return false;
    }

}
