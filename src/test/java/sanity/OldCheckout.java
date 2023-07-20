package sanity;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

@Tag("sanity")
public class OldCheckout extends TestBase {
    @Test
    //@Disabled
    @Feature("Старый чекаут")
    @Story("Успешное оформление заказа")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/") //todo добавить актуальную US
    @DisplayName("Оформление заказа с доставкой почтой России и наложенным платежом")
    void successfulOrderWithDeliveryPost() {

        listing.openPageForGirl();
        cookie.addCookiesOldCheckout(CookieName, CookieValue)
                .closePopUpCookies();
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
    @Story("Успешное оформление заказа")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Оформление заказа с доставкой курьером и наложенным платежом")
    void successfulOrderWithDeliveryCourier() {

        listing.openPageForGirl();

        cookie.addCookiesOldCheckout(CookieName, CookieValue)
                .closePopUpCookies();

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
    @Story("Успешное оформление заказа")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Оформление заказа с доставкой курьером и оплатой картой")
    void successfulOrderWithDeliveryCourierPayCard() {

        listing.openPageForGirl();

        cookie.addCookiesOldCheckout(CookieName, CookieValue)
                .closePopUpCookies();

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
                .createOrder()
                .setPaymentInfo(numberCard, dateCard, CVV, email)
                .orderCreationCheck()
                .takeScreenshot();

    }

    @Test //todo доделать шаги чекаута и сменить имя метода
    //@Disabled
    @Feature("Старый чекаут")
    @Story("Успешное оформление заказа авторизованным пользователем")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Оформление заказа с доставкой курьером и оплатой картой авторизованным пользователем")
    void testName() {
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
        if (!oldCheckout.postDelivery.has(cssClass("active"))) {
            //try {
            oldCheckout.setDeliveryMethodPost();
           // } catch (Exception e) {
                // Обработка ошибки клика
            //    System.out.println("Ошибка клика: " + e.getMessage());
           // }
        }
        //else {
          //  return;
       // }
        oldCheckout.setPaymentModeCash()
                .createOrder()
                .orderCreationCheck()
                .takeScreenshot();
        sleep(5000);
    }


}
