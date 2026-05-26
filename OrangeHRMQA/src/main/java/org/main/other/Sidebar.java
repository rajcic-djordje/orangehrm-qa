package org.main.other;

import org.main.base.BaseComponent;
import org.main.pages.HomePage;
import org.main.pages.MyInfoPage;
import org.main.pages.RecruitmentPage;
import org.main.util.constants.TagNameConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Sidebar extends BaseComponent {



    @FindBy(tagName = TagNameConstants.TAG_LI)
    List<WebElement> sidebarItems;

    public Sidebar(WebDriver driver) {

        super(driver);
    }


    public MyInfoPage navigateToMyInfoPage() {
        sidebarItems.get(5).click();

        return new MyInfoPage(getDriver());
    }


    public HomePage navigateToHomePage() {
        sidebarItems.get(8).click();

        return new HomePage(getDriver());
    }

    public RecruitmentPage navigateToRecruitmentPage() {
        sidebarItems.get(4).click();

        return new RecruitmentPage(getDriver());
    }

    public boolean isLoaded() {

        return isLoaded(sidebarItems.getFirst());
    }

}
