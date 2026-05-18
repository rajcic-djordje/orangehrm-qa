package org.main.pages;

import org.main.base.BasePage;
import org.main.util.constants.HomePageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = HomePageConstants.TITLE)
    WebElement title;

    public HomePage(WebDriver driver) {

        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public boolean isLoaded() {
        return super.isLoaded(title);
    }
}
