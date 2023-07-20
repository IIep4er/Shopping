package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.localStorage;

public class CookiePages {

    @Step("Устанавливаем куку старого чекаута")
    public CookiePages addCookiesOldCheckout(String name, String value) {
        Selenide.clearBrowserCookies();
        var cookie = new Cookie(name, value);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        Selenide.refresh();
        //localStorage().setItem("flockapi:2111:precheckoutClosed", "[{\"campaign\":\"692647\",\"expireAt\":1689155424526},{\"campaign\":\"714291\",\"expireAt\":1689155491406},{\"campaign\":\"707109\",\"expireAt\":1689155606805}]");
        return this;
    }

    @Step("Закрываем поп ап согласия куки")
    public CookiePages closePopUpCookies() {

        $((".confirm-message__button-block")).click();
        return this;
    }
}
