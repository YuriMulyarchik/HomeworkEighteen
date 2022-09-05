package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private static String homePageTitle="Online Store | My Store1";

    private static By successMessage = By.cssSelector(".notice.success");

    public static boolean successMessageIsVisible(WebDriver driver) {
        return driver.findElement(successMessage).isDisplayed();
    }

    public static boolean verifyHomePageTitle(WebDriver driver) {

        return driver.getTitle().equals(homePageTitle);
    }


}
