package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdateModal {
    public static final String MODAL_UPDATE_MOOD_LABEL_CSS = "[class='modal-title']";
    public static final String DONE_BUTTON_XPATH = "//button[contains(text(),'Done')]";

    public MoodUpdateModal isModalLabelDisplayed() {
        $(MODAL_UPDATE_MOOD_LABEL_CSS).getText();
        return this;
    }

    public FeedPage clickDoneButton() {
        $(By.xpath(DONE_BUTTON_XPATH)).click();
        return new FeedPage();
    }

    public MoodUpdateModal waitForPageOpened() {
        $(By.xpath(DONE_BUTTON_XPATH)).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }
}
