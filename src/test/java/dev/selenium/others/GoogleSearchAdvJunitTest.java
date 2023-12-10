package dev.selenium.others;

import junit.framework.Assert;
import org.junit.AfterClass;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchAdvJunitTest {

    //SEAT
    static WebDriver driver;
    String searchTerm = "Testing is fun second";

    //Setup
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
    }


    //Execute
    @Test
    public void testGoogleSearchAgain() {
        driver.get("https://www.google.com/");

        //Locate the search box.
        //Location/Address as a WebElement


        //Find element - Search Box
        WebElement searchBox = driver.findElement(By.name("q"));

        //Entered search term into search box
        searchBox.sendKeys(searchTerm);

        //Find out webelement search button
        WebElement googleSearchButton = driver.findElement(By.name("btnK"));

        //Submit the search button
        googleSearchButton.submit();

        //From results page het the title of the page
        String actualPageTitle = driver.getTitle();
        assertResultsPage(actualPageTitle);
    }


    //Assert
    public void assertResultsPage(String actualPageTitle) {
        System.out.println("pageTitle = " + actualPageTitle);
        Assert.assertTrue(actualPageTitle.contains(searchTerm));

    }


    //TearDown
    @AfterClass
    public static void tearDown() {
        driver.close();
        driver.quit();

    }

}
