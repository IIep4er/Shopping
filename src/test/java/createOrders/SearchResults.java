package createOrders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.SearchResultsPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class SearchResults extends TestBase {

    @CsvFileSource(resources = "/searchValues.csv")
    @ParameterizedTest (name = "Поиск по слову value1 должен содержать результат с тестом value2")
    void checkingTheCorrectionOfSearchResults2(String value1, String value2) {
        searchResultsPages.openMainPage();

        searchResultsPages.inputWord(value1)
                .checkSearchResult(value2);
    }




























}
