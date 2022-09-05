package pageobject.selenide;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    public void selenideTest() {

        open("https://litecart.stqa.ru/en/");
        $("[name=email]").sendKeys("ttttt@mail.ru");
        $(By.name("password")).sendKeys("123456");
        $(By.name("login")).click();
        $(".notice.success").shouldBe(visible).shouldHave(text("You are now logged in as y m."));

    }
}

