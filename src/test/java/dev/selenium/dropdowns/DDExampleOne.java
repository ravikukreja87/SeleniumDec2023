package dev.selenium.dropdowns;

import dev.selenium.constants.WebConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

        String valueToSelect = "Slow";
        int counter = 0;

        WebElement dropDown = driver.findElement(By.id("speed-button"));
        Assert.assertTrue(dropDown.isDisplayed());
        String selectedValueStr = null;

        do {
            counter++;
            if (counter < 5) dropDown.sendKeys(Keys.DOWN);
            else if (counter < 10) dropDown.sendKeys(Keys.UP);
            else {
                Assert.assertFalse("Expected DD Value Not Found", true);
                break;
            }

            WebElement selectedValue = dropDown.findElement(By.xpath("//span[@class='ui-selectmenu-text']"));
            selectedValueStr = selectedValue.getText();
            System.out.println(selectedValueStr);
        } while (!selectedValueStr.equals(valueToSelect));
        driver.switchTo().defaultContent(); //Switch back to main html
        System.out.println("Switched back to default html from inner demo frame");
    }
}