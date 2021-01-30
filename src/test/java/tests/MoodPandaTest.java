package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    @Test(invocationCount = 2)
    public void loginTest() {
        loginPage.openPage()
                .login(EMAIL, PASSWORD)
                .waitForPageOpen()
                .clickOnUpdateMoodButton()
                .waitForPageOpen();
        rateYourHappinessModal.updateMood(8, "HELLO!")
                .clickUpdateMoodToButton()
                .waitForPageOpen();
        moodUpdateModal.waitForPageOpen()
                .clickDoneButton();
        feedPage.waitForPageOpen();
        Assert.assertEquals(feedPage.getTextFromDescription(), "HELLO!");
        Assert.assertEquals(feedPage.getRate(), "8");
    }
}
