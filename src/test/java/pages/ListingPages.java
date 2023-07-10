package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class ListingPages {


    @Step("Открываем страницу для женщин")
    public void openPageForGirl() {

        open("/c/dlya-zhenshchin");
    }

    @Step("Открываем рандомную карточку товара")

    public ListingPages openRandomProductCard(int value) {
        $$(".yCmsContentSlot .img").get(value).click();
        return this;
    }



}
