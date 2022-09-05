import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobject.pagefactory.*;


public class PFTest extends PFTestBase{
    @Test
    public void successfulLoginTest() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        loginPage.attemptLogin("ttttt@mail.ru", "123456");

        Assert.assertTrue(homePage.successMessageIsVisible(), "Login was unsuccessful");

    }

    @Test
    public void unsuccessfulLoginTest() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.attemptLogin("ttttt@mail.ru", "123");

        Assert.assertTrue(loginPage.loginErrorMessageIsVisible(), "loginErrorMessage is invisible");

    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void logoutTest() throws Exception {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.attemptLogin("ttttt@mail.ru", "123456");
        loginPage.clickLogoutButton();

        Assert.assertTrue(loginPage.logoutButtonIsVisible(), "Logout is incorrect");

    }

    @Test
    public void homePageLinkTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToHomePage();

        Assert.assertEquals(driver.getTitle(), "Online Store | My Store1",
                "homePage has an incorrect title");

    }

    @Test
    public void discountsAndPromotionsPageLinkTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToDiscountsAndPromotionsPage();

        Assert.assertEquals(driver.getTitle(), "4 | My Store1",
                "PromotionsAndDiscountsPage has an incorrect title");
    }

    @Test
    public void discountsAndPromotionsPageInformationVisibilityTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToDiscountsAndPromotionsPage();

        DiscountsAndPromotionsPage discountsAndPromotionsPage = PageFactory.initElements(driver,
                DiscountsAndPromotionsPage.class);

        Assert.assertTrue(discountsAndPromotionsPage.informationAboutPromotionsAndDiscountsMessageIsVisible(),
                "informationAboutPromotionsAndDiscountsMessage is invisible");
    }

    @Test
    public void discountsAndPromotionsPageNoPromotionsTextTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToDiscountsAndPromotionsPage();

        DiscountsAndPromotionsPage discountsAndPromotionsPage = PageFactory.initElements(driver,
                DiscountsAndPromotionsPage.class);

        Assert.assertTrue(discountsAndPromotionsPage.verifyNoPromotionsAndDiscountsMessage(),
                "DiscountsAndPromotionsPageNoPromotions text is incorrect");

    }

    @Test
    public void termsAndConditionsPageLinkTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToTermsAndConditionsPage();

        Assert.assertEquals(driver.getTitle(), "Terms & Conditions | My Store1",
                "TermsAndConditionsPage has an incorrect title");

    }

    @Test
    public void termsAndConditionsPageSubtitlesVisibilityTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToTermsAndConditionsPage();

        TermsAndConditionsPage termsAndConditionsPage = PageFactory.initElements(driver, TermsAndConditionsPage.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(termsAndConditionsPage.subtitleOneIsVisible(), "subtitleOne is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleTwoIsVisible(), "subtitleTwo is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleThreeIsVisible(),"subtitleThree is invisible");
        softAssert.assertAll();

    }

    @Test
    public void termsAndConditionsPageSubtitlesInformationVisibilityTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToTermsAndConditionsPage();

        TermsAndConditionsPage termsAndConditionsPage = PageFactory.initElements(driver, TermsAndConditionsPage.class);
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
    public void termsAndConditionsPageSubtitlesVerifySubtitlesTextTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToTermsAndConditionsPage();

        TermsAndConditionsPage termsAndConditionsPage = PageFactory.initElements(driver, TermsAndConditionsPage.class);

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
    public void deliveryInformationPageLinkTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToDeliveryInfoPage();

        Assert.assertEquals(driver.getTitle(), "Delivery Information | My Store1",
                "DeliveryInformationPage has an incorrect title");
    }

    @Test
    public void deliveryInformationPageSubtitlesVisibilityTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToDeliveryInfoPage();

        DeliveryInformationPage deliveryInformationPage = PageFactory.initElements(driver,
                DeliveryInformationPage.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(deliveryInformationPage.subtitleOneIsVisible(), "subtitleOne is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleTwoIsVisible(), "subtitleTwo is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleThreeIsVisible(),"subtitleThree is invisible");
        softAssert.assertAll();
    }

    @Test
    public void deliveryInformationPageSubtitlesInformationVisibilityTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToDeliveryInfoPage();

        DeliveryInformationPage deliveryInformationPage = PageFactory.initElements(driver,
                DeliveryInformationPage.class);
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
    public void deliveryInformationPageVerifySubtitlesTextTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToDeliveryInfoPage();

        DeliveryInformationPage deliveryInformationPage = PageFactory.initElements(driver,
                DeliveryInformationPage.class);
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
    public void rubberDucksPageLinkTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToRubberDucksPage();

        Assert.assertEquals(driver.getTitle(), "Rubber Ducks | My Store1",
                "RubberDucksPage has an incorrect title");
    }

    @Test
    public void rubberDucksPageContainsGoodsTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        siteMenuPage.moveToRubberDucksPage();

        RubberDucksPage rubberDucksPage = PageFactory.initElements(driver, RubberDucksPage.class);

        Assert.assertTrue(rubberDucksPage.verifyRubberDucksPageContainsGoods(), "RubberDucksPage does not " +
                "goods");
    }

    @Test
    public void SubcategoriesLinkTest() {

        moveToSubcategoryPage();

        Assert.assertEquals(driver.getTitle(), "Subcategory | My Store1",
                "SubcategoriesPage has an incorrect title");
    }

    @Test
    public void yellowDuckSaleStickerTest() {

        moveToSubcategoryPage();

        SubcategoriesPage subcategoriesPage = PageFactory.initElements(driver, SubcategoriesPage.class);

        Assert.assertTrue(subcategoriesPage.verifyYellowDuckSticker(), "Yellow Duck has an incorrect sticker");
    }

    @Test
    public void greenDuckSaleStickerTest() {

        moveToSubcategoryPage();

        SubcategoriesPage subcategoriesPage = PageFactory.initElements(driver, SubcategoriesPage.class);

        Assert.assertTrue(subcategoriesPage.verifyGreenDuckSticker(), "Green Duck has an incorrect sticker");
    }

    @Test
    public void sortingByNamesTest() {

        moveToSubcategoryPage();

        SubcategoriesPage subcategoriesPage = PageFactory.initElements(driver, SubcategoriesPage.class);

        subcategoriesPage.clickSortByNamesButton();
        Assert.assertTrue(subcategoriesPage.verifySortingByNames(), "Duck list is not sorted by names!!");

    }


    @Test
    public void sortingByPricesTest() {

        moveToSubcategoryPage();

        SubcategoriesPage subcategoriesPage = PageFactory.initElements(driver, SubcategoriesPage.class);

        subcategoriesPage.clickSortByPriceButton();

        Assert.assertTrue(subcategoriesPage.verifySortingByPrices(), "Duck list is not sorted by prices!!");

    }

    @Test
    public void changingCurrencyToDollarsTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        SoftAssert softAssert = new SoftAssert();

        changeCurrentCurrencyToDollars();
        softAssert.assertTrue(checkThatCurrentDuckPricesChangedToDollars(), "Current prices of ducks is not" +
                "changed to dollars");
        softAssert.assertEquals(siteMenuPage.getCurrentSiteCurrency(), "USD",
                "Current currency on site menu is not changed to dollars");

        softAssert.assertAll();
    }

    @Test
    public void changingCurrentCountryToBelarusTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        changeCurrentCountryToBelarus();

        Assert.assertEquals(siteMenuPage.getCurrentSiteCountry(), "Belarus", "Current country is not" +
                "changed to Belarus");

    }

    @Test
    public void orderDucksOnRubberDucksPageTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);
        siteMenuPage.moveToRubberDucksPage();

        orderRandomGoods();

        Assert.assertTrue(checkThatGoodsPlacedToCart(), "Goods are not added to the cart " +
                "from RubberDucksPage" );
    }

    @Test
    public void orderDucksOnHomePageTest() {
        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);
        siteMenuPage.moveToHomePage();

        orderRandomGoods();

        Assert.assertTrue(checkThatGoodsPlacedToCart(), "Goods are not added to the cart " +
                "from HomePage" );
    }

    @Test
    public void informationBoxPageVisibilityTest() {

        SiteMenuPage siteMenuPage = PageFactory.initElements(driver, SiteMenuPage.class);

        InformationBoxPage informationBoxPage = PageFactory.initElements(driver, InformationBoxPage.class);

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
