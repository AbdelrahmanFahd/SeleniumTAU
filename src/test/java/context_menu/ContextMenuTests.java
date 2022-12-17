package context_menu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenu() throws InterruptedException {
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickOnSpotBox();

        assertEquals(contextMenuPage.getAlertText(),
                "You selected a context menu",
                "Field To Right Click");
        contextMenuPage.acceptAlert();
        Thread.sleep(2000);
    }
}
