package sanity;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import pages.*;

import static com.codeborne.selenide.Selenide.$;

public class TestBase {
    OldCheckoutPages oldCheckout = new OldCheckoutPages();
    SearchPages search = new SearchPages();
    ListingPages listing = new ListingPages();
    HeaderPages header = new HeaderPages();
    BasketPages basket = new BasketPages();
    ProductCardPages productCard = new ProductCardPages();
    CookiePages cookie = new CookiePages();

    Faker faker = new Faker();

    String CookieName = "abtc-new-checkout-mode_1",
            CookieValue = "not_new_checkout",
            lastName = "Офицеров",
            firstName = "Кирилл",
            middleName = "Олегович",
            number = "9631113375",
            email = "ki@ri.ru",
            city = "Москва",
            address = "ракетный 12",
            numberCard = "4242424242424242",
            dateCard = "1225",
            CVV = "123";
    int NumberProductCard = faker.number().numberBetween(1, 30);

    @BeforeAll
    static void config() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www-hybris-rt-01.shoppinglive.ru/";
        Configuration.timeout = 10000;

    }

}
