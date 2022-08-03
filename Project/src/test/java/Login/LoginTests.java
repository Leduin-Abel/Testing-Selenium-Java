package Login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;


public class LoginTests extends BaseTests {
    @Test //esta notación le pertmite a TestNG saber que es método para pruebas
    public void testSuccesfulLogin(){
        LoginPage loginPage = homepage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),
                "Something went wrong");

    }
}
