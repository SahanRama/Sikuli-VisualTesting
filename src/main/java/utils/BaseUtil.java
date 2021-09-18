package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class BaseUtil {
    protected static WebDriver driver;
    protected static Logger log;

    public static void openBrowser(){
        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
        log.info("Chrome Driver is initiated");
        driver.manage().window().maximize();
    }
    public static void initializeLogger() {
        //Initialize the log4j logger
        log = LogManager.getLogger();
        System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        log.info("Initiating the test execution.");
        log.info("Started Executing :" );
    }
    public static void navigateToURL(String URL){
        driver.get(URL);
        log.info("Navigated to the URL : "+ URL);
    }
    public static void waitForElement(By locator, int timeout) {
        try{
            new WebDriverWait(driver, timeout).until
                    (ExpectedConditions.visibilityOfElementLocated(locator));}

        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void waitForSeconds(int waitTimeInSeconds) {
        try {
            TimeUnit.SECONDS.sleep(waitTimeInSeconds);
        } catch (InterruptedException e) {
            log.error("Interrupted Exception:", e);
            Thread.currentThread().interrupt();
        }
    }
    public static void closeBrowser(){
        driver.quit();
    }

}
