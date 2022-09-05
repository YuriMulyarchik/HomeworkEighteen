import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class FITestBase {

    WebDriver driver;

    Logger LOG = Logger.getLogger(FITestBase.class);

    @BeforeMethod
    public void setup() {

        Browsers browser = Browsers.valueOf(System.getProperty("browser", "chrome"));

        switch (browser) {
            case chrome:
                driver = new ChromeDriver();
                LOG.info("Instantiating Chrome driver");
                break;
            case firefox:
                driver = new FirefoxDriver();
                LOG.info("Instantiating Firefox driver");
                break;
        }

//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
//            driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
    }



    @AfterMethod
    public void teardown() {
        LOG.debug("closing driver");
        driver.quit();
    }


}
