package org.main.pages;

import org.main.base.BasePage;
import org.main.util.constants.LoginPageConstants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class LoginPage extends BasePage {

    @FindBy(name = LoginPageConstants.USERNAME_INPUT)
    WebElement username;

    @FindBy(name = LoginPageConstants.PASSWORD_INPUT)
    WebElement password;

    @FindBy(className = LoginPageConstants.LOGIN_BUTTON)
    WebElement loginBtn;

    public LoginPage (WebDriver driver) {

        super(driver);
    }

    public void insertUsername(String user) {

        username.sendKeys(user);
    }

    public void insertPassword(String pass) {

        password.sendKeys(pass);
    }

    public HomePage completeLogin(String user, String pass) {

        insertUsername(user);
        insertPassword(pass);
        loginBtn.sendKeys(Keys.ENTER);

        return new HomePage(getDriver());
    }

    public boolean isLoaded() {
        return super.isLoaded(loginBtn);
    }





}
