package pageobject.htmlelements;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.helpers.WebDriverContainer;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;
import java.util.Random;

import static org.openqa.selenium.Keys.ARROW_UP;
import static pageobject.helpers.Locators.getLocator;

@Name("Cart")
@FindBy(id="cart-wrapper")

public class Cart extends HtmlElement {
    public boolean checkThatGoodsPlacedToCart() throws Exception {

        WebElement element = WebDriverContainer.getDriver().findElement(getLocator("CartPage.orderedGoodsQuantity"));

        WebDriverWait wait = new WebDriverWait(WebDriverContainer.getDriver(), 10);

        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, "0")));

        if (WebDriverContainer.getDriver().findElement(getLocator("CartPage.orderedGoodsQuantity")).getText().equals("0") ) {
            return false;
        } else return true;

    }

    public void orderRandomGoods() throws Exception {

        List<WebElement> ducksPricesList =
                WebDriverContainer.getDriver().findElements(getLocator("CartPage.goodsOnPage"));

        int maxProducts = ducksPricesList.size();

        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);

        ducksPricesList.get(randomProduct).click();

        try {
            WebDriverContainer.getDriver().findElement(getLocator("CartPage.ducksSizeSelectorButton")).click();
            List<WebElement> availableDuckSixesList =
                    WebDriverContainer.getDriver().findElements(getLocator("CartPage.ducksSizesSelector"));
            Random randomDuckSize = new Random();
            int size = randomDuckSize.nextInt(availableDuckSixesList.size());
            availableDuckSixesList.get(size).click();

            WebDriverContainer.getDriver().findElement(getLocator("CartPage.ducksQuantityForPurchase")).click();

            for (int i = (int) (Math.random()*20); i > 0; i--) {

                Actions builder = new Actions(WebDriverContainer.getDriver());
                builder.sendKeys(ARROW_UP).perform();
            }

            WebDriverContainer.getDriver().findElement(getLocator("CartPage.addGoodsToCartButton")).click();

        } catch (Exception e) {

            WebDriverContainer.getDriver().findElement(getLocator("CartPage.ducksQuantityForPurchase")).click();

            for (int i = (int) (Math.random()*20); i > 0; i--) {
                Actions builder = new Actions(WebDriverContainer.getDriver());
                builder.sendKeys(Keys.ARROW_UP).perform();
            }

            WebDriverContainer.getDriver().findElement(getLocator("CartPage.addGoodsToCartButton")).click();
        }

    }
}
