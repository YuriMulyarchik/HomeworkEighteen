package pageobject.pagefactory;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(css = ".content [href='https://litecart.stqa.ru/en/logout']")
    private WebElement logoutButton;

    @FindBy(css = ".notice.errors")
    private WebElement errorMessage;

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void attemptLogin(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public boolean loginErrorMessageIsVisible() {
       return errorMessage.isDisplayed();
    }
    public void clickLogoutButton() throws Exception {
        logoutButton.click();
    }
    public boolean logoutButtonIsVisible() throws Exception {
        return logoutButton.isDisplayed();
    }


}
