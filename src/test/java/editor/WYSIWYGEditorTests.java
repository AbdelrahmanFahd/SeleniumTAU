package editor;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WYSIWYGEditorTests extends BaseTests {

    @Test
    public void testFrameArea() throws InterruptedException {
        var editorPage = homePage.clickWYSIWYGEditor();
        Thread.sleep(1000);
        editorPage.clearArea();
        editorPage.sendTextToArea("Hello ");
        editorPage.setIncreaseIndent();
        editorPage.sendTextToArea("World");
        assertEquals(editorPage.getTextFromEditor(), "Hello World", "Text is incorrect");
    }

}
