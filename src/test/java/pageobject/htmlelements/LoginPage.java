package pageobject.htmlelements;


import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static pageobject.helpers.Locators.getLocator;


public class LoginPage extends PageBase {

    public HeaderMenu headerMenu;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        HtmlElementLoader.populatePageObject(this,driver);
    }

    public void setEmail(String email) throws Exception {
        driver.findElement(getLocator("LoginPage.emailInput")).sendKeys(email);
    }
    public void setPassword(String password) throws Exception {
        driver.findElement(getLocator("LoginPage.passwordInput")).sendKeys(password);
    }

    public void clickLoginButton() throws Exception {

        driver.findElement(getLocator("LoginPage.loginButton")).click();
    }

    public void clickLogoutButton() throws Exception {
        driver.findElement(getLocator("LoginPage.logoutButton")).click();
    }

    public void attemptLogin(String email, String password) throws Exception {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public boolean loginErrorMessageIsVisible() throws Exception {
        return driver.findElement(getLocator("LoginPage.errorMessage")).isDisplayed();
    }

    public boolean logoutButtonIsVisible() throws Exception {
        return driver.findElement(getLocator("LoginPage.logoutButton")).isDisplayed();
    }



}
