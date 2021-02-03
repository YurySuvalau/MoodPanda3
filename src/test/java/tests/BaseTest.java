package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

abstract class BaseTest {
    MoodUpdateModal moodUpdateModal;
    LoginPage loginPage;
    FeedPage feedPage;
    RateYourHappinessModal rateYourHappinessModal;
    static final String EMAIL = "men@mailinator.com";
    static final String PASSWORD = "12345";

    @BeforeMethod
    public void initTest() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 15000;
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        rateYourHappinessModal = new RateYourHappinessModal();
        moodUpdateModal = new MoodUpdateModal();
    }

    @AfterMethod
    public void closeBrowser() {
        getWebDriver().quit();
    }
}
