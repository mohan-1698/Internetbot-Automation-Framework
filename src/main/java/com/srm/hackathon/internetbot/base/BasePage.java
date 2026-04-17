package com.srm.hackathon.internetbot.base;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.srm.hackathon.internetbot.factory.DriverManager;
import com.srm.hackathon.internetbot.utils.ConfigReader;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        int timeout = ConfigReader.getInt("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    // -------------------- WAIT METHODS --------------------

    protected WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean waitForElementInvisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // -------------------- ACTION METHODS --------------------

    protected void click(By locator) {
        waitForElementClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForElementVisible(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return waitForElementVisible(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // -------------------- DROPDOWN --------------------

    protected void selectByVisibleText(By locator, String value) {
        WebElement element = waitForElementVisible(locator);
        new org.openqa.selenium.support.ui.Select(element).selectByVisibleText(value);
    }

    // -------------------- ALERT HANDLING --------------------

    protected void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    protected void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    protected void enterAlertText(String text) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
    }

    protected String getAlertText() {
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

    // -------------------- NAVIGATION --------------------

    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}