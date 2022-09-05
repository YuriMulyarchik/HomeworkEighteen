package pageobject.htmlelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.object.PageBase;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static pageobject.helpers.Locators.getLocator;


public class SubcategoriesPage extends PageBase {

    private String subcategoriesPageTitle="Subcategory | My Store1";

    private String yellowDuckCorrectTitle = "Yellow Duck";

    private String greenDuckTCorrectTitle = "Green DucK";

    private String yellowDuckCorrectSticker = "SALE";

    private String greenDuckCorrectSticker = "NEW";

    private WebDriver driver;

    public SubcategoriesPage(WebDriver driver) {
        this.driver = driver;
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void clickSortByNamesButton() throws Exception {
        driver.findElement(getLocator("SubcategoriesPage.sortByNamesButton")).click();
    }

    public void clickSortByPriceButton() throws Exception {
        driver.findElement(getLocator("SubcategoriesPage.sortByPriceButton")).click();
    }

    public boolean verifyYellowDuckSticker() throws Exception {

        WebElement DuckLink = driver.findElement(getLocator("SubcategoriesPage.yellowDuckLink"));
        WebElement StickerLink = driver.findElement(getLocator("SubcategoriesPage.saleStickerLink"));
        if (DuckLink.getAttribute("title").equals(yellowDuckCorrectTitle) &&
                StickerLink.getText().equals(yellowDuckCorrectSticker)) {
            return true;
        } else return false;
    }

    public boolean verifyGreenDuckSticker() throws Exception {

        WebElement DuckLink = driver.findElement(getLocator("SubcategoriesPage.greenDuckLink"));
        WebElement StickerLink = driver.findElement(getLocator("SubcategoriesPage.newStickerLink"));
        if (DuckLink.getAttribute("title").equals(greenDuckTCorrectTitle) &&
                StickerLink.getText().equals(greenDuckCorrectSticker)) {
            return true;
        } else return false;
    }

    public boolean verifySortingByNames() throws Exception {

        WebElement sortByNamesLink = driver.findElement(getLocator("SubcategoriesPage.sortByNamesButton"));
        sortByNamesLink.click();



        List<WebElement> ducksList = driver.findElements(getLocator("SubcategoriesPage.ducksNames"));

        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<String> sortedNamesList = new ArrayList<>();

        for (WebElement link: ducksList) {
            namesList.add(link.getText());
            sortedNamesList.add(link.getText());
        }

        Collections.sort(sortedNamesList);
        if (Objects.equals(namesList, sortedNamesList)) {
            return true;
        } else return false;

    }

    public boolean verifySortingByByPrices() throws Exception {

        List<WebElement> ducksPricesList = driver.findElements(getLocator("SubcategoriesPage.prices"));

        ArrayList<String> pricesListInString = new ArrayList<>();

        for (WebElement link: ducksPricesList) {
            pricesListInString.add(link.getText());
        }

        ArrayList<Float> pricesListInFloat = new ArrayList<>();
        ArrayList<Float> sortedPricesListInFloat = new ArrayList<>();


        for (int i = 0; i < pricesListInString.size(); i++ ) {
            pricesListInFloat.add(Float.parseFloat(pricesListInString.get(i).replaceAll("[^\\d.]",
                    "")));
            sortedPricesListInFloat.add(Float.parseFloat(pricesListInString.get(i).replaceAll("[^\\d.]",
                    "")));
        }


        Collections.sort(sortedPricesListInFloat);

        if (Objects.equals(pricesListInFloat, sortedPricesListInFloat)) {
            return true;
        } else return false;
    }

    public boolean hasOpened() {
        return super.hasOpened(driver, subcategoriesPageTitle);
    }


}


