package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement searchInput = $("[name='query']"),

    searchButton = $("[type='submit']");


    public MainPage openPage() {
        open("https://ptici.info/");
        searchInput.shouldBe(visible);
        return this;
    }


    public MainPage fillSearchInput(String value) {
        searchInput.setValue(value);
        return this;
    }

    public MainPage search() {
        searchButton.click();
        return this;
    }
}
