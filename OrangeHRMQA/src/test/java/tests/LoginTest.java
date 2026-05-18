package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {


    @Test
    public void smokeTest() {
        Assert.assertTrue(login.isLoaded());
    }
}
