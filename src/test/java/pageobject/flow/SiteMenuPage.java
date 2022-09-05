package pageobject.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;


public class SiteMenuPage {

    private WebDriver driver;

    private By homePageLink = By.cssSelector(".general-0");
    private By rubberDucksPageLink = By.cssSelector("#site-menu .category-1");
    private By subcategoriesPageLink = By.cssSelector("#site-menu .category-2");
    private By deliveryInfoPageLink = By.cssSelector(".page-2");
    private By termsAndConditionsPageLink = By.cssSelector(".page-4");
    private By discountsAndPromotionsPageLink = By.cssSelector(".page-5");
    private By currentCountry = By.cssSelector(".country");
    private By currentCurrency = By.cssSelector(".currency");
    private By regionalSettingsButton = By.cssSelector(".change");

    private By ducksPrices = By.cssSelector(".price-wrapper > :not(s)");

    private By currencySelectorButton = By.name("currency_code");
    private By usdInCurrencySelector = By.cssSelector("[value='USD']");
    private By countrySelectorButton = By.name("country_code");
    private By belarusInCountrySelector = By.cssSelector("[value='BY']");
    private By saveSettingsButton = By.name("save");


    public SiteMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage moveToHomePage() {
        driver.findElement(homePageLink).click();
        return new HomePage(driver);
    }

    public RubberDucksPage moveToRubberDucksPage() {
        driver.findElement(rubberDucksPageLink).click();
        return new RubberDucksPage(driver);
    }

    public SubcategoriesPage moveToSubcategoryPage() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(rubberDucksPageLink)).perform();
        WebElement subcategoriesLink = driver.findElement(subcategoriesPageLink);
        subcategoriesLink.click();
        return new SubcategoriesPage(driver);
    }

    public DeliveryInformationPage moveToDeliveryInfoPage() {
        driver.findElement(deliveryInfoPageLink).click();
        return new DeliveryInformationPage(driver);
    }

    public TermsAndConditionsPage moveToTermsAndConditionsPage() {
        driver.findElement(termsAndConditionsPageLink).click();
        return new TermsAndConditionsPage(driver);
    }

    public DiscountsAndPromotionsPage moveToDiscountsAndPromotionsPage() {
        driver.findElement(discountsAndPromotionsPageLink).click();
        return new DiscountsAndPromotionsPage(driver);
    }

    public SiteMenuPage changeCurrentCurrencyToDollars() {

        driver.findElement(regionalSettingsButton).click();

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(currencySelectorButton));

        driver.findElement(currencySelectorButton).click();
        driver.findElement(usdInCurrencySelector).click();
        driver.findElement(saveSettingsButton).click();

        return this;
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


    public SiteMenuPage changeCurrentCountryToBelarus() {

        driver.findElement(regionalSettingsButton).click();

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(countrySelectorButton));

        driver.findElement(countrySelectorButton).click();
        driver.findElement(belarusInCountrySelector).click();
        driver.findElement(saveSettingsButton).click();

        return this;

    }

    public SiteMenuPage verifyThatCurrentCountryChangedToBelarus() {

        Assert.assertEquals(driver.findElement(currentCountry).getText(), "Belarus",
                "Current country is not changed to Belarus");
        return this;
    }

}
