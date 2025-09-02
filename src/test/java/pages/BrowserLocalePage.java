package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserLocalePage {
    private WebDriver driver;

    private By time = By.id("time");
    private By timeZone = By.id("timeZone");
    private By timeLocale = By.id("timeLocale");
    private By languages = By.id("languages");

    public BrowserLocalePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(long timestamp) {
        driver.get("about:blank");

        String script = """
                const time = new Date(%d).toLocaleString();
                const timeFormatOptions = Intl.DateTimeFormat().resolvedOptions();
                const timeZone = timeFormatOptions.timeZone;
                const timeLocale = timeFormatOptions.locale;
                const languages = navigator.languages.join(',');

                var elem = document.createElement('div');
                elem.id = 'time';
                elem.textContent = 'Time: ' + time;
                document.body.appendChild(elem);

                var elem = document.createElement('div');
                elem.id = 'timeZone';
                elem.textContent = 'TimeZone: ' + timeZone;
                document.body.appendChild(elem);

                var elem = document.createElement('div');
                elem.id = 'timeLocale';
                elem.textContent = 'TimeLocale: ' + timeLocale;
                document.body.appendChild(elem);

                var elem = document.createElement('div');
                elem.id = 'languages';
                elem.textContent = 'Languages: ' + languages;
                document.body.appendChild(elem);
                """.formatted(timestamp);

        ((JavascriptExecutor) driver).executeScript(script);
    }

    public String getTime() {
        WebElement element = driver.findElement(time);
        return element.getText();
    }

    public String getTimeZone() {
        WebElement element = driver.findElement(timeZone);
        return element.getText();
    }

    public String getTimeLocale() {
        WebElement element = driver.findElement(timeLocale);
        return element.getText();
    }

    public String getLanguages() {
        WebElement element = driver.findElement(languages);
        return element.getText();
    }
}