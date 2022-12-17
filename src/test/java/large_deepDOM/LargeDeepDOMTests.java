package large_deepDOM;

import base.BaseTests;
import org.testng.annotations.Test;

public class LargeDeepDOMTests extends BaseTests {

    @Test
    public void testLargeDeep() {
        homePage.clickLargeDeepDOM().scrollToTable();
    }


    @Test
    public void testInfiniteScroll() {
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}
