package pageobject.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class RubberDucksPage {

    @FindAll({@FindBy(css = ".link[title*='Duc']")})
    private List<WebElement> goodsList;

    public boolean verifyRubberDucksPageContainsGoods() {
        if (goodsList.isEmpty()) {
         return false;
        } else return true;
    }
}
