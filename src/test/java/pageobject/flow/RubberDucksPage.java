package pageobject.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;


public class RubberDucksPage {

    private String rubberDucksPageTitle="Rubber Ducks | My Store1";

    private By goods = By.cssSelector(".link[title*='Duc']");

    private WebDriver driver;


    public RubberDucksPage(WebDriver driver) {
        this.driver = driver;
    }
    public RubberDucksPage verifyRubberDucksPageTitle() {
        Assert.assertTrue(driver.getTitle().equals(rubberDucksPageTitle), "RubberDucksPage " +
                "has an incorrect title or RubberDucksPage not navigated");
        return this;
    }

    public RubberDucksPage verifyRubberDucksPageContainsGoods() {

        List<WebElement> ducksPricesList = driver.findElements(goods);

        Assert.assertTrue(!ducksPricesList.isEmpty(), "RubberDucksPage does not goods");
        return this;
    }

}
