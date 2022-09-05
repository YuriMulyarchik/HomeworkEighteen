package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RubberDucksPage {

    private static String rubberDucksPageTitle="Rubber Ducks | My Store1";

    private static By goods = By.cssSelector(".link[title*='Duc']");


    public static boolean verifyRubberDucksPageTitle(WebDriver driver) {
        return driver.getTitle().equals(rubberDucksPageTitle);
    }

    public static boolean verifyRubberDucksPageContainsGoods(WebDriver driver) {
        List<WebElement> ducksPricesList = driver.findElements(goods);

        if (ducksPricesList.isEmpty()) {
         return false;
        } else return true;
    }

}
