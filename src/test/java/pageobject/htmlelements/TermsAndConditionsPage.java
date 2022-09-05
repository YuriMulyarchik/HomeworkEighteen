package pageobject.htmlelements;


import org.openqa.selenium.WebDriver;
import pageobject.object.PageBase;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static pageobject.helpers.Locators.getLocator;

public class TermsAndConditionsPage extends PageBase {

    private String termsAndConditionsPageTitle="Terms & Conditions | My Store1";

    private String subtitleOneText = "Условия";

    private String subtitleTwoText = "Подзаголовок 2";

    private String subtitleThreeText = "Подзаголовок 3";

    public HeaderMenu headerMenu;

    public RegionalSettingsMenu regionalSettingsMenu;

    public Cart cart;

    public InformationBox informationBox;
    private WebDriver driver;

    public TermsAndConditionsPage(WebDriver driver) {
        this.driver = driver;
        HtmlElementLoader.populatePageObject(this, driver);
    }


    public boolean subtitleOneIsVisible() throws Exception {
        return driver.findElement(getLocator("TermsAndConditionsPage.subtitleOne")).isDisplayed();
    }

    public boolean subtitleTwoIsVisible() throws Exception {
        return driver.findElement(getLocator("TermsAndConditionsPage.subtitleTwo")).isDisplayed();
    }

    public boolean subtitleThreeIsVisible() throws Exception {
        return driver.findElement(getLocator("TermsAndConditionsPage.subtitleThree")).isDisplayed();
    }


    public boolean subtitleOneInformationIsVisible() throws Exception {
        return driver.findElement(getLocator("TermsAndConditionsPage.subtitleOneInformation")).isDisplayed();
    }
    public boolean subtitleTwoInformationIsVisible() throws Exception {
        return driver.findElement(getLocator("TermsAndConditionsPage.subtitleTwoInformation")).isDisplayed();
    }
    public boolean subtitleThreeInformationIsVisible() throws Exception {
        return driver.findElement(getLocator("TermsAndConditionsPage.subtitleThreeInformation")).isDisplayed();
    }

    public boolean verifySubtitleOneText() throws Exception {
        return driver.findElement(getLocator("TermsAndConditionsPage.subtitleOne")).getText()
                .equals(subtitleOneText);
    }

    public boolean verifySubtitleTwoText() throws Exception {
        return driver.findElement(getLocator("TermsAndConditionsPage.subtitleTwo")).getText()
                .equals(subtitleTwoText);
    }

    public boolean verifySubtitleThreeText() throws Exception {
        return driver.findElement(getLocator("TermsAndConditionsPage.subtitleThree")).getText()
                .equals(subtitleThreeText);
    }

    public boolean hasOpened() {
        return super.hasOpened(driver, termsAndConditionsPageTitle);
    }
}
