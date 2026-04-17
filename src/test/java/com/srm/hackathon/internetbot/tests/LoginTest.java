package com.srm.hackathon.internetbot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.internetbot.base.BaseTest;
import com.srm.hackathon.internetbot.pages.*;
import com.srm.hackathon.internetbot.utils.ConfigReader;

public class LoginTest extends BaseTest {

    // 1️⃣ Valid Login Test
    @Test
    public void testValidLogin() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();

        SecureAreaPage securePage = loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        String successMsg = securePage.getSuccessMessage();
        Assert.assertTrue(successMsg.contains("You logged into a secure area!"));
    }

    // 2️⃣ Invalid Login Test
    @Test
    public void testInvalidLogin() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();

        loginPage.login("wronguser", "wrongpass");

        String errorMsg = loginPage.getFlashMessage();
        Assert.assertTrue(errorMsg.contains("Your username is invalid!"));
    }

    // 3️⃣ Logout Functionality Test
    @Test
    public void testLogoutMessage() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();

        SecureAreaPage securePage = loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        LoginPage backToLogin = securePage.clickLogout();

        String logoutMsg = backToLogin.getFlashMessage();
        Assert.assertTrue(logoutMsg.contains("You logged out of the secure area!"));
    }

    // 4️ Logout Redirect Test
    @Test
    public void testLogoutRedirect() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();

        SecureAreaPage securePage = loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        LoginPage backToLogin = securePage.clickLogout();

        Assert.assertTrue(backToLogin.getCurrentUrl().contains("/login"));
    }
}