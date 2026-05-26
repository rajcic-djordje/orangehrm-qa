package tests;

import base.BaseTest;
import org.main.pages.ForgotPasswordPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.constants.ForgotPasswordTestConstants;

public class ForgotPasswordTest extends BaseTest {

    ForgotPasswordPage forgotPassword;

    @BeforeMethod
    public void beforeForgotPasswordClass() {
        login.isLoaded();
        forgotPassword =login.navigateToForgot();
        forgotPassword.isLoaded();
    }

    @Test
    public void successfulForgotPassword() {

        forgotPassword.completeForgotPassword(ForgotPasswordTestConstants.successfulForgotPassword_USERNAME);

        Assert.assertTrue(forgotPassword.isLoaded());
        Assert.assertEquals(forgotPassword.getReturnMessage(), ForgotPasswordTestConstants.successfulForgotPassword_RETURN_MESSAGE);
    }
}
