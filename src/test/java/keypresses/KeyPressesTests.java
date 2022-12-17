package keypresses;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class KeyPressesTests extends BaseTests {


    @Test
    public void testBackSpace() {
        var keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterText("63"+ Keys.BACK_SPACE);
        assertTrue(keyPressesPage.getResult().contains("BACK_SPACE"));

    }

    @Test
    public void testPI() throws InterruptedException {
        var keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterPi();
        Thread.sleep(2000);
        System.out.println(keyPressesPage.getResult());
//        assertTrue(keyPressesPage.getResult().contains("BACK_SPACE"));

    }
}
