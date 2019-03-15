package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class iFrames {

    WebDriver driver;
    By textEditorInput = By.id("tinymce");

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/tatsianadz/IdeaProjects/JavaTestNGChrome/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testHW() {
        String url = "https://the-internet.herokuapp.com/tinymce";
        String textToType = "Hello World!!!";

        driver.get(url);
        switchToiFrame ();
        clearEditor();
        typeText(textToType);
        switchToDefaultContent();
        alignRight();
        alignCenter();

    }

    private void switchToDefaultContent() {
        driver.switchTo().defaultContent();

    }

    private void alignCenter() {
        driver.findElement(By.cssSelector("#mceu_6 > button")).click();
    }

    private void alignRight() {
        driver.findElement(By.cssSelector("div#mceu_7 button")).click();

    }

    @Test
    public void test001() {
        String url = "https://the-internet.herokuapp.com/tinymce";
        String textToType = "Text type from Webdriver";

        driver.get(url);
        switchToiFrame ();
        clearEditor();
        typeText(textToType);
        assertTextTyped(textToType);
    }

    private void assertTextTyped(String expectedText) {
        String actualTextFromElement = driver.findElement(textEditorInput).getText();
        Assert.assertEquals(actualTextFromElement, expectedText);

    }

    private void typeText(String textToType) {
        driver.findElement(textEditorInput).sendKeys(textToType);
    }

    private void clearEditor() {
        driver.findElement(textEditorInput).clear();
    }

    private void switchToiFrame() {

        WebElement webelement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(webelement);
    }

    @Test
    public void test002() {
        String url = "https://the-internet.herokuapp.com/nested_frames";
        String topFrame = "frame-top";
        String middleFrame = "frame-middle";
        String leftFrame = "frame-left";
        String expectedText = "MIDDLE";

        driver.get(url);

        switchToFrameByName(topFrame);
        switchToFrameByName(middleFrame);
        assertMiddleText(expectedText);


    }
    @Test
    public void test003() {
        String url = "https://the-internet.herokuapp.com/nested_frames";
        String topFrame = "frame-top";
        String middleFrame = "frame-middle";
        String leftFrame = "frame-left";
        String expectedText = "LEFT";

        driver.get(url);

        switchToFrameByName(topFrame);
        switchToFrameByName(leftFrame);
        assertLeftText(expectedText);

    }

    private void assertMiddleText(String expectedText) {
        String actualMiddleText =  driver.findElement(By.id("content")).getText();
        Assert.assertEquals(actualMiddleText, expectedText);

    }

    private void assertLeftText(String expectedText) {
        boolean result =  driver.getPageSource().contains(expectedText);
        Assert.assertTrue(result);

    }

    private void switchToFrameByName(String frameName) {
        driver.switchTo().frame(frameName);
    }




}
