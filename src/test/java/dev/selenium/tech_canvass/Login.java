package dev.selenium.tech_canvass;

import dev.selenium.assertions.AssertionsLogin;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Login {

    WebDriver driver;
    //SEAT


    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /*@BeforeTest
    public void setUp() {

        Scanner in = new Scanner(System.in);
        System.out.print("Press 1 for Chrome\nPress 2 for Firefox\nPress 3 for Edge");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                driver = new ChromeDriver();
                break;
            case 2:
                driver = new FirefoxDriver();
                break;
            case 3:
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Please enter correct choice");
        }

        driver.manage().window().maximize();
    }*/

    @Test
    public void testLogin() {
        driver.get("https://techedge.techcanvass.co/Login.aspx");
        AssertionsLogin.assertLogin(driver.getTitle().trim());

        WebElement loginTextBox = driver.findElement(By.id("txtLoginid"));
        loginTextBox.clear();
        loginTextBox.sendKeys("testusername");

        WebElement passwordTextBox = driver.findElement(By.id("txtpassword"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys("wrongpassword");

        driver.findElement(By.id("btnLogin")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        AssertionsLogin.assertAlertText(alertText);
        System.out.println("alertText = " + alertText);
        alert.accept();
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}