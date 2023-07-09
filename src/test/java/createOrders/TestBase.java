package createOrders;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import pages.OldCheckoutPages;
import pages.SearchResultsPages;

public class TestBase {
    OldCheckoutPages oldCheckoutPages = new OldCheckoutPages();
    SearchResultsPages searchResultsPages = new SearchResultsPages();
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

        Configuration.pageLoadStrategy = "eager"; //�������� �������� �������� - ������������
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www-hybris-rt-01.shoppinglive.ru";
        Configuration.timeout = 60000;

    }
}
