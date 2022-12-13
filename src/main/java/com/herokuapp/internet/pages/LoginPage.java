package com.herokuapp.internet.pages;

import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "username")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement loginField;
    @CacheLookup
    @FindBy(xpath = "//h4[@class='subheader']")
    WebElement verifyText;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your username is invalid!')]")
    WebElement errorText;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your password is invalid!')]")
    WebElement errorPassword;

    public void enterUserName(String name) {
        Reporter.log("Enter email "+emailField.toString());
        sendTextToElement(emailField, name);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password "+passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickOnLogin() {
        Reporter.log("click on login "+loginField.toString());
        clickOnElement(loginField);
    }

    public String getTextToVerify() {
        Reporter.log("verify text email login"+verifyText.toString());
        return getTextFromElement(verifyText);
    }

    public String getErrorMessage() {
        Reporter.log("verify error message"+errorText.toString());
        return getTextFromElement(errorText);
    }

    public String getErrorPasswordMessage() {
        Reporter.log("verify error message for password"+errorPassword.toString());
        return getTextFromElement(errorPassword);
    }
}
