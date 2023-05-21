package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _01_GoogleTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();// set up Chrome driver
        driver = new ChromeDriver();// launch a Chrome driver
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();// Maximizes Chrome window

        driver.get("https://www.google.com/");


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);

        driver.quit();
    }

    /*
    Go to google.com
    Validate that the user see a search input box
     */

    @Test
    public void validateSearchBar() throws InterruptedException {

// here i removed all the 5 lines because i put them in the before method... notice above
        WebElement searchInputBox = driver.findElement(By.id("APjFqb"));

        Assert.assertTrue(searchInputBox.isDisplayed());




        Thread.sleep(5000);

        driver.quit();


    }

    /*
     Go to google.com
    Validate that the title is "Google"
    Validate that the URL is https://www.google.com/

     */


    @Test
    public void validateTitleAndURL() throws InterruptedException {
        WebDriverManager.chromedriver().setup();// set up Chrome driver
        WebDriver driver = new ChromeDriver();// launch a Chrome driver
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();// Maximizes Chrome window

        driver.get("https://www.google.com/");

        // validation of title and url
        System.out.println(driver.getTitle());// Google
        System.out.println(driver.getCurrentUrl());//https://www.google.com/

        Assert.assertEquals(driver.getTitle(),"Google");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/");

        Thread.sleep(5000);

        driver.quit();

    }

    /*
   Go to google.com
   refresh the page
   Navigate to https://www.amazon.com/
   Navigate back
   Navigate forward
   validate that the title is https://www.amazon.com/
     */

    @Test
    public void validateNavigation() throws InterruptedException {

        Thread.sleep(2000); // giving it some time to refresh
        driver.navigate().refresh();

        Thread.sleep(2000);
        driver.navigate().to("https://www.amazon.com/");

        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

        Assert.assertEquals(driver.getTitle(),"Amazon.com. Spend less. Smile more.");
    }

    /*
    Go to google.com
    Validate that the user see "Google Search" button
    Validate its text is "Google Search"
    validate that it is clickable
     */

    @Test
    public void validateGoogleSearchButton(){
        WebElement searchButton = driver.findElement(By.name("btnK"));
        Assert.assertTrue(searchButton.isDisplayed());


    }
}
