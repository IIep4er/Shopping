package sanity;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("sanity")
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
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www-hybris-rt-01.shoppinglive.ru/";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

    }

    @Step("Открываем главную страницу")
    public void openMainPage() {

        open(baseUrl);
    }

}
