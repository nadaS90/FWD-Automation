import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
      //  PageFactory.initElements(driver, this);
    }

//    @FindBy(id = "username")
//    WebElement usernamePF;


    public WebElement usernamePOM()
    {
        By username = By.id("username");
        WebElement usernameElm = driver.findElement(username);
        return usernameElm;

    }

    public WebElement passwordPOM(){
        By password = By.name("password");
        WebElement passwordElm = driver.findElement(password);
        return passwordElm;
        //return driver.findElement(By.name("password"));
    }

    public WebElement flashPOM(){
        By flashmsg = By.id("flash");
        WebElement flashmsgElm =driver.findElement(flashmsg);
        return flashmsgElm;
    }

    public WebElement logoutPOM(){
        By logoutmsg = By.cssSelector("a[href=\"/logout\"]");
        WebElement logoutmsgElm =driver.findElement(logoutmsg);
        return logoutmsgElm;
    }

    public void LoginSteps(String username, String password)
    {
        // Enter Username with POM
        usernamePOM().clear();
        usernamePOM().sendKeys(username);

        //Enter password with POM
        passwordPOM().sendKeys(password);
        passwordPOM().sendKeys(Keys.ENTER);
        //tomsmith
        //SuperSecretPassword!
    }
}
