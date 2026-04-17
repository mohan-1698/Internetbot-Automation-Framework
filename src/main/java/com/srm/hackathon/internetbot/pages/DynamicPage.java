package com.srm.hackathon.internetbot.pages;

import org.openqa.selenium.By;
import com.srm.hackathon.internetbot.base.BasePage;

public class DynamicPage extends BasePage {

    private By example1Link = By.xpath("//a[@href='/dynamic_loading/1']");
    private By example2Link = By.xpath("//a[@href='/dynamic_loading/2']");
    private By startBtn = By.xpath("//button[text()='Start']");
    private By loadingText = By.id("loading");
    private By finishText = By.id("finish");

    // -------------------- NAVIGATION --------------------

    public void goToExample1() {
        click(example1Link);
    }

    public void goToExample2() {
        click(example2Link);
    }

    // -------------------- ACTION --------------------

    public void clickStart() {
        click(startBtn);
    }

    // -------------------- VALIDATION --------------------

    public String getLoadedText() {
        return waitForElementVisible(finishText).getText();
    }

    public boolean isLoadingGone() {
        return waitForElementInvisible(loadingText);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}