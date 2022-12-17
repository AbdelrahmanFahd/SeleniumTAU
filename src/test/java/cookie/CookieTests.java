package cookie;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class CookieTests extends BaseTests {


    @Test
    public void testCookie() {
        String cookieName = "optimizelyBuckets";
        deleteCookie(cookieName);

        assertFalse(cookieExist(cookieName), "Cookie still Exist");
    }


}
