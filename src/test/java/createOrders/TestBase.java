package createOrders;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.OldCheckoutPages;
import pages.SearchResultsPages;

public class TestBase {
    OldCheckoutPages oldCheckoutPages = new OldCheckoutPages();
    SearchResultsPages searchResultsPages = new SearchResultsPages();
    @BeforeAll
    static void config() {

        Configuration.pageLoadStrategy="eager"; //�������� �������� �������� - ������������
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl="https://www-hybris-rt-01.shoppinglive.ru";
        Configuration.timeout = 10000;

    }
}
