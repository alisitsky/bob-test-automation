package tests.components;

import com.codeborne.selenide.Configuration;
import data.RunTags;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag(RunTags.MAIN)
public class ScrollToTopElementTest extends TestBase {

    MainPage mainPage = new MainPage();

    @BeforeEach
    void setUp() {
        step("Open site by url", () -> {
            open(Configuration.baseUrl);
            allowCookiesIfNeeded();
        });
    }

    @Test
    void scrollDownAndCheckBackToTopElementIsDisplayed() {
        step("Scroll down and check element is visible", () -> {
            mainPage.scrollDownUntilElementIsVisible();
        });
    }

}