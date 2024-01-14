package tests.overdraft_section;

import data.Language;
import data.RunTags;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.TestBase;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

@Tag(RunTags.MAIN)
public class OverdraftSectionTest extends TestBase {

    public static Stream<Arguments> getOverdraftSectionApplyButton() {
        return Stream.of(
                Arguments.of(Language.EN, "Apply now", "/en/business-loans_#aizdevuma_pieteikums"),
                Arguments.of(Language.LV, "Pieteikties", "/lv/aizdevumi-biznesam#aizdevuma_pieteikums"),
                Arguments.of(Language.RU, "Подать заявку", "/ru/kredity-dlya-predpriyatij#aizdevuma_pieteikums")
        );
    }

    @MethodSource("getOverdraftSectionApplyButton")
    @ParameterizedTest(name = "Set language {0} and check overdraft apply button name is {1} and href is {2}")
    void checkTopMenuOptionsInAnyLanguage(Language language, String name, String href) {
        step("Select language", () -> {
            mainPage.selectLanguage(language.getLanguage());
        });
        step("Verify top apply button", () -> {
            mainPage.getOverdraftSectionApplyButton().shouldHave(text(name));
            mainPage.getOverdraftSectionApplyButton().getAttribute("href").equals(href);
        });
    }
}
