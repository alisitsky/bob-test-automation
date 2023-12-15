package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage {

    private SelenideElement searchInput = $("[name='query']"),

    searchButton = $("[type='submit']");


    public MainPage openPage() {
        step("Открываем главную", () -> {
            open("https://ptici.info/");
            searchInput.shouldBe(visible);
        });
        return this;
    }


    public MainPage fillSearchInput(String value) {
        step("Вводим поисковый запрос: " + value, () -> {
            open();
            searchInput.setValue(value);

        });
        return this;
    }

    public MainPage search() {
        step("Нажимаем на кнопку поиска", () -> {
            searchButton.click();
        });
        return this;
    }
}
