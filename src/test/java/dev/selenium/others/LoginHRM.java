package dev.selenium.others;

import dev.selenium.utils.WaitUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class LoginHRM {


    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public  void readProperties() throws IOException {
        Properties properties = new Properties();

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/user.properties");
        properties.load(fileInputStream);
        fileInputStream.close();



        setUsername(properties.getProperty("username"));
        setPassword(properties.getProperty("password"));

    }

    public void login(WebDriver driver) throws InterruptedException, IOException {
        readProperties();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WaitUtils.customFluentWait(driver, 3, 500, "//button[@type='submit']" );
        driver.findElement(By.name("username")).sendKeys(getUsername());
        driver.findElement(By.name("password")).sendKeys(getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
    @Test
    public void login() throws InterruptedException, IOException {
        readProperties();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WaitUtils.customFluentWait(driver, 3, 500, "//button[@type='submit']");
        driver.findElement(By.name("username")).sendKeys(getUsername());
        driver.findElement(By.name("password")).sendKeys(getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WaitUtils.customFluentWait(driver,5,1000,"//h6");
        assertLoginPage();
    }

    private void assertLoginPage() {
        String actualResult = driver.findElement(By.xpath("//h6")).getText();
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult,expectedResult);
    }

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

/*    @After
    public void tearDown() {
        driver.quit();
    }*/



}
