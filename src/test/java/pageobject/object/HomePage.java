package pageobject.object;

import org.openqa.selenium.WebDriver;
import static pageobject.helpers.Locators.getLocator;

public class HomePage extends PageBase{

    private String homePageTitle="Online Store | My Store1";

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean successMessageIsVisible() throws Exception {
        LOG.info("Checking success message");
        return driver.findElement(getLocator("HomePage.successMessage")).isDisplayed();
    }

    public boolean hasOpened() {
        LOG.info("Getting Home Page loaded status");
        return super.hasOpened(driver, homePageTitle);
    }
}
