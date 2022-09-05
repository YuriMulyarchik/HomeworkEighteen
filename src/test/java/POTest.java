import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobject.object.*;




public class POTest extends POTestBase {

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the login")
    @Story(value = "The test checks the correctness of the login")
    @Test
    public void successfulLoginTest() throws Exception {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.attemptLogin("ttttt@mail.ru", "1234568");

        Assert.assertTrue(homePage.successMessageIsVisible(), "Login was unsuccessful");

    }

    @Feature(value = "Functional test")
    @Description(value = "Checking login with incorrect credits")
    @Story(value = "The test checks the login with incorrect credits")
    @Test
    public void unsuccessfulLoginTest() throws Exception {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.attemptLogin("ttttt@mail.ru", "123");

        Assert.assertTrue(loginPage.loginErrorMessageIsVisible(), "Login with incorrect creds");

    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the logout")
    @Story(value = "The test checks the correctness of the logout")
    @Test(expectedExceptions = NoSuchElementException.class)
    public void logoutTest() throws Exception {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.attemptLogin("ttttt@mail.ru", "123456");

        loginPage.clickLogoutButton();

        Assert.assertTrue(loginPage.logoutButtonIsVisible(), "Logout is incorrect");

    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the logout")
    @Story(value = "The test checks the correctness of the logout")
    @Test
    public void homePageLinkTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToHomePage();

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.hasOpened(),
                "homePage has an incorrect title");

    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the move to the discounts and promotions page")
    @Story(value = "The test checks the correctness of the move to the discounts and promotions page")
    @Test
    public void discountsAndPromotionsPageLinkTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToDiscountsAndPromotionsPage();

        DiscountsAndPromotionsPage discountsAndPromotionsPage = new DiscountsAndPromotionsPage(driver);

        Assert.assertTrue(discountsAndPromotionsPage.hasOpened(),
                "PromotionsAndDiscountsPage has an incorrect title");

    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Checking the visibility of information about  discounts and promotions")
    @Story(value = "The test checks the visibility of information about  discounts and promotions")
    @Test
    public void discountsAndPromotionsPageInformationVisibilityTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToDiscountsAndPromotionsPage();

        DiscountsAndPromotionsPage discountsAndPromotionsPage = new DiscountsAndPromotionsPage(driver);

        Assert.assertTrue(discountsAndPromotionsPage.informationAboutPromotionsAndDiscountsMessageIsVisible(),
                "informationAboutPromotionsAndDiscountsMessage is invisible");

    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Checking the correctness of the no promotions text")
    @Story(value = "The test checks the correctness of the no promotions text")
    @Test
    public void discountsAndPromotionsPageNoPromotionsTextTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToDiscountsAndPromotionsPage();

        DiscountsAndPromotionsPage discountsAndPromotionsPage = new DiscountsAndPromotionsPage(driver);

        Assert.assertTrue(discountsAndPromotionsPage.verifyNoPromotionsAndDiscountsMessage(),
                "DiscountsAndPromotionsPageNoPromotions text is incorrect");

    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the move to the terms and conditions page")
    @Story(value = "The test checks the correctness of the move to the terms and conditions page")
    @Test
    public void termsAndConditionsPageLinkTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToTermsAndConditionsPage();


        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(driver);
        Assert.assertTrue(termsAndConditionsPage.hasOpened(),
                "TermsAndConditionsPage has an incorrect title");

    }
    @Feature(value = "Elements visibility test")
    @Description(value = "Checking the visibility of subtitles on the terms and conditions page")
    @Story(value = "The test checks the visibility of subtitles on the terms and conditions page")
    @Test
    public void termsAndConditionsPageSubtitlesVisibilityTest() throws Exception{

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToTermsAndConditionsPage();

        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(termsAndConditionsPage.subtitleOneIsVisible(), "subtitleOne is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleTwoIsVisible(), "subtitleTwo is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleThreeIsVisible(),"subtitleThree is invisible");
        softAssert.assertAll();

    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Checking the visibility of subtitles information on the terms and conditions page")
    @Story(value = "The test checks the visibility of subtitles information on the terms and conditions page")
    @Test
    public void termsAndConditionsPageSubtitlesInformationVisibilityTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToTermsAndConditionsPage();

        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(termsAndConditionsPage.subtitleOneInformationIsVisible(), "subtitleOne info" +
                "is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleTwoInformationIsVisible(), "subtitleTwo info" +
                "is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleThreeInformationIsVisible(),"subtitleThree info" +
                "is invisible");
        softAssert.assertAll();

    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Verifying text of the subtitles  on the terms and conditions page")
    @Story(value = "The test verifies text of the subtitles  on the terms and conditions page")
    @Test
    public void termsAndConditionsPageSubtitlesVerifySubtitlesTextTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToTermsAndConditionsPage();

        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(termsAndConditionsPage.verifySubtitleOneText(), "subtitleOne text " +
                "is incorrect");
        softAssert.assertTrue(termsAndConditionsPage.verifySubtitleTwoText(), "subtitleTwo text " +
                "is incorrect");
        softAssert.assertTrue(termsAndConditionsPage.verifySubtitleThreeText(),"subtitleThree text " +
                "is incorrect");
        softAssert.assertAll();

    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the move to the delivery information page")
    @Story(value = "The test checks the correctness of the move to the delivery information page")
    @Test
    public void deliveryInformationPageLinkTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToDeliveryInfoPage();

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(driver);

        Assert.assertTrue(deliveryInformationPage.hasOpened(),
                "DeliveryInformationPage has an incorrect title");

    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Checking the visibility of subtitles on the delivery information page")
    @Story(value = "The test checks the visibility of subtitles on the delivery information page")
    @Test
    public void deliveryInformationPageSubtitlesVisibilityTest()  throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToDeliveryInfoPage();

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(deliveryInformationPage.subtitleOneIsVisible(), "subtitleOne is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleTwoIsVisible(), "subtitleTwo is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleThreeIsVisible(),"subtitleThree is invisible");
        softAssert.assertAll();

    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Checking the visibility of subtitles information on the delivery information page")
    @Story(value = "The test checks the visibility of subtitles information on the delivery information page")
    @Test
    public void deliveryInformationPageSubtitlesInformationVisibilityTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToDeliveryInfoPage();

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(deliveryInformationPage.subtitleOneInformationIsVisible(), "subtitleOne info " +
                "is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleTwoInformationIsVisible(), "subtitleTwo info" +
                "is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleThreeInformationIsVisible(),"subtitleThree info" +
                "is invisible");
        softAssert.assertAll();

    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Verifying text of the subtitles  on the delivery information page")
    @Story(value = "The test verifies text of the subtitles  on the delivery information page")
    @Test
    public void deliveryInformationPageVerifySubtitlesTextTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToDeliveryInfoPage();

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(deliveryInformationPage.verifySubtitleOneText(), "subtitle one text " +
                "is incorrect");
        softAssert.assertTrue(deliveryInformationPage.verifySubtitleTwoText(), "subtitle two text " +
                "is incorrect");
        softAssert.assertTrue(deliveryInformationPage.verifySubtitleThreeText(),"subtitle three text " +
                "is incorrect");
        softAssert.assertAll();
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the move to the rubber ducks page")
    @Story(value = "The test checks the correctness of the move to the rubber ducks page")
    @Test
    public void rubberDucksPageLinkTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToRubberDucksPage();

        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);

        Assert.assertTrue(rubberDucksPage.hasOpened(),
                "RubberDucksPagePage has an incorrect title");
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking that the rubberDucks page contains products")
    @Story(value = "The test checks that the rubberDucks page contains products")
    @Test
    public void rubberDucksPageContainsGoodsTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToRubberDucksPage();
        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);
        Assert.assertTrue(rubberDucksPage.verifyRubberDucksPageContainsGoods(), "RubberDucksPage does not " +
                "goods");

    }


    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the move to the subcategories")
    @Story(value = "The test checks the correctness of the move to the subcategories")
    @Test
    public void SubcategoriesLinkTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToSubcategoryPage();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(driver);

        Assert.assertTrue(subcategoriesPage.hasOpened(),
                "SubcategoriesPage has an incorrect title");

    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the yellow duck sticker")
    @Story(value = "The test checks the correctness of the yellow duck sticker")
    @Test
    public void yellowDuckSaleStickerTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToSubcategoryPage();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(driver);

        Assert.assertTrue(subcategoriesPage.verifyYellowDuckSticker(), "Yellow Duck has an incorrect sticker");
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking the correctness of the green duck sticker")
    @Story(value = "The test checks the correctness of the green duck sticker")
    @Test
    public void greenDuckSaleStickerTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToSubcategoryPage();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(driver);

        Assert.assertTrue(subcategoriesPage.verifyGreenDuckSticker(), "Green Duck has an incorrect sticker");

    }

    @Feature(value = "Functional test")
    @Description(value = "Checking sorting by names")
    @Story(value = "The test checks sorting by names")
    @Test
    public void sortingByNamesTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToSubcategoryPage();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(driver);

        subcategoriesPage.clickSortByNamesButton();
        Assert.assertTrue(subcategoriesPage.verifySortingByNames(), "Duck list is not sorted by names!!");

    }

    @Feature(value = "Functional test")
    @Description(value = "Checking sorting by prices")
    @Story(value = "The test checks sorting by prices")
    @Test
    public void sortingByPricesTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage.moveToSubcategoryPage();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(driver);
        subcategoriesPage.clickSortByPriceButton();

        Assert.assertTrue(subcategoriesPage.verifySortingByPrices(), "Duck list is not sorted by prices!!");

    }

    @Feature(value = "Functional test")
    @Description(value = "Checking changing site current currency to USD")
    @Story(value = "The test checks changing site current currency to USD")
    @Test
    public void changingCurrencyToDollarsTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);
        siteMenuPage.changeCurrentCurrencyToDollars();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(siteMenuPage.checkThatCurrentDuckPricesChangedToDollars(), "Duck prices are not" +
                "changed to USD");
        softAssert.assertEquals(siteMenuPage.getCurrentSiteCurrency(), "USD",
                "Current currency on site menu is not changed to dollars");

        softAssert.assertAll();

    }

    @Feature(value = "Functional test")
    @Description(value = "Checking if the current site country has changed")
    @Story(value = "The test checks the changing of current site country")
    @Test
    public void changingCurrentCountryToBelarusTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);
        siteMenuPage.changeCurrentCountryToBelarus();

        Assert.assertEquals(siteMenuPage.getCurrentSiteCountry(), "Belarus", "Current country is not" +
                "changed to Belarus");

    }


    @Feature(value = "Functional test")
    @Description(value = "Checking goods ordering from rubber ducks page")
    @Story(value = "The test checks goods ordering from rubber ducks page")
    @Test
    public void orderDucksOnRubberDucksPageTest() throws Exception {
        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);
        siteMenuPage.moveToRubberDucksPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.orderRandomGoods();

        Assert.assertTrue(cartPage.checkThatGoodsPlacedToCart(), "Goods are not added to the cart " +
                "from RubberDucksPage" );
    }

    @Feature(value = "Functional test")
    @Description(value = "Checking goods ordering from home page")
    @Story(value = "The test checks goods ordering from home page")
    @Test
    public void orderDucksOnHomePageTest() throws Exception {
        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);
        siteMenuPage.moveToHomePage();
        CartPage cartPage = new CartPage(driver);
        cartPage.orderRandomGoods();

        Assert.assertTrue(cartPage.checkThatGoodsPlacedToCart(), "Goods are not added to the cart " +
                "from HomePage" );
    }

    @Feature(value = "Elements visibility test")
    @Description(value = "Checking information box visibility")
    @Story(value = "The test checks information box visibility")
    @Test
    public void informationBoxPageVisibilityTest() throws Exception {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        InformationBoxPage informationBoxPage = new InformationBoxPage(driver);

        SoftAssert softAssert = new SoftAssert();

        siteMenuPage.moveToDeliveryInfoPage();
        softAssert.assertTrue(informationBoxPage.informationBoxPageIsVisible(), "Information box is " +
                "invisible on DeliveryInfoPage");

        siteMenuPage.moveToTermsAndConditionsPage();
        softAssert.assertTrue(informationBoxPage.informationBoxPageIsVisible(),"Information box is " +
                "invisible on TermsAndConditionsPage");

        siteMenuPage.moveToDiscountsAndPromotionsPage();
        softAssert.assertTrue(informationBoxPage.informationBoxPageIsVisible(), "Information box is" +
                "invisible on DiscountsAndPromotionsPage");

        softAssert.assertAll();

    }

}
