import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.Keys.ARROW_UP;

public class PFTestBase {
    WebDriver driver;

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

    //тут мне пришлось добавить метолы для которых нужен driver для ожидалок и actions
    private By rubberDucksPageLink = By.cssSelector("#site-menu .category-1");
    private By subcategoriesPageLink = By.cssSelector("#site-menu .category-2");

    private By countrySelectorButton = By.name("country_code");
    public void moveToSubcategoryPage() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(rubberDucksPageLink)).perform();
        WebElement subcategoriesLink = driver.findElement(subcategoriesPageLink);
        subcategoriesLink.click();
    }




    private By regionalSettingsButton = By.cssSelector(".change");

    private By ducksPrices = By.cssSelector(".price-wrapper > :not(s)");

    private By currencySelectorButton = By.name("currency_code");
    private By usdInCurrencySelector = By.cssSelector("[value='USD']");

    private By belarusInCountrySelector = By.cssSelector("[value='BY']");
    private By saveSettingsButton = By.name("save");

    private By orderedGoodsQuantity = By.cssSelector("span.quantity");
    private By goodsOnPage = By.cssSelector(".link[title*='Duc']");

    private By ducksSizeSelectorButton = By.cssSelector("td > select");
    private By ducksSizesSelector = By.cssSelector("option:not(:first-child)");

    private By addGoodsToCartButton = By.name("add_cart_product");

    private By ducksQuantityForPurchase = By.name("quantity");

    public void changeCurrentCurrencyToDollars() {

        driver.findElement(regionalSettingsButton).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(currencySelectorButton));

        driver.findElement(currencySelectorButton).click();
        driver.findElement(usdInCurrencySelector).click();
        driver.findElement(saveSettingsButton).click();
    }

    public boolean checkThatCurrentDuckPricesChangedToDollars() {

        List<WebElement> ducksPricesList = driver.findElements(ducksPrices);

        ArrayList<String> pricesListInString = new ArrayList<>();

        ArrayList<Boolean> booleansList = new ArrayList<>();

        for (WebElement link: ducksPricesList) {
            pricesListInString.add(link.getText());
        }

        for (String str: pricesListInString) {
            if (str.charAt(0) == '$') {
                booleansList.add(true);
            } else  booleansList.add(false);
        }

        for (Boolean bool: booleansList) {
            if (!bool) {
                return false;
            }
        } return true;

    }


    public void changeCurrentCountryToBelarus() {

        driver.findElement(By.cssSelector(".change")).click();

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(countrySelectorButton));


        driver.findElement(countrySelectorButton).click();
        driver.findElement(belarusInCountrySelector).click();
        driver.findElement(saveSettingsButton).click();

    }

    public boolean checkThatGoodsPlacedToCart()  {

        WebElement element = driver.findElement(orderedGoodsQuantity);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, "0")));

        if (driver.findElement(orderedGoodsQuantity).getText().equals("0") ) {
            return false;
        } else return true;

    }

    public void orderRandomGoods() {

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
