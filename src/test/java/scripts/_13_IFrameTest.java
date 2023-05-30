package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _13_IFrameTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/iframes");

    }

    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend/iframes
    Validate the "Please fill out your information below" paragraph

     */
    @Test
    public void validateTheParagraph(){
        WebElement iframe = driver.findElement(By.id("form_frame"));
        driver.switchTo().frame(iframe);

        WebElement p = driver.findElement(By.cssSelector("p[class='label mb-4']"));

        Assert.assertTrue(p.isDisplayed());
        Assert.assertEquals(p.getText(),"Please fill out your information below");


    }


    /*

    TEST CASE
Go to https://techglobal-training.com/frontend/iframes
Enter name as "John"
Enter last name as "Doe"
Click on "SUBMIT" button
Validate that the Result is "You entered: John Doe"
 */
    @Test(priority = 2, description = "TC345 Validate the form submission")
    public void validateTheFormSubmission(){
        driver.switchTo().frame("form_frame");

        WebElement firstName = driver.findElement(By.id("first_name"));
        WebElement lastName = driver.findElement(By.id("last_name"));

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        driver.switchTo().parentFrame();

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(),"You entered: John Doe");





    }
}
