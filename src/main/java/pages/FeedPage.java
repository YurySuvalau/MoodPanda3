package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class FeedPage {
    public final static String URL_FEED_PAGE = "https://moodpanda.com/Feed/";
    public final static String UPDATE_MOOD_BUTTON_CSS = "#LinkUpdate";
    public final static String GET_RATING_HAPPINESS_XPATH = "//*[contains(@class,'m1')]//*[contains(text(),'Yury')]/preceding::span[contains(@class,'badge')]";
    public final static String GET_DESCRIPTION_TEXTAREA_TEXT_XPATH = "//*[contains(@class,'m1')]//*[contains(text(),'Yury')]/preceding::*[contains(@class,'MoodPostItem')]";

    public FeedPage waitForPageOpened() {
        log.info("Button Update Mood is visible ");
        $(UPDATE_MOOD_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public RateYourHappinessModal clickOnUpdateMoodButton() {
        log.info("Click on update mood button ");
        $(UPDATE_MOOD_BUTTON_CSS).click();
        return new RateYourHappinessModal();
    }

    public String getTextFromDescription() {
        log.info("Get text from description textarea ");
        return $(URL_FEED_PAGE).$(By.xpath(GET_DESCRIPTION_TEXTAREA_TEXT_XPATH)).getText();
    }

    public String getRate() {
        return $(By.xpath(GET_RATING_HAPPINESS_XPATH)).getText();
    }

    public FeedPage openPage() {
        log.info("Open " + URL_FEED_PAGE);
        open(URL_FEED_PAGE);
        waitForPageOpened();
        return this;
    }


}

