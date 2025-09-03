package tests;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.WebDriverConfig;
import pages.BrowserLocalePage;

public class BrowserLocaleTest {
    private WebDriver driver;
    private BrowserLocalePage browserTimePage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverConfig.getDriver();
        browserTimePage = new BrowserLocalePage(driver);
    }

    @Test
    public void testLocale() {
        // Create a Java date in the Europe/Lisbon timezone.
        LocalDateTime localDateTime = LocalDateTime.of(2025, 9, 2, 21, 30, 0);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Europe/Lisbon"));
        long timestamp = zonedDateTime.toInstant().toEpochMilli();

        // Open the test page.
        browserTimePage.open(timestamp);

        // Verify that the browser is configured with the correct locale and time zone.
        String timeText = browserTimePage.getTime();
        String timeZoneText = browserTimePage.getTimeZone();
        String timeLocaleText = browserTimePage.getTimeLocale();
        String languagesText = browserTimePage.getLanguages();
        Assert.assertEquals(timeText, "Time: 02/09/2025, 21:30:00");
        Assert.assertEquals(timeZoneText, "TimeZone: Europe/Lisbon");
        Assert.assertEquals(timeLocaleText, "TimeLocale: pt-PT");
        Assert.assertEquals(languagesText, "Languages: pt-PT");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverConfig.quitDriver();
    }
}