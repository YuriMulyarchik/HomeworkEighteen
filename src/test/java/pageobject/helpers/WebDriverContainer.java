package pageobject.helpers;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;






public class WebDriverContainer {

    private static WebDriver driver;

    public static WebDriver getDriver() {


        if (driver == null) {

            Browsers browser = Browsers.valueOf(System.getProperty("browser", "chrome"));

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setPlatform(Platform.WINDOWS);

            switch (browser) {
                case chrome:
                    caps.setBrowserName(Browser.CHROME.browserName());
                    break;
                case firefox:
                    caps.setBrowserName(Browser.FIREFOX.browserName());
                    break;

            }

            try {
                driver = new RemoteWebDriver(new URL("http://192.168.100.211:4444/wd/hub"), caps);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver.manage().window().maximize();


        }
        return driver;

    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
