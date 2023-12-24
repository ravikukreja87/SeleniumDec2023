package dev.selenium.drag_drop;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragDropDemo {


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
    public void dragDropDemo() {
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        //Click on source element
        //Drag over destination element

        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement destinationElement = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);


//        actions.dragAndDrop(sourceElement, destinationElement);

//        actions.clickAndHold(sourceElement).moveToElement(destinationElement).release();

        actions.clickAndHold(sourceElement).moveByOffset(120,47).release();

        actions.build().perform();

        String expectedTextOnDestinationElement = "Dropped!";
        String actualTextOnDestinationElement = destinationElement.findElement(By.xpath("//div[@id='droppable']/p")).getText();

        Assert.assertEquals(actualTextOnDestinationElement, expectedTextOnDestinationElement);

        driver.switchTo().defaultContent();




    }
}
