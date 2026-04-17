package com.srm.hackathon.internetbot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.srm.hackathon.internetbot.base.BasePage;

import java.util.List;

public class DropdownPage extends BasePage {

    private By dropdown = By.id("dropdown");

    public void selectOption(String value) {
        selectByVisibleText(dropdown, value);
    }

    public String getSelectedOption() {
        Select select = new Select(waitForElementVisible(dropdown));
        return select.getFirstSelectedOption().getText();
    }

    public int getOptionsCount() {
        Select select = new Select(waitForElementVisible(dropdown));
        List<WebElement> options = select.getOptions();
        return options.size();
    }
}