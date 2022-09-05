package pageobject.htmlelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.helpers.WebDriverContainer;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import java.util.ArrayList;
import java.util.List;
import static pageobject.helpers.Locators.getLocator;

@Name("Regional settings menu")
@FindBy(id="region-wrapper")

public class RegionalSettingsMenu extends HtmlElement {


    @Name("current site currency")
    @FindBy(css = ".currency")
    WebElement currentCurrency;


    @Name("current site country")
    @FindBy(css = ".country")
    WebElement currentCountry;

    @Name("duck prices list")
    @FindAll({@FindBy(css = ".price-wrapper > :not(s)")})
    private List<WebElement> ducksPrices;


//    public void changeCurrentCurrencyToDollars() throws Exception{
//
//        regionalSettingsButton.click();
//
//                WebDriverWait wait = new WebDriverWait(WebDriverContainer.getDriver(), 5);
//        wait.until(ExpectedConditions.visibilityOf(currencySelectorButton));
//
//
//        currencySelectorButton.click();
//        usdInCurrencySelector.click();
//        saveSettingsButton.click();
//
//    }



    public void changeCurrentCurrencyToDollars() throws Exception {

        WebDriverContainer.getDriver().findElement(getLocator("SiteMenuPage.regionalSettingsButton")).click();

        WebDriverWait wait = new WebDriverWait(WebDriverContainer.getDriver(), 5);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(getLocator("SiteMenuPage.currencySelectorButton")));

        WebDriverContainer.getDriver().findElement(getLocator("SiteMenuPage.currencySelectorButton")).click();
        WebDriverContainer.getDriver().findElement(getLocator("SiteMenuPage.usdInCurrencySelector")).click();
        WebDriverContainer.getDriver().findElement(getLocator("SiteMenuPage.saveSettingsButton")).click();
    }

    public boolean checkThatCurrentDuckPricesChangedToDollars() throws Exception {

        ArrayList<String> pricesListInString = new ArrayList<>();

        ArrayList<Boolean> booleansList = new ArrayList<>();

        for (WebElement link: ducksPrices) {
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

    public void changeCurrentCountryToBelarus() throws Exception {

        WebDriverContainer.getDriver().findElement(getLocator("SiteMenuPage.regionalSettingsButton")).click();

        WebDriverWait wait = new WebDriverWait(WebDriverContainer.getDriver(),5);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(getLocator("SiteMenuPage.countrySelectorButton")));

        WebDriverContainer.getDriver().findElement(getLocator("SiteMenuPage.countrySelectorButton")).click();
        WebDriverContainer.getDriver().findElement(getLocator("SiteMenuPage.belarusInCountrySelector")).click();
        WebDriverContainer.getDriver().findElement(getLocator("SiteMenuPage.saveSettingsButton")).click();


    }

    public String getCurrentSiteCountry() throws Exception {
        return currentCountry.getText();
    }

    public String getCurrentSiteCurrency() throws Exception {
        return currentCurrency.getText();
    }
}
