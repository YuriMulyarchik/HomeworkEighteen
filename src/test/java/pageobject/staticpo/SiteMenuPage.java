package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class SiteMenuPage {

    private static By homePageLink = By.cssSelector(".general-0");
    private static By rubberDucksPageLink = By.cssSelector("#site-menu .category-1");
    private static By subcategoriesPageLink = By.cssSelector("#site-menu .category-2");
    private static By deliveryInfoPageLink = By.cssSelector(".page-2");
    private static By termsAndConditionsPageLink = By.cssSelector(".page-4");
    private static By discountsAndPromotionsPageLink = By.cssSelector(".page-5");
    private static By currentCountry = By.cssSelector(".country");
    private static By currentCurrency = By.cssSelector(".currency");
    private static By regionalSettingsButton = By.cssSelector(".change");

    private static By ducksPrices = By.cssSelector(".price-wrapper > :not(s)");

    private static By currencySelectorButton = By.name("currency_code");
    private static By usdInCurrencySelector = By.cssSelector("[value='USD']");
    private static By countrySelectorButton = By.name("country_code");
    private static By belarusInCountrySelector = By.cssSelector("[value='BY']");
    private static By saveSettingsButton = By.name("save");

    public static void moveToHomePage(WebDriver driver) {
        driver.findElement(homePageLink).click();
    }

    public static void moveToRubberDucksPage(WebDriver driver) {
        driver.findElement(rubberDucksPageLink).click();
    }

    public static void moveToSubcategoryPage(WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(rubberDucksPageLink)).perform();
        WebElement subcategoriesLink = driver.findElement(subcategoriesPageLink);
        subcategoriesLink.click();
    }

    public static void moveToDeliveryInfoPage(WebDriver driver) {
        driver.findElement(deliveryInfoPageLink).click();
    }

    public static void moveToTermsAndConditionsPage(WebDriver driver) {
        driver.findElement(termsAndConditionsPageLink).click();
    }

    public static void moveToDiscountsAndPromotionsPage(WebDriver driver) {
        driver.findElement(discountsAndPromotionsPageLink).click();
    }

    public static void changeCurrentCurrencyToDollars(WebDriver driver) {

        driver.findElement(regionalSettingsButton).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(currencySelectorButton));

        driver.findElement(currencySelectorButton).click();
        driver.findElement(usdInCurrencySelector).click();
        driver.findElement(saveSettingsButton).click();
    }

    public static boolean checkThatCurrentDuckPricesChangedToDollars(WebDriver driver) {

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

    public static void changeCurrentCountryToBelarus(WebDriver driver) {

        driver.findElement(regionalSettingsButton).click();

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(countrySelectorButton));

        driver.findElement(countrySelectorButton).click();
        driver.findElement(belarusInCountrySelector).click();
        driver.findElement(saveSettingsButton).click();


    }

    public static String getCurrentSiteCountry(WebDriver driver) {
        return driver.findElement(currentCountry).getText();
    }

    public static String getCurrentSiteCurrency(WebDriver driver) {
        return driver.findElement(currentCurrency).getText();
    }

}
