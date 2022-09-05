package pageobject.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.ArrayList;
import java.util.List;
import static pageobject.helpers.Locators.getLocator;




public class SiteMenuPage extends PageBase{

    private WebDriver driver;

    public SiteMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveToHomePage() throws Exception {
        LOG.info("Navigating to home page");
        driver.findElement(getLocator("SiteMenuPage.homePageLink")).click();
    }

    public void moveToRubberDucksPage() throws Exception {
        LOG.info("Navigating to rubberDucks page");
        driver.findElement(getLocator("SiteMenuPage.rubberDucksPageLink")).click();
    }

    public void moveToSubcategoryPage() throws Exception {
        LOG.info("Navigating to subcategory page");
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(getLocator("SiteMenuPage.rubberDucksPageLink"))).perform();
        WebElement subcategoriesLink = driver.findElement(getLocator("SiteMenuPage.subcategoriesPageLink"));
        subcategoriesLink.click();
    }

    public void moveToDeliveryInfoPage() throws Exception {
        LOG.info("Navigating to deliveryInfo page");
        driver.findElement(getLocator("SiteMenuPage.deliveryInfoPageLink")).click();
    }

    public void moveToTermsAndConditionsPage() throws Exception {
        LOG.info("Navigating to terms and conditions page");
        driver.findElement(getLocator("SiteMenuPage.termsAndConditionsPageLink")).click();
    }

    public void moveToDiscountsAndPromotionsPage() throws Exception {
        LOG.info("Navigating to discounts and promotions page");
        driver.findElement(getLocator("SiteMenuPage.discountsAndPromotionsPageLink")).click();
    }

    public void changeCurrentCurrencyToDollars() throws Exception {

        LOG.info("Changing current site currency to USD");

        driver.findElement(getLocator("SiteMenuPage.regionalSettingsButton")).click();

        LOG.debug("Waiting for currency selector button");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(getLocator("SiteMenuPage.currencySelectorButton")));

        driver.findElement(getLocator("SiteMenuPage.currencySelectorButton")).click();
        driver.findElement(getLocator("SiteMenuPage.usdInCurrencySelector")).click();
        driver.findElement(getLocator("SiteMenuPage.saveSettingsButton")).click();
    }

    public boolean checkThatCurrentDuckPricesChangedToDollars() throws Exception {

        LOG.info("Checking that current duck prices changed to USD");

        LOG.debug("Collecting duck prices");

        List<WebElement> ducksPricesList = driver.findElements(getLocator("SiteMenuPage.ducksPrices"));

        ArrayList<String> pricesListInString = new ArrayList<>();

        ArrayList<Boolean> booleansList = new ArrayList<>();

        for (WebElement link: ducksPricesList) {
            pricesListInString.add(link.getText());
        }

        LOG.debug("Checking that prices contains $ symbol");
        for (String str: pricesListInString) {
            if (str.charAt(0) == '$') {
                booleansList.add(true);
            } else  booleansList.add(false);
        }

        LOG.debug("Checking that all prices contains $ symbol");
        for (Boolean bool: booleansList) {
            if (!bool) {
                return false;
            }
        } return true;

    }

    public void changeCurrentCountryToBelarus() throws Exception {

        LOG.info("Changing current site country to Belarus");

        driver.findElement(getLocator("SiteMenuPage.regionalSettingsButton")).click();

        LOG.debug("Waiting for country selector button");
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(getLocator("SiteMenuPage.countrySelectorButton")));

        driver.findElement(getLocator("SiteMenuPage.countrySelectorButton")).click();
        driver.findElement(getLocator("SiteMenuPage.belarusInCountrySelector")).click();
        driver.findElement(getLocator("SiteMenuPage.saveSettingsButton")).click();

    }

    public String getCurrentSiteCountry() throws Exception {
        LOG.info("Getting current site country");
        return driver.findElement(getLocator("SiteMenuPage.currentCountry")).getText();
    }

    public String getCurrentSiteCurrency() throws Exception {
        LOG.info("Getting current site currency");
        return driver.findElement(getLocator("SiteMenuPage.currentCurrency")).getText();
    }

}
