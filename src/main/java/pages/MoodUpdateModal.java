package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class MoodUpdateModal {
    public static final String DONE_BUTTON_XPATH = "//button[contains(text(),'Done')]";

    public FeedPage clickDoneButton() {
        log.info("Click done button ");
        $(By.xpath(DONE_BUTTON_XPATH)).click();
        return new FeedPage();
    }

    public MoodUpdateModal waitForPageOpened() {
        $(By.xpath(DONE_BUTTON_XPATH)).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }
}
