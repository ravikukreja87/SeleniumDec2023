package dev.selenium.dropdowns;

import dev.selenium.others.LoginHRM;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class MouseHover {


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
    public void testMouseHover() throws InterruptedException, IOException {

        LoginHRM loginHrm = new LoginHRM();
        loginHrm.login(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");

        driver.manage().window().maximize();
        Thread.sleep(3000);

        WebElement helpButton = driver.findElement(By.xpath("//button[@title='Help']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(helpButton);
        actions.build().perform();
        Thread.sleep(3000);
        String text = helpButton.getAttribute("title");
        System.out.println("Hover Text = " + text);

    }


}
