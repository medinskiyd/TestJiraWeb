package TestIssueCreation;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCreateIssueJira {

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
    public void testIssueCreate() throws Exception {
        driver.get(baseUrl + "/secure/Dashboard.jspa");

        HomePage hPage = new HomePage(driver);

        LoginPage logPage = hPage.clickLogin();
        logPage.enterLogin(login);
        logPage.enterPassword(pass);

        IssuePage issPage = logPage.clickLogin();
        issPage.openIssuePage();
        issPage.enterSummary(issueSummary);
        driver = issPage.clickCreateIssue();

        assertTrue(issPage.confirmIssueCreate().contains(issueSummary));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}