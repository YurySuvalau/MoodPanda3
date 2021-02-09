package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {
    static final String LOGIN_URL = "https://moodpanda.com/Login/";
    public static final String EMAIL_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxEmail";
    public static final String PASSWORD_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxPassword";
    public static final String LOGIN_BUTTON_CSS = "#ContentPlaceHolderContent_ButtonLogin";
    public static final String GOOGLE_PLAY_ICON_CSS = "[alt = 'MoodPanda Android App on Google Play']";

    public FeedPage login(String email, String password) {
        log.info(String.format("Enter email '%s' ", email));
        $(EMAIL_INPUT_CSS).sendKeys(email);
        log.info(String.format("Enter password '%s' ", password));
        $(PASSWORD_INPUT_CSS).sendKeys(password);
        log.info("Click login button ");
        $(LOGIN_BUTTON_CSS).click();
        return new FeedPage();
    }

    public LoginPage openPage() {
        log.info("Open page " + LOGIN_URL);
        open(LOGIN_URL);
        waitForPageOpened();
        return this;
    }

    public LoginPage waitForPageOpened() {
        $(GOOGLE_PLAY_ICON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }
}

