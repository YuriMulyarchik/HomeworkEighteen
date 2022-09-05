package pageobject.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class SubcategoriesPage {
    private String yellowDuckCorrectTitle = "Yellow Duck";

    private String greenDuckTCorrectTitle = "Green DucK";

    private String yellowDuckCorrectSticker = "SALE";

    private String greenDuckCorrectSticker = "NEW";

    @FindBy(xpath = "//*[@id='box-category']/nav/*[1]")
    private WebElement sortByNamesButton;

    @FindBy(xpath = "//*[@id='box-category']/nav/*[2]")
    private WebElement sortByPriceButton;

    @FindBy(css = ".link[title='Yellow Duck']")
    private WebElement yellowDuckLink;

    @FindBy(css = ".link[title='Green DucK']")
    private WebElement greenDuckLink;

    @FindBy(css = "[title='On Sale']")
    private WebElement saleSticker;

    @FindBy(css = ".sticker.new")
    private WebElement newSticker;

    @FindAll({@FindBy(css = ".price-wrapper > :not(s)")})
    private List<WebElement> duckPricesList;

    @FindAll({@FindBy(className = "name")})
    private List<WebElement> duckNamesList;

    public void clickSortByNamesButton() {
        sortByNamesButton.click();
    }

    public void clickSortByPriceButton() {
        sortByPriceButton.click();
    }

    public boolean verifyYellowDuckSticker() {

        if (yellowDuckLink.getAttribute("title").equals(yellowDuckCorrectTitle) &&
                saleSticker.getText().equals(yellowDuckCorrectSticker)) {
            return true;
        } else return false;
    }

    public boolean verifyGreenDuckSticker() {

        if (greenDuckLink.getAttribute("title").equals(greenDuckTCorrectTitle) &&
                newSticker.getText().equals(greenDuckCorrectSticker)) {
            return true;
        } else return false;
    }

    public boolean verifySortingByNames() {

        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<String> sortedNamesList = new ArrayList<>();

        for (WebElement link: duckNamesList) {
            namesList.add(link.getText());
            sortedNamesList.add(link.getText());
        }

        Collections.sort(sortedNamesList);
        if (Objects.equals(namesList, sortedNamesList)) {
            return true;
        } else return false;

    }

    public boolean verifySortingByPrices() {

        ArrayList<String> pricesListInString = new ArrayList<>();

        for (WebElement link: duckPricesList) {
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

}


