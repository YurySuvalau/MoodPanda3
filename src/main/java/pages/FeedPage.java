package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {
    public final static String URL_FEED_PAGE = "https://moodpanda.com/Feed/";
    public final static String UPDATE_MOOD_BUTTON_CSS = "#LinkUpdate";
    public final static String GET_RATING_HAPPINESS = "//*[contains(@class,'p7670318')and contains(@class,'m1')]//span[contains(@class,'badge')]";
    public final static String GET_DESCRIPTION_TEXTAREA_TEXT = "//*[contains(@class,'p7670318 ')and contains(@class, 'm1')]//*[contains(@class,'MoodPostItem')]";

    public FeedPage waitForPageOpen() {
        $(UPDATE_MOOD_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public RateYourHappinessModal clickOnUpdateMoodButton() {
        $(UPDATE_MOOD_BUTTON_CSS).click();
        return new RateYourHappinessModal();
    }


    public String getTextFromDescription() {
        return $(By.xpath(GET_DESCRIPTION_TEXTAREA_TEXT)).getText();
    }

    public String getRate() {
        return $(By.xpath(GET_RATING_HAPPINESS)).getText();
    }

    public FeedPage refreshPage() {
        $(URL_FEED_PAGE).sendKeys(Keys.F5);
        return this;
    }
}
