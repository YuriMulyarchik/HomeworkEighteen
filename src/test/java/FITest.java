
import org.openqa.selenium.NoSuchElementException;


import org.testng.annotations.Test;

import pageobject.flow.*;



public class FITest extends FITestBase{

    @Test
    public void successfulLoginTest() {

        LoginPage loginPage = new LoginPage(driver);


        loginPage
                .loginWithCorrectCreds()
                .assertThatSuccessMessageIsVisible();

    }

    @Test
    public void unsuccessfulLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .loginWithIncorrectCreds()
                .assertThatLoginErrorMessageIsVisible();

    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void logoutTest() throws Exception {

       LoginPage loginPage = new LoginPage(driver);

        loginPage
                .loginWithCorrectCreds()
                .clickLogoutButton()
                .assertThatLogoutButtonIsInvisible();

    }

    @Test
    public void homePageLinkTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToHomePage()
                .verifyHomePageTitle();

    }

    @Test
    public void discountsAndPromotionsPageLinkTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToDiscountsAndPromotionsPage()
                .verifyDiscountsAndPromotionsPageTitle();

    }

    @Test
    public void discountsAndPromotionsPageInformationVisibilityTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToDiscountsAndPromotionsPage()
                .informationAboutPromotionsAndDiscountsMessageIsVisible();

    }

    @Test
    public void discountsAndPromotionsPageNoPromotionsTextTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToDiscountsAndPromotionsPage()
                .verifyNoPromotionsAndDiscountsMessage();

    }

    @Test
    public void termsAndConditionsPageLinkTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToTermsAndConditionsPage()
                .verifyTermsAndConditionsPageTitle();

    }

    @Test
    public void termsAndConditionsPageSubtitlesVisibilityTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToTermsAndConditionsPage()
                .assertThatSubtitlesAreVisible();

    }

    @Test
    public void termsAndConditionsPageSubtitlesInformationVisibilityTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToTermsAndConditionsPage()
                .assertThatSubtitlesInformationIsVisible();

    }

    @Test
    public void termsAndConditionsPageSubtitlesVerifySubtitlesTextTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToTermsAndConditionsPage()
                .verifySubtitlesText();

    }

    @Test
    public void deliveryInformationPageLinkTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToDeliveryInfoPage()
                .verifyDeliveryInformationPageTitle();

    }

    @Test
    public void deliveryInformationPageSubtitlesVisibilityTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToDeliveryInfoPage()
                .assertThatSubtitlesAreVisible();

    }

    @Test
    public void deliveryInformationPageSubtitlesInformationVisibilityTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToDeliveryInfoPage()
                .assertThatSubtitlesInformationIsVisible();

    }

    @Test
    public void deliveryInformationPageVerifySubtitlesTextTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToDeliveryInfoPage()
                .verifySubtitlesText();
    }

    @Test
    public void rubberDucksPageLinkTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToRubberDucksPage()
                .verifyRubberDucksPageTitle();

    }

    @Test
    public void rubberDucksPageContainsGoodsTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToRubberDucksPage()
                .verifyRubberDucksPageContainsGoods();

    }

    @Test
    public void SubcategoriesLinkTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToSubcategoryPage()
                .verifySubcategoriesPageTitle();

    }

    @Test
    public void yellowDuckSaleStickerTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToSubcategoryPage()
                .verifyYellowDuckSticker();

    }

    @Test
    public void greenDuckSaleStickerTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToSubcategoryPage()
                .verifyGreenDuckSticker();

    }

    @Test
    public void sortingByNamesTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToSubcategoryPage()
                .clickSortByNamesButton()
                .verifySortingByNames();

    }

    @Test
    public void sortingByPricesTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .moveToSubcategoryPage()
                .clickSortByPriceButton()
                .verifySortingByPrices();

    }

    @Test
    public void changingCurrencyToDollarsTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

        siteMenuPage
                .changeCurrentCurrencyToDollars()
                .checkThatCurrentDuckPricesChangedToDollars();

    }



    @Test
    public void changingCurrentCountryToBelarusTest() {

       SiteMenuPage siteMenuPage = new SiteMenuPage(driver);

       siteMenuPage
                .changeCurrentCountryToBelarus()
                .verifyThatCurrentCountryChangedToBelarus();

    }

    @Test
    public void orderDucksOnRubberDucksPageTest() {
        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);
        siteMenuPage
                .moveToRubberDucksPage();

        CartPage cartPage = new CartPage(driver);
        cartPage
                .orderRandomGoods()
                .checkThatGoodsPlacedToCart();

    }

    @Test
    public void orderDucksOnHomePageTest() {
        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);
        siteMenuPage
                .moveToHomePage();

        CartPage cartPage = new CartPage(driver);
        cartPage
                .orderRandomGoods()
                .checkThatGoodsPlacedToCart();
    }

    @Test
    public void informationBoxPageVisibilityOnDeliveryInfoPageTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);
        siteMenuPage
                .moveToDeliveryInfoPage();

        InformationBoxPage informationBoxPage = new InformationBoxPage(driver);
        informationBoxPage
                .verifyThatInformationBoxPageIsVisible();

    }

    @Test
    public void informationBoxPageVisibilityOnTermsAndConditionsPageTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);
        siteMenuPage
                .moveToTermsAndConditionsPage();

        InformationBoxPage informationBoxPage = new InformationBoxPage(driver);
        informationBoxPage
                .verifyThatInformationBoxPageIsVisible();

    }

    @Test
    public void informationBoxPageVisibilityOnDiscountsAndPromotionsPageTest() {

        SiteMenuPage siteMenuPage = new SiteMenuPage(driver);
        siteMenuPage
                .moveToDiscountsAndPromotionsPage();

        InformationBoxPage informationBoxPage = new InformationBoxPage(driver);
        informationBoxPage
                .verifyThatInformationBoxPageIsVisible();

    }


}

