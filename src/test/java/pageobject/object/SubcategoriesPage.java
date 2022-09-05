package pageobject.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import static pageobject.helpers.Locators.getLocator;


public class SubcategoriesPage extends PageBase{

    private String subcategoriesPageTitle="Subcategory | My Store1";

    private String yellowDuckCorrectTitle = "Yellow Duck";

    private String greenDuckTCorrectTitle = "Green DucK";

    private String yellowDuckCorrectSticker = "SALE";

    private String greenDuckCorrectSticker = "NEW";

    private WebDriver driver;

    public SubcategoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSortByNamesButton() throws Exception {
        LOG.info("Clicking sorting by names button");
        driver.findElement(getLocator("SubcategoriesPage.sortByNamesButton")).click();
    }

    public void clickSortByPriceButton() throws Exception {
        LOG.info("Clicking sorting by prices button");
        driver.findElement(getLocator("SubcategoriesPage.sortByPriceButton")).click();
    }

    public boolean verifyYellowDuckSticker() throws Exception {

        LOG.debug("Looking for yellow duck");
        WebElement DuckLink = driver.findElement(getLocator("SubcategoriesPage.yellowDuckLink"));
        LOG.debug("Looking for yellow duck sticker");
        WebElement StickerLink = driver.findElement(getLocator("SubcategoriesPage.saleStickerLink"));
        LOG.info("Checking yellow duck sticker");
        if (DuckLink.getAttribute("title").equals(yellowDuckCorrectTitle) &&
                StickerLink.getText().equals(yellowDuckCorrectSticker)) {
            return true;
        } else return false;
    }

    public boolean verifyGreenDuckSticker() throws Exception {

        LOG.debug("Looking for green duck");
        WebElement DuckLink = driver.findElement(getLocator("SubcategoriesPage.greenDuckLink"));
        LOG.debug("Looking for green duck sticker");
        WebElement StickerLink = driver.findElement(getLocator("SubcategoriesPage.newStickerLink"));
        LOG.info("Checking green duck sticker");
        if (DuckLink.getAttribute("title").equals(greenDuckTCorrectTitle) &&
                StickerLink.getText().equals(greenDuckCorrectSticker)) {
            return true;
        } else return false;
    }

    public boolean verifySortingByNames() throws Exception {

//        WebElement sortByNamesLink = driver.findElement(getLocator("SubcategoriesPage.sortByNamesButton"));
//        sortByNamesLink.click();

        LOG.info("Verifying sorting by names");
        LOG.debug("Collecting duck names");

        List<WebElement> ducksList = driver.findElements(getLocator("SubcategoriesPage.ducksNames"));

        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<String> sortedNamesList = new ArrayList<>();

        LOG.debug("Adding duck names to list");

        for (WebElement link: ducksList) {
            namesList.add(link.getText());
            sortedNamesList.add(link.getText());
        }

        LOG.debug("Sorting duck names list");
        Collections.sort(sortedNamesList);


        if (Objects.equals(namesList, sortedNamesList)) {
            return true;
        } else return false;

    }

    public boolean verifySortingByPrices() throws Exception {

        LOG.info("Verifying sorting by prices");

        LOG.debug("Collecting duck prices");

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

        LOG.debug("Sorting duck prices list");
        Collections.sort(sortedPricesListInFloat);


        if (Objects.equals(pricesListInFloat, sortedPricesListInFloat)) {
            return true;
        } else return false;
    }

    public boolean hasOpened() {
        LOG.info("Getting SubcategoriesPage loaded status");
        return super.hasOpened(driver, subcategoriesPageTitle);
    }


}


