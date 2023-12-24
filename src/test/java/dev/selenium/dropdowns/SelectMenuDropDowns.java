package dev.selenium.dropdowns;

import com.assertthat.selenium_shutterbug.core.CaptureElement;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import dev.selenium.utils.WaitUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectMenuDropDowns {


    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

/*    @After
    public void tearDown() {
        driver.quit();
    }*/


    //Choose drop down value as Slower

    @Test
    public void selectComplexDropDown() throws InterruptedException {
        driver.get("https://jqueryui.com/selectmenu/#default");
        WebElement frameWebElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        Shutterbug.shootFrame(driver, frameWebElement, CaptureElement.FULL_SCROLL).save();
        driver.switchTo().defaultContent();
        driver.navigate().refresh();
//        driver.navigate().to("https://jqueryui.com/selectmenu/#default");
        WaitUtils.customFluentWait(driver, 3, 1000, "//iframe[@class='demo-frame']");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

//        Shutterbug.shootFrame(driver, frameWebElement, CaptureElement.FULL_SCROLL).save();
        String dropDownValueToChoose = "Slow";
        int counter = 0;

        WebElement selectASpeedDropDown = driver.findElement(By.cssSelector("span[id='speed-button']"));
        String currentValue = null;

        do {
            counter++;

            if (counter < 5) {
                selectASpeedDropDown.sendKeys(Keys.DOWN);
            } else if (counter < 10) {
                selectASpeedDropDown.sendKeys(Keys.UP);
            } else {
                Assert.assertFalse("Cannot find value in DropDown", true);
                break;
            }
            currentValue = selectASpeedDropDown.findElement(By.xpath("//span[@class='ui-selectmenu-text']")).getText();
            System.out.println("currentValue = " + currentValue);
        } while (!currentValue.equals(dropDownValueToChoose));
        driver.switchTo().defaultContent();
    }
}