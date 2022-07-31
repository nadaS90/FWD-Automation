import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpenBrowserSoftAssertion {
    WebDriver driver = null;
    LoginPage login ;


    @BeforeTest
    public void OpenBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\browsers\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        // Create new objects
        login = new LoginPage();
    }


    @Test
    public void validData() throws InterruptedException {

        driver.navigate().to("https://the-internet.herokuapp.com/login");

        login.LoginSteps("tomsmith","SuperSecretPassword!", driver);

        //Waiting time
        Thread.sleep(3000);

        //Soft Assertion Object
        SoftAssert soft =  new SoftAssert();


        // First Assertion
        System.out.println("first Assertion");
        String expectedResult = "You logged into a secure";
        String actualResult = login.flashPOM(driver).getText();
        System.out.println("actual result: " + actualResult);
        soft.assertEquals(actualResult.contains(expectedResult), true, "First Assertion Fail");
        soft.assertTrue(actualResult.contains(expectedResult), "First Assertion True ");

        //Second Assertion
        System.out.println("second Assertion");
        soft.assertTrue(login.logoutPOM(driver).isDisplayed(), "Second Assertion Fail");

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

       login.LoginSteps("tomsmi","password", driver);

       String expectedResult = "Your username is invalid!";
       String actualResult = login.flashPOM(driver).getText();
       System.out.println("actual result: "+ actualResult);
       Assert.assertTrue(actualResult.contains(expectedResult), "Error Message: text not matching");

   }

    @AfterTest
    public  void closeBrowser ()throws  InterruptedException{
        //driver.close(); -> close one tab
        driver.quit();
    }

}
