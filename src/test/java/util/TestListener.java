package util;

import driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TestListener implements ITestListener {

    public void onTestSuccess(ITestResult iTestResult) {
        String status = "success ";
        saveScreenshot(status);
    }

    public void onTestFailure(ITestResult iTestResult) {
        String status = "failure ";
        saveScreenshot(status);
    }

    private void saveScreenshot(String status){
        File screenCapture = ((TakesScreenshot)DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/" +
                            status +
                            getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException ignored) {}
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }
}
