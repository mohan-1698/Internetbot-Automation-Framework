package com.srm.hackathon.internetbot.pages;

import org.openqa.selenium.By;
import com.srm.hackathon.internetbot.base.BasePage;

public class LoginPage extends BasePage {

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginBtn);
    }

    public SecureAreaPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new SecureAreaPage();
    }

    public String getFlashMessage() {
        return getText(flashMessage);
    }
}