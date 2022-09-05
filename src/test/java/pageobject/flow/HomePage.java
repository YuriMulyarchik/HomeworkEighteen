package pageobject.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    private String homePageTitle="Online Store | My Store1";
    private By successMessage = By.cssSelector(".notice.success");

    private By logoutButton = By.cssSelector(".content [href='https://litecart.stqa.ru/en/logout']");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage assertThatSuccessMessageIsVisible() {
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed(), "Login was unsuccessful");
        return this;
    }

    public HomePage verifyHomePageTitle() {
        Assert.assertTrue(driver.getTitle().equals(homePageTitle), "homePage has an incorrect title or " +
                "homePage not navigated");
        return this;
    }

    public LoginPage clickLogoutButton() throws Exception {
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }

}
