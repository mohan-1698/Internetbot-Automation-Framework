package com.srm.hackathon.internetbot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.internetbot.base.BaseTest;
import com.srm.hackathon.internetbot.pages.*;

public class DynamicTest extends BaseTest {

    // 1️⃣ Example 1 - Hidden element appears
    @Test
    public void testExample1DynamicLoading() {

        HomePage homePage = new HomePage();
        DynamicPage dynamicPage = homePage.goToDynamicPage();

        dynamicPage.goToExample1();
        dynamicPage.clickStart();

        Assert.assertTrue(dynamicPage.isLoadingGone());
        Assert.assertTrue(dynamicPage.getLoadedText().contains("Hello World!"));
    }

    // 2️⃣ Example 2 - Element rendered dynamically
    @Test
    public void testExample2DynamicLoading() {

        HomePage homePage = new HomePage();
        DynamicPage dynamicPage = homePage.goToDynamicPage();

        dynamicPage.goToExample2();
        dynamicPage.clickStart();

        Assert.assertTrue(dynamicPage.getLoadedText().contains("Hello World!"));
    }

    // 3️⃣ Refresh behavior test
    @Test
    public void testElementReappearsOnRefresh() {

        HomePage homePage = new HomePage();
        DynamicPage dynamicPage = homePage.goToDynamicPage();

        dynamicPage.goToExample1();
        dynamicPage.clickStart();

        Assert.assertTrue(dynamicPage.getLoadedText().contains("Hello World!"));

        // Refresh
        dynamicPage.refreshPage();

        // After refresh, start button should appear again
        dynamicPage.clickStart();

        Assert.assertTrue(dynamicPage.getLoadedText().contains("Hello World!"));
    }
}