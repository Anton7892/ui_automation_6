package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DropdownHandler;
import utils.Waiter;

import java.util.List;

public class _11_TGDropdownsTest extends Base {

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-5")).click();

    }

    @Test
    public void productDropdownTest() {
        WebElement dropDown = driver.findElement(By.id("product_dropdown"));
        DropdownHandler.selectByVisibleText(dropDown,"iPhone 14 Pro Max");
        Waiter.pause(2);

    }

    @Test
    public void productDropdownTest2() {
        WebElement dropDown = driver.findElement(By.id("color_dropdown"));
        DropdownHandler.selectByIndex(dropDown,2);
        Waiter.pause(2);
    }

    @Test
    public void productDropdownTest3() {
        // we don't use select tag for this drop down because there is no select tag on the inspect page
        // we need to handle using web elements
        WebElement dropDown = driver.findElement(By.id("shipment_dropdown"));
        List<WebElement> dropdownOption = driver.findElements(By.cssSelector("#shipment_dropdown span"));

         DropdownHandler.clickDropdownOption(dropDown,dropdownOption,"Delivery");
         Waiter.pause(2);


    }
    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Alerts" card
    Select the "MacBook Pro 13" option from the "Product" dropdown.
    Select the "Green" option from the "Color" dropdown.
    Open the "Shipping" dropdown and click on the "Delivery" option.
    Click on the "Submit" button.
    Validate result message displays "Your Green MacBook Pro 13 will be delivered to you."

     */


    @Test
    public void dropDownTest4(){
        WebElement productDropdown = driver.findElement(By.id("product_dropdown"));
        DropdownHandler.selectByVisibleText(productDropdown, "MacBook Pro 13");

        WebElement colorDropdown = driver.findElement(By.id("color_dropdown"));
        DropdownHandler.selectByVisibleText(colorDropdown, "Green");

        WebElement deliveryDropdown = driver.findElement(By.id("shipment_dropdown"));
        deliveryDropdown.click();

        List<WebElement> deliveryDropdownOptions = driver.findElements(By.cssSelector("#shipment_dropdown span"));
        deliveryDropdownOptions.get(0).click();

        driver.findElement(By.id("submit")).click();
        String actualText = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(actualText, "Your Green MacBook Pro 13 will be delivered to you.");

    }
}


