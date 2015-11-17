package TestIssueCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuePage {

    private WebDriver wDriver;

    public IssuePage(WebDriver wDriver) {
        this.wDriver = wDriver;
    }

    public void openIssuePage() {
        wDriver.findElement(By.id("create_link")).click();
    }

    public void enterSummary(String issue) {
        wDriver.findElement(By.id("summary")).sendKeys(issue);
    }

    public WebDriver clickCreateIssue() {
        wDriver.findElement(By.id("create-issue-submit")).click();
        return wDriver;
    }

    public String confirmIssueCreate() {
        return wDriver.findElement(By.xpath("//*[@id='aui-flag-container']/div/div/a")).getText();
    }





}