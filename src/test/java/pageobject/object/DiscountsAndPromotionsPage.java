package pageobject.object;

import org.openqa.selenium.WebDriver;
import static pageobject.helpers.Locators.getLocator;

public class DiscountsAndPromotionsPage extends PageBase{

    private String discountsAndPromotionsPageTitle="4 | My Store1";

    private String noDiscountsAndPromotionsText = "Скидок пока нет.\n" +
            "Следите за рассылкой по электронной почте";

    private WebDriver driver;

    public DiscountsAndPromotionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean informationAboutPromotionsAndDiscountsMessageIsVisible() throws Exception{
        LOG.info("Checking information about promotions and discounts visibility");
        return driver.findElement
                (getLocator("DiscountsAndPromotionsPage.informationAboutDiscountsAndPromotions")).isDisplayed();
    }

    public boolean verifyNoPromotionsAndDiscountsMessage() throws Exception {
        LOG.info("Verifying information about no promotions and discounts text");
        return driver
                .findElement(getLocator("DiscountsAndPromotionsPage.informationAboutDiscountsAndPromotions"))
                .getText().equals(noDiscountsAndPromotionsText);
    }

    public boolean hasOpened() {
        LOG.info("Getting discounts and promotions page loaded status");
        return super.hasOpened(driver, discountsAndPromotionsPageTitle);
    }
}



