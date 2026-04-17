package com.srm.hackathon.internetbot.pages;

import org.openqa.selenium.By;
import com.srm.hackathon.internetbot.base.BasePage;

public class HomePage extends BasePage {

    private By formAuthLink = By.xpath("//a[@href='/login']");

    public LoginPage goToLoginPage() {
        click(formAuthLink);
        return new LoginPage();
    }
    
    private By jsAlertLink = By.xpath("//a[@href='/javascript_alerts']");

    public AlertPage goToAlertsPage() {
        click(jsAlertLink);
        return new AlertPage();
    }
}