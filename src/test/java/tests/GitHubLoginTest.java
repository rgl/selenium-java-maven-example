package tests;

import config.WebDriverConfig;
import pages.GitHubHomePage;
import pages.GitHubLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GitHubLoginTest {
    private WebDriver driver;
    private GitHubHomePage homePage;
    private GitHubLoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverConfig.getDriver();
        homePage = new GitHubHomePage(driver);
        loginPage = new GitHubLoginPage(driver);
    }

    @Test
    public void testGitHubLoginFlow() {
        // Open the GitHub homepage.
        homePage.open();
        Assert.assertTrue(homePage.getPageTitle().contains("GitHub"),
                "GitHub homepage title is incorrect");

        // Click Sign in button.
        homePage.clickSignIn();

        // Verify that we are on login page.
        Assert.assertTrue(loginPage.getCurrentUrl().contains("github.com/login"),
                "Not on GitHub login page");
        Assert.assertTrue(loginPage.getPageTitle().contains("Sign in"),
                "Login page title is incorrect");

        // Verify that the login page elements are visible.
        Assert.assertTrue(loginPage.isSignInHeadingDisplayed(),
                "Login page header is not displayed");
        Assert.assertTrue(loginPage.isUsernameInputDisplayed(),
                "Username input is not displayed");
        Assert.assertTrue(loginPage.isPasswordInputDisplayed(),
                "Password input is not displayed");
        Assert.assertTrue(loginPage.isSignInButtonDisplayed(),
                "Sign in button is not displayed");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverConfig.quitDriver();
    }
}