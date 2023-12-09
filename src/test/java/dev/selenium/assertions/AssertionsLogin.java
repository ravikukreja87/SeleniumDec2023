package dev.selenium.assertions;

import org.testng.Assert;

public class AssertionsLogin {

    public static void assertAlertText(String alertText) {
        String expectedAlertText = "It seems that your credentials are invalid or your access to LMS has expired. Please contact Techcanvass team on this email address : course-admin@techcanvass.com";
        Assert.assertEquals(alertText, expectedAlertText);
    }

    public static void assertLogin(String actualTitle) {
        String expectedTitle = "Techcanvass LMS Portal – TechEdge | Learning made simple";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
