package sanity;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    OldCheckoutPages oldCheckout = new OldCheckoutPages();
    SearchPages search = new SearchPages();
    ListingPages listing = new ListingPages();
    HeaderPages header = new HeaderPages();
    BasketPages basket = new BasketPages();
    ProductCardPages productCard = new ProductCardPages();
    CookiePages cookie = new CookiePages();
    AuthorizationPages authorization = new AuthorizationPages();
    MyProfilePages myProfile = new MyProfilePages();

    Faker faker = new Faker();

    String CookieName = "abtc-new-checkout-mode_1",
            CookieValue = "not_new_checkout",
            lastName = "Офицеров",
            firstName = "Кирилл",
            middleName = "Олегович",
            number = "9631113375",
            email = "kofitserov@shoppinglive.ru",
            password = "password1234",
            city = "Москва",
            address = "ракетный 12",
            numberCard = "4242424242424242",
            dateCard = "1225",
            CVV = "123";
    int NumberProductCard = faker.number().numberBetween(1, 30);

    @BeforeAll
    static void config() {

        Configuration.pageLoadStrategy = "eager";
        //Configuration.browser = "chrome";
        //Configuration.browserVersion = System.getProperty("version", "100.0");
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www-hybris-dev-02.shoppinglive.ru";
        Configuration.timeout = 30000;
        /*Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;*/

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
        void addAttachments() {
            Attach.browserConsoleLogs();
            Attach.screenshotAs("Last screenshot");
            Attach.addVideo();
        }


    @Step("Открываем главную страницу")
    public void openMainPage() {

        open(baseUrl);
    }

}
