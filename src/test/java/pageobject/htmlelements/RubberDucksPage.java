package pageobject.htmlelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.object.PageBase;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;

import static pageobject.helpers.Locators.getLocator;


public class RubberDucksPage extends PageBase {

    private String rubberDucksPageTitle="Rubber Ducks | My Store1";

    public HeaderMenu headerMenu;

    public RegionalSettingsMenu regionalSettingsMenu;
    public Cart cart;
    private WebDriver driver;

    public RubberDucksPage(WebDriver driver) {
        this.driver = driver;
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public boolean verifyRubberDucksPageContainsGoods() throws Exception {
        List<WebElement> ducksPricesList = driver.findElements(getLocator("RubberDucksPage.goods"));

        if (ducksPricesList.isEmpty()) {
         return false;
        } else return true;
    }

    public boolean hasOpened() {
        return super.hasOpened(driver, rubberDucksPageTitle);
    }

}
