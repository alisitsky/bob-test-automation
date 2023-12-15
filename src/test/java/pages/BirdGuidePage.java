package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class BirdGuidePage {
    SelenideElement swanSilhouette = $("[data-filter='.shape-lebed']"),
            colorBird = $("[data-filter='.color-white']"),
            birdLink = $("[href*='lebed']");

    public BirdGuidePage openPage() {
        step("Открываем страницу конструктора", () -> {
            open("/opredelitel-ptic.html");
        });
        return this;
    }

    public BirdGuidePage selectSilhoette() {
        step("Выбираем силуэт", () -> {
            swanSilhouette.click();
        });
        return this;
    }

    public BirdGuidePage selectColour() {
        step("Выбираем цвет", () -> {
            colorBird.click();
        });
        return this;
    }


    public BirdGuidePage checkLinkBird() {
        step("Проверяем наличие ссылки на птицу", () -> {
            birdLink.shouldBe(Condition.visible);
        });
        return this;
    }


    public BirdGuidePage LinkBirdClick() {
        step("Кликаем по ссылке", () -> {
            birdLink.click();
        });
        return this;
    }
}
