package navigation;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTests {

    @Test
    public void testSwitch() {
        homePage.clickMultipleWindows().clickHere();
        getWindowManger().switchToTab("New Window");

    }

    @Test
    public void testSwitchDynamic() {
        var dynamicLoadingPage = homePage.clickDynamicLoading();
        dynamicLoadingPage.example2Button.sendKeys(Keys.CONTROL,Keys.RETURN);
        getWindowManger().switchToNewTab();
        assertTrue(dynamicLoadingPage.startButton.isEnabled(),"Button is still Disable");
    }
}
