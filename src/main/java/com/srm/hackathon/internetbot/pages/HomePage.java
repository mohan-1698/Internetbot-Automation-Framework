package com.srm.hackathon.internetbot.pages;

import org.openqa.selenium.By;
import com.srm.hackathon.internetbot.base.BasePage;

public class HomePage extends BasePage {
	
	private By checkboxLink = By.xpath("//a[@href='/checkboxes']");
	private By dropdownLink = By.xpath("//a[@href='/dropdown']");
	private By formAuthLink = By.xpath("//a[@href='/login']");
	private By jsAlertLink = By.xpath("//a[@href='/javascript_alerts']");
	private By uploadLink = By.xpath("//a[@href='/upload']");
	private By dynamicLink = By.xpath("//a[@href='/dynamic_loading']");

    

    public LoginPage goToLoginPage() {
        click(formAuthLink);
        return new LoginPage();
    }

    public AlertPage goToAlertsPage() {
        click(jsAlertLink);
        return new AlertPage();
    }
    
    public CheckboxPage goToCheckboxPage() {
        click(checkboxLink);
        return new CheckboxPage();
    }

    public DropdownPage goToDropdownPage() {
        click(dropdownLink);
        return new DropdownPage();
    }
    
    public UploadPage goToUploadPage() {
        click(uploadLink);
        return new UploadPage();
    }
    
    public DynamicPage goToDynamicPage() {
        click(dynamicLink);
        return new DynamicPage();
    }
}