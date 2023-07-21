package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class OldCheckoutPages {
    public SelenideElement

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
            setNumberCard = $("input[name=\"card\"]"),
            setDateCard= $("input[name=\"date\"]"),
            setCVV = $("input[name=\"cvv\"]"),
            paymentEmail = $("#email[name=\"email\"]"),
            pay = $(".confirm-button");

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Вводим ФИО")

    public OldCheckoutPages setFIO(String lastName, String firstName, String middleName) {
        lastNameInput.setValue(lastName); //фамилия
        firstNameInput.setValue(firstName); //имя
        middleNameInput.setValue(middleName); //отчество
        return this;
    }

    @Step("Вводим номер")

    public OldCheckoutPages setNumber(String value) {
        numberInput.setValue("9631113375");
        return this;
    }

    @Step("Вводим Email")

    public OldCheckoutPages setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Утанавливаем город ")

    public OldCheckoutPages setCity(String value) {
        cityInput.setValue(value);
        sleep(500);
        cityInput.sendKeys(Keys.ARROW_DOWN);
        sleep(500);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Выбираем способ доставки Постой России")

    public OldCheckoutPages setDeliveryMethodPost() {
        postDelivery.click();
        return this;
    }

    @Step("Выбираем способ доставки Курьер")

    public OldCheckoutPages setDeliveryMethodCourier() {
        courierDelivery.click();
        return this;
    }

    @Step("Выбираем способ доставки Пункт выдачи")

    public OldCheckoutPages setDeliveryMethodPickPoint() {
        selectPickPoint.click();

        return this;
    }

    @Step("Вводим адрес")

    public OldCheckoutPages setAddress(String value) {
        addressInput.setValue(value);
        sleep(500);
        addressInput.sendKeys(Keys.ARROW_DOWN);
        sleep(500);
        addressInput.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Выбираем оплату при получении")

    public OldCheckoutPages setPaymentModeCash() {
        paymentModeCash.shouldHave(visible);
        paymentModeCash.click();
        return this;
    }

    @Step("Выбираем оплату картой")

    public OldCheckoutPages setPaymentModeCard() {
        paymentModeCard.shouldHave(visible);
        paymentModeCard.click();
        return this;
    }

    @Step("Заполняем информацию для оплаты")

    public OldCheckoutPages setPaymentInfo(String numberCard, String dateCard, String cvv, String email) {
        //paymentPopUp.shouldHave(text("Аванс за заказ"));
        setNumberCard.shouldBe(visible).click();//setValue(numberCard);
        setDateCard.setValue(dateCard);
        setCVV.setValue(cvv);
        paymentEmail.shouldHave(text(email));
        pay.click();
        $(".repeat-action").click();
        $(".progress").shouldHave(text("Платёж завершён"));
        $(".actions .action").click();
        return this;
    }

    @Step("Нажимаем Оформить заказ")

    public OldCheckoutPages createOrder() {
        createOrder.click();
        return this;
    }

    @Step("Проверяем, что заказ создан") //todo вынести в отдельный ThanksPage

    public OldCheckoutPages orderCreationCheck() {
        $(By.cssSelector(".heading")).shouldHave(text("Отлично! Заказ создан"));  // todo придумать название и вынести в селенид элемент
        return this;
    }


}
