package pageobject.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryInformationPage {

    private String subtitleOneText = "информация о доставке";
    private String subtitleTwoText = "Подзаголовок 2";
    private String subtitleThreeText = "Подзаголовок 3";

    @FindBy(css = "div.content > h1")
    private WebElement subtitleOne;

    @FindBy(css = "p:nth-child(2) > font")
    private WebElement subtitleOneInformation;

    @FindBy(css = "div.content > h2")
    private WebElement subtitleTwo;

    @FindBy(css = "p:nth-child(4) > font")
    private WebElement subtitleTwoInformation;

    @FindBy(css = "div.content > h3")
    private WebElement subtitleThree;

    @FindBy(css = "p:nth-child(6) > font")
    private WebElement subtitleThreeInformation;


    public boolean subtitleOneIsVisible() {
        return subtitleOne.isDisplayed();
    }
    public boolean subtitleTwoIsVisible() {
        return subtitleTwo.isDisplayed();
    }
    public boolean subtitleThreeIsVisible() {
        return subtitleThree.isDisplayed();
    }

    public boolean subtitleOneInformationIsVisible() {
        return subtitleOneInformation.isDisplayed();
    }
    public boolean subtitleTwoInformationIsVisible() {
        return subtitleTwoInformation.isDisplayed();
    }
    public boolean subtitleThreeInformationIsVisible() {
        return subtitleThreeInformation.isDisplayed();
    }

    public String getSubtitleOneText(){
        return subtitleOne.getText();
    }

    public boolean verifySubtitleOneText() {
        return getSubtitleOneText().contains(subtitleOneText);
    }

    public String getSubtitleTwoText(){
        return subtitleTwo.getText();
    }

    public boolean verifySubtitleTwoText() {
        return getSubtitleTwoText().contains(subtitleTwoText);
    }

    public String getSubtitleThreeText(){
        return subtitleThree.getText();
    }

    public boolean verifySubtitleThreeText() {
        return getSubtitleThreeText().equalsIgnoreCase(subtitleThreeText);
    }
}
