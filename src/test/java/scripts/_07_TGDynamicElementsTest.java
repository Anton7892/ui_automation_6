package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _07_TGDynamicElementsTest extends Base {

    /*
     TEST CASE 1
     Go to https://techglobal-training.com/frontend/
     Click on the "Dynamic Elements" card
     Validate both boxes are displayed with the below texts
     Box 1
     */

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-3")).click(); // this makes it reusable for later

    }

    @Test
    public void validateDynamicElementsBox1() {
        //WebElement card = driver.findElement(By.id("card-3"));
        //card.click();
        WebElement box1 = driver.findElement(By.cssSelector("p[id^='box_1_'"));


        Assert.assertTrue(box1.isDisplayed());

        Assert.assertEquals(box1.getText(), "Box 1");

    }

    /*
    TEST CASE 2
    Go to https://techglobal-training.com/frontend/
    Click on the "Dynamic Elements" card
    Validate box2 is displayed with the below texts
    Box 2
     */

    @Test
    public void validateDynamicElementsBox2() {


        WebElement box2 = driver.findElement(By.cssSelector("p[id^='box_2_'"));

        Assert.assertTrue(box2.isDisplayed());
        Assert.assertEquals(box2.getText(), "Box 2");

    }

        /*

        TEST CASE 3
        Go to https://techglobal-training.com/frontend/
        Click on the "Dynamic Elements" card
        Validate that both boxes are displayed with the below texts
        Box 1, Box 2 by using contains
        */

    @Test
    public void validateDynamicElementsBoxes() {

        List<WebElement> boxes = driver.findElements(By.cssSelector("p[id*='box_']"));
        System.out.println(boxes.size());//2
        String [] expectedText ={"Box 1","Box 2"};

        for (int i = 0; i<=1; i++){
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertEquals(boxes.get(i).getText(),expectedText[i]);
        }

    }
}