package pageobject.object;


import org.openqa.selenium.WebDriver;
import static pageobject.helpers.Locators.getLocator;

public class DeliveryInformationPage extends PageBase{

    private String deliveryInformationPageTitle="Delivery Information | My Store1";
    private String subtitleOneText = "информация о доставке";
    private String subtitleTwoText = "Подзаголовок 2";
    private String subtitleThreeText = "Подзаголовок 3";

    private WebDriver driver;

    public DeliveryInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean subtitleOneIsVisible() throws Exception {
        LOG.info("Checking subtitleOne visibility");
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleOne")).isDisplayed();
    }

    public boolean subtitleTwoIsVisible() throws Exception {
        LOG.info("Checking subtitleTwo visibility");
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleTwo")).isDisplayed();
    }

    public boolean subtitleThreeIsVisible() throws Exception {
        LOG.info("Checking subtitleThree visibility");
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleThree")).isDisplayed();
    }

    public boolean subtitleOneInformationIsVisible() throws Exception {
        LOG.info("Checking subtitleOne information visibility");
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleOneInformation")).isDisplayed();
    }

    public boolean subtitleTwoInformationIsVisible() throws Exception {
        LOG.info("Checking subtitleTwo information visibility");
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleTwoInformation")).isDisplayed();
    }

    public boolean subtitleThreeInformationIsVisible() throws Exception {
        LOG.info("Checking subtitleThree information visibility");
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleThreeInformation"))
                .isDisplayed();
    }

    public boolean verifySubtitleOneText() throws Exception {
        LOG.info("Verifying SubtitleOne text");
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleOne")).getText()
                .equals(subtitleOneText);
    }

    public boolean verifySubtitleTwoText() throws Exception {
        LOG.info("Verifying SubtitleTwo text");
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleTwo")).getText()
                .equals(subtitleTwoText);
    }

    public boolean verifySubtitleThreeText() throws Exception {
        LOG.info("Verifying SubtitleThree text");
        return driver.findElement(getLocator("DeliveryInformationPage.subtitleThree")).getText()
                .equals(subtitleThreeText);
    }

    public boolean hasOpened() {
        LOG.info("Getting Delivery Information Page loaded status");
        return super.hasOpened(driver, deliveryInformationPageTitle);
    }
}
