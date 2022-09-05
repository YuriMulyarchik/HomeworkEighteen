package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.Keys.ARROW_UP;

public class CartPage {

    private static By orderedGoodsQuantity = By.cssSelector("span.quantity");

    private static By goodsOnPage = By.cssSelector(".link[title*='Duc']");

    private static By ducksSizeSelectorButton = By.cssSelector("td > select");

    private static By ducksSizesSelector = By.cssSelector("option:not(:first-child)");

    private static By addGoodsToCartButton = By.name("add_cart_product");

    private static By ducksQuantityForPurchase = By.name("quantity");



    public static boolean checkThatGoodsPlacedToCart(WebDriver driver)  {

        WebElement element = driver.findElement(orderedGoodsQuantity);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, "0")));

        if (driver.findElement(orderedGoodsQuantity).getText().equals("0") ) {
            return false;
        } else return true;

    }

    public static void orderRandomGoods(WebDriver driver) {

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
    }

}
