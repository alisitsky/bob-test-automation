package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class BirdPage {

    private SelenideElement title = $("h1"),
            video = $("[src*='https://www.youtube.com/']"),
            audio = $("[src*='audio']");

    public BirdPage checkTitlePage(String value) {
        title.shouldHave(text(value));
        return this;
    }


    public BirdPage checkVideo() {
        video.shouldBe(visible);
        return this;
    }

    public BirdPage checkAudio() {
        audio.shouldBe(visible);
        return this;
    }
}
