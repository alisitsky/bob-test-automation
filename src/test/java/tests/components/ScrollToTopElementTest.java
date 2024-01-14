package tests.components;

import data.RunTags;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.qameta.allure.Allure.step;

@Tag(RunTags.MAIN)
public class ScrollToTopElementTest extends TestBase {

    @Test
    void scrollDownAndCheckBackToTopElementIsDisplayed() {
        step("Scroll down and check element is visible", () -> {
            mainPage.scrollDownUntilElementIsVisible();
        });
    }

}