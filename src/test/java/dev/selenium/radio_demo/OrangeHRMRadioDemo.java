package dev.selenium.radio_demo;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMRadioDemo {

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
    public void testRadioOne() throws InterruptedException{
        LoginHRM loginHrm = new LoginHRM();
        loginHrm.login(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");

        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='radio'][@value='2']/..")).submit();
        driver.findElement(By.xpath("//input[@type='radio'][@value='2']/..")).click();


    }





}
