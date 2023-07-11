package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MyProfilePages {
    SelenideElement
    accountName = $(".account-header__user");

    @Step ("Проверяем имя пользователя в профиле")

    public MyProfilePages verify(String name) {
        accountName.shouldHave(text(name));
        return this;
    }

}
