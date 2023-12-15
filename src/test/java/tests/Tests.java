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
        mainPage.openPage().fillSearchInput(data.randomBird).search();
        searchPage.checkSearchResult(data.randomBird);
    }

    @Test
    @Feature("Поиск")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Поиск птицы (нет результатов)")
    @Tag("regress")
    void searchBirdEmpty() {
        mainPage.openPage().fillSearchInput(data.emptySearchResult).search();
        searchPage.checkSearchResultEmpty();
    }

    @Test
    @Feature("Страница птицы")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия видео у птицы")
    @Tag("regress")
    void checkBirdVideo() {
        mainPage.openPage().fillSearchInput(data.birdsWithVideo).search();
        searchPage.openSearchLink();
        birdPage.checkTitlePage(data.birdsWithVideo).checkVideo();

    }


    @Test
    @Feature("Страница птицы")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия аудио у птицы")
    @Tag("regress")
    void checkBirdAudio() {
        mainPage.openPage().fillSearchInput(data.birdsWithAudio).search();
        searchPage.openSearchLink();
        birdPage.checkTitlePage(data.birdsWithAudio).checkAudio();
    }

    @Test
    @Feature("Конструктор птицы")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка работы конструктора птицы")
    @Tag("smoke")
    void CheckBirdGuide() {
        birdGuidePage.openPage().selectSilhoette().selectColour().checkLinkBird().LinkBirdClick();
        birdPage.checkTitlePage(data.birdGuide);
    }
}
