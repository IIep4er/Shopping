package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchResultsPages {
    private SelenideElement
            searchString = $("#site-search-input"),
            searchResult = $("div.digi-products-grid_horde");

    public void openMainPage() {

        open(baseUrl);
    }

    public SearchResultsPages inputWord(String value) {
        searchString.setValue(value).pressEnter();
        return this;
    }

    public SearchResultsPages checkSearchResult(String value) {
        searchResult.shouldBe(text(value));
        return this;
    }

}
