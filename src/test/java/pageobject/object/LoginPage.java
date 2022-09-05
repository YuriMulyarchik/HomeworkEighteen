package pageobject.object;

import org.openqa.selenium.WebDriver;
import static pageobject.helpers.Locators.getLocator;


public class LoginPage extends PageBase {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) throws Exception {
        LOG.debug("Setting email");
        driver.findElement(getLocator("LoginPage.emailInput")).sendKeys(email);
    }
    public void setPassword(String password) throws Exception {
        LOG.debug("Setting password");
        driver.findElement(getLocator("LoginPage.passwordInput")).sendKeys(password);
    }

    public void clickLoginButton() throws Exception {
        LOG.debug("Clicking login button");
        driver.findElement(getLocator("LoginPage.loginButton")).click();
    }

    public void clickLogoutButton() throws Exception {
        LOG.debug("Clicking logout button");
        driver.findElement(getLocator("LoginPage.logoutButton")).click();
    }

    public void attemptLogin(String email, String password) throws Exception {
        LOG.info("Attempting login");
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public boolean loginErrorMessageIsVisible() throws Exception {
        LOG.info("Checking login error message visibility");
        return driver.findElement(getLocator("LoginPage.errorMessage")).isDisplayed();
    }

    public boolean logoutButtonIsVisible() throws Exception {
        LOG.info("Checking logout button visibility");
        return driver.findElement(getLocator("LoginPage.logoutButton")).isDisplayed();
    }


}
