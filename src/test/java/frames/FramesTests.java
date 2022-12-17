package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTests extends BaseTests {

    @Test
    public void testFrame() {

        var framesPage = homePage.clickFrames();
        framesPage.clickNestedFrames();
        assertEquals(framesPage.getTextOfLeftFrame(), "LEFT",
                "Text of left frame is incorrect");
        assertEquals(framesPage.getTextOfBottomFrame(), "BOTTOM",
                "Text of BOTTOM frame is incorrect");


    }

}
