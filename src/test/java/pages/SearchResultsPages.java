package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchResultsPages {
    private SelenideElement
            searchString = $("#site-search-input"),
            searchResult = $("div.digi-products-grid_horde");

    @Step("Открываем главную страницу")
    public void openMainPage() {

        open(baseUrl);
    }


    @Step("Вводим искомое слово") //todo разобраться, как подцепить в название конкретное слово

    public SearchResultsPages inputWord(String value) {
        searchString.setValue(value).pressEnter();
        return this;
    }

    @Step("Проверяем, что в предлженной выдаче есть искомый товар ") //todo разобраться, как подцепить в название конкретное слово

    public SearchResultsPages checkSearchResult(String value) {
        searchResult.shouldBe(text(value));
        return this;
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
