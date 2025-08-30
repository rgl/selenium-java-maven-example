package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GitHubLoginPage {
    private WebDriver driver;

    private By usernameInput = By.id("login_field");
    private By passwordInput = By.id("password");
    private By signInButton = By.name("commit");
    private By signInHeading = By.xpath("//h1[contains(text(),'Sign in to GitHub')]");

    public GitHubLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUsernameInputDisplayed() {
        WebElement element = driver.findElement(usernameInput);
        return element.isDisplayed();
    }

    public boolean isPasswordInputDisplayed() {
        WebElement element = driver.findElement(passwordInput);
        return element.isDisplayed();
    }

    public boolean isSignInButtonDisplayed() {
        WebElement element = driver.findElement(signInButton);
        return element.isDisplayed();
    }

    public boolean isSignInHeadingDisplayed() {
        WebElement element = driver.findElement(signInHeading);
        return element.isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}