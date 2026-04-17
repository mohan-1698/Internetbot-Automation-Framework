package com.srm.hackathon.internetbot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.internetbot.base.BaseTest;
import com.srm.hackathon.internetbot.pages.*;

public class UploadTest extends BaseTest {

    // 1️⃣ Verify page loaded + form visible
    @Test
    public void testUploadPageUI() {

        HomePage homePage = new HomePage();
        UploadPage uploadPage = homePage.goToUploadPage();

        Assert.assertTrue(uploadPage.getCurrentUrl().contains("/upload"));
        Assert.assertTrue(uploadPage.getTitle().contains("The Internet"));

        Assert.assertTrue(uploadPage.isUploadFieldVisible());
        Assert.assertTrue(uploadPage.isUploadButtonVisible());
    }

    // 2️⃣ Upload valid file
    @Test
    public void testFileUpload() {

        HomePage homePage = new HomePage();
        UploadPage uploadPage = homePage.goToUploadPage();

        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/sample.txt";

        uploadPage.uploadFile(filePath);
        uploadPage.clickUpload();

        Assert.assertTrue(uploadPage.getUploadedFileName().contains("sample.txt"));
    }

    // 3️⃣ Unsupported file (behavior validation)
    @Test
    public void testUnsupportedFileUpload() {

        HomePage homePage = new HomePage();
        UploadPage uploadPage = homePage.goToUploadPage();

        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/sample.bat";

        uploadPage.uploadFile(filePath);
        uploadPage.clickUpload();

        // Site accepts all files → validate behavior
        Assert.assertTrue(uploadPage.getUploadedFileName().contains("sample.bat"));
    }
}