package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeliveryInformationPage {

    private static String deliveryInformationPageTitle="Delivery Information | My Store1";

    private static String subtitleOneText = "информация о доставке";

    private static String subtitleTwoText = "Подзаголовок 2";

    private static String subtitleThreeText = "Подзаголовок 3";

    private static By subtitleOne = By.cssSelector("div.content > h1");

    private static By subtitleOneInformation = By.cssSelector("p:nth-child(2) > font");
    private static By subtitleTwo = By.cssSelector("div.content > h2");

    private static By subtitleTwoInformation = By.cssSelector("p:nth-child(4) > font");

    private static By subtitleThree = By.cssSelector("div.content > h3");

    private static By subtitleThreeInformation = By.cssSelector("p:nth-child(6) > font");

    public static boolean subtitleOneIsVisible(WebDriver driver) {
        return driver.findElement(subtitleOne).isDisplayed();
    }
    public static boolean subtitleTwoIsVisible(WebDriver driver) {
        return driver.findElement(subtitleTwo).isDisplayed();
    }
    public static boolean subtitleThreeIsVisible(WebDriver driver) {
        return driver.findElement(subtitleThree).isDisplayed();
    }

    public static boolean subtitleOneInformationIsVisible(WebDriver driver) {
        return driver.findElement(subtitleOneInformation).isDisplayed();
    }
    public static boolean subtitleTwoInformationIsVisible(WebDriver driver) {
        return driver.findElement(subtitleTwoInformation).isDisplayed();
    }
    public static boolean subtitleThreeInformationIsVisible(WebDriver driver) {
        return driver.findElement(subtitleThreeInformation).isDisplayed();
    }

    public static String getSubtitleOneText(WebDriver driver){
        return driver.findElement(subtitleOne).getText();
    }

    public static boolean verifySubtitleOneText(WebDriver driver) {
        return getSubtitleOneText(driver).contains(subtitleOneText);
    }

    public static String getSubtitleTwoText(WebDriver driver){
        return driver.findElement(subtitleTwo).getText();
    }

    public static boolean verifySubtitleTwoText(WebDriver driver) {
        return getSubtitleTwoText(driver).contains(subtitleTwoText);
    }

    public static String getSubtitleThreeText(WebDriver driver){
        return driver.findElement(subtitleThree).getText();
    }

    public static boolean verifySubtitleThreeText(WebDriver driver) {
        return getSubtitleThreeText(driver).equalsIgnoreCase(subtitleThreeText);
    }

    public static boolean verifyDeliveryInformationPageTitle(WebDriver driver) {
        return driver.getTitle().equals(deliveryInformationPageTitle);
    }
}
