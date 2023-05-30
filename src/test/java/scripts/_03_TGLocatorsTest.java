package scripts;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;




public class _03_TGLocatorsTest extends Base {
    /*
    Test case 1:
    go to https://techglobal-training.netlify.app/frontend/locators
    validate the "Kiwi" paragraph
     */



    @BeforeMethod
    public void setPage() {

        driver.get("https://techglobal-training.netlify.app/frontend/locators");
    }


    @Test(priority = 1)
    public void validateKiwiParagraph(){
        WebElement kiwi_paragraph = driver.findElement(By.id("item_kiwi"));

        Assert.assertTrue(kiwi_paragraph.isDisplayed());
        Assert.assertEquals(kiwi_paragraph.getText(),"Kiwi");
    }

    /*
     go to https://techglobal-training.netlify.app/frontend/locators
    validate the "Orange" paragraph
     */

    @Test
    public void validateOrangeParagraph(){
        WebElement orange_paragraph = driver.findElement(By.name("item_orange"));

        Assert.assertTrue(orange_paragraph.isDisplayed());
        Assert.assertEquals(orange_paragraph.getText(),"Orange");

        System.out.println(orange_paragraph.getText());
        System.out.println(orange_paragraph.getAttribute("id"));
        System.out.println(orange_paragraph.getAttribute("name"));
        System.out.println(orange_paragraph.getTagName());

        System.out.println(orange_paragraph.getCssValue("font-size"));
        System.out.println(orange_paragraph.getCssValue("color"));
        System.out.println(orange_paragraph.getCssValue("line-height"));
        System.out.println(orange_paragraph.getCssValue("font-family"));
        System.out.println(orange_paragraph.getCssValue("box-sizing"));
    }
     /*
         Test case 3
         go to https://techglobal-training.netlify.app/frontend/locators
         validate the "Grapes" paragraph
      */
    @Test
    public void validateGrapesParagraph(){
        WebElement grape_Paragraph = driver.findElement(By.className("item_grapes")); // we use classname because class is a reserve keyword in java

        Assert.assertTrue(grape_Paragraph.isDisplayed());
        Assert.assertEquals(grape_Paragraph.getText(),"Grapes");
    }
    @Test
    public void findAllParagraphs(){
      List<WebElement> allParagraphs = driver.findElements(By.tagName("p"));
        System.out.println(allParagraphs.size());//5
/*
        for (WebElement element : allParagraphs) {
            Assert.assertTrue(element.isDisplayed());
            System.out.println(element.getText());
*/
            // for first 3
            String[] expectedTexts ={"Kiwi", "Orange", "Grapes"};
            for (int i = 0; i <= 2; i++) {
                Assert.assertTrue(allParagraphs.get(i).isDisplayed());
                Assert.assertEquals(allParagraphs.get(i).getText(),expectedTexts[i]);
                System.out.println();
            }
        }

        /*
        Test case
        go to https://techglobal-training.netlify.app/frontend/locators

       validate "Red Apple" Link( displayed and enabled)
       validate it navigates user to the https://en.wikipedia.org/wiki/Red_apple

         */
    @Test
    public void validateRedAppleLink(){
        WebElement red_apple_link = driver.findElement(By.linkText("Red Apple"));

        Assert.assertTrue(red_apple_link.isDisplayed());
        Assert.assertTrue(red_apple_link.isEnabled());

        Assert.assertEquals(red_apple_link.getAttribute("href"),"https://en.wikipedia.org/wiki/Red_apple");
/*
        //Another way is to click and validate the URL
        red_apple_link.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://en.wikipedia.org/wiki/Red_apple");
*/
    }
    /*
    Test case
        go to https://techglobal-training.netlify.app/frontend/locators

       validate "Red Apple" "Green Apple" , "pineapple" links are displayed and enabled
       validate it navigates user to the https://en.wikipedia.org/wiki/Red_apple,https://en.wikipedia.org/wiki/Green_Apple,https://en.wikipedia.org/wiki/Pineapple
     */
        @Test
    public void validateAllLinks(){
           List<WebElement> allLinks = driver.findElements(By.partialLinkText("pple"));
           String[] expectedVisibleTexts ={"Red Apple","Green Apple","Pineapple"};
           String[] expectedLinks ={"https://en.wikipedia.org/wiki/Red_apple","https://en.wikipedia.org/wiki/Green_apple","https://en.wikipedia.org/wiki/Pineapple"};

            for (int i = 0; i <= 2; i++) {
                Assert.assertTrue(allLinks.get(i).isDisplayed());
                Assert.assertTrue(allLinks.get(i).isEnabled());
                Assert.assertEquals(allLinks.get(i).getText(),expectedVisibleTexts[i]);
                Assert.assertEquals(allLinks.get(i).getAttribute("href"),expectedLinks[i]);
            }


        }



}



