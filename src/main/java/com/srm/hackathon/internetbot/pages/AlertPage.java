package com.srm.hackathon.internetbot.pages;

import org.openqa.selenium.By;
import com.srm.hackathon.internetbot.base.BasePage;

public class AlertPage extends BasePage {

    private By jsAlertBtn = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmBtn = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptBtn = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result");

    // -------------------- CLICK ACTIONS --------------------

    public void clickJSAlert() {
        click(jsAlertBtn);
    }

    public void clickJSConfirm() {
        click(jsConfirmBtn);
    }

    public void clickJSPrompt() {
        click(jsPromptBtn);
    }

    // -------------------- ALERT HANDLING (WRAPPERS) --------------------

    public void acceptJSAlert() {
        acceptAlert();
    }

    public void dismissJSAlert() {
        dismissAlert();
    }

    public void enterTextInPrompt(String text) {
        enterAlertText(text);
    }

    public String getAlertMessage() {
        return getAlertText();
    }

    // -------------------- RESULT --------------------

    public String getResult() {
        return getText(resultText);
    }
}