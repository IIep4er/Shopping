package sanity;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Tag("sanity")
public class OldCheckout extends TestBase {
    @Test
    //@Disabled
    @Feature("Старый чекаут")
    @Story("Успешное оформление заказа анонимом")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/") //todo добавить актуальную US
    @DisplayName("Оформление заказа с доставкой почтой России и НП анонимом")
    void successfulOrderWithDeliveryPost() {

        open("/_ui/custom/img/logo.svg");
        cookie.addCookiesOldCheckout(CookieName, CookieValue);
        listing.openPageForGirl();
        cookie.closePopUpCookies();
        listing.openRandomProductCard(NumberProductCard);
        productCard.addToBasket();
        header.openBasket();
        basket.clickCheckout();
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
    //@Disabled
    @Feature("Старый чекаут")
    @Story("Успешное оформление заказа анонимом")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Оформление заказа с доставкой курьером и НП анонимом")
    void successfulOrderWithDeliveryCourier() {

        open("/_ui/custom/img/logo.svg");
        cookie.addCookiesOldCheckout(CookieName, CookieValue);
        listing.openPageForGirl();
        cookie.closePopUpCookies();
        listing.openRandomProductCard(NumberProductCard);
        productCard.addToBasket();
        header.openBasket();
        basket.clickCheckout();
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
    @Story("Успешное оформление заказа анонимом")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Оформление заказа с доставкой курьером и оплатой картой анонимом")
    void successfulOrderWithDeliveryCourierPayCard() {

        open("/_ui/custom/img/logo.svg");
        cookie.addCookiesOldCheckout(CookieName, CookieValue);
        listing.openPageForGirl();
        cookie.closePopUpCookies();
        listing.openRandomProductCard(NumberProductCard);
        productCard.addToBasket();
        header.openBasket();
        basket.clickCheckout();
        oldCheckout.setFIO(lastName, firstName, middleName)
                .setNumber(number)
                .setEmail(email)
                .setCity(city)
                .setDeliveryMethodCourier()
                .setAddress(address)
                .setPaymentModeCard()
                .createOrder();
        oldCheckout.setPaymentInfo(numberCard, dateCard, CVV, email)
                .orderCreationCheck()
                .takeScreenshot();

    }

    @Test
    //@Disabled
    @Feature("Старый чекаут")
    @Story("Успешное оформление заказа авторизованным пользователем")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Оформление заказа с доставкой почтой и НП авторизованным пользователем")
    void testName() { //todo сменить имя метода
        open("/_ui/custom/img/logo.svg");
        cookie.addCookiesOldCheckout(CookieName, CookieValue);
        openMainPage();
        cookie.closePopUpCookies();
        header.clickLogin();
        authorization.clickLoginForEmail()
                .setEmail(email)
                .setPassword(password)
                .clickLoginEmail();
        header.checkLoggedIn();
        listing.openPageForGirl();
        listing.openRandomProductCard(NumberProductCard);
        productCard.addToBasket();
        header.openBasket();
        basket.clickCheckout();
        $(".delivery-tab .active").shouldBe(visible);//todo обернуть в метод
        if (!oldCheckout.postDelivery.has(cssClass("active"))) {
            oldCheckout.setDeliveryMethodPost();
        }
        oldCheckout.setPaymentModeCash()
                .createOrder()
                .orderCreationCheck();
    }

    @Test
    //@Disabled
    @Feature("Старый чекаут")
    @Story("Успешное оформление заказа авторизованным пользователем")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Оформление заказа с доставкой курьером и НП авторизованным пользователем")
    void testName2() { //todo сменить имя метода
        open("/_ui/custom/img/logo.svg");
        cookie.addCookiesOldCheckout(CookieName, CookieValue);
        openMainPage();
        cookie.closePopUpCookies();
        header.clickLogin();
        authorization.clickLoginForEmail()
                .setEmail(email)
                .setPassword(password)
                .clickLoginEmail();
        header.checkLoggedIn();
        listing.openPageForGirl();
        listing.openRandomProductCard(NumberProductCard);
        productCard.addToBasket();
        header.openBasket();
        basket.clickCheckout();
        $(".delivery-tab .active").shouldBe(visible);//todo обернуть в метод
        if (!oldCheckout.courierDelivery.has(cssClass("active"))) {
            oldCheckout.setDeliveryMethodCourier();
        }
        oldCheckout.setPaymentModeCash()
                .createOrder()
                .orderCreationCheck();
    }


}
