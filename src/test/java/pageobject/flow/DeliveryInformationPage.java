package pageobject.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DeliveryInformationPage {

    private String deliveryInformationPageTitle="Delivery Information | My Store1";

    private String subtitleOneText = "информация о доставке";

    private String subtitleTwoText = "Подзаголовок 2";

    private String subtitleThreeText = "Подзаголовок 3";

    private By subtitleOne = By.cssSelector("div.content > h1");

    private By subtitleOneInformation = By.cssSelector("p:nth-child(2) > font");
    private By subtitleTwo = By.cssSelector("div.content > h2");

    private By subtitleTwoInformation = By.cssSelector("p:nth-child(4) > font");

    private By subtitleThree = By.cssSelector("div.content > h3");

    private By subtitleThreeInformation = By.cssSelector("p:nth-child(6) > font");

    private WebDriver driver;


    public DeliveryInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public DeliveryInformationPage assertThatSubtitlesAreVisible() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(subtitleOne).isDisplayed(), "SubtitleOne is invisible");
        softAssert.assertTrue(driver.findElement(subtitleTwo).isDisplayed(), "SubtitleTwo is invisible");
        softAssert.assertTrue(driver.findElement(subtitleTwo).isDisplayed(), "SubtitleTwo is invisible");
        softAssert.assertAll();
        return this;
    }

    public DeliveryInformationPage assertThatSubtitlesInformationIsVisible() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(subtitleOneInformation).isDisplayed(), "subtitleOne info" +
                "is invisible");
        softAssert.assertTrue(driver.findElement(subtitleTwoInformation).isDisplayed(), "subtitleTwo info" +
                "is invisible");
        softAssert.assertTrue(driver.findElement(subtitleThreeInformation).isDisplayed(), "subtitleThree info" +
                "is invisible");
        softAssert.assertAll();
        return this;
    }
    public DeliveryInformationPage verifySubtitlesText() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getSubtitleOneText(),subtitleOneText, "subtitleOne text " +
                "is incorrect");
        softAssert.assertEquals(getSubtitleTwoText(),subtitleTwoText, "subtitleTwo text " +
                "is incorrect");
        softAssert.assertEquals(getSubtitleThreeText(),subtitleThreeText, "subtitleThree text " +
                "is incorrect");
        softAssert.assertAll();
        return this;
    }
    public String getSubtitleOneText(){
        return driver.findElement(subtitleOne).getText();
    }
    public String getSubtitleTwoText(){
        return driver.findElement(subtitleTwo).getText();
    }
    public String getSubtitleThreeText(){
        return driver.findElement(subtitleThree).getText();
    }

    public DeliveryInformationPage verifyDeliveryInformationPageTitle() {
        Assert.assertTrue(driver.getTitle().equals(deliveryInformationPageTitle), "DeliveryInformationPage " +
                "has an incorrect title or DeliveryInformationPage not navigated");
        return this;
    }
}
