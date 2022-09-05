
import com.epam.reportportal.service.ReportPortal;
import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;


//@Listeners(ScreenshotListener.class)

public class POTestBase {

    WebDriver driver;

    Logger LOG = Logger.getLogger(POTestBase.class);

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

            driver.manage().window().maximize();
            driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void teardown(ITestResult result) {

        LOG.debug("closing driver");


        if (result.getStatus() == ITestResult.FAILURE) {

            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            try {
                Allure.addAttachment(result.getTestName() + "screenshot", new FileInputStream(screenshot));
                ReportPortal.emitLog(result.getTestName() + "screenshot", "ERROR",
                        Calendar.getInstance().getTime(), screenshot);

            } catch (FileNotFoundException e) {
                LOG.error("Could not take screenshot:" + e.getMessage());
            }



            driver.quit();

        } else if (result.getStatus() == ITestResult.SKIP) {
            driver.quit();
        } else if (result.getStatus() == ITestResult.SUCCESS){
            driver.quit();
        }

    }


}
