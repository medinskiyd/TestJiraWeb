package TestIssueUpdate;
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

    public IssuePage clickIssue() {
        wDriver.findElement(By.id("issue_lnk_474006_lnk")).click();
        return new IssuePage(wDriver);
    }

}