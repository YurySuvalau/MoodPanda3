package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FeedPage {
    public final static String URL_FEED_PAGE = "https://moodpanda.com/Feed/";
    public final static String UPDATE_MOOD_BUTTON_CSS = "#LinkUpdate";
    public final static String GET_RATING_HAPPINESS_XPATH = "//*[contains(@class,'m1')]//span[contains(@class,'badge')]";
    public final static String GET_DESCRIPTION_TEXTAREA_TEXT_XPATH = "//*[contains(@class,'m1')]/../../..//*[contains(@class,'MoodPostItem')]";

    public FeedPage waitForPageOpened() {
        $(UPDATE_MOOD_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public RateYourHappinessModal clickOnUpdateMoodButton() {
        $(UPDATE_MOOD_BUTTON_CSS).click();
        return new RateYourHappinessModal();
    }

    public String getTextFromDescription() {
        return $(By.xpath(GET_DESCRIPTION_TEXTAREA_TEXT_XPATH)).getText();
    }

    public String getRate() {
        return $(By.xpath(GET_RATING_HAPPINESS_XPATH)).getText();
    }

    public FeedPage openPage() {
        open(URL_FEED_PAGE);
        waitForPageOpened();
        return this;
    }
}

