package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert(){
        var alertsPage = homepage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAcceptAlert();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Text is wrong");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homepage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text,"I am a JS Confirm", "Wrong text");

    }

    @Test
    public void testSetInputAlert(){
        var alertsPage = homepage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "No lo se";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAcceptAlert();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "fallaste");
    }
}
