package TestIssueUpdate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuePage {

    private WebDriver wDriver;

    public IssuePage(WebDriver driver) {
        this.wDriver = driver;
    }

    public void editIssue() {
        wDriver.findElement(By.cssSelector("span.trigger-label")).click();
    }

    public void enterDescription(String description) {
        wDriver.findElement(By.id("description")).sendKeys(description);
    }

    public WebDriver enterUpdate() {
        wDriver.findElement(By.id("edit-issue-submit")).click();
        return wDriver;
    }

    public String confirmIssueUpdate() {
        System.out.println(wDriver.findElement(By.cssSelector("#description-val > div > p")).getText());
        return wDriver.findElement(By.cssSelector("#description-val > div > p")).getText();
    }

}