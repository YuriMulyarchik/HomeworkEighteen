package pageobject.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class SubcategoriesPage {

    private String subcategoriesPageTitle="Subcategory | My Store1";
    private String yellowDuckCorrectTitle = "Yellow Duck";
    private String greenDuckTCorrectTitle = "Green DucK";

    private String yellowDuckCorrectSticker = "SALE";
    private String greenDuckCorrectSticker = "NEW";

    private By sortByNamesButton = By.xpath("//*[@id='box-category']/nav/*[1]");

    private By sortByPriceButton = By.xpath("//*[@id='box-category']/nav/*[2]");

    private By yellowDuckLink = By.cssSelector(".link[title='Yellow Duck']");

    private By greenDuckLink = By.cssSelector(".link[title='Green DucK']");

    private By saleStickerLink = By.cssSelector("[title='On Sale']");

    private By newStickerLink = By.cssSelector(".sticker.new");

    private By  prices = By.cssSelector(".price-wrapper > :not(s)");
    private By  ducksNames = By.className("name");


    private WebDriver driver;

    public SubcategoriesPage(WebDriver driver) {
        this.driver = driver;
    }


    public SubcategoriesPage clickSortByNamesButton() {
        driver.findElement(sortByNamesButton).click();
        return this;
    }

    public SubcategoriesPage clickSortByPriceButton() {
        driver.findElement(sortByPriceButton).click();
        return this;
    }

    public SubcategoriesPage verifyYellowDuckSticker() {

        WebElement DuckLink = driver.findElement(yellowDuckLink);
        WebElement StickerLink = driver.findElement(saleStickerLink);

        Assert.assertTrue(DuckLink.getAttribute("title").equals(yellowDuckCorrectTitle) &&
                StickerLink.getText().equals(yellowDuckCorrectSticker), "Yellow Duck has an incorrect sticker");
        return this;

    }


    public SubcategoriesPage verifyGreenDuckSticker() {


        WebElement DuckLink = driver.findElement(greenDuckLink);
        WebElement StickerLink = driver.findElement(newStickerLink);

        Assert.assertTrue(DuckLink.getAttribute("title").equals(greenDuckTCorrectTitle) &&
                StickerLink.getText().equals(greenDuckCorrectSticker), "Green Duck has an incorrect sticker");
        return this;
    }

    public SubcategoriesPage verifySortingByNames() {

        WebElement sortByNamesLink = driver.findElement(sortByNamesButton);
        sortByNamesLink.click();


        List<WebElement> ducksList = driver.findElements(ducksNames);

        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<String> sortedNamesList = new ArrayList<>();

        for (WebElement link: ducksList) {
            namesList.add(link.getText());
            sortedNamesList.add(link.getText());
        }

        Collections.sort(sortedNamesList);

        Assert.assertTrue(Objects.equals(namesList, sortedNamesList), "Duck list is not sorted by names!!");
        return this;


    }

    public SubcategoriesPage verifySortingByPrices() {

        List<WebElement> ducksPricesList = driver.findElements(prices);

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


        Assert.assertTrue(Objects.equals(pricesListInFloat, sortedPricesListInFloat),
                "Duck list is not sorted by prices!!");
        return this;

    }

    public SubcategoriesPage verifySubcategoriesPageTitle() {
        Assert.assertTrue(driver.getTitle().equals(subcategoriesPageTitle), "SubcategoriesPage has " +
                "an incorrect title or SubcategoriesPage not navigated");
        return this;
    }


}


