package TestIssueFind;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestIssueFindJira{
    private WebDriver driver;
    private String baseUrl;

    private String login = "medinskiyd@gmail.com";
    private String pass = "12345677";
    private String issueSummary = "New issue";

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://jira.atlassian.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl + "/secure/Dashboard.jspa");

        HomePage hPage = new HomePage(driver);

        LoginPage logPage = hPage.clickLogin();
        logPage.enterLogin(login);
        logPage.enterPassword(pass);

        hPage = logPage.clickLogin();
        hPage.clickIssues();

        IssuesPage issPage = hPage.clickReportedIssues();
        issPage.enterIssueSummary(issueSummary);
        driver = issPage.clickFindIssues();

        assertTrue(issPage.confirmIssueFind().contains(issueSummary));

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
