package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class OldCheckoutPages {
    private SelenideElement
            basket = $(".header-body__right-block [href=\"/cart\"]"),
            checkoutButton = $(By.cssSelector("[data-js=\"button-apply-order\"]")),
            lastNameInput = $("[name=\"lastName\"]"),
            firstNameInput = $("[name=\"firstName\"]"),
            middleNameInput = $("[name=\"middleName\"]"),
            numberInput = $("[name=\"phoneNumber\"]"),
            emailInput = $(".two-fields-block [name=\"email\"]"),
            cityInput = $("[data-js=\"root-region-container\"] [name=\"address\"]"),
            postDelivery = $("[data-delivery-code=\"russian-post\"]"),
            courierDelivery = $("[data-delivery-code=\"courier\"]"),
            pickupPointDelivery = $("[data-delivery-code=\"pickup-point\"]"),
            addressInput = $("[data-js=\"address-field-container\"] [name=\"address\"]"),
            paymentModeCash = $("[data-payment-code=\"CASH\"]"),
            paymentModeCard= $("[data-payment-code=\"CREDITCARD\"]"),
            createOrder = $("[data-js=\"button-apply-order\"]"),
            selectPickPoint = $(".point-map"),
            paymentPopUp = $(".header-component__text"),
            setNumberCard = $("[name=\"card\"]"),
            setDateCard= $("[name=\"date\"]"),
            setCVV = $("[name=\"cvv\"]"),
            paymentEmail = $("#email[name=\"email\"]"),
            pay = $(".confirm-button");
    public void openPageForGirl() {

        open("/c/dlya-zhenshchin");
    }
    public void addCookiesOldCheckout(String name, String value) {
        Selenide.clearBrowserCookies();
        var cookie = new Cookie(name, value);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        Selenide.refresh();
    }

    public void closePopUpCookies() {

        $((".confirm-message__button-block")).click();
    }

    public OldCheckoutPages openProductCard(int value) {
        $$(".yCmsContentSlot .img").get(value-1).click();
        return this;
    }

    public OldCheckoutPages addToBasket() {
        $("[data-js=\"button-add-to-cart-block\"]").$(byText("В корзину")).shouldHave(visible);
        $("[data-js=\"button-add-to-cart-block\"]").click();
        return this;
    }

    public OldCheckoutPages openBasket() {
        basket.click();
        return this;
    }

    public OldCheckoutPages checkout() {
        checkoutButton.click();
        return this;
    }

    public OldCheckoutPages setFIO(String lastName, String firstName, String middleName) {
        lastNameInput.setValue(lastName); //фамилия
        firstNameInput.setValue(firstName); //имя
        middleNameInput.setValue(middleName); //отчество
        return this;
    }

    public OldCheckoutPages setNumber(String value) {
        numberInput.setValue("9631113375");
        return this;
    }

    public OldCheckoutPages setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public OldCheckoutPages setCity(String value) {
        cityInput.setValue(value);
        sleep(500);
        cityInput.sendKeys(Keys.ARROW_DOWN);
        sleep(500);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    public OldCheckoutPages setDeliveryMethodPost() {
        postDelivery.click();
        return this;
    }

    public OldCheckoutPages setDeliveryMethodCourier() {
        courierDelivery.click();
        return this;
    }

    public OldCheckoutPages setDeliveryMethodPickPoint() {
        selectPickPoint.click();

        return this;
    }

    public OldCheckoutPages setAddress(String value) {
        addressInput.setValue(value);
        sleep(500);
        addressInput.sendKeys(Keys.ARROW_DOWN);
        sleep(500);
        addressInput.sendKeys(Keys.ENTER);
        return this;
    }

    public OldCheckoutPages setPaymentModeCash() {
        paymentModeCash.shouldHave(visible);
        paymentModeCash.click();
        return this;
    }

    public OldCheckoutPages setPaymentModeCard() {
        paymentModeCard.shouldHave(visible);
        paymentModeCard.click();
        return this;
    }
    public OldCheckoutPages setPaymentInfo(String numberCard, String dateCard, String cvv, String email) {
        paymentPopUp.shouldHave(visible);
        setNumberCard.setValue(numberCard);
        setDateCard.setValue(dateCard);
        setCVV.setValue(cvv);
        paymentEmail.shouldBe(text(email));
        pay.click();
        $(".repeat-action").click();
        $(".progress").shouldBe(text("Платёж завершён"));
        $(".actions .action").click();
        return this;
    }

    public OldCheckoutPages createOrder() {
        createOrder.click();
        return this;
    }

    public OldCheckoutPages orderCreationCheck() {
        $(By.cssSelector(".heading")).shouldBe(text("Отлично! Заказ создан"));  // todo придумать название и вынести в селенид элемент
        return this;
    }

}
