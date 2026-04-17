package com.srm.hackathon.internetbot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.internetbot.base.BaseTest;
import com.srm.hackathon.internetbot.pages.*;

public class DropdownTest extends BaseTest {

    // 1️⃣ Select Option 1
    @Test
    public void testSelectOption1() {

        HomePage homePage = new HomePage();
        DropdownPage dropdownPage = homePage.goToDropdownPage();

        dropdownPage.selectOption("Option 1");

        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 1");
    }

    // 2️⃣ Select Option 2
    @Test
    public void testSelectOption2() {

        HomePage homePage = new HomePage();
        DropdownPage dropdownPage = homePage.goToDropdownPage();

        dropdownPage.selectOption("Option 2");

        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 2");
    }

    // 3️⃣ Verify dropdown options count
    @Test
    public void testDropdownOptionsCount() {

        HomePage homePage = new HomePage();
        DropdownPage dropdownPage = homePage.goToDropdownPage();

        Assert.assertEquals(dropdownPage.getOptionsCount(), 3);
    }
}