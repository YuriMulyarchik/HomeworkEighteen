package pageobject.htmlelements;

import org.openqa.selenium.WebDriver;
import pageobject.object.PageBase;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static pageobject.helpers.Locators.getLocator;

public class DiscountsAndPromotionsPage extends PageBase {


    private String discountsAndPromotionsPageTitle="4 | My Store1";

    private String noDiscountsAndPromotionsText = "Скидок пока нет.\n" +
            "Следите за рассылкой по электронной почте";

    public HeaderMenu headerMenu;

    public RegionalSettingsMenu regionalSettingsMenu;

    public Cart cart;

    public InformationBox informationBox;
    private WebDriver driver;

    public DiscountsAndPromotionsPage(WebDriver driver) {
        this.driver = driver;
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public boolean informationAboutPromotionsAndDiscountsMessageIsVisible() throws Exception{
        return driver.findElement
                (getLocator("DiscountsAndPromotionsPage.informationAboutDiscountsAndPromotions")).isDisplayed();
    }

    public boolean verifyNoPromotionsAndDiscountsMessage() throws Exception {
        return driver.findElement(getLocator("DiscountsAndPromotionsPage.informationAboutDiscountsAndPromotions"))
                .getText().equals(noDiscountsAndPromotionsText);
    }

    public boolean hasOpened() {
        return super.hasOpened(driver, discountsAndPromotionsPageTitle);
    }
}



