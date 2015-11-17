package TestIssueUpdate;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestIssueUpdateJira{
    private WebDriver driver;
    private String baseUrl;

    private String login = "medinskiyd@gmail.com";
    private String pass = "12345677";
    private String description = "Update issue done! ";

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

        IssuePage issPage = hPage.clickIssue();

        issPage.editIssue();
        issPage.enterDescription(description);

        driver = issPage.enterUpdate();

        assertTrue(issPage.confirmIssueUpdate().contains(description));

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}