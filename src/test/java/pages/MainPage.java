package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.Language;
import org.junit.jupiter.params.provider.Arguments;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public static SelenideElement burgerMenuLocator = $("[for=drop-down-cbox]"),
            internetBankButtonLocator = $(".i-internetbank"),
            logoLocator = $(".i-logo"),
            languagePickerLocator = $("#languages"),
            scrollToTopElementLocator = $(".scrollToTop");


    public SelenideElement getTopMenuLanguagePicker() {
        return languagePickerLocator;
    }

    public SelenideElement getInternetBankLoginButton() {
        return internetBankButtonLocator;
    }

    public SelenideElement getTopMenuLogo() {
        return logoLocator;
    }

    public void selectLanguage(String language) {
        if (!getTopMenuLanguagePicker().getText().trim().equals(text(language))
                || !getBurgerMenuElement().isDisplayed()) {
            getTopMenuLanguagePicker().parent().click();
            getTopMenuLanguages().findBy(text(language)).click();
            getTopMenuOptions().first().shouldBe(visible, Duration.ofSeconds(10));
        } else {
            getBurgerMenuElement().click();
            selectLanguageMobile(language);
        }
    }

    private ElementsCollection getMobileTopMenuLanguages() {
        return $$(".mobile-lang a");
    }

    private ElementsCollection getTopMenuOptions() {
        return $$(".root-menu-item a");
    }

    private ElementsCollection getTopMenuLanguages() {
        return $$("[class='dropdown-menu languages'] li a");
    }

    public SelenideElement getBurgerMenuElement() {
        return burgerMenuLocator;
    }

    public void selectLanguageMobile(String language) {
        if (getMobileTopMenuLanguages().findBy(text(language)).isDisplayed()) {
            getMobileTopMenuLanguages().findBy(text(language)).click();
        }
    }

    public void verifyTopMenuOptions(List<String> topMenuButtons) {
        if (!getTopMenuLanguagePicker().isDisplayed()) {
            getBurgerMenuElement().click();
        }
        getTopMenuOptions().filter(visible).shouldHave(texts(topMenuButtons));
    }

    public void scrollDownUntilElementIsVisible() {
        Selenide.executeJavaScript("window.scrollBy(0, 500);");
        scrollToTopElementLocator.shouldBe(visible);
    }

    public SelenideElement getOverdraftSection() {
        return $(".widget-block-11");
    }

    public SelenideElement getOverdraftSectionApplyButton() {
        return getOverdraftSection().$(".widget-btn");
    }

}