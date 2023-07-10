package sanity;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OldCheckout extends TestBase {
    @Test
    @Disabled
    @Feature("Старый чекаут")
    @Story("Успешное оформление заказа")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Оформление заказа с доставкой почтой России и наложенным платежом")
    void successfulOrderWithDeliveryPost() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        listing.openPageForGirl();

        cookie.addCookiesOldCheckout(CookieName, CookieValue)
                .closePopUpCookies();

        listing.openRandomProductCard(NumberProductCard);

        productCard.addToBasket();

        header.openBasket();

        basket.checkout();

        oldCheckout.setFIO(lastName, firstName, middleName)
                .setNumber(number)
                .setEmail(email)
                .setCity(city)
                .setDeliveryMethodPost()
                .setAddress(address)
                .setPaymentModeCash()
                .createOrder()
                .orderCreationCheck()
                .takeScreenshot();

    }

    @Test
    @Disabled
    @Feature("Старый чекаут")
    @Story("Успешное оформление заказа")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Оформление заказа с доставкой курьером и наложенным платежом")
    void successfulOrderWithDeliveryCourier() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        listing.openPageForGirl();

        cookie.addCookiesOldCheckout(CookieName, CookieValue)
                .closePopUpCookies();

        listing.openRandomProductCard(NumberProductCard);

        productCard.addToBasket();

        header.openBasket();

        basket.checkout();

        oldCheckout.setFIO(lastName, firstName, middleName)
                .setNumber(number)
                .setEmail(email)
                .setCity(city)
                .setDeliveryMethodCourier()
                .setAddress(address)
                .setPaymentModeCash()
                .createOrder()
                .orderCreationCheck()
                .takeScreenshot();
    }

    @Test
    @Disabled
    @Feature("Старый чекаут")
    @Story("Успешное оформление заказа")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Оформление заказа с доставкой курьером и оплатой картой")
    void successfulOrderWithDeliveryCourierPayCard() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        listing.openPageForGirl();

        cookie.addCookiesOldCheckout(CookieName, CookieValue)
                .closePopUpCookies();

        listing.openRandomProductCard(NumberProductCard);

        productCard.addToBasket();

        header.openBasket();

        basket.checkout();

        oldCheckout.setFIO(lastName, firstName, middleName)
                .setNumber(number)
                .setEmail(email)
                .setCity(city)
                .setDeliveryMethodCourier()
                .setAddress(address)
                .setPaymentModeCard()
                .createOrder()
                .setPaymentInfo(numberCard, dateCard, CVV, email)
                .orderCreationCheck()
                .takeScreenshot();

    }

}
