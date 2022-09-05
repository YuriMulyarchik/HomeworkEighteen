import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pageobject.helpers.ScreenshotListener;

import static pageobject.helpers.WebDriverContainer.*;

@Listeners(ScreenshotListener.class)
public class SPOTestBase {
    static WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");

    }

    @AfterMethod
    public void teardown() {

        driver.quit();

    }
}
