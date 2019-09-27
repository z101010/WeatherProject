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
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
            String baseUrl = "https://www.accuweather.com/";
            String expectedUrl = "https://www.accuweather.com/";
            driver.get(baseUrl);
            String actualUrl = driver.getCurrentUrl();
            System.out.println("Website: " + actualUrl);
            Assert.assertEquals(actualUrl, expectedUrl);
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        }

        @Test
        public void Main() throws Exception {
            AccuweatherPageObject AccuweatherPage = PageFactory.initElements(driver, AccuweatherPageObject.class);
            Actions builder = new Actions(driver);

            driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/form/input")).click();
            Thread.sleep(2000);
            driver.findElement(By.name("query")).sendKeys("East London");
            Thread.sleep(2000);
            builder.sendKeys(Keys.ENTER);

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
