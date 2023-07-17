package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasketPages {

    private SelenideElement

            checkoutButton = $(By.cssSelector("[data-js=\"button-apply-order\"]"));

    @Step("Нажамаем оформить заказ")

    public BasketPages clickCheckout() {
        checkoutButton.click();
        return this;
    }

}
