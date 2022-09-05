import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static pageobject.helpers.WebDriverContainer.getDriver;
import org.testng.asserts.SoftAssert;
import pageobject.htmlelements.*;


public class HTMLETest extends HTMLETestBase{

    @Test
    public void successfulLoginTest() throws Exception {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.attemptLogin("ttttt@mail.ru", "123456");

        Assert.assertTrue(homePage.successMessageIsVisible(), "Login was unsuccessful");

    }

    @Test
    public void unsuccessfulLoginTest() throws Exception {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.attemptLogin("ttttt@mail.ru", "123");

        Assert.assertTrue(loginPage.loginErrorMessageIsVisible(), "Login with incorrect creds");

    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void logoutTest() throws Exception {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.attemptLogin("ttttt@mail.ru", "123456");

        loginPage.clickLogoutButton();

        Assert.assertTrue(loginPage.logoutButtonIsVisible(), "Logout is incorrect");

    }

    @Test
    public void homePageLinkTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickHomeButton();

        Assert.assertTrue(homePage.hasOpened(),
                "homePage has an incorrect title or home page not navigated from header menu");

    }

    @Test
    public void discountsAndPromotionsPageLinkTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickDiscountsAndPromotionsButton();

        DiscountsAndPromotionsPage discountsAndPromotionsPage = new DiscountsAndPromotionsPage(getDriver());

        Assert.assertTrue(discountsAndPromotionsPage.hasOpened(),
                "PromotionsAndDiscountsPage has an incorrect title");

    }

    @Test
    public void discountsAndPromotionsPageInformationVisibilityTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickDiscountsAndPromotionsButton();

        DiscountsAndPromotionsPage discountsAndPromotionsPage = new DiscountsAndPromotionsPage(getDriver());

        Assert.assertTrue(discountsAndPromotionsPage.informationAboutPromotionsAndDiscountsMessageIsVisible(),
                "informationAboutPromotionsAndDiscountsMessage is invisible");

    }

    @Test
    public void discountsAndPromotionsPageNoPromotionsTextTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickDiscountsAndPromotionsButton();

        DiscountsAndPromotionsPage discountsAndPromotionsPage = new DiscountsAndPromotionsPage(getDriver());

        Assert.assertTrue(discountsAndPromotionsPage.verifyNoPromotionsAndDiscountsMessage(),
                "DiscountsAndPromotionsPageNoPromotions text is incorrect");

    }

    @Test
    public void termsAndConditionsPageLinkTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickTermsAndConditionsButton();

        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(getDriver());
        Assert.assertTrue(termsAndConditionsPage.hasOpened(),
                "TermsAndConditionsPage has an incorrect title");

    }

    @Test
    public void termsAndConditionsPageSubtitlesVisibilityTest() throws Exception{

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickTermsAndConditionsButton();

        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(termsAndConditionsPage.subtitleOneIsVisible(), "subtitleOne is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleTwoIsVisible(), "subtitleTwo is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleThreeIsVisible(),"subtitleThree is invisible");
        softAssert.assertAll();

    }

    @Test
    public void termsAndConditionsPageSubtitlesInformationVisibilityTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickTermsAndConditionsButton();

        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(termsAndConditionsPage.subtitleOneInformationIsVisible(), "subtitleOne info" +
                "is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleTwoInformationIsVisible(), "subtitleTwo info" +
                "is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleThreeInformationIsVisible(),"subtitleThree info" +
                "is invisible");
        softAssert.assertAll();

    }

    @Test
    public void termsAndConditionsPageSubtitlesVerifySubtitlesTextTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickTermsAndConditionsButton();

        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(getDriver());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(termsAndConditionsPage.verifySubtitleOneText(), "subtitleOne text " +
                "is incorrect");
        softAssert.assertTrue(termsAndConditionsPage.verifySubtitleTwoText(), "subtitleTwo text " +
                "is incorrect");
        softAssert.assertTrue(termsAndConditionsPage.verifySubtitleThreeText(),"subtitleThree text " +
                "is incorrect");
        softAssert.assertAll();

    }

    @Test
    public void deliveryInformationPageLinkTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickDeliveryInformationButton();

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(getDriver());

        Assert.assertTrue(deliveryInformationPage.hasOpened(),
                "DeliveryInformationPage has an incorrect title");

    }

    @Test
    public void deliveryInformationPageSubtitlesVisibilityTest()  throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickDeliveryInformationButton();

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(deliveryInformationPage.subtitleOneIsVisible(), "subtitleOne is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleTwoIsVisible(), "subtitleTwo is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleThreeIsVisible(),"subtitleThree is invisible");
        softAssert.assertAll();

    }

    @Test
    public void deliveryInformationPageSubtitlesInformationVisibilityTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickDeliveryInformationButton();

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(deliveryInformationPage.subtitleOneInformationIsVisible(), "subtitleOne info " +
                "is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleTwoInformationIsVisible(), "subtitleTwo info" +
                "is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleThreeInformationIsVisible(),"subtitleThree info" +
                "is invisible");
        softAssert.assertAll();

    }

    @Test
    public void deliveryInformationPageVerifySubtitlesTextTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickDeliveryInformationButton();

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(deliveryInformationPage.verifySubtitleOneText(), "subtitle one text " +
                "is incorrect");
        softAssert.assertTrue(deliveryInformationPage.verifySubtitleTwoText(), "subtitle two text " +
                "is incorrect");
        softAssert.assertTrue(deliveryInformationPage.verifySubtitleThreeText(),"subtitle three text " +
                "is incorrect");
        softAssert.assertAll();
    }

    @Test
    public void rubberDucksPageLinkTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickRubberDucksButton();

        RubberDucksPage rubberDucksPage = new RubberDucksPage(getDriver());

        Assert.assertTrue(rubberDucksPage.hasOpened(),
                "RubberDucksPagePage has an incorrect title");
    }

    @Test
    public void rubberDucksPageContainsGoodsTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickRubberDucksButton();

        RubberDucksPage rubberDucksPage = new RubberDucksPage(getDriver());

        Assert.assertTrue(rubberDucksPage.verifyRubberDucksPageContainsGoods(), "RubberDucksPage does not " +
                "goods");

    }

    @Test
    public void SubcategoriesLinkTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickSubcategory();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(getDriver());

        Assert.assertTrue(subcategoriesPage.hasOpened(),
                "SubcategoriesPage has an incorrect title");

    }

    @Test
    public void yellowDuckSaleStickerTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickSubcategory();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(getDriver());

        Assert.assertTrue(subcategoriesPage.verifyYellowDuckSticker(), "Yellow Duck has an incorrect sticker");
    }

    @Test
    public void greenDuckSaleStickerTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickSubcategory();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(getDriver());

        Assert.assertTrue(subcategoriesPage.verifyGreenDuckSticker(), "Green Duck has an incorrect sticker");

    }

    @Test
    public void sortingByNamesTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickSubcategory();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(getDriver());

        subcategoriesPage.clickSortByNamesButton();

        Assert.assertTrue(subcategoriesPage.verifySortingByNames(), "Duck list is not sorted by names!!");

    }

    @Test
    public void sortingByPricesTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.headerMenu.clickSubcategory();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(getDriver());

        subcategoriesPage.clickSortByPriceButton();

        Assert.assertTrue(subcategoriesPage.verifySortingByByPrices(), "Duck list is not sorted by prices!!");

    }

    @Test
    public void changingCurrencyToDollarsTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.regionalSettingsMenu.changeCurrentCurrencyToDollars();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(homePage.regionalSettingsMenu.checkThatCurrentDuckPricesChangedToDollars(),
                "Duck prices are not changed to USD");
        softAssert.assertEquals( homePage.regionalSettingsMenu.getCurrentSiteCurrency(), "USD",
                "Current currency on site menu is not changed to dollars");

        softAssert.assertAll();

    }


    @Test
    public void changingCurrentCountryToBelarusTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.regionalSettingsMenu.changeCurrentCountryToBelarus();

        Assert.assertEquals(homePage.regionalSettingsMenu.getCurrentSiteCountry(), "Belarus",
                "Current country is not changed to Belarus");

    }

    @Test
    public void orderDucksOnRubberDucksPageTest() throws Exception {

        RubberDucksPage rubberDucksPage = new RubberDucksPage(getDriver());

        rubberDucksPage.cart.orderRandomGoods();

        Assert.assertTrue(rubberDucksPage.cart.checkThatGoodsPlacedToCart(), "Goods are not added " +
                "to the cart from RubberDucksPage" );
    }

    @Test
    public void orderDucksOnHomePageTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        homePage.cart.orderRandomGoods();

        Assert.assertTrue(homePage.cart.checkThatGoodsPlacedToCart(), "Goods are not added to the cart " +
                "from HomePage" );
    }

    @Test
    public void informationBoxPageVisibilityTest() throws Exception {

        HomePage homePage = new HomePage(getDriver());

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(getDriver());

        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(getDriver());

        DiscountsAndPromotionsPage discountsAndPromotionsPage = new DiscountsAndPromotionsPage(getDriver());


        SoftAssert softAssert = new SoftAssert();

        homePage.headerMenu.clickDeliveryInformationButton();
        softAssert.assertTrue(deliveryInformationPage.informationBox.informationBoxPageIsVisible(),
                "Information box is invisible on DeliveryInfoPage");

        homePage.headerMenu.clickTermsAndConditionsButton();
        softAssert.assertTrue(termsAndConditionsPage.informationBox.informationBoxPageIsVisible(),
                "Information box is invisible on TermsAndConditionsPage");

        homePage.headerMenu.clickDiscountsAndPromotionsButton();
        softAssert.assertTrue(discountsAndPromotionsPage.informationBox.informationBoxPageIsVisible(),
                "Information box is invisible on DiscountsAndPromotionsPage");

        softAssert.assertAll();

    }



}
