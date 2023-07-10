package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;

public class CookiePages {

    @Step("Устанавливаем куку старого чекаута")
    public CookiePages addCookiesOldCheckout(String name, String value) {
        Selenide.clearBrowserCookies();
        var cookie = new Cookie(name, value);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        Selenide.refresh();
        return this;
    }

    @Step("Закрываем поп ап согласия куки")
    public CookiePages closePopUpCookies() {

        $((".confirm-message__button-block")).click();
        return this;
    }
}
