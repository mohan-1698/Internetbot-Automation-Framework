package com.srm.hackathon.internetbot.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.srm.hackathon.internetbot.factory.DriverManager;
import com.srm.hackathon.internetbot.utils.ExtentManager;
import com.srm.hackathon.internetbot.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private ExtentReports extent = ExtentManager.getExtent();

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentManager.getExtent();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        ExtentManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentManager.getTest().log(Status.FAIL, "Test Failed");

        String path = ScreenshotUtil.captureScreenshot(
                DriverManager.getDriver(),
                result.getMethod().getMethodName()
        );

        ExtentManager.getTest().addScreenCaptureFromPath(path);
        ExtentManager.getTest().fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}