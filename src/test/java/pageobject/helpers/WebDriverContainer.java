package pageobject.helpers;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
//import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;






public class WebDriverContainer {

    private static WebDriver driver;

    public static WebDriver getDriver() {


//        if (driver == null) {
//
//            Browsers browser = Browsers.valueOf(System.getProperty("browser", "chrome"));
//
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setPlatform(Platform.WINDOWS);
//
//            switch (browser) {
//                case chrome:
//                    caps.setBrowserName(Browser.CHROME.browserName());
//                    break;
//                case firefox:
//                    caps.setBrowserName(Browser.FIREFOX.browserName());
//                    break;
//
//            }
//
//            try {
//                driver = new RemoteWebDriver(new URL("http://192.168.100.211:4444/wd/hub"), caps);
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            }
//            driver.manage().window().maximize();
//
//
//        }
//        return driver;


            if (driver == null) {

                Browsers browser = Browsers.valueOf(System.getProperty("browser", "chrome"));

                switch (browser) {
                    case chrome:
                        driver = new ChromeDriver();
                        break;
                    case firefox:
                        driver = new FirefoxDriver();
                        break;
                    case opera:
                        driver = new OperaDriver();
                        break;
                    case ie:
                        driver = new InternetExplorerDriver();

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
