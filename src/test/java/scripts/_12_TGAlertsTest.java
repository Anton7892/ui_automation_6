package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.AlertHandler;

public class _12_TGAlertsTest extends Base {

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-8")).click();

    }

    @Test
    public void warningAlert() {
        WebElement warningAlert = driver.findElement(By.id("warning_alert"));
        warningAlert.click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "You are on TechGlobal Training application.");

        alert.accept();

        WebElement resultText = driver.findElement(By.id("action"));
        Assert.assertEquals(resultText.getText(), "You accepted warning by clicking OK.");

    }
    /*
    Click on the "Alerts" card
Click on the "Confirmation alert" button
Validate the alert text equals "Would you like to stay on TechGlobal Training application?"
Click on the "Cancel" button on the alert
Validate the result message equals "You rejected the alert by clicking Cancel."
Click on the "Confirmation alert" button again
Click on the "OK" button on the alert
Validate the result message equals "You confirmed the alert by clicking OK."
     */

    @Test
    public void warningAlerts2() {
        WebElement confirmationAlert = driver.findElement(By.id("confirmation_alert"));
        confirmationAlert.click();


        Assert.assertEquals(AlertHandler.getAlertText(), "Would you like to stay on TechGlobal Training application?");

        AlertHandler.dismissAlert();

        WebElement confirmText = driver.findElement(By.id("action"));
        Assert.assertEquals(confirmText.getText(), "You rejected the alert by clicking Cancel.");

        confirmationAlert.click();
        AlertHandler.acceptAlert();
        Assert.assertEquals(confirmText.getText(), "You confirmed the alert by clicking OK.");

    }
}