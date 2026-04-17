package com.srm.hackathon.internetbot.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.srm.hackathon.internetbot.factory.DriverFactory;
import com.srm.hackathon.internetbot.factory.DriverManager;
import com.srm.hackathon.internetbot.utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriver driverInstance = DriverFactory.initDriver();
        DriverManager.setDriver(driverInstance);

        driver = DriverManager.getDriver();

        // ✅ THIS IS THE FIX
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}