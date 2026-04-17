package com.srm.hackathon.internetbot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.internetbot.base.BaseTest;
import com.srm.hackathon.internetbot.pages.*;

public class AlertTest extends BaseTest {

    // 1️⃣ JS Alert Test
    @Test
    public void testJSAlertAccept() {

        HomePage homePage = new HomePage();
        AlertPage alertPage = homePage.goToAlertsPage();

        alertPage.clickJSAlert();
        alertPage.acceptJSAlert();  // ✅ FIX

        Assert.assertTrue(alertPage.getResult().contains("You successfully clicked an alert"));
    }

    // 2️⃣ JS Confirm Dismiss Test
    @Test
    public void testJSConfirmDismiss() {

        HomePage homePage = new HomePage();
        AlertPage alertPage = homePage.goToAlertsPage();

        alertPage.clickJSConfirm();
        alertPage.dismissJSAlert();  // ✅ FIX

        Assert.assertTrue(alertPage.getResult().contains("You clicked: Cancel"));
    }

    // 3️⃣ JS Prompt Input Test
    @Test
    public void testJSPromptInput() {

        HomePage homePage = new HomePage();
        AlertPage alertPage = homePage.goToAlertsPage();

        alertPage.clickJSPrompt();
        alertPage.enterTextInPrompt("Hello");  // ✅ FIX

        Assert.assertTrue(alertPage.getResult().contains("You entered: Hello"));
    }

    // 4️⃣ Result Reset Test
    @Test
    public void testResultClearsBetweenAlerts() {

        HomePage homePage = new HomePage();
        AlertPage alertPage = homePage.goToAlertsPage();

        // First alert
        alertPage.clickJSAlert();
        alertPage.acceptJSAlert();  // ✅ FIX

        String firstResult = alertPage.getResult();

        // Second alert
        alertPage.clickJSConfirm();
        alertPage.dismissJSAlert();  // ✅ FIX

        String secondResult = alertPage.getResult();

        Assert.assertNotEquals(firstResult, secondResult);
    }
}