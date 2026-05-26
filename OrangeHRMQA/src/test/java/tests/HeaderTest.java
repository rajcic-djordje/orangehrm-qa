package tests;

import base.BaseTest;
import org.main.other.Header;
import org.main.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

    Header header;

    @BeforeMethod
    public void beforeSuite() {

        loginAsDefaultUser();
        home.isLoaded();
        header = new Header(driver);

    }

    @Test
    public void successfulLogout() {

        LoginPage login = header.logOut();

        Assert.assertTrue(login.isLoaded());
    }


}
