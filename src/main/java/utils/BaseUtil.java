package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUtil {
    protected static WebDriver driver;
    protected static Logger log;

    public static void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
    }
}
