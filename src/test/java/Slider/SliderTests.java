package Slider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SliderTests extends BaseTests {

    @Test
    public void TestSlider() {

        var slider = homePage.clickHorizontalSlider();
        slider.moveSlider("4");
        assertEquals(slider.getText(),"4","Slider not shifting enough :"+slider.getText());
    }
}
