package dev.selenium.checkboxes;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxSampleTwo {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testCheckboxTwo() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {

            if (checkBox.isSelected()) {
                System.out.println("Already checked = " + checkBox.getText());
            } else {
                checkBox.click();
            }
        }
    }
}