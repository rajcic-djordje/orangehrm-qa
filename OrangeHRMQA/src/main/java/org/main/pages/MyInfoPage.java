package org.main.pages;

import org.main.base.BasePage;
import org.main.util.constants.MyInfoPageConstants;
import org.main.util.constants.TagNameConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyInfoPage extends BasePage {


    @FindBy(className = MyInfoPageConstants.EDIT_NAVIGATION)
    WebElement editNavigation;

    @FindBy(name = MyInfoPageConstants.FIRST_NAME)
    WebElement firstNameInput;

    @FindBy(className = MyInfoPageConstants.FORM_ROW)
    List<WebElement> formRows;

    @FindBy(className = MyInfoPageConstants.SELECT_DROPDOWN)
    WebElement selectDropDown;

    @FindBy(className = MyInfoPageConstants.FORM_ACTIONS)
    List<WebElement> formActionFields;

    @FindBy(className = MyInfoPageConstants.FORM_LOADER)
    WebElement formLoader;

    @FindBy(className = MyInfoPageConstants.NATIONALITY_SELECT_TEXT )
    WebElement nationalityText;

    @FindBy(className = MyInfoPageConstants.GENDER_INPUT_FIELD)
    WebElement genderInputField;


    public MyInfoPage(WebDriver driver) {
        super(driver);
    }


    public void insertFirstName(String input) {

        explicitWaitInvisibility(formLoader);
        firstNameInput.sendKeys(Keys.CONTROL + MyInfoPageConstants.CLEAR_CONTROL_INPUT);
        firstNameInput.sendKeys(Keys.BACK_SPACE);
        firstNameInput.sendKeys(input);
    }

    public void completeFirstNameChange(String input) {

        insertFirstName(input);
        completePersonalInfo();
        driver.navigate().refresh();
    }

    public void changeNationality(String nation) {

        explicitWaitInvisibility(formLoader);

        WebElement selectElement = formRows.get(2).findElement(By.className(MyInfoPageConstants.SELECT_ELEMENT));

        WebElement dropDownBtn = selectElement.findElement(By.tagName(TagNameConstants.TAG_I));

        if(dropDownBtn.isDisplayed()) dropDownBtn.click();

        selectDropDown = explicitWait(selectDropDown);


        if(!selectDropDown.isDisplayed()) return;


        WebElement option = selectDropDown.findElement( By.xpath(MyInfoPageConstants.OPTION_XPATH_1+nation+MyInfoPageConstants.OPTION_XPATH_2));

        jse.executeScript(MyInfoPageConstants.JSE_SCROLL_INTO_VIEW, option);

        if(option.isDisplayed()) option.click();


    }

    public void completeNationalityChange(String nation) {
        changeNationality(nation);
        completePersonalInfo();
        driver.navigate().refresh();
    }

    public void changeDateOfBirth(String newDate) {

        explicitWaitInvisibility(formLoader);
        WebElement dateInputField = formRows.get(2).findElement(By.xpath(MyInfoPageConstants.DATE_INPUT_FIELD));

        dateInputField.sendKeys(Keys.CONTROL + MyInfoPageConstants.CLEAR_CONTROL_INPUT);
        dateInputField.sendKeys(Keys.BACK_SPACE);
        dateInputField.sendKeys(newDate);
    }

    public void completeBirthDateChange(String newDate) {
        changeDateOfBirth(newDate);
        completePersonalInfo();
        driver.navigate().refresh();
    }

    public void changeGender(String gen) {

        explicitWaitInvisibility(formLoader);
        List<WebElement> genderOptions = genderInputField.findElements(By.className(MyInfoPageConstants.INPUT_GROUP));

        for(WebElement e: genderOptions) {

            WebElement label = e.findElement(By.tagName(TagNameConstants.TAG_LABEL));
            if(label.getText().equals(gen)) {


                label.findElement(By.tagName(TagNameConstants.TAG_SPAN)).click();
            }


        }
    }

    public void completeGenderChange(String gen) {
        changeGender(gen);
        completePersonalInfo();
        driver.navigate().refresh();
    }


    public void completePersonalInfo() {

        explicitWaitInvisibility(formLoader);
        explicitWaitClickable(explicitWait(formActionFields.getFirst().findElement(By.cssSelector(MyInfoPageConstants.SUBMIT_ATTRIBUTE)))).click();
    }

    public String getFistName() {
        explicitWaitInvisibility(formLoader);
        return firstNameInput.getAttribute(MyInfoPageConstants.VALUE_ATTRIBUTE);
    }

    public String getNationality() {
        explicitWaitInvisibility(formLoader);
        return nationalityText.getText();

    }

    public String getGender() {
        explicitWaitInvisibility(formLoader);

        List<WebElement> genderLabels = formRows.get(2).findElements(By.xpath(MyInfoPageConstants.GENDER_RADIO_XPATH));

        for (WebElement genderLabel : genderLabels) {

            WebElement radio = genderLabel.findElement(By.tagName(TagNameConstants.TAG_INPUT));
            if (radio.isSelected())

                return genderLabel.getText();
        }

        return null;

    }

    public String getBirthDate() {
        explicitWaitInvisibility(formLoader);

        WebElement dateInputField = formRows.get(2).findElement(By.xpath(MyInfoPageConstants.DATE_INPUT_FIELD));

        return dateInputField.getAttribute(MyInfoPageConstants.VALUE_ATTRIBUTE);
    }

    public boolean isLoaded() {

        return isLoaded(editNavigation);
    }
}
