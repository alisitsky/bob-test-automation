package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class BirdPage {

    private SelenideElement title = $("h1"),

    video = $("[src*='https://www.youtube.com/']"),

    audio = $("[src*='audio']");

    public BirdPage checkTitlePage(String value) {
        step("Проверяем заголовок страницы", () -> {
            title.shouldHave(text(value));
        });
        return this;
    }


    public BirdPage checkVideo() {
        step("Проверяем наличие видео", () -> {
            video.shouldBe(visible);
        });
        return this;
    }

    public BirdPage checkAudio() {
        step("Проверяем наличие аудио", () -> {
            audio.shouldBe(visible);
        });
        return this;
    }
}
