package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    @Test(invocationCount = 1)
    public void loginTest() {
        loginPage.openPage()
                .login(EMAIL, PASSWORD)
                .waitForPageOpened()
                .clickOnUpdateMoodButton()
                .waitForPageOpen()
                .updateMood(8, "HELLO!")
                .clickUpdateMoodToButton()
                .waitForPageOpened()
                .clickDoneButton()
                .waitForPageOpened();
        Assert.assertEquals(feedPage.getTextFromDescription(), "HELLO!");
        Assert.assertEquals(feedPage.getRate(), "8");
    }
}
