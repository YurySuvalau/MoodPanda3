package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class RateYourHappinessModal {
    public static final String SLIDER_CSS = ".ui-slider-handle";
    public static final String TEXT_AREA_CSS = "[id='TextBoxUpdateMoodTag']";
    public static final String UPDATE_MOOD_BUTTON_XPATH = "//button[contains(text(),'Update')]";

    public RateYourHappinessModal updateMood(int moodValue, String description) {
        $(TEXT_AREA_CSS).sendKeys(description);
        $(SLIDER_CSS).click();
        Keys direction;
        int defaultMood = 5;
        if (moodValue > defaultMood) {
            direction = Keys.ARROW_RIGHT;
        } else {
            direction = Keys.ARROW_LEFT;
        }
        for (int i = 0; i < Math.abs(moodValue - defaultMood); i++) {
            $(SLIDER_CSS).sendKeys(direction);
        }
        return this;
    }

    public MoodUpdateModal clickUpdateMoodToButton() {
        $(By.xpath(UPDATE_MOOD_BUTTON_XPATH)).click();
        return new MoodUpdateModal();
    }

    public void waitForPageOpen() {
        $(TEXT_AREA_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
