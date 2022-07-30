import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpenBrowserSoftAssertion {
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
    public void validData() throws InterruptedException {
      //  driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

        //Waiting time
        Thread.sleep(3000);

        //Soft Assertion Object
        SoftAssert soft =  new SoftAssert();


        // First Assertion
        System.out.println("first Assertion");
        String expectedResult = "You logged into a secure";
        String actualResult = driver.findElement(By.id("flash")).getText();
        System.out.println("actual result: " + actualResult);
        soft.assertEquals(actualResult.contains(expectedResult), false, "First Assertion Fail");
        soft.assertTrue(actualResult.contains(expectedResult), "First Assertion True ");

        //Second Assertion
        System.out.println("second Assertion");
        soft.assertTrue(driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed(), "Second Assertion Fail");

        //Third Assertion for URL
        System.out.println("third Assertion");
        String actualdURL = "https://the-internet.herokuapp.com/secure";
        System.out.println(driver.getCurrentUrl());
        soft.assertEquals(driver.getCurrentUrl(),actualdURL, "Third Assertion Fail");

        //Assert all
        soft.assertAll();

    }

   @Test
    public void invalidData(){
     //  driver.findElement(By.linkText("Form Authentication")).click();
       driver.navigate().to("https://the-internet.herokuapp.com/login");
       driver.findElement(By.id("username")).clear();
       driver.findElement(By.id("username")).sendKeys("invalid");
       driver.findElement(By.name("password")).sendKeys("Super");
       driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

       String expectedResult = "Your username is invalid!";
       String actualResult = driver.findElement(By.id("flash")).getText();
       System.out.println("actual result: "+ actualResult);
       Assert.assertTrue(actualResult.contains(expectedResult), "Error Message: text not matching");


   }



    @AfterTest
    public  void closeBrowser ()throws  InterruptedException{
        //driver.close(); -> close one tab
        driver.quit();
    }

}
