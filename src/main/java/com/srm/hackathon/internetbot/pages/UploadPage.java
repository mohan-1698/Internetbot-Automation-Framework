package com.srm.hackathon.internetbot.pages;

import org.openqa.selenium.By;
import com.srm.hackathon.internetbot.base.BasePage;

public class UploadPage extends BasePage {

    private By fileInput = By.id("file-upload");
    private By uploadBtn = By.id("file-submit");
    private By uploadedFileText = By.id("uploaded-files");

    // -------------------- ACTIONS --------------------

    // Upload file
    public void uploadFile(String filePath) {
        type(fileInput, filePath);
    }

    // Click upload
    public void clickUpload() {
        click(uploadBtn);
    }

    // -------------------- VALIDATIONS --------------------

    // Get uploaded file name
    public String getUploadedFileName() {
        return getText(uploadedFileText);
    }

    // Check if upload field is visible
    public boolean isUploadFieldVisible() {
        return isDisplayed(fileInput);
    }

    // Check if upload button is visible
    public boolean isUploadButtonVisible() {
        return isDisplayed(uploadBtn);
    }
}