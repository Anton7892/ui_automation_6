package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
            // implicit wait ,It is used to tell the web driver to wait for a certain amount of time before it throws aNoSuchElementException
        }
        return driver;
    }



    public static void quitDriver(){
        if (driver!= null){
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }
}
