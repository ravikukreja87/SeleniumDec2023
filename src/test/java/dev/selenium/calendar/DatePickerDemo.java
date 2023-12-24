package dev.selenium.dropdowns;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class DatePickerDemo {


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
    public void testDate() {

        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);

        WebElement date = driver.findElement(By.id("datepicker"));
        date.clear();
        date.sendKeys("12/27/2023" + Keys.ENTER);


    }


}
