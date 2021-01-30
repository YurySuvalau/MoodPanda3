package pages;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    static final String LOGIN_URL = "https://moodpanda.com/Login/";
    public static final String EMAIL_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxEmail";
    public static final String PASSWORD_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxPassword";
    public static final String LOGIN_BUTTON_CSS = "#ContentPlaceHolderContent_ButtonLogin";
    public static final String GOOGLE_PLAY_ICON_CSS = "[alt = 'MoodPanda Android App on Google Play']";

    public FeedPage login(String email, String password) {
        $(EMAIL_INPUT_CSS).sendKeys(email);
        $(PASSWORD_INPUT_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
        return new FeedPage();
    }

    public LoginPage openPage() {
        open(LOGIN_URL);
        waitForPageOpen();
        return this;
    }

    public LoginPage waitForPageOpen() {
        $(GOOGLE_PLAY_ICON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }
}

