package org.main.pages;

import org.main.base.BasePage;
import org.main.util.constants.ForgotPasswordPageConstants;
import org.main.util.constants.TagNameConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(className = ForgotPasswordPageConstants.FORGOT_PASSWORD_PAGE)
    WebElement pageContainer;

    @FindBy(name = ForgotPasswordPageConstants.FORGOT_PASSWORD_USERNAME)
    WebElement username;

    @FindBy(className = ForgotPasswordPageConstants.FORGOT_PASSWORD_RETURN_CONTAINER)
    WebElement returnPageContainer;


    public ForgotPasswordPage(WebDriver driver) {

        super(driver);
    }

    public void insertUsername(String user) {

        username.sendKeys(user);
    }

    public void completeForgotPassword(String user) {

        insertUsername(user);
        WebElement forgotBtn = (explicitWait(pageContainer).findElements(By.tagName(TagNameConstants.TAG_BUTTON))).getLast();
        forgotBtn.click();

    }

    public String getReturnMessage() {

        WebElement returnMessage = explicitWait(returnPageContainer).findElement(By.tagName(TagNameConstants.TAG_H6));
        return returnMessage.getText();
    }


    public boolean isLoaded() {

        return isLoaded(pageContainer);
    }



}
