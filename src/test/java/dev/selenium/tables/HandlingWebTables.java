package dev.selenium.dropdowns;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingWebTables {


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
    public void testDynamicTables() {
        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement fullTable = driver.findElement(By.id("table1"));
        List<WebElement> tableHeaders = fullTable.findElements(By.xpath("//table[@id='table1']//th/span"));
        for (WebElement header : tableHeaders) {
            System.out.print(header.getText() + "\t\t");
        }

        List<WebElement> tableBodyRows = fullTable.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        System.out.println(tableBodyRows.size());
        for (WebElement bodyRow : tableBodyRows) {
            List<WebElement> cellValueEachRow = bodyRow.findElements(By.xpath("//td"));

            for (WebElement cellValue : cellValueEachRow) {
                System.out.print(cellValue.getText() + "\t\t");
            }
            System.out.println();

        }


    }


}
