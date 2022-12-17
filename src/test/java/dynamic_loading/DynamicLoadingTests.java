package dynamic_loading;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DynamicLoadingTests extends BaseTests {

    @Test
    public void testLoading()  {
        var dynamicLoadingPage = homePage.clickDynamicLoading();
        dynamicLoadingPage.clickExample1();
        dynamicLoadingPage.clickStart();
        assertEquals(dynamicLoadingPage.getTextResult(), "Hello World!", "Result Text is incorrect");
    }

    @Test
    public void testLoadingExample2()   {
        var dynamicLoadingPage = homePage.clickDynamicLoading();
        dynamicLoadingPage.clickExample2();
        dynamicLoadingPage.clickStart2();
        assertEquals(dynamicLoadingPage.getTextResult(), "Hello World!", "Result Text is incorrect");
    }
}
