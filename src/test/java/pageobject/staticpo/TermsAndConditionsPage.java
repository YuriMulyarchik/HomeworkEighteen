package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsAndConditionsPage {
    private static String termsAndConditionsPageTitle="Terms & Conditions | My Store1";
    private static String subtitleOneText = "Условия";
    private static String subtitleTwoText = "Подзаголовок 2";
    private static String subtitleThreeText = "Подзаголовок 3";
    private static By subtitleOneLink = By.cssSelector("div.content > h1");

    private static By subtitleOneInformation = By.cssSelector("p:nth-child(2) > font");
    private static By subtitleTwoLink = By.cssSelector("div.content > h2");

    private static By subtitleTwoInformation = By.cssSelector("p:nth-child(4) > font");

    private static By subtitleThreeLink = By.cssSelector("div.content > h3");

    private static By subtitleThreeInformation = By.cssSelector("p:nth-child(6) > font");


    public static boolean subtitleOneIsVisible(WebDriver driver) {
        return driver.findElement(subtitleOneLink).isDisplayed();
    }

    public static boolean subtitleTwoIsVisible(WebDriver driver) {
        return driver.findElement(subtitleTwoLink).isDisplayed();
    }

    public static boolean subtitleThreeIsVisible(WebDriver driver) {
        return  driver.findElement(subtitleThreeLink).isDisplayed();
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
        return driver.findElement(subtitleOneLink).getText();
    }

    public static boolean verifySubtitleOneText(WebDriver driver) {
        return getSubtitleOneText(driver).equals(subtitleOneText);
    }

    public static String getSubtitleTwoText(WebDriver driver){
        return driver.findElement(subtitleTwoLink).getText();
    }

    public static boolean verifySubtitleTwoText(WebDriver driver) {
        return getSubtitleTwoText(driver).equals(subtitleTwoText);
    }

    public static String getSubtitleThreeText(WebDriver driver){
        return driver.findElement(subtitleThreeLink).getText();
    }

    public static boolean verifySubtitleThreeText(WebDriver driver) {
        return getSubtitleThreeText(driver).equals(subtitleThreeText);
    }
    public static boolean verifyTermsAndConditionsPageTitle(WebDriver driver) {
        return driver.getTitle().equals(termsAndConditionsPageTitle);
    }
}
