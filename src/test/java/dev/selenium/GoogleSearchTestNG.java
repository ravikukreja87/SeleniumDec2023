package dev.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchTestNG {

    //SEAT
    static WebDriver driver;
    String searchTerm = "Testing is fun second";

    //Setup
    @BeforeTest
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
    @AfterTest
    public static void tearDown() {
        driver.close();
        driver.quit();

    }

}
