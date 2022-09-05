package pageobject.htmlelements;

import org.openqa.selenium.WebDriver;

public class PageBase {
    protected boolean hasOpened(WebDriver driver, String title) {
        return driver.getTitle().equals(title);

    }
}
