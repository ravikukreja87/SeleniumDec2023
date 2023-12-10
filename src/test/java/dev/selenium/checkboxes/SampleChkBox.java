package dev.selenium.checkboxes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleChkBox {

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
    public void testCheckboxOne() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //Click second check box
        WebElement secondCheckBox = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        WebElement firstCheckBox = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));

        if(!firstCheckBox.isSelected()){
            firstCheckBox.click();
            firstCheckBox.getText();
        } else {
            System.out.println("Check box 1 was already checked");
        }
        if(!secondCheckBox.isSelected()){
            secondCheckBox.click();
        }else {
            System.out.println("Check box 2 was already checked");
        }






    }




}
