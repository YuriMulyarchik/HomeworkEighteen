package pageobject.htmlelements;


import org.openqa.selenium.WebDriver;
import pageobject.object.PageBase;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static pageobject.helpers.Locators.getLocator;

public class DeliveryInformationPage extends PageBase {

    public HeaderMenu headerMenu;

    public RegionalSettingsMenu regionalSettingsMenu;

    public Cart cart;

    public InformationBox informationBox;
    private String deliveryInformationPageTitle="Delivery Information | My Store1";
    private String subtitleOneText = "информация о доставке";
    private String subtitleTwoText = "Подзаголовок 2";
    private String subtitleThreeText = "Подзаголовок 3";

    private WebDriver driver;

    public DeliveryInformationPage(WebDriver driver) {
        this.driver = driver;
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public boolean subtitleOneIsVisible() throws Exception {
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleOne")).isDisplayed();
    }

    public boolean subtitleTwoIsVisible() throws Exception {
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleTwo")).isDisplayed();
    }

    public boolean subtitleThreeIsVisible() throws Exception {
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleThree")).isDisplayed();
    }

    public boolean subtitleOneInformationIsVisible() throws Exception {
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleOneInformation")).isDisplayed();
    }

    public boolean subtitleTwoInformationIsVisible() throws Exception {
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleTwoInformation")).isDisplayed();
    }

    public boolean subtitleThreeInformationIsVisible() throws Exception {
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleThreeInformation")).isDisplayed();
    }

    public boolean verifySubtitleOneText() throws Exception {
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleOne")).getText().equals(subtitleOneText);
    }

    public boolean verifySubtitleTwoText() throws Exception {
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleTwo")).getText().equals(subtitleTwoText);
    }

    public boolean verifySubtitleThreeText() throws Exception {
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleThree")).getText().equals(subtitleThreeText);
    }

    public boolean hasOpened() {
        return super.hasOpened(driver, deliveryInformationPageTitle);
    }
}
