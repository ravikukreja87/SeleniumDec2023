package dev.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void customFluentWait(WebDriver driver, long timeoutInSeconds, long pollingDuration, String xpathOfElement) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingDuration))
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(NoSuchElementException.class);

        wait.until(d -> {
            driver.findElement(By.xpath(xpathOfElement)).isEnabled();
            return true;
        });
    }

    public static void customExplicitWait(WebDriver driver, long timeoutInSeconds, String xPath) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(d -> driver.findElement(By.xpath(xPath)).isEnabled());
    }
}
