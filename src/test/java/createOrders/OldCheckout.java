package createOrders;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OldCheckout extends TestBase {
    @Test
    @Disabled
    @Feature("Старый чекаут")
    @Story("Успешное оформление заказа")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Оформление заказа с доставкой почтой России и наложенным платежом")


    void succesful_Order_with_delivery_post() {

        SelenideLogger.addListener("allure", new AllureSelenide());

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
    void succesful_Order_with_delivery_courier() {

        SelenideLogger.addListener("allure", new AllureSelenide());

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
    void succesful_Order_with_delivery_courier_payCard() {

        SelenideLogger.addListener("allure", new AllureSelenide());

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
                .setPaymentInfo(numberCard, dateCard, CVV, email)
                .orderCreationCheck()
                .takeScreenshot();

    }

}
