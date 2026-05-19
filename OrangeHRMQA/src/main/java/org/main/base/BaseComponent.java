package org.main.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseComponent {


    WebDriver driver;
    WebDriverWait wait;

    public BaseComponent (WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement explicitWait(WebElement element) {

        return wait.until(ExpectedConditions.visibilityOf(element));
    }



    public boolean isLoaded(WebElement element) {

        return explicitWait(element).isDisplayed();
    }
}
