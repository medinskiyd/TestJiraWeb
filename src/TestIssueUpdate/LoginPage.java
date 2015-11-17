package TestIssueUpdate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver wDriver;

    public LoginPage(WebDriver driver) {
        this.wDriver = driver;
    }

    public void enterLogin(String login) {
        wDriver.findElement(By.id("username")).sendKeys(login);
    }

    public void enterPassword(String password) {
        wDriver.findElement(By.id("password")).sendKeys(password);
    }

    public HomePage clickLogin() {
        wDriver.findElement(By.id("login-submit")).click();
        return new HomePage(wDriver);
    }


}