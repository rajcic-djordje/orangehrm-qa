package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @BeforeClass
    public void beforeHomeClass() {
        loginAsDefaultUser();
    }

    @Test
    public void smokeTest() {
        Assert.assertTrue(home.isLoaded());
    }
}
