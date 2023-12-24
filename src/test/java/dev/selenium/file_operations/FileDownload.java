package dev.selenium.dropdowns;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class FileDownload {


    private WebDriver driver;

    //SETUP
    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    //TEARDOWN
/*    @After
    public void tearDown() {
        driver.quit();
    }*/

    //EXECUTE
    @Test
    public void testFileDownload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        String fileName = "test_file.txt";
        driver.findElement(By.partialLinkText(fileName)).click();

        //SEAT

        //ASSERT

        //Download location is?
        //In windows system - "Downloads"

        //C:\Users\91721\Downloads

        String downloadDirectory = System.getProperty("user.home") + "/Downloads/";
        //List all the files in my downloads directory

        File dir = new File(downloadDirectory);

        File[] listOfFilesInDownloadsDirectory = dir.listFiles();
        boolean status = false;
        Thread.sleep(2000);
        for(int i=0 ; i < listOfFilesInDownloadsDirectory.length ; i++){
            if(listOfFilesInDownloadsDirectory[i].getName().equals(fileName)){
                System.out.println("Runtime retrieved name of file is = " + listOfFilesInDownloadsDirectory[i].getName());
                status = true;
                listOfFilesInDownloadsDirectory[i].delete();
                break;
            }
        }
        Assert.assertTrue("File " + fileName + " found!", status);
    }
}