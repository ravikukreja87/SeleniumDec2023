package dev.selenium.file_operations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadSample {


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
    public void testFileUpload() {

        String fileName = "chromedriver.exe";

        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Training2023\\NovWorkspaces\\SeleniumFirstProject\\src\\test\\resources\\" + fileName);
        driver.findElement(By.id("file-submit")).click();


        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        System.out.println("actualFileName = " + actualFileName);
        Assert.assertEquals(actualFileName,fileName);


    }


}
