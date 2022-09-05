package pageobject.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

import static org.openqa.selenium.Keys.ARROW_UP;

public class CartPage {

    private By orderedGoodsQuantity = By.cssSelector("span.quantity");

    private By goodsOnPage = By.cssSelector(".link[title*='Duc']");

    private By ducksSizeSelectorButton = By.cssSelector("td > select");

    private By ducksSizesSelector = By.cssSelector("option:not(:first-child)");


    private By addGoodsToCartButton = By.name("add_cart_product");

    private By ducksQuantityForPurchase = By.name("quantity");


    private WebDriver driver;


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage checkThatGoodsPlacedToCart()  {

        WebElement element = driver.findElement(orderedGoodsQuantity);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, "0")));

        Assert.assertTrue(!driver.findElement(orderedGoodsQuantity).getText().equals("0"),
                "Goods are not added to the cart from RubberDucksPage");
        return this;
    }

    public CartPage orderRandomGoods() {

        List<WebElement> ducksPricesList = driver.findElements(goodsOnPage);

        int maxProducts = ducksPricesList.size();

        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);

        ducksPricesList.get(randomProduct).click();

        try {
            driver.findElement(ducksSizeSelectorButton).click();
            List<WebElement> availableDuckSixesList = driver.findElements(ducksSizesSelector);
            Random randomDuckSize = new Random();
            int size = randomDuckSize.nextInt(availableDuckSixesList.size());
            availableDuckSixesList.get(size).click();

            driver.findElement(ducksQuantityForPurchase).click();

            for (int i = (int) (Math.random()*20); i > 0; i--) {

                Actions builder = new Actions(driver);
                builder.sendKeys(ARROW_UP).perform();
            }

            driver.findElement(addGoodsToCartButton).click();

        } catch (Exception e) {

            driver.findElement(ducksQuantityForPurchase).click();

            for (int i = (int) (Math.random()*20); i > 0; i--) {
                Actions builder = new Actions(driver);
                builder.sendKeys(Keys.ARROW_UP).perform();
            }

            driver.findElement(addGoodsToCartButton).click();
        }
    return this;
    }

}
