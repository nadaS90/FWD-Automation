import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    public static void main(String[] args) {

        //1- link browser with IDE
        String chromePath = System.getProperty("user.dir") + "\\src\\browsers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        //2- New object
        WebDriver driver = new ChromeDriver();

        //3- Navigate
        driver.navigate().to("https://github.com/login");

        //4- close Browser
        driver.close();



    }
}
