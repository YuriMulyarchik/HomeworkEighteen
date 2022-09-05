import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobject.staticpo.*;
import static pageobject.helpers.WebDriverContainer.*;



public class SPOTest extends SPOTestBase{
    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the login")
    @Story(value = "The test checks the correctness of the login")
    @Test
    public static void successfulLoginTest() {

        LoginPage.attemptLogin(driver,"ttttt@mail.ru", "123456");

        Assert.assertTrue(HomePage.successMessageIsVisible(driver), "Login was unsuccessful");
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking login with incorrect credits")
    @Story(value = "The test checks the login with incorrect credits")
    @Test
    public static void unsuccessfulLoginTest() {

        LoginPage.attemptLogin(driver,"ttttt@mail.ru", "123");

        Assert.assertTrue(LoginPage.loginErrorMessageIsVisible(driver), "login with incorrect creds");
    }
    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the logout")
    @Story(value = "The test checks the correctness of the logout")
    @Test(expectedExceptions = NoSuchElementException.class)
    public void logoutTest() throws Exception {

        LoginPage.attemptLogin(driver,"ttttt@mail.ru", "123456");
        LoginPage.clickLogoutButton(driver);

        Assert.assertTrue(LoginPage.logoutButtonIsVisible(driver), "Logout is incorrect");
    }
    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the logout")
    @Story(value = "The test checks the correctness of the logout")
    @Test
    public void homePageLinkTest() {

        SiteMenuPage.moveToHomePage(driver);

        Assert.assertTrue(HomePage.verifyHomePageTitle(driver),
                "homePage has an incorrect title");
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the move to the discounts and promotions page")
    @Story(value = "The test checks the correctness of the move to the discounts and promotions page")
    @Test
    public void discountsAndPromotionsPageLinkTest() {

        SiteMenuPage.moveToDiscountsAndPromotionsPage(driver);

        Assert.assertTrue(DiscountsAndPromotionsPage.verifyDiscountsAndPromotionsPageTitle(driver),
                "PromotionsAndDiscountsPage has an incorrect title");
    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Checking the visibility of information about  discounts and promotions")
    @Story(value = "The test checks the visibility of information about  discounts and promotions")
    @Test
    public void discountsAndPromotionsPageInformationVisibilityTest() {

        SiteMenuPage.moveToDiscountsAndPromotionsPage(driver);

        Assert.assertTrue(DiscountsAndPromotionsPage.informationAboutPromotionsAndDiscountsMessageIsVisible(driver),
                "informationAboutPromotionsAndDiscountsMessage is invisible");
    }
    @Feature(value = "Elements visibility test")
    @Description(value = "Checking the correctness of the no promotions text")
    @Story(value = "The test checks the correctness of the no promotions text")
    @Test
    public void discountsAndPromotionsPageNoPromotionsTextTest() {


        SiteMenuPage.moveToDiscountsAndPromotionsPage(driver);

        Assert.assertTrue(DiscountsAndPromotionsPage.verifyNoPromotionsAndDiscountsMessage(driver),
                "DiscountsAndPromotionsPageNoPromotions text is incorrect");
    }
    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the move to the terms and conditions page")
    @Story(value = "The test checks the correctness of the move to the terms and conditions page")
    @Test
    public void termsAndConditionsPageLinkTest() {

        SiteMenuPage.moveToTermsAndConditionsPage(driver);

        Assert.assertTrue(TermsAndConditionsPage.verifyTermsAndConditionsPageTitle(driver),
                "TermsAndConditionsPage has an incorrect title");
    }
    @Feature(value = "Elements visibility test")
    @Description(value = "Checking the visibility of subtitles on the terms and conditions page")
    @Story(value = "The test checks the visibility of subtitles on the terms and conditions page")
    @Test
    public void termsAndConditionsPageSubtitlesVisibilityTest() {

        SiteMenuPage.moveToTermsAndConditionsPage(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(TermsAndConditionsPage.subtitleOneIsVisible(driver), "subtitleOne is invisible");
        softAssert.assertTrue(TermsAndConditionsPage.subtitleTwoIsVisible(driver), "subtitleTwo is invisible");
        softAssert.assertTrue(TermsAndConditionsPage.subtitleThreeIsVisible(driver),
                "subtitleThree is invisible");
        softAssert.assertAll();
    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Checking the visibility of subtitles information on the terms and conditions page")
    @Story(value = "The test checks the visibility of subtitles information on the terms and conditions page")
    @Test
    public void termsAndConditionsPageSubtitlesInformationVisibilityTest() {

        SiteMenuPage.moveToTermsAndConditionsPage(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(TermsAndConditionsPage.subtitleOneInformationIsVisible(driver), "subtitleOne " +
                "info is invisible");
        softAssert.assertTrue(TermsAndConditionsPage.subtitleTwoInformationIsVisible(driver), "subtitleTwo " +
                "info is invisible");
        softAssert.assertTrue(TermsAndConditionsPage.subtitleThreeInformationIsVisible(driver),"subtitleThree" +
                " info is invisible");
        softAssert.assertAll();
    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Verifying text of the subtitles  on the terms and conditions page")
    @Story(value = "The test verifies text of the subtitles  on the terms and conditions page")
    @Test
    public void termsAndConditionsPageSubtitlesVerifySubtitlesTextTest() {

        SiteMenuPage.moveToTermsAndConditionsPage(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(TermsAndConditionsPage.verifySubtitleOneText(driver), "subtitleOne text " +
                "is incorrect");
        softAssert.assertTrue(TermsAndConditionsPage.verifySubtitleTwoText(driver), "subtitleTwo text " +
                "is incorrect");
        softAssert.assertTrue(TermsAndConditionsPage.verifySubtitleThreeText(driver),"subtitleThree text " +
                "is incorrect");
        softAssert.assertAll();
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the move to the delivery information page")
    @Story(value = "The test checks the correctness of the move to the delivery information page")
    @Test
    public void deliveryInformationPageLinkTest() {

        SiteMenuPage.moveToDeliveryInfoPage(driver);

        Assert.assertTrue(DeliveryInformationPage.verifyDeliveryInformationPageTitle(driver),
                "DeliveryInformationPage has an incorrect title");
    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Checking the visibility of subtitles on the delivery information page")
    @Story(value = "The test checks the visibility of subtitles on the delivery information page")
    @Test
    public void deliveryInformationPageSubtitlesVisibilityTest() {

        SiteMenuPage.moveToDeliveryInfoPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(DeliveryInformationPage.subtitleOneIsVisible(driver), "subtitleOne is invisible");
        softAssert.assertTrue(DeliveryInformationPage.subtitleTwoIsVisible(driver), "subtitleTwo is invisible");
        softAssert.assertTrue(DeliveryInformationPage.subtitleThreeIsVisible(driver),
                "subtitleThree is invisible");
        softAssert.assertAll();
    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Checking the visibility of subtitles information on the delivery information page")
    @Story(value = "The test checks the visibility of subtitles information on the delivery information page")
    @Test
    public void deliveryInformationPageSubtitlesInformationVisibilityTest() {

        SiteMenuPage.moveToDeliveryInfoPage(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(DeliveryInformationPage.subtitleOneInformationIsVisible(driver), "subtitleOne " +
                "info is invisible");
        softAssert.assertTrue(DeliveryInformationPage.subtitleTwoInformationIsVisible(driver), "subtitleTwo " +
                "info is invisible");
        softAssert.assertTrue(DeliveryInformationPage.subtitleThreeInformationIsVisible(driver),
                "subtitleThree info is invisible");
        softAssert.assertAll();
    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Verifying text of the subtitles  on the delivery information page")
    @Story(value = "The test verifies text of the subtitles  on the delivery information page")
    @Test
    public void deliveryInformationPageVerifySubtitlesTextTest() {

        SiteMenuPage.moveToDeliveryInfoPage(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(DeliveryInformationPage.verifySubtitleOneText(driver), "subtitle one text " +
                "is incorrect");
        softAssert.assertTrue(DeliveryInformationPage.verifySubtitleTwoText(driver), "subtitle two text " +
                "is incorrect");
        softAssert.assertTrue(DeliveryInformationPage.verifySubtitleThreeText(driver),"subtitle three text " +
                "is incorrect");
        softAssert.assertAll();
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the move to the rubber ducks page")
    @Story(value = "The test checks the correctness of the move to the rubber ducks page")
    @Test
    public void rubberDucksPageLinkTest() {

        SiteMenuPage.moveToRubberDucksPage(driver);

        Assert.assertTrue(RubberDucksPage.verifyRubberDucksPageTitle(driver),
                "RubberDucksPage has an incorrect title");
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking that the rubberDucks page contains products")
    @Story(value = "The test checks that the rubberDucks page contains products")
    @Test
    public void rubberDucksPageContainsGoodsTest() {

        SiteMenuPage.moveToRubberDucksPage(driver);

        Assert.assertTrue(RubberDucksPage.verifyRubberDucksPageContainsGoods(driver), "RubberDucksPage " +
                "does not goods");
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the move to the subcategories")
    @Story(value = "The test checks the correctness of the move to the subcategories")
    @Test
    public void SubcategoriesLinkTest() {

        SiteMenuPage.moveToSubcategoryPage(driver);

        Assert.assertTrue(SubcategoriesPage.verifySubcategoriesPageTitle(driver),
                "SubcategoriesPage has an incorrect title");
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the yellow duck sticker")
    @Story(value = "The test checks the correctness of the yellow duck sticker")
    @Test
    public void yellowDuckSaleStickerTest() {

        SiteMenuPage.moveToSubcategoryPage(driver);

        Assert.assertTrue(SubcategoriesPage.verifyYellowDuckSticker(driver),
                "Yellow Duck has an incorrect sticker");
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the green duck sticker")
    @Story(value = "The test checks the correctness of the green duck sticker")
    @Test
    public void greenDuckSaleStickerTest() {

        SiteMenuPage.moveToSubcategoryPage(driver);

        Assert.assertTrue(SubcategoriesPage.verifyGreenDuckSticker(driver),
                "Green Duck has an incorrect sticker");
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking sorting by names")
    @Story(value = "The test checks sorting by names")
    @Test
    public void sortingByNamesTest() {

        SiteMenuPage.moveToSubcategoryPage(driver);

        SubcategoriesPage.clickSortByNamesButton(driver);

        Assert.assertTrue(SubcategoriesPage.sortByNames(driver), "Duck list is not sorted by names!!");
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking sorting by prices")
    @Story(value = "The test checks sorting by prices")
    @Test
    public void sortingByPricesTest() {

        SiteMenuPage.moveToSubcategoryPage(driver);

        SubcategoriesPage.clickSortByPriceButton(driver);

        Assert.assertTrue(SubcategoriesPage.sortByPrices(driver), "Duck list is not sorted by prices!!");
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking changing site current currency to USD")
    @Story(value = "The test checks changing site current currency to USD")
    @Test
    public void changingCurrencyToDollarsTest() {

        SiteMenuPage.changeCurrentCurrencyToDollars(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(SiteMenuPage.checkThatCurrentDuckPricesChangedToDollars(driver),
                "Current prices of ducks is not changed to dollars");
        softAssert.assertEquals(SiteMenuPage.getCurrentSiteCurrency(driver), "USD",
                "Current currency on site menu is not changed to dollars");

        softAssert.assertAll();
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking if the current site country has changed")
    @Story(value = "The test checks the changing of current site country")
    @Test
    public void changingCurrentCountryToBelarusTest() {

        SiteMenuPage.changeCurrentCountryToBelarus(driver);

        Assert.assertEquals(SiteMenuPage.getCurrentSiteCountry(driver), "Belarus", "Current country " +
                "is not changed to Belarus");
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking goods ordering from rubber ducks page")
    @Story(value = "The test checks goods ordering from rubber ducks page")
    @Test
    public void orderDucksOnRubberDucksPageTest() {
        SiteMenuPage.moveToRubberDucksPage(driver);

        CartPage.orderRandomGoods(driver);

        Assert.assertTrue(CartPage.checkThatGoodsPlacedToCart(driver), "Goods are not added to the cart " +
                "from RubberDucksPage" );
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking goods ordering from home page")
    @Story(value = "The test checks goods ordering from home page")
    @Test
    public void orderDucksOnHomePageTest() {

        SiteMenuPage.moveToHomePage(driver);

        CartPage.orderRandomGoods(driver);

        Assert.assertTrue(CartPage.checkThatGoodsPlacedToCart(driver), "Goods are not added to the cart " +
                "from HomePage" );
    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Checking information box visibility")
    @Story(value = "The test checks information box visibility")
    @Test
    public void informationBoxPageVisibilityTest() {

        SoftAssert softAssert = new SoftAssert();

        SiteMenuPage.moveToDeliveryInfoPage(driver);
        softAssert.assertTrue(InformationBoxPage.informationBoxPageIsVisible(driver), "Information box is " +
                "invisible on DeliveryInfoPage");

        SiteMenuPage.moveToTermsAndConditionsPage(driver);
        softAssert.assertTrue(InformationBoxPage.informationBoxPageIsVisible(driver),"Information box is " +
                "invisible on TermsAndConditionsPage");

        SiteMenuPage.moveToDiscountsAndPromotionsPage(driver);
        softAssert.assertTrue(InformationBoxPage.informationBoxPageIsVisible(driver), "Information box is" +
                "invisible on DiscountsAndPromotionsPage");

        softAssert.assertAll();
    }

}
