package dev.selenium.others;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {



    @Test
    public void googleSearchTest(){
        //1. Initialized driver instance with ChromeDriver
        WebDriver driver = new ChromeDriver();

        //2. Navigated to google home page
        driver.get("https://www.google.com/");

        //Locate the search box.
        //Location/Address as a WebElement
        String searchTerm = "Testing is fun";

        //Find element - Search Box
        WebElement searchBox = driver.findElement(By.name("q"));

        //Entered search term into search box
        searchBox.sendKeys(searchTerm);

        //Find out webelement search button
        WebElement googleSearchButton = driver.findElement(By.name("btnK"));

        //Submit the search button
        googleSearchButton.submit();

        //From results page het the title of the page
        String pageTitle = driver.getTitle();
        System.out.println("pageTitle = " + pageTitle);

        Assert.assertTrue(pageTitle.contains(searchTerm + "more"));

        driver.close();
        driver.quit();

    }


}
