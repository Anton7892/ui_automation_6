package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _10_TGRadioButtonsTest extends Base {
    /*
    EST CASE 1
    Go to https://techglobal-training.com/frontend/
    Click on the "Radio Buttons" card
    Validate that "Java", "JavaScript" and "C#" radio buttons are displayed, enabled, and not selected
    Select "Java" and validate it is selected but the other 2 are deselected
    Select "JavaScript" to validate it is selected but the other 2 are deselected
     */

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-6")).click();
    }
        @Test
        public void selectButtons () {

            List<WebElement> buttonLabels = driver.findElements(By.cssSelector("#radio-button-group_1 label"));
            List<WebElement> buttonInputs = driver.findElements(By.cssSelector("#radio-button-group_1 input"));



            buttonInputs.forEach(bl -> {
                Assert.assertTrue(bl.isDisplayed());
                Assert.assertTrue(bl.isEnabled());
                Assert.assertFalse(bl.isSelected());
            });

          buttonLabels.get(0).click();
          Assert.assertTrue(buttonInputs.get(0).isSelected());

            for (int i = 1; i < buttonLabels.size(); i++) {
                Assert.assertFalse(buttonInputs.get(i).isSelected());
            }

            buttonLabels.get(1).click();
            Assert.assertTrue(buttonInputs.get(1).isSelected());

            for (int i = 0; i < buttonLabels.size(); i++) {
                Assert.assertFalse(buttonInputs.get(i).isSelected());
                i+=1;
            }
    }

    @Test
    public void selectButtons2(){
        List<WebElement> buttonLabels2 = driver.findElements(By.cssSelector("#radio-button-group_2 label"));
        List<WebElement> buttonInputs2 = driver.findElements(By.cssSelector("#radio-button-group_2 input"));

        buttonInputs2.forEach(bl -> {
            Assert.assertTrue(bl.isDisplayed());
            Assert.assertTrue(bl.isEnabled());
            Assert.assertFalse(bl.isSelected());
        });

        buttonLabels2.get(0).click();
        Assert.assertTrue(buttonInputs2.get(0).isSelected());

        for (int i = 1; i < buttonLabels2.size(); i++) {
            Assert.assertFalse(buttonInputs2.get(i).isSelected());
        }

        buttonLabels2.get(1).click();
        Assert.assertTrue(buttonInputs2.get(1).isSelected());

        for (int i = 0; i < buttonLabels2.size(); i++) {
            Assert.assertFalse(buttonInputs2.get(i).isSelected());
            i+=1;
        }
    }
}
/*
        buttonInputs2.forEach(bl -> {
            Assert.assertTrue(bl.isDisplayed());
            Assert.assertTrue(bl.isEnabled());
            Assert.assertFalse(bl.isSelected());
        });

        for (int i = 0; i < buttonLabels2.size(); i++) {
            buttonInputs2.get(0).click();
            Assert.assertTrue(buttonInputs2.get(0).isSelected());
            Assert.assertFalse(buttonInputs2.get(1).isSelected());
            Assert.assertFalse(buttonInputs2.get(2).isSelected());

        }
        for (int i = 0; i < buttonLabels2.size(); i++) {
            buttonInputs2.get(1).click();
            Assert.assertFalse(buttonInputs2.get(0).isSelected());
            Assert.assertTrue(buttonInputs2.get(1).isSelected());
            Assert.assertFalse(buttonInputs2.get(2).isSelected());

        }

 */
