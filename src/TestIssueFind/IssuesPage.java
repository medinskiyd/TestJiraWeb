package TestIssueFind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuesPage {

    private WebDriver wDriver;

    public IssuesPage(WebDriver driver) {
        this.wDriver = driver;
    }

    public void enterIssueSummary(String issueSummary) {
        wDriver.findElement(By.id("searcher-query")).sendKeys(issueSummary);
    }

    public WebDriver clickFindIssues() {
        wDriver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
        return wDriver;
    }

    public String confirmIssueFind() {
        return wDriver.findElement(By.xpath("//*[@id='content']/div[1]/div[4]/div/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/ol/li[1]/a/span[2]")).getText();
    }
}