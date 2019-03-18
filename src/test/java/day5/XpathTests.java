package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class XpathTests {
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/tatsianadz/IdeaProjects/JavaTestNGChrome/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testHW() {
        String url = "http://52.9.182.211:3001/v1/log-in";
        driver.get(url);

        String xpath10 = "(//input[@type='text'])[last()]";
        String xpath11 = "(//input[@type='text'])[2]";
        String xpath12 = "(//input[@type='text'])[position()=2]";

        driver.findElement(By.xpath(xpath12)).sendKeys("dramma");
    }

    @Test
    public void testHW2() {
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);

        String xpath13 = "//*[@id='username']/following::input[@type='password']";
        String xpath14 = "//*[@id='password']//preceding::input[@type='text']";

        driver.findElement(By.xpath(xpath14)).sendKeys("dramma");

    }

    @Test
    public void test001() {
        String xpath = "html/body/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div[1]/div/div/input[1]";
        String xpath2 = "//form/div[1]/div/div[1]/div/div/input[1]";
        String xpath3 = "//*[@name='restaurant_id']";
        String xpath4 = "//*[@name='restaurant_id'][@type='text']";
        String xpath5 = "//*[@name='restaurant_id' and @type='text']";
        String xpath6 = "//*[@name='restaurant_id' or @type='adfadsfasdfdasfsd']";
        String xpath7 = "//*[contains(@name,'aurant_id')]";
        String xpath8 = "//*[starts-with(@name,'rest')]";
        String xpath9 = "//*[text()='Log In']";
//        TODO: why we found email input using following locator
        String xpath10 = "//input[@type='text'])[last()]";

//        TODO: find email text input with position() xpath method
        String xpath11 = "//input[@type='text'][2]";
        String xpath12 = "//input[@type='text'][position()=2]";
        String xpath13 = "//*[@id='FirstName']/following::input[@type='text']";
        String xpath14 = "//*[@id='LastName']//preceding::input[@type='text']";


    }
}