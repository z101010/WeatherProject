package Expleo.testcases;

import java.util.concurrent.TimeUnit;

import Expleo.pageobjects.Weather24PageObject;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Weather24Test {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        String baseUrl = "http://weather.news24.com/";
        String expectedUrl = "http://weather.news24.com/";
        driver.get(baseUrl);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Website: " + actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @Test
    public void Main() throws Exception {
        Weather24PageObject w24Page = PageFactory.initElements(driver, Weather24PageObject.class);

        driver.findElement(By.xpath(".//*[@id='ctl00_WeatherContentHolder_ddlCity']")).click();
        driver.findElement(By.xpath(".//*[@id='ctl00_WeatherContentHolder_ddlCity']/option[20]")).click();
        driver.findElement(By.id("ctl00_WeatherContentHolder_btnGo")).click();
        driver.findElement(By.xpath(".//*[@id='ext-gen32']")).click();

        String maxDay1 = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[3]/td[4]")).getText();
        w24Page.addMaxTemp(0, Integer.parseInt(maxDay1.substring(0,2)));
        String minDay1 = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[3]/td[5]")).getText();
        w24Page.addMinTemp(0, Integer.parseInt(minDay1.substring(0,2)));


        String maxDay2 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[4]")).getText();
        w24Page.addMaxTemp(1, Integer.parseInt(maxDay2.substring(0,2)));
        String minDay2 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[5]")).getText();
        w24Page.addMinTemp(1, Integer.parseInt(minDay2.substring(0,2)));


        String maxDay3 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[4]")).getText();
        w24Page.addMaxTemp(2, Integer.parseInt(maxDay3.substring(0,2)));
        String minDay3 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[5]")).getText();
        w24Page.addMinTemp(2, Integer.parseInt(minDay3.substring(0,2)));


        String maxDay4 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[4]")).getText();
        w24Page.addMaxTemp(3, Integer.parseInt(maxDay4.substring(0,2)));
        String minDay4 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[5]")).getText();
        w24Page.addMinTemp(3, Integer.parseInt(minDay4.substring(0,2)));

        String maxDay5 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[4]")).getText();
        w24Page.addMaxTemp(4, Integer.parseInt(maxDay5.substring(0,2)));
        String minDay5 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[5]")).getText();
        w24Page.addMinTemp(4, Integer.parseInt(minDay5.substring(0,2)));

        w24Page.printBoth();
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
