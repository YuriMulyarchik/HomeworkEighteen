package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiscountsAndPromotionsPage {

    private static String discountsAndPromotionsPageTitle="4 | My Store1";

    private static String noDiscountsAndPromotionsText = "Скидок пока нет.\n" +
            "Следите за рассылкой по электронной почте";

    private static By informationAboutDiscountsAndPromotions = By.cssSelector("div.middle > div.content");


    public static boolean informationAboutPromotionsAndDiscountsMessageIsVisible(WebDriver driver) {
        return driver.findElement(informationAboutDiscountsAndPromotions).isDisplayed();
    }

    public static String getNoPromotionsAndDiscountsMessageText(WebDriver driver){
        return driver.findElement(informationAboutDiscountsAndPromotions).getText();
    }

    public static boolean verifyNoPromotionsAndDiscountsMessage(WebDriver driver) {

        return getNoPromotionsAndDiscountsMessageText(driver).equals(noDiscountsAndPromotionsText);
    }

       public static boolean verifyDiscountsAndPromotionsPageTitle(WebDriver driver) {
        return driver.getTitle().equals(discountsAndPromotionsPageTitle);
    }

}



