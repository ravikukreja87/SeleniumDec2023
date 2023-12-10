package dev.selenium.dropdowns;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SauceDemoDD {



    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

/*
    @After
    public void tearDown() {
        driver.quit();
    }
*/

    @Test
    public void testSauceDDOne() {
        driver.get("https://www.saucedemo.com/");
        //Login Code
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input[type='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //DropDown Code
        WebElement productSortContainerDD = driver.findElement(By.xpath("//select[@data-test='product_sort_container']"));
        Select select = new Select(productSortContainerDD);
        select.selectByValue("lohi");

    }
}
