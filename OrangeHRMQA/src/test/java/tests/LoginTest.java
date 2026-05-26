package tests;

import base.BaseTest;
import org.main.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.constants.LoginTestConstants;


public class LoginTest extends BaseTest {


    @BeforeMethod
    public void BeforeLoginClass() {
        login.isLoaded();
    }

    @Test
    public void successfulLogin() {

        HomePage home = login.completeLogin(LoginTestConstants.successfulLogin_USERNAME, LoginTestConstants.successfulLogin_PASSWORD);


        Assert.assertTrue(home.isLoaded());
    }

    @Test
    public void unsuccessfulLogin() {

        login.completeLogin(LoginTestConstants.unsuccessfulLogin_USERNAME, LoginTestConstants.unsuccessfulLogin_PASSWORD);


        Assert.assertTrue(login.isLoaded());
        Assert.assertEquals(login.getAlertMessage(), LoginTestConstants.unsuccessfulLogin_ALERT_MESSAGE);
    }
}
