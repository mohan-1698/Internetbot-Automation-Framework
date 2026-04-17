package com.srm.hackathon.internetbot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.internetbot.base.BaseTest;
import com.srm.hackathon.internetbot.pages.*;

public class CheckboxTest extends BaseTest {

    // 1️⃣ Checkbox 1 toggle test
    @Test
    public void testCheckbox1Toggle() {

        HomePage homePage = new HomePage();
        CheckboxPage checkboxPage = homePage.goToCheckboxPage();

        checkboxPage.clickCheckbox1();
        Assert.assertTrue(checkboxPage.isCheckbox1Selected());

        checkboxPage.clickCheckbox1();
        Assert.assertFalse(checkboxPage.isCheckbox1Selected());
    }

    // 2️⃣ Checkbox 2 toggle test
    @Test
    public void testCheckbox2Toggle() {

        HomePage homePage = new HomePage();
        CheckboxPage checkboxPage = homePage.goToCheckboxPage();

        boolean initialState = checkboxPage.isCheckbox2Selected();

        checkboxPage.clickCheckbox2();

        Assert.assertNotEquals(checkboxPage.isCheckbox2Selected(), initialState);
    }
}