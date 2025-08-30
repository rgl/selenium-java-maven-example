package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GitHubHomePage {
    private WebDriver driver;

    private By signInButton = By.linkText("Sign in");

    public GitHubHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://github.com");
    }

    public void clickSignIn() {
        WebElement element = driver.findElement(signInButton);
        element.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}