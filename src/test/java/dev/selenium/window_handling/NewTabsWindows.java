package dev.selenium.window_handling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class NewTabsWindows {


    private WebDriver driver;
    private static Logger logger = LogManager.getLogger();

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

/*    @After
    public void tearDown() {
        driver.quit();
    }*/

    @Test
    public void testNewTabs() {


        driver.get("https://www.google.com/");
        logger.info("Title of current window is : " + driver.getTitle());
        logger.error("Title of current window is : " + driver.getTitle());


        //Before switchTo --> Always capture window handle as a string
        String googleWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.att.com/");
        logger.info("Title of current window is : " + driver.getTitle());

        String attWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.selenium.dev/");
        logger.info("Title of current window is : " + driver.getTitle());

        String seleniumWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://techedge.techcanvass.co/Login.aspx");
        logger.info("Title of current window is : " + driver.getTitle());



        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String eachWindow : allWindowHandles){
            driver.switchTo().window(eachWindow);
            logger.info("Title from For Loop =  " + driver.getTitle());
        }


/*        driver.close();
        driver.switchTo().window(googleWindow);
        driver.close();
        driver.switchTo().window(attWindow);
        driver.close();*/

//        driver.quit();

    }


}
