package pageobject.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationBoxPage {

    @FindBy(css = ".content [href='https://litecart.stqa.ru/en/about-us-i-1']")
    private WebElement aboutUsPageLink;

    @FindBy(css = ".content [href='https://litecart.stqa.ru/en/delivery-information-i-2']")
    private WebElement deliveryInformationPageLink;

    @FindBy(css = ".content [href='https://litecart.stqa.ru/en/privacy-policy-i-3']")
    private WebElement privacyPolicyLink;

    @FindBy(css = ".content [href='https://litecart.stqa.ru/en/terms-conditions-i-4']")
    private WebElement termsAndConditionsPageLink;

    @FindBy(css = ".content [href='https://litecart.stqa.ru/en/skidki-i-akcii-i-5']")
    private WebElement discountsAndPromotionsPageLink;

    public boolean informationBoxPageIsVisible() {
        if (aboutUsPageLink.isDisplayed() &&
                deliveryInformationPageLink.isDisplayed() &&
                privacyPolicyLink.isDisplayed() &&
                termsAndConditionsPageLink.isDisplayed() &&
                discountsAndPromotionsPageLink.isDisplayed()
                ) {
            return  true;
        }
        else return false;
    }

}
