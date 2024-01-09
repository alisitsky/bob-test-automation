package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.remote = System.getProperty("selenoid", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://bluorbank.lv/");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "120.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    protected static void allowCookiesIfNeeded() {
        if ($("#GDPR-modal").isDisplayed()) {
            $("#allowAllGDPR").click();
        }
    }

    @AfterEach
    void afterEach() {
        Attachments.screenshotAs("Screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
    }

    @AfterAll
    static void close() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}