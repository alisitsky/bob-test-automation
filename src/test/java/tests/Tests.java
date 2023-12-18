package tests;


import data.TestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BirdGuidePage;
import pages.BirdPage;
import pages.MainPage;
import pages.SearchPage;

import static io.qameta.allure.Allure.step;


@DisplayName("Тесты на вебсайт 'Птицы России'")
@Tag("all-tests")
public class Tests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    BirdPage birdPage = new BirdPage();
    BirdGuidePage birdGuidePage = new BirdGuidePage();
    TestData data = new TestData();

    @Test
    @Feature("Поиск")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск птицы (есть результаты)")
    @Tag("smoke")
    void searchBird() {
        step("Открываем главную cтраницу", () -> {
            mainPage.openPage();
        });
        step("Вводим поисковый запрос: " + data.randomBird, () -> {
            mainPage.fillSearchInput(data.randomBird);
        });
        step("Нажимаем на кнопку поиска", () -> {
            mainPage.search();
        });

        step("Проверяем наличие результата поиска", () -> {
            searchPage.checkSearchResult(data.randomBird);
        });

    }

    @Test
    @Feature("Поиск")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Поиск птицы (нет результатов)")
    @Tag("regress")
    void searchBirdEmpty() {
        step("Открываем главную cтраницу", () -> {
            mainPage.openPage();
        });

        step("Вводим поисковый запрос: " + data.emptySearchResult, () -> {
            mainPage.fillSearchInput(data.emptySearchResult);
        });

        step("Нажимаем на кнопку поиска", () -> {
            mainPage.search();
        });

        step("Проверяем заглушку при отсутствии результатов поиска", () -> {
            searchPage.checkSearchResultEmpty();
        });
    }

    @Test
    @Feature("Страница птицы")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия видео у птицы")
    @Tag("regress")
    void checkBirdVideo() {
        step("Открываем главную cтраницу", () -> {
            mainPage.openPage();
        });
        step("Вводим поисковый запрос: " + data.birdsWithVideo, () -> {
            mainPage.fillSearchInput(data.birdsWithVideo);
        });
        step("Нажимаем на кнопку поиска", () -> {
            mainPage.search();
        });
        step("Открываем ссылку поискового результата", () -> {
            searchPage.openSearchLink();
        });
        step("Проверяем заголовок страницы", () -> {
            birdPage.checkTitlePage(data.birdsWithVideo);
        });
        step("Проверяем наличие видео", () -> {
            birdPage.checkVideo();
        });
    }


    @Test
    @Feature("Страница птицы")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия аудио у птицы")
    @Tag("regress")
    void checkBirdAudio() {
        step("Открываем главную cтраницу", () -> {
            mainPage.openPage();
        });
        step("Вводим поисковый запрос: " + data.birdsWithAudio, () -> {
            mainPage.fillSearchInput(data.birdsWithAudio);
        });
        step("Нажимаем на кнопку поиска", () -> {
            mainPage.search();
        });
        step("Открываем ссылку поискового результата", () -> {
            searchPage.openSearchLink();
        });
        step("Проверяем заголовок страницы", () -> {
            birdPage.checkTitlePage(data.birdsWithAudio);
        });
        step("Проверяем наличие аудио", () -> {
            birdPage.checkAudio();
        });
    }

    @Test
    @Feature("Конструктор птицы")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка работы конструктора птицы")
    @Tag("smoke")
    void CheckBirdGuide() {
        step("Открываем страницу конструктора", () -> {
            birdGuidePage.openPage();
        });
        step("Выбираем силуэт", () -> {
            birdGuidePage.selectSilhoette();
        });
        step("Выбираем цвет", () -> {
            birdGuidePage.selectColour();
        });
        step("Проверяем наличие ссылки на птицу", () -> {
            birdGuidePage.checkLinkBird();
        });
        step("Кликаем по ссылке", () -> {
            birdGuidePage.linkBirdClick();
        });

        step("Проверяем заголовок страницы", () -> {
            birdPage.checkTitlePage(data.birdGuide);
        });
    }
}
