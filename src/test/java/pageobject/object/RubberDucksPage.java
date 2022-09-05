package pageobject.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static pageobject.helpers.Locators.getLocator;


public class RubberDucksPage extends PageBase {

    private String rubberDucksPageTitle="Rubber Ducks | My Store1";

    private WebDriver driver;

    public RubberDucksPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyRubberDucksPageContainsGoods() throws Exception {

        LOG.info("Verifying that goods are placed on page");

        LOG.debug("Collecting goods on page");

        List<WebElement> ducksPricesList = driver.findElements(getLocator("RubberDucksPage.goods"));

        if (ducksPricesList.isEmpty()) {
         return false;
        } else return true;
    }

    public boolean hasOpened() {
        LOG.info("Getting RubberDucksPage loaded status");
        return super.hasOpened(driver, rubberDucksPageTitle);
    }

}
