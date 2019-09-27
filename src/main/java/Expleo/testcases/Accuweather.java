package Expleo.testcases;

import Expleo.pageobjects.AccuweatherPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;


public class Accuweather {
        private static WebDriver driver;
        private String baseUrl;
        private static boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Test
        public static AccuweatherPageObject AccuWeatherData() throws Exception {
            System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
            String baseUrl = "https://www.accuweather.com/";
            String expectedUrl = "https://www.accuweather.com/";
            driver.get(baseUrl);
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl);
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

            AccuweatherPageObject AccuweatherPage = PageFactory.initElements(driver, AccuweatherPageObject.class);

            //Commands to get through the different web pages.
            driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/form/input")).click();
            Thread.sleep(2000);
            driver.findElement(By.name("query")).sendKeys("East London");
            driver.findElement(By.name("query")).sendKeys(Keys.ENTER);
            driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div[1]/div[1]/a[1]")).click();
            driver.findElement(By.xpath("/html/body/div/div[4]/div/div/div[3]/a[4]/span")).click();

            //Gets the Min & Max for Day 1
            String ACCMaxDay1 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[1]")).getText();
            AccuweatherPage.addMaxTemp(0, Integer.parseInt(ACCMaxDay1.substring(0,2)));
            String ACCMinDay1 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[2]")).getText();
            AccuweatherPage.addMinTemp(0, Integer.parseInt((ACCMinDay1.substring(2,4))));

            //Gets the Min & Max for Day 2
            String ACCMaxDay2 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[1]")).getText();
            AccuweatherPage.addMaxTemp(1, Integer.parseInt(ACCMaxDay2.substring(0,2)));
            String ACCMinDay2 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[2]")).getText();
            AccuweatherPage.addMinTemp(1, Integer.parseInt(ACCMinDay2.substring(2,4)));

            //Gets the Min & Max for Day 3
            String ACCMaxDay3 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[1]")).getText();
            AccuweatherPage.addMaxTemp(2, Integer.parseInt(ACCMaxDay3.substring(0,2)));
            String ACCMinDay3 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[2]")).getText();
            AccuweatherPage.addMinTemp(2, Integer.parseInt(ACCMinDay3.substring(2,4)));

            //Gets the Min & Max for Day 4
            String ACCMaxDay4 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[3]/a[1]/div[2]/span[1]")).getText();
            AccuweatherPage.addMaxTemp(3, Integer.parseInt(ACCMaxDay4.substring(0,2)));
            String ACCMinDay4 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[3]/a[1]/div[2]/span[2]")).getText();
            AccuweatherPage.addMinTemp(3, Integer.parseInt(ACCMinDay4.substring(2,4)));

            //Gets the Min & Max for Day 5
            String ACCMaxDay5 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[3]/a[2]/div[2]/span[1]")).getText();
            AccuweatherPage.addMaxTemp(4, Integer.parseInt(ACCMaxDay5.substring(0,2)));
            String ACCMinDay5 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[3]/a[2]/div[2]/span[2]")).getText();
            AccuweatherPage.addMinTemp(4, Integer.parseInt(ACCMinDay5.substring(2,4)));

            return AccuweatherPage;
        }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


}
