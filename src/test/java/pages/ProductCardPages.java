package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProductCardPages {

    @Step("Нажамаем кнопку В корзину ") //todo вынести в сселениде элемент
    public ProductCardPages addToBasket() {
        $("[data-js=\"button-add-to-cart-block\"]").$(byText("В корзину")).shouldHave(visible);
        $("[data-js=\"button-add-to-cart-block\"]").click();
        return this;
    }

}
