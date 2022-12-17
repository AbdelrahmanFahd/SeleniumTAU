package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertsTests extends BaseTests {


    @Test
    public void triggerAlertTest() {
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.clickTriggerAlertButton();
        alertPage.acceptAlert();
        String result = alertPage.getResult();
        assertTrue(result.contains("You successfully clicked an alert"), "Result Message Incorrect");
    }

    @Test
    public void triggerConfirmTest() {
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.clickTriggerConfirmButton();
        String message = alertPage.getAlertText();
        System.out.println(message);
        alertPage.dismissAlert();
        String result = alertPage.getResult();
        assertTrue(result.contains("You clicked: Cancel"), "Result Message Incorrect");
        assertEquals(message,"I am a JS Confirm", "Alert Message Incorrect");
    }

    @Test
    public void triggerPromptTest() {
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.clickTriggerPromptButton();
        String text = "Hello";
        alertPage.setValueToPrompt(text);
        alertPage.acceptAlert();
        String result = alertPage.getResult();
        assertTrue(result.contains("You entered: " + text), "Result Message Incorrect");
    }


}
