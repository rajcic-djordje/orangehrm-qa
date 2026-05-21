package tests;

import base.BaseTest;
import org.main.pages.MyInfoPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.constants.MyInfoTestConstants;


public class MyInfoTest extends BaseTest {

    MyInfoPage myInfo;

    @BeforeMethod
    public void beforeMyInfo() {
        loginAsDefaultUser();
        sidebar.navigateToMyInfoPage();
        myInfo = new MyInfoPage(driver);
        myInfo.isLoaded();
    }

    @Test
    public void successfulFirstNameChange() {

        myInfo.completeFirstNameChange(MyInfoTestConstants.successfulFirstNameChange_USERNAME);

        Assert.assertTrue(myInfo.isLoaded());
        Assert.assertEquals(myInfo.getFistName(),MyInfoTestConstants.successfulFirstNameChange_USERNAME);

    }

    @Test
    public void successfulNationalityChange() {

        myInfo.completeNationalityChange(MyInfoTestConstants.successfulNationalityChange_NATION);

        Assert.assertTrue(myInfo.isLoaded());
        Assert.assertEquals(myInfo.getNationality(),MyInfoTestConstants.successfulNationalityChange_NATION);

    }

    @Test
    public void successfulGenderChange() {
        myInfo.completeGenderChange(MyInfoTestConstants.successfulGenderChange_GENDER);

        Assert.assertTrue(myInfo.isLoaded());
        Assert.assertEquals(myInfo.getGender(),MyInfoTestConstants.successfulGenderChange_GENDER);

    }

    @Test
    public void successfulBirthDateChange() {
        myInfo.completeBirthDateChange(MyInfoTestConstants.successfulBirthDateChange_DATE);

        Assert.assertTrue(myInfo.isLoaded());
        Assert.assertEquals(myInfo.getBirthDate(),MyInfoTestConstants.successfulBirthDateChange_DATE);

    }


}
