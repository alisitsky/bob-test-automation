package pages;


import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchPage {


    private SelenideElement searchResultTitle = $("h1"),

    searchResultItem = $("[class*='search_results_item_text']"),

    searchResultEmpty = $("h1"),


    searchResultLink = $("[class^='search-link']");


    public SearchPage checkSearchResult(String value) {
        step("Проверяем наличие результата поиска", () -> {
            searchResultTitle.shouldBe(visible);
            searchResultItem.shouldBe(visible).shouldHave(text(value));
        });
        return this;
    }


    public SearchPage checkSearchResultEmpty() {
        step("Проверяем заглушку при отсутствии результатов поиска", () -> {
            searchResultTitle.shouldBe(visible);
            searchResultEmpty.shouldBe(visible);
            searchResultItem.shouldNotBe(visible);
        });
        return this;
    }

    public SearchPage openSearchLink() {
        step("Открываем ссылку поискового результата", () -> {
            searchResultLink.click();
        });
        return this;
    }
}
