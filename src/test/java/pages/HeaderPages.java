package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPages {

    private SelenideElement
            basket = $(".header-body__right-block [href=\"/cart\"]"),
            loginHeaderButton = $(".login-block__enter-text");

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

}
