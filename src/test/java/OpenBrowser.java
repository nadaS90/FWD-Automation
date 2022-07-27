import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //navigate to page
        driver.findElement(By.linkText("Form Authentication")).click();

        // find text field
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        // another way to click enter
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

        //click btn
       // driver.findElement(By.className("radius")).click();
        //driver.findElement(By.linkText("Elemental Selenium")).click();
       // driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        //driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Get success message
        String successMsg = driver.findElement(By.id("flash")).getText();
        System.out.println(successMsg);



        // close Browser
        //driver.close(); -> close one tab
        driver.quit();



    }
}
