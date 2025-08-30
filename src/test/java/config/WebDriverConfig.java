package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.MalformedURLException;

public class WebDriverConfig {
    private static final String REMOTE_WEB_DRIVER_URL = "http://chrome:4444";

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1440,900");

            try {
                driver = new RemoteWebDriver((new URI(REMOTE_WEB_DRIVER_URL)).toURL(), options);
            } catch (MalformedURLException | URISyntaxException e) {
                throw new RuntimeException("Failed to initialize RemoteWebDriver", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}