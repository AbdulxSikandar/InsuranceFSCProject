package com.asux.actiondriver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import com.asux.config.base;

public class ActionHelper extends base {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    // Constructor to initialize WebDriver and WebDriverWait
    public ActionHelper(WebDriver driver) {
        this.driver = (driver != null) ? driver : base.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Default timeout
        this.actions = new Actions(driver);
    }

    // Click an element
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // Send keys to an element
    public void sendKeys(WebElement element, String text) {
        element.clear(); // Clear existing text
        element.sendKeys(text);
    }

    // Scroll to an element
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Select a value from dropdown by visible text
    public void selectByVisibleText(WebElement element, String text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    // Select a value from dropdown by index
    public void selectByIndex(WebElement element, int index) {
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }

    // Hover over an element
    public void hoverOverElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    // Double-click an element
    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    // Right-click (context click) an element
    public void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }

    public void clickWithJavaScript(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Take a screenshot
    public void takeScreenshot(String filePath) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(srcFile.toPath(), Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Drag and drop an element
    public void dragAndDrop(By sourceLocator, By targetLocator) {
        WebElement source = wait.until(ExpectedConditions.elementToBeClickable(sourceLocator));
        WebElement target = wait.until(ExpectedConditions.elementToBeClickable(targetLocator));
        actions.dragAndDrop(source, target).perform();
    }

    // Get text from an element
    public String getText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    // Check if an element is displayed
    public boolean isElementDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}



