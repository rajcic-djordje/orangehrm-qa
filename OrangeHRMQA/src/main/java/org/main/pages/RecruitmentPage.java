package org.main.pages;

import org.main.base.BasePage;
import org.main.util.constants.RecruitmentPageConstants;
import org.main.util.constants.TagNameConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentPage extends BasePage {


    @FindBy(tagName = TagNameConstants.TAG_H5)
    WebElement title;

    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }


    public boolean isLoaded() {
        if(isLoaded(title))
            return title.getText().equals(RecruitmentPageConstants.TITLE);

        return false;
    }
}
