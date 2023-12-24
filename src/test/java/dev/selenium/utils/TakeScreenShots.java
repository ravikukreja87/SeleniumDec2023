package dev.selenium.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TakeScreenShots {


    public static void customScreenShot(Object driver, String pathWithFileName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenShotFile = screenshot.getScreenshotAs(OutputType.FILE);

        File saveToFile = new File(pathWithFileName);

        FileUtils.copyFile(screenShotFile, saveToFile);
    }

}
