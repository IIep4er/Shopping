package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPages {

    private SelenideElement
            basket = $(".header-body__right-block [href=\"/cart\"]"),
            loginHeaderButton = $(".login-block__enter-text"),
            userMenu = $(".login-block__account"),
            profileDropDown = $(".login-block__dropdown");

    @Step("Открываем корзину")

    public HeaderPages openBasket() {
        basket.click();
        return this;
    }

    @Step("Нажимаем кнопку Войти")

    public HeaderPages clickLogin() {
        loginHeaderButton.click();
        return this;
    }

    @Step("Переходим в мой профиль")

    public HeaderPages clickMyProfile() {
        userMenu.shouldBe(visible).hover();
        profileDropDown.shouldBe(visible);
        $(By.linkText("Мой профиль")).click();
        return this;
    }
    @Step("Проверяем, что успешно авторизовались")

    public HeaderPages checkLoggedIn() {
        userMenu.shouldBe(visible);
        return this;
    }

}
