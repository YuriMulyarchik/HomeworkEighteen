package pageobject.htmlelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobject.helpers.WebDriverContainer;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Header menu")
@FindBy(id="site-menu")

public class HeaderMenu extends HtmlElement {

    @Name("Home button")
    @FindBy(css = ".fa.fa-home")
    WebElement homeButton;

    @Name("Rubber ducks button")
    @FindBy(css = "#site-menu > ul > li.category-1")
    WebElement rubberDucksButton;

    @Name("Subcategory menu item")
    @FindBy(css = "[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/']")
    WebElement subcategoryMenuItem;


    @Name("Delivery information button")
    @FindBy(css = ".page-2")
    WebElement deliveryInformationButton;

    @Name("Terms and conditions button")
    @FindBy(css = ".page-4")
    WebElement termsAndConditionsButton;

    @Name("Discounts and promotions button")
    @FindBy(css = ".page-5")
    WebElement discountsAndPromotionsButton;

    public void clickHomeButton() {
        homeButton.click();
    }
    public void clickRubberDucksButton() {
        rubberDucksButton.click();
    }
    public void clickSubcategory() {
        Actions builder = new Actions(WebDriverContainer.getDriver());
        builder.moveToElement(rubberDucksButton).click(subcategoryMenuItem).perform();
    }
    public void clickDeliveryInformationButton() {
        deliveryInformationButton.click();
    }
    public void clickTermsAndConditionsButton() {
        termsAndConditionsButton.click();
    }
    public void clickDiscountsAndPromotionsButton() {
        discountsAndPromotionsButton.click();
    }
}
