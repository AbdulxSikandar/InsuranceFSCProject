package com.asux.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asux.config.base;
import com.asux.actiondriver.ActionHelper;
import com.asux.actiondriver.ExplicitWaitHelper;

public class ItsmePage extends base {
    private WebDriver driver;
    ExplicitWaitHelper waitHelper;
    private ActionHelper action;

    @FindBy(xpath = "//input[@type='tel']")
    WebElement phoneInputLocator;

    @FindBy(xpath = "//button[@class='btn']")
    WebElement submitButtonLocator;

    // Constructor to initialize 
    public ItsmePage() {
        this.driver = base.getDriver();  // Get shared WebDriver
        this.action = new ActionHelper(this.driver);
        PageFactory.initElements(driver, this);
        this.waitHelper = new ExplicitWaitHelper(driver, 30); // Pass driver as parameter
    }

    // Method to enter phone number and click submit
    public void enterPhoneAndSubmit(String phone) {
        action.sendKeys(phoneInputLocator, phone);
        action.click(submitButtonLocator);
    }
}
