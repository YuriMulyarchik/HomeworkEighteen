package pageobject.pagefactory;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiscountsAndPromotionsPage {

    private String noDiscountsAndPromotionsText = "Скидок пока нет.\n" +
            "Следите за рассылкой по электронной почте";
    @FindBy(css = "div.middle > div.content")
    private WebElement informationAboutDiscountsAndPromotions;

    public boolean informationAboutPromotionsAndDiscountsMessageIsVisible() {
        return informationAboutDiscountsAndPromotions.isDisplayed();
    }

    public String getNoPromotionsAndDiscountsMessageText(){
        return informationAboutDiscountsAndPromotions.getText();
    }

    public boolean verifyNoPromotionsAndDiscountsMessage() {
        return getNoPromotionsAndDiscountsMessageText().equals(noDiscountsAndPromotionsText);
    }

}



