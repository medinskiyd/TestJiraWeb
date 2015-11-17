package TestIssueCreation;
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

}