package tests;

import base.BaseTest;
import org.main.other.Header;
import org.main.other.Sidebar;
import org.main.pages.HomePage;
import org.main.pages.MyInfoPage;
import org.main.pages.RecruitmentPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SidebarTest extends BaseTest {

    Sidebar sidebar;

    @BeforeMethod
    public void beforeMethod() {

        loginAsDefaultUser();
        home.isLoaded();
        sidebar = new Sidebar(driver);
        sidebar.isLoaded();

    }

    @Test
    public void successfulNavigateToHomePage() {

        HomePage home = sidebar.navigateToHomePage();
        Assert.assertTrue(home.isLoaded());
    }

    @Test
    public void successfulNavigateToMyInfoPage() {

        MyInfoPage myInfo = sidebar.navigateToMyInfoPage();

        Assert.assertTrue(myInfo.isLoaded());
    }

    @Test
    public void successfulNavigateToRecruitmentPage() {

        RecruitmentPage recruitment = sidebar.navigateToRecruitmentPage();

        Assert.assertTrue(recruitment.isLoaded());
    }

    @Test
    public void test() {
        Assert.assertTrue(sidebar.isLoaded());
    }


}
