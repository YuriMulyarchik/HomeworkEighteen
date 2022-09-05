package pageobject.htmlelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("InformationBox")
@FindBy(id="box-information-links")

public class InformationBox extends HtmlElement {

    @Name("aboutUsPageLink")
    @FindBy(css = ".content [href='https://litecart.stqa.ru/en/about-us-i-1']")
    WebElement aboutUsPageLink;

    @Name("deliveryInformationPageLink")
    @FindBy(css = ".content [href='https://litecart.stqa.ru/en/delivery-information-i-2']")
    WebElement deliveryInformationPageLink;

    @Name("privacyPolicyLink")
    @FindBy(css = ".content [href='https://litecart.stqa.ru/en/privacy-policy-i-3']")
    WebElement privacyPolicyLink;

    @Name("termsAndConditionsPageLink")
    @FindBy(css = ".content [href='https://litecart.stqa.ru/en/terms-conditions-i-4']")
    WebElement termsAndConditionsPageLink;

    @Name("discountsAndPromotionsPageLink")
    @FindBy(css = ".content [href='https://litecart.stqa.ru/en/skidki-i-akcii-i-5']")
    WebElement discountsAndPromotionsPageLink;

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
