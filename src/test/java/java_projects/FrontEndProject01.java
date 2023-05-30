package java_projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.Base;

public class FrontEndProject01 extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-1");

    }

    @Test
    public void validateContactInformation(){
        WebElement header = driver.findElement(By.className("is-size-2"));
        Assert.assertTrue(header.isDisplayed());
        Assert.assertEquals(header.getText(),"Contact Us");

        WebElement address = driver.findElement(By.id("address"));
        Assert.assertTrue(address.isDisplayed());
        Assert.assertEquals(address.getText(),"2860 S River Rd Suite 350, Des Plaines IL 60018");

        WebElement email = driver.findElement(By.id("email"));
        Assert.assertTrue(email.isDisplayed());
        Assert.assertEquals(email.getText(),"info@techglobalschool.com");

        WebElement phoneNumber = driver.findElement(By.id("phone-number"));
        Assert.assertTrue(phoneNumber.isDisplayed());
        Assert.assertEquals(phoneNumber.getText(),"(773) 257-3010");

    }
    @Test
    public void validateFullNameInputBox(){
        WebElement inputBox = driver.findElement(By.cssSelector("input[class='input' "));
        Assert.assertTrue(inputBox.isDisplayed());
        Assert.assertTrue(inputBox.isEnabled());
        WebElement fullNameLabel = driver.findElement(By.cssSelector("label[class='label' "));
        Assert.assertTrue(fullNameLabel.isDisplayed());
        Assert.assertEquals(fullNameLabel.getText(),"Full name *");
        WebElement placeHolder = driver.findElement(By.className("input"));
        Assert.assertEquals(placeHolder.getText(),"Enter your full name");
    }

    @Test
    public void validateGenderButton(){

    }
}
