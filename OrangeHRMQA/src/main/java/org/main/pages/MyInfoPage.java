package org.main.pages;

import org.main.base.BasePage;
import org.main.util.constants.MyInfoPageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyInfoPage extends BasePage {


    @FindBy(className = MyInfoPageConstants.EDIT_NAVIGATION)
    WebElement editNavigation;

    public MyInfoPage(WebDriver driver) {
        super(driver);
    }


    public boolean isLoaded() {

        return isLoaded(editNavigation);
    }
}
