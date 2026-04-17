package com.srm.hackathon.internetbot.pages;

import org.openqa.selenium.By;
import com.srm.hackathon.internetbot.base.BasePage;

public class SecureAreaPage extends BasePage {

    private By flashMessage = By.id("flash");
    private By logoutBtn = By.xpath("//a[@href='/logout']");

    public String getSuccessMessage() {
        return getText(flashMessage);
    }

    public LoginPage clickLogout() {
        click(logoutBtn);
        return new LoginPage();
    }
}