package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class SubcategoriesPage {

    private static String subcategoriesPageTitle="Subcategory | My Store1";
    private static String yellowDuckCorrectTitle = "Yellow Duck";
    private static String greenDuckTCorrectTitle = "Green DucK";

    private static String yellowDuckCorrectSticker = "SALE";
    private static String greenDuckCorrectSticker = "NEW";

    private static By sortByNamesButton = By.xpath("//*[@id='box-category']/nav/*[1]");

    private static By sortByPriceButton = By.xpath("//*[@id='box-category']/nav/*[2]");

    private static By yellowDuckLink = By.cssSelector(".link[title='Yellow Duck']");

    private static By greenDuckLink = By.cssSelector(".link[title='Green DucK']");

    private static By saleStickerLink = By.cssSelector("[title='On Sale']");

    private static By newStickerLink = By.cssSelector(".sticker.new");

    private static By  prices = By.cssSelector(".price-wrapper > :not(s)");
    private static By  ducksNames = By.className("name");

    public static void clickSortByNamesButton(WebDriver driver) {
        driver.findElement(sortByNamesButton).click();
    }

    public static void clickSortByPriceButton(WebDriver driver) {
        driver.findElement(sortByPriceButton).click();
    }

    public static boolean verifyYellowDuckSticker(WebDriver driver) {

        WebElement DuckLink = driver.findElement(yellowDuckLink);
        WebElement StickerLink = driver.findElement(saleStickerLink);
        if (DuckLink.getAttribute("title").equals(yellowDuckCorrectTitle) &&
                StickerLink.getText().equals(yellowDuckCorrectSticker)) {
            return true;
        } else return false;
    }

    public static boolean verifyGreenDuckSticker(WebDriver driver) {


        WebElement DuckLink = driver.findElement(greenDuckLink);
        WebElement StickerLink = driver.findElement(newStickerLink);
        if (DuckLink.getAttribute("title").equals(greenDuckTCorrectTitle) &&
                StickerLink.getText().equals(greenDuckCorrectSticker)) {
            return true;
        } else return false;
    }

    public static boolean sortByNames(WebDriver driver) {

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
        if (Objects.equals(namesList, sortedNamesList)) {
            return true;
        } else return false;

    }

    public static boolean sortByPrices(WebDriver driver) {

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

        if (Objects.equals(pricesListInFloat, sortedPricesListInFloat)) {
            return true;
        } else return false;
    }

    public static boolean verifySubcategoriesPageTitle(WebDriver driver) {

        return driver.getTitle().equals(subcategoriesPageTitle);
    }

}


