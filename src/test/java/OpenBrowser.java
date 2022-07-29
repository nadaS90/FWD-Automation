import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowser {
    WebDriver driver = null;

    @BeforeTest
    public void OpenBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\browsers\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @Test
    public void validData(){
      //  driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

    }

   @Test
    public void invalidData(){
     //  driver.findElement(By.linkText("Form Authentication")).click();
       driver.navigate().to("https://the-internet.herokuapp.com/login");
       driver.findElement(By.id("username")).clear();
       driver.findElement(By.id("username")).sendKeys("invalid");
       driver.findElement(By.name("password")).sendKeys("Super");
       driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

   }

    @AfterTest
    public  void closeBrowser ()throws  InterruptedException{
        //driver.close(); -> close one tab
        driver.quit();
    }

}
