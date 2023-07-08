package createOrders;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OldCheckout extends TestBase {
    @Test
    @DisplayName("Оформление заказа с доставкой почтой России и наложенным платежом")
    void succesful_Order_with_delivery_post() {

        oldCheckoutPages.openPageForGirl();

        oldCheckoutPages.addCookiesOldCheckout(CookieName, CookieValue);

        oldCheckoutPages.closePopUpCookies();

        oldCheckoutPages.openProductCard(NumberProductCard)
                .addToBasket()
                .openBasket()
                .checkout()
                .setFIO(lastName,firstName,middleName)
                .setNumber(number)
                .setEmail(email)
                .setCity(city)
                .setDeliveryMethodPost()
                .setAddress(address)
                .setPaymentModeCash()
                .createOrder();

        $(By.cssSelector(".heading")).shouldBe(text("Отлично! Заказ создан"));

    }

    @Test
    @DisplayName("Оформление заказа с доставкой курьером и наложенным платежом")
    void succesful_Order_with_delivery_courier() {
        oldCheckoutPages.openPageForGirl();

        oldCheckoutPages.addCookiesOldCheckout(CookieName, CookieValue);

        oldCheckoutPages.closePopUpCookies();

        oldCheckoutPages.openProductCard(NumberProductCard)
                .addToBasket()
                .openBasket()
                .checkout()
                .setFIO(lastName,firstName,middleName)
                .setNumber(number)
                .setEmail(email)
                .setCity(city)
                .setDeliveryMethodCourier()
                .setAddress(address)
                .setPaymentModeCash()
                .createOrder();

        $(By.cssSelector(".heading")).shouldBe(text("Отлично! Заказ создан"));
    }

    @Test
    @DisplayName("Оформление заказа с доставкой курьером и оплатой картой")
    void succesful_Order_with_delivery_courier_payCard() {
        oldCheckoutPages.openPageForGirl();

        oldCheckoutPages.addCookiesOldCheckout(CookieName, CookieValue);

        oldCheckoutPages.closePopUpCookies();

        oldCheckoutPages.openProductCard(NumberProductCard)
                .addToBasket()
                .openBasket()
                .checkout()
                .setFIO(lastName,firstName,middleName)
                .setNumber(number)
                .setEmail(email)
                .setCity(city)
                .setDeliveryMethodCourier()
                .setAddress(address)
                .setPaymentModeCard()
                .createOrder()
                .setPaymentInfo(numberCard, dateCard, CVV, email);

        $(By.cssSelector(".heading")).shouldBe(text("Отлично! Заказ создан"));

    }

}
