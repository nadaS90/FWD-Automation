import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebElement usernamePOM(WebDriver driver)
    {
        By username = By.id("username");
        WebElement usernameElm = driver.findElement(username);
        return usernameElm;

    }

    public WebElement passwordPOM(WebDriver driver){
        By password = By.name("password");
        WebElement passwordElm = driver.findElement(password);
        return passwordElm;
        //return driver.findElement(By.name("password"));
    }

    public WebElement flashPOM(WebDriver driver){
        By flashmsg = By.id("flash");
        WebElement flashmsgElm =driver.findElement(flashmsg);
        return flashmsgElm;
    }

    public WebElement logoutPOM(WebDriver driver){
        By logoutmsg = By.cssSelector("a[href=\"/logout\"]");
        WebElement logoutmsgElm =driver.findElement(logoutmsg);
        return logoutmsgElm;
    }
}
