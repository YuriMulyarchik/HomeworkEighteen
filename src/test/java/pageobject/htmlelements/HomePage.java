package pageobject.htmlelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static pageobject.helpers.Locators.getLocator;

public class HomePage extends PageBase {

    private String homePageTitle="Online Store | My Store1";

    public HeaderMenu headerMenu;

    public RegionalSettingsMenu regionalSettingsMenu;

    public Cart cart;


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public boolean successMessageIsVisible() throws Exception {
        return driver.findElement(getLocator("HomePage.successMessage")).isDisplayed();
    }

    public boolean hasOpened() {
        return super.hasOpened(driver, homePageTitle);
    }
}
