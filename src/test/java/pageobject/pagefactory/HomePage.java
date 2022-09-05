package pageobject.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private String homePageTitle="Online Store | My Store1";
    @FindBy(css = ".notice.success")
    private WebElement successMessage;

    public boolean successMessageIsVisible() {
        return successMessage.isDisplayed();
    }

}
