package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;
import utils.WindowHandler;

public class _14_MultipleWindowsTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.netlify.app/frontend");
        driver.findElement(By.id("card-10")).click();

    }
    /*
    go to "https://techglobal-training.netlify.app/frontend"
    click on "multipe windows
    click on "apple
    validate apple logo is displayed

     */

    @Test
    public void validateTheAppleNavigation(){




        WebElement appleLink = driver.findElement(By.id("apple"));

        appleLink.click();

        WindowHandler.switchToChildWindow();


        WebElement appleLogo = driver.findElement(By.cssSelector(".globalnav-link-apple"));

        Assert.assertTrue(appleLogo.isDisplayed());

    }
    @Test
    public void validateMicrosoftNavigation() {
        /*
        TEST CASE
    Go to https://techglobal-training.com/frontend
    Click on "Multiple Windows" card
    Click on "Microsoft"
    Validate the URL contains "microsoft"
     */

        WebElement microsoftLink = driver.findElement(By.id("microsoft"));
        microsoftLink.click();

        WindowHandler.switchToChildWindow();

        Assert.assertTrue(driver.getCurrentUrl().contains("microsoft"));

    }
    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend
    Click on "Multiple Windows" card
    Click on "Tesla"
    Validate the title is "Electric Cars, Solar & Clean Energy | Tesla"
    Navigate back to https://techglobal-training.com/frontend/multiple-windows
    Validate the URL contains "techglobal"
    Validate the main heading is "Multiple Windows"
     */

    public void validateTeslaNavigation(){
        WebElement teslaLink = driver.findElement(By.id("tesla"));
        teslaLink.click();

        WindowHandler.switchToChildWindow();

        Assert.assertEquals(driver.getTitle(),"Electric Cars, Solar & Clean Energy | Tesla");

        WindowHandler.switchToMainWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("techglobal"));

        WebElement mainHeading = driver.findElement(By.id("main_heading"));
        Assert.assertEquals(mainHeading.getText(),"Multiple Windows");
    }



}
