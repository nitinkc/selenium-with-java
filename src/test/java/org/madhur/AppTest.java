package org.madhur;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AppTest {

    WebDriver driver;

    @Test
    public void test() throws InterruptedException, IOException {
        System.out.println("Creating Chrome Driver");
        ChromeOptions options = new ChromeOptions();//No need to set System.setProperty("webdriver.chrome.driver", "");
        //options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);

        driver.get("http://www.google.com");
        System.out.println("Wait a bit for the page to render");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Taking Screenshot");
        File outputFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String imageDetails = "/Users/nichaurasia/Pictures/screenshots/img.png";
        File screenShot = new File(imageDetails).getAbsoluteFile();
        FileHandler.copy(outputFile, screenShot);
        System.out.println("Screenshot saved: {}" + imageDetails);


        driver.quit();
    }

    @Test
    public void verifyTitle() {
        //WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver(options);
        driver.get("https://www.browserstack.com/");
        System.out.println("Title is: " +driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
        driver.quit();
    }
}