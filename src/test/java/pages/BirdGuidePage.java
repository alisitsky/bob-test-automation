package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BirdGuidePage {
    SelenideElement swanSilhouette = $("[data-filter='.shape-lebed']"),
            colorBird = $("[data-filter='.color-white']"),
            birdLink = $("[href*='lebed']");

    public BirdGuidePage openPage() {
        open("/opredelitel-ptic.html");
        return this;
    }

    public BirdGuidePage selectSilhoette() {
        swanSilhouette.click();
        return this;
    }

    public BirdGuidePage selectColour() {
        colorBird.click();
        return this;
    }


    public BirdGuidePage checkLinkBird() {
        birdLink.shouldBe(Condition.visible);
        return this;
    }


    public BirdGuidePage linkBirdClick() {
        birdLink.click();
        return this;
    }
}
