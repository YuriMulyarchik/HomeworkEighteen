package pageobject.object;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class PageBase {

    Logger LOG = Logger.getLogger(PageBase.class);

    protected boolean hasOpened(WebDriver driver, String title) {
        return driver.getTitle().equals(title);

    }
}
