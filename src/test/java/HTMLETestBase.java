import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageobject.helpers.ScreenshotListener;
import pageobject.helpers.WebDriverContainer;


@Listeners(ScreenshotListener.class)
public class HTMLETestBase {

    WebDriver driver;


    @BeforeMethod
    public void Setup(){

    driver = WebDriverContainer.getDriver();

    driver.get("https://litecart.stqa.ru/en/");

    }

    @AfterMethod
    public void tearDown(){

    WebDriverContainer.closeDriver();

    }

}
