package dev.selenium.dropdowns;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AutoSuggest {


    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

/*    @After
    public void tearDown() {
        driver.quit();
    }*/

    @Test
    public void testAutoSuggest() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("selenium");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@role='listbox']")));


        String expectedItem = "selenium webdriver1";


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='option']/div[1]")));
        List<WebElement> allOptions = driver.findElements(By.xpath("//div[@role='option']/div[1]"));
        boolean condition = false;
        for(WebElement eachOption : allOptions){
            System.out.println(eachOption.getText());
            if(eachOption.getText().equals(expectedItem)){
                Assert.assertTrue(true, expectedItem + " not found in list of auto suggestions");
                condition = true;
                break;
            }
        }
        if(!condition){
           Assert.assertFalse(true, expectedItem + " not found in list of auto suggestions");
        }

    }


}
