package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Day3Homework {

    WebDriver driver;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/tatsianadz/IdeaProjects/JavaTestNGChrome/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void test001() {
        String url = "https://the-internet.herokuapp.com/checkboxes";

        driver.get(url);

        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxes > input:nth-child(1)"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkboxes > input:nth-child(3)"));


        if (checkbox1.isSelected()){
            System.out.println("checkbox1 is checked");

        } else checkbox1.click();

        if (checkbox2.isSelected()){
            System.out.println("checkbox2 is checked");

        } else checkbox2.click();



    }
}
