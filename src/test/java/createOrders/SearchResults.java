package createOrders;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.SearchResultsPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class SearchResults extends TestBase {

    @CsvFileSource(resources = "/searchValues.csv")
    @ParameterizedTest (name = "Поиск по слову {0} должен содержать результат с тестом {1}")
    @Feature("Поиск")
    @Story("Успешное исправление результатов")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Проверка исправления результатов поиска.")
    void checkingTheCorrectionOfSearchResults2(String value1, String value2) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        searchResultsPages.openMainPage();
        searchResultsPages.inputWord(value1)
                .checkSearchResult(value2);
    }




























}
