package dev.selenium.radio_demo;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import dev.selenium.others.LoginHRM;
import dev.selenium.utils.WaitUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

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
    public void testRadioOne() throws InterruptedException, IOException {
        dev.selenium.others.LoginHRM loginHrm = new LoginHRM();
        loginHrm.login(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");

        driver.manage().window().maximize();

        //Hard Coded wait
//        Thread.sleep(3000);
        //1. Impliict Wait - Wait which is applicable to entire driver instance
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

        //2. Explicit Wait - Wait depending on the condition
        WaitUtils.customExplicitWait(driver, 3, "//input[@type='radio'][@value='2']/..");


        //3. Explicit Wait with Options or Fluent Wait
//        WaitUtils.customFluentWait(driver, 3, 750, "//input[@type='radio'][@value='2']/..");
        WebElement femaleRadio = driver.findElement(By.xpath("//input[@type='radio'][@value='2']/.."));
        femaleRadio.click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); //Implicit wait will be disabled
//        WaitUtils.customFluentWait(driver, 2, 200, "//input[@type='radio'][@value='1']/..");
//        WebElement maleRadio = driver.findElement(By.xpath("//input[@type='radio'][@value='1']/.."));

//        Thread.sleep(3000);
//        maleRadio.click();




        //Take a screenshot
//        customScreenShot(driver,"src/test/resources/screens/TC01_Functionality_ScreenName_URL.png");
//        Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();
        Shutterbug.shootElement(driver, femaleRadio).save();


    }




}