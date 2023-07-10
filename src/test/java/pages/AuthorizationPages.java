package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPages {

    private SelenideElement
    loginForEmailButton = $(".backstage-body__footer").$(withText("Войдите по почте")),
    emailInput = $(".suggestions-input"),
    passwordInput = $(".password-input-text-field .field-text__input"),
    loginEmail = $(".backstage-body__footer .backstage-login-email__login-button");

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Нажимаем Войти по почте")

    public AuthorizationPages clickLoginForEmail() {
    loginForEmailButton.click();
        return this;
    }

    @Step("Вводим Email")

    public AuthorizationPages setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Вводим пароль")

    public AuthorizationPages setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Нажимаем войти")

    public AuthorizationPages clickLoginEmail() {
        loginEmail.click();
        return this;
    }

 /*   @Step("")

    public AuthorizationPages name() {

        return this;
    }

    @Step("")

    public AuthorizationPages name() {

        return this;
    }
*/
}
