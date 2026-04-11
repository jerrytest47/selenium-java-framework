package com.jerrytest.framework.pages;

import com.jerrytest.framework.driver.DriverFactory;
import com.jerrytest.framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    protected void enterText(By locator, String text) {
        WaitUtils.waitForVisibility(locator).clear();
        WaitUtils.waitForVisibility(locator).sendKeys(text);
    }

    protected void click(By locator) {
        WaitUtils.waitForClickable(locator).click();
    }

    protected String getText(By locator) {
        return WaitUtils.waitForVisibility(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        return WaitUtils.waitForVisibility(locator).isDisplayed();
    }
}