package config;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v137.emulation.Emulation;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;

public class WebDriverConfig {
    private static final String REMOTE_WEB_DRIVER_URL = "http://chrome:4444";
    private static final String LANG = "pt-PT";
    private static final String TZ = "Europe/Lisbon";

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1440,900");
            options.addArguments("--lang=" + LANG);

            Map<String, Object> prefs = Map.of(
                    "intl.accept_languages", LANG);
            options.setExperimentalOption("prefs", prefs);

            try {
                driver = new Augmenter()
                        .augment(new RemoteWebDriver((new URI(REMOTE_WEB_DRIVER_URL)).toURL(), options));
            } catch (MalformedURLException | URISyntaxException e) {
                throw new RuntimeException("Failed to initialize RemoteWebDriver", e);
            }

            DevTools devTools = ((HasDevTools) driver).getDevTools();
            devTools.createSession();
            devTools.send(Emulation.setLocaleOverride(Optional.of(LANG)));
            devTools.send(Emulation.setTimezoneOverride(TZ));
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