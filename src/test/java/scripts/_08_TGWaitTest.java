package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;
import utils.Waiter;

public class _08_TGWaitTest extends Base {


    /*
    TEST CASE 1
    Go to https://techglobal-training.com/frontend/
    Click on the "Waits" card
    Click on the "Click on me to see a red box" button
    Validate that a red box is displayed
     */
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-4")).click();

    }
    @Test
    public void waitForRedBox(){
        WebElement clickToSeeRed = driver.findElement(By.cssSelector("button[id='red']"));
        clickToSeeRed.click();

        WebElement redBoxAppears = driver.findElement(By.cssSelector("button[class^='Box_c']"));
        Assert.assertTrue(redBoxAppears.isDisplayed());

    }

    @Test
    public void waitForBlueBox(){
        WebElement clickToSeeBlue = driver.findElement(By.id("blue"));
        clickToSeeBlue.click();


        WebElement blueBoxAppears = driver.findElement(By.cssSelector("button[class*='blue_box']"));

        Waiter.waitForVisibilityOfElement(blueBoxAppears,40);

        Assert.assertTrue(blueBoxAppears.isDisplayed());

    }
}
