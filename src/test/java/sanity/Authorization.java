package sanity;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.HeaderPages;

@Tag("sanity")
@Tags({
        @Tag("sanity"),
        @Tag("authorization")})
public class Authorization extends TestBase {

    @Test
    @Feature("Окно авторизации/регистрации")
    @Story("Успешная авторизация")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Успешная авторизация через почту/пароль")
    void successfulAuthorizationWithEmailAndPassword() {
        openMainPage();
        header.clickLogin();
        authorization.clickLoginForEmail()
                .setEmail(email)
                .setPassword(password)
                .clickLoginEmail();
        header.clickMyProfile();
        myProfile.verify("Заказ");

    }

}
