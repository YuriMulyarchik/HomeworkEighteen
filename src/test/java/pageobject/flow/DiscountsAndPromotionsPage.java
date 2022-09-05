package pageobject.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DiscountsAndPromotionsPage {

    private String discountsAndPromotionsPageTitle="4 | My Store1";
    private String noDiscountsAndPromotionsText = "Скидок пока нет.\n" +
            "Следите за рассылкой по электронной почте";
    private By informationAboutDiscountsAndPromotions = By.cssSelector("div.middle > div.content");
    private WebDriver driver;

    public DiscountsAndPromotionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public DiscountsAndPromotionsPage informationAboutPromotionsAndDiscountsMessageIsVisible() {
        Assert.assertTrue(driver.findElement(informationAboutDiscountsAndPromotions).isDisplayed(),
                "informationAboutPromotionsAndDiscountsMessage is invisible");
        return new DiscountsAndPromotionsPage(driver);
    }

    public String getNoPromotionsAndDiscountsMessageText(){
        return driver.findElement(informationAboutDiscountsAndPromotions).getText();
    }

    public DiscountsAndPromotionsPage verifyNoPromotionsAndDiscountsMessage() {

        Assert.assertTrue(getNoPromotionsAndDiscountsMessageText().equals(noDiscountsAndPromotionsText), "" +
                "DiscountsAndPromotionsPageNoPromotions text is incorrect");
        return new DiscountsAndPromotionsPage(driver);
    }

    public DiscountsAndPromotionsPage verifyDiscountsAndPromotionsPageTitle() {
        Assert.assertTrue(driver.getTitle().equals(discountsAndPromotionsPageTitle),
                "DiscountsAndPromotionsPage has an incorrect title or " +
                        "DiscountsAndPromotionsPage not navigated");
        return this;
    }

}



