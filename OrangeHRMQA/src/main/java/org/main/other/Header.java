package org.main.other;

import org.main.base.BaseComponent;
import org.main.pages.LoginPage;
import org.main.util.constants.HeaderConstants;
import org.main.util.constants.TagNameConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BaseComponent {



    @FindBy(className = HeaderConstants.USER_DROPDOWN)
    WebElement userDropDown;

    @FindBy(className = HeaderConstants.DROPDOWN_MENU)
    WebElement dropDownMenu;

    public Header(WebDriver driver) {
        super(driver);
    }


    public LoginPage logOut() {

        userDropDown.click();

        dropDownMenu = explicitWait(dropDownMenu);

        if(dropDownMenu.isDisplayed()) {

            dropDownMenu.findElements(By.tagName(TagNameConstants.TAG_LI)).getLast().click();

            return new LoginPage(getDriver());
        }

        return null;

    }

    public boolean isLoaded() {

        WebElement el = explicitWait(userDropDown);

        return el.isDisplayed();
    }
}
