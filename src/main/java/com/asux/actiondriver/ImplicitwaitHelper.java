package com.asux.actiondriver;

import org.openqa.selenium.WebDriver;

import com.asux.config.base;

import java.time.Duration;

public class ImplicitwaitHelper extends base {
    public static void setImplicitWait(int timeInSeconds) {
        WebDriver driver = com.asux.config.base.getDriver(); // Get shared driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }
}
