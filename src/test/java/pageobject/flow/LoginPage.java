package pageobject.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private By emailInput = By.name("email");

    private By passwordInput = By.name("password");

    private By loginButton = By.name("login");

    private By errorMessage = By.cssSelector(".notice.errors");

    private By logoutButton = By.cssSelector(".content [href='https://litecart.stqa.ru/en/logout']");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }
    public LoginPage setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    private void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public HomePage loginWithCorrectCreds() {
        setEmail("ttttt@mail.ru");
        setPassword("123456");
        clickLoginButton();
        return new HomePage(driver);
    }

    public LoginPage loginWithIncorrectCreds() {
        setEmail("ttttt@mail.ru");
        setPassword("123");
        clickLoginButton();
        return this;
    }
    public LoginPage assertThatLoginErrorMessageIsVisible() {
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message is not displayed");
        return this;
    }

    public LoginPage assertThatLogoutButtonIsInvisible() throws Exception {
        Assert.assertTrue(driver.findElement(logoutButton).isDisplayed(), "Logout button is displayed");
        return this;
    }


}
