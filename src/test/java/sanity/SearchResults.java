package sanity;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.sleep;

@Tag("sanity")
@Tags({
        @Tag("sanity"),
        @Tag("search")})
public class SearchResults extends TestBase {

    @CsvFileSource(resources = "/searchValues.csv")
    @ParameterizedTest(name = "Поиск по слову {0} должен содержать результат с тестом {1}")
    @Feature("Поиск")
    @Story("Успешное исправление результатов")
    @Owner("Ofitserov")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "US", url = "https://confluence.shoppinglive.local/")
    @DisplayName("Проверка исправления результатов поиска.")
    void checkingTheCorrectionOfSearchResults(String value1, String value2) {
        openMainPage();
        sleep(5000); //todo придумать нормальное ожидание
        search.inputWord(value1)
                .checkSearchResult(value2);
    }


}
