package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");
    private static By unsuccessMessag = By.cssSelector(".notice.errors");
    private static By logoutButton = By.cssSelector(".content [href='https://litecart.stqa.ru/en/logout']");



    public static void setEmail(WebDriver driver, String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public static void setPassword(WebDriver driver, String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public static void clickLoginButton(WebDriver driver) {
        driver.findElement(loginButton).click();
    }
    public static void clickLogoutButton(WebDriver driver) throws Exception {
        driver.findElement(logoutButton).click();
    }

    public static void attemptLogin(WebDriver driver, String email, String password) {
        setEmail(driver, email);
        setPassword(driver, password);
        clickLoginButton(driver);
    }

    public static boolean loginErrorMessageIsVisible(WebDriver driver) {
        return driver.findElement(unsuccessMessag).isDisplayed();
    }
    public static boolean logoutButtonIsVisible(WebDriver driver) throws Exception {
        return driver.findElement(logoutButton).isDisplayed();
    }

}
