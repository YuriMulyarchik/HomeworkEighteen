package pageobject.object;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;
import static pageobject.helpers.Locators.getLocator;
import static org.openqa.selenium.Keys.ARROW_UP;

public class CartPage extends PageBase{

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkThatGoodsPlacedToCart() throws Exception {

        WebElement element = driver.findElement(getLocator("CartPage.orderedGoodsQuantity"));

        WebDriverWait wait = new WebDriverWait(driver, 10);

        LOG.debug("Waiting until ordered goods quantity changed");

        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, "0")));

        LOG.info("Checking that goods placed to cart");

        if (driver.findElement(getLocator("CartPage.orderedGoodsQuantity")).getText().equals("0") ) {
            return false;
        } else return true;

    }

    public void orderRandomGoods() throws Exception {

        LOG.debug("Collecting goods on page");

        List<WebElement> ducksPricesList = driver.findElements(getLocator("CartPage.goodsOnPage"));

        int maxProducts = ducksPricesList.size();

        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);

        LOG.debug("Taking random good");

        ducksPricesList.get(randomProduct).click();

        try {
            driver.findElement(getLocator("CartPage.ducksSizeSelectorButton")).click();
            List<WebElement> availableDuckSixesList =
                    driver.findElements(getLocator("CartPage.ducksSizesSelector"));
            Random randomDuckSize = new Random();
            int size = randomDuckSize.nextInt(availableDuckSixesList.size());
            availableDuckSixesList.get(size).click();

            driver.findElement(getLocator("CartPage.ducksQuantityForPurchase")).click();

            for (int i = (int) (Math.random()*20); i > 0; i--) {

                Actions builder = new Actions(driver);
                builder.sendKeys(ARROW_UP).perform();
            }

            LOG.debug("Adding goods to the cart");

            driver.findElement(getLocator("CartPage.addGoodsToCartButton")).click();

        } catch (Exception e) {

            driver.findElement(getLocator("CartPage.ducksQuantityForPurchase")).click();

            for (int i = (int) (Math.random()*20); i > 0; i--) {
                Actions builder = new Actions(driver);
                builder.sendKeys(Keys.ARROW_UP).perform();
            }

            LOG.debug("Adding goods to the cart");

            driver.findElement(getLocator("CartPage.addGoodsToCartButton")).click();
        }

        LOG.info("Ordering random goods on page");
    }

}
