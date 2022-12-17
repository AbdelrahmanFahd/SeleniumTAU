package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {


    @Test
    public void testSuccessFullLogin() {
        LoginPage loginPage = homePage.clickOnFormAuth();

        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        System.out.println();
        assertEquals(secureAreaPage.getMessage(),
                "You logged into a secure area!\n" + "×",
                "Alert text is incorrect");

    }

}
