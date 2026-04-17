package com.srm.hackathon.internetbot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.srm.hackathon.internetbot.base.BasePage;

public class CheckboxPage extends BasePage {

    private By checkbox1 = By.xpath("(//input[@type='checkbox'])[1]");
    private By checkbox2 = By.xpath("(//input[@type='checkbox'])[2]");

    // Toggle checkbox 1
    public void clickCheckbox1() {
        click(checkbox1);
    }

    // Toggle checkbox 2
    public void clickCheckbox2() {
        click(checkbox2);
    }

    public boolean isCheckbox1Selected() {
        return waitForElementVisible(checkbox1).isSelected();
    }

    public boolean isCheckbox2Selected() {
        return waitForElementVisible(checkbox2).isSelected();
    }
}