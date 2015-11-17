package TestIssueFind;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver wDriver;

    public HomePage(WebDriver driver) {
        this.wDriver = driver;
    }

    public LoginPage clickLogin() {
        wDriver.findElement(By.linkText("Log In")).click();
        return new LoginPage(wDriver);
    }

    public void clickIssues() {
        wDriver.findElement(By.id("find_link")).click();

    }

    public IssuesPage clickReportedIssues() {
        wDriver.findElement(By.id("filter_lnk_reported_lnk")).click();
        return new IssuesPage(wDriver);
    }

}