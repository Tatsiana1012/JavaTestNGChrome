package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsHandles {

    WebDriver driver;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/tatsianadz/IdeaProjects/JavaTestNGChrome/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testHW() {
        String url = "https://the-internet.herokuapp.com/windows";

        openMainPage(url);
        clickOnLink("Click Here");
        explicitWait();
        assertTwoWindows();
        switchToMainPage();
        assertTextOnMainPage();
    }

    private void assertTextOnMainPage() {
        Assert.assertTrue(driver.getPageSource().contains("Opening a new window"));
    }

    private void switchToMainPage() {
        Object[] array = driver.getWindowHandles().toArray();

        String windowHandle0 = (String) array[0];

        driver.switchTo().window(windowHandle0);

        String actualWindowTitle0 = driver.getTitle();

        String expectedWindowTitle0 = "The Internet";

        Assert.assertEquals(actualWindowTitle0, expectedWindowTitle0);
    }
    private void explicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Test
    public void test001() {
        String url = "https://the-internet.herokuapp.com/windows";

        openMainPage(url);
        clickOnLink("Click Here");
//TODO create an explicit wait here
        explicitWait();
        assertTwoWindows();
        switchToNewWindow();
        assertTexOnPage();

    }

    private void assertTexOnPage() {
        Assert.assertTrue(driver.getPageSource().contains("New Window"));
    }

    private void switchToNewWindow() {
        Object[] array = driver.getWindowHandles().toArray();

        String windowHandle1 = (String) array[1];

        driver.switchTo().window(windowHandle1);

        String actualWindowTitle = driver.getTitle();

        String expectedWindowTitle = "New Window";

        Assert.assertEquals(actualWindowTitle, expectedWindowTitle);
    }

    private void assertTwoWindows() {
        Set<String> windowHandles = driver.getWindowHandles();

        int size = windowHandles.size();
        int expectedSize = 2;

        Assert.assertEquals(size, expectedSize);
    }

    private void clickOnLink(String linkText) {
        WebElement element = driver.findElement(By.partialLinkText(linkText));
        element.click();
    }

    private void openMainPage(String url) {
        driver.get(url);
    }


}

