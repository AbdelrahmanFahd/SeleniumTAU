package Hovers;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoversTests extends BaseTests {

    @Test
    public void TestImageHover() {
        var hoversPage = homePage.clickHovers();
        int index = 2;
        var caption = hoversPage.hoverOverFigure(index);

        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(), "name: user" + index, "Caption Title Incorrect");
        assertEquals(caption.getLinkText(), "View profile", "Caption Link Text Incorrect");
        assertTrue(caption.getLink().endsWith("/users/" + index), "Link Incorrect");
    }
}
