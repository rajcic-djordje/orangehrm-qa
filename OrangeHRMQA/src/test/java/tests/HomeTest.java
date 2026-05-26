package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @BeforeMethod
    public void beforeHome() {
        loginAsDefaultUser();
    }

    @Test
    public void smokeTest() {
        Assert.assertTrue(home.isLoaded());
    }
}
