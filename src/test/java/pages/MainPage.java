package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement burgerMenuLocator = $("[for=drop-down-cbox]"),
            internetBankButtonLocator = $(".i-internetbank"),
            logoLocator = $(".i-logo"),
            languagePickerLocator = $("#languages"),
            scrollToTopElementLocator = $(".scrollToTop"),
            overdraftSectionLocator = $(".widget-block-11");

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
        if (!TestBase.isMobile()) {
            if (!getTopMenuLanguagePicker().getText().equals(language)) {
                getTopMenuLanguagePicker().parent().click();
                getTopMenuLanguages().findBy(text(language)).click();
                Selenide.sleep(5000);
            }
        } else {
            getBurgerMenuElement().shouldBe(visible).click();
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

    private SelenideElement getBurgerMenuElement() {
        return burgerMenuLocator;
    }

    public void selectLanguageMobile(String language) {
        if (getMobileTopMenuLanguages().findBy(text(language)).isDisplayed()) {
            getMobileTopMenuLanguages().findBy(text(language)).click();
        }
    }

    public void verifyTopMenuOptions(List<String> topMenuButtons) {
        if (getBurgerMenuElement().isDisplayed()) {
            getBurgerMenuElement().click();
        }
        getTopMenuOptions().filter(visible).shouldHave(texts(topMenuButtons));
    }

    public void scrollDownUntilElementIsVisible() {
        Selenide.executeJavaScript("window.scrollBy(0, 500);");
        scrollToTopElementLocator.shouldBe(visible);
    }

    private SelenideElement getOverdraftSection() {
        return overdraftSectionLocator;
    }

    public SelenideElement getOverdraftSectionApplyButton() {
        return getOverdraftSection().$(".widget-btn");
    }

}