package dev.selenium.dropdowns;

import dev.selenium.constants.WebConstants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DDExampleOne {


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
    public void testDDOne() throws InterruptedException {


        driver.get(WebConstants.DD_URL);



        WebElement demoFrame = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
        driver.switchTo().frame(demoFrame);


        System.out.println("Switched to the demo Frame");

        Thread.sleep(2000);
        WebElement selectASpeedDropDown = driver.findElement(By.id("speed"));
        driver.switchTo().activeElement();
        Select select = new Select(selectASpeedDropDown); //This is used for Drop Downs in Selenium
        Thread.sleep(2000);
        select.selectByIndex(0);

        WebElement ddLabel = driver.findElement(By.xpath("//label[@for='speed-button']"));
        System.out.println("Label = " + ddLabel.getText());

        driver.switchTo().defaultContent(); //Switch back to main html
        System.out.println("Switched back to default html from inner demo frame");




    }


}
