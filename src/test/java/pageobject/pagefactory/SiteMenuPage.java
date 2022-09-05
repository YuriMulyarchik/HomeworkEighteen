package pageobject.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteMenuPage {

    @FindBy(css = ".general-0")
    private WebElement homePageLink;

    @FindBy(css = "#site-menu .category-1")
    private WebElement rubberDucksPageLink;

    @FindBy(css = ".page-2")
    private WebElement deliveryInfoPageLink;

    @FindBy(css = ".page-4")
    private WebElement termsAndConditionsPageLink;

    @FindBy(css = ".page-5")
    private WebElement discountsAndPromotionsPageLink;

    @FindBy(css = ".country")
    private WebElement currentCountry;

    @FindBy(css = ".currency")
    private WebElement currentCurrency;

    public void moveToHomePage() {
        homePageLink.click();
    }

    public void moveToRubberDucksPage() {
        rubberDucksPageLink.click();
    }
    public void moveToDeliveryInfoPage() {
        deliveryInfoPageLink.click();
    }

    public void moveToTermsAndConditionsPage() {
        termsAndConditionsPageLink.click();
    }

    public void moveToDiscountsAndPromotionsPage() {
        discountsAndPromotionsPageLink.click();
    }

    public String getCurrentSiteCountry() {
        return currentCountry.getText();
    }

    public String getCurrentSiteCurrency() {
        return currentCurrency.getText();
    }
}

