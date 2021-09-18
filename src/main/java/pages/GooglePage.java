package pages;

import org.openqa.selenium.By;
import utils.BaseUtil;

public class GooglePage extends BaseUtil {

    private static final By txtGoogleSearch = By.xpath("//input[@name='q']");
    private static final By linkSikulixGoogleSearch = By.xpath("//a[@href='http://sikulix.com/']");


    public static void typeTextOnGoogleSearch(String text){
        waitForElement(txtGoogleSearch,60);
        driver.findElement(txtGoogleSearch).sendKeys(text);
        log.info("Typed on the google search");
        waitForSeconds(2);
    }
    public static void clickOnSikulixLink(){
        waitForElement(linkSikulixGoogleSearch,60);
        driver.findElement(linkSikulixGoogleSearch).click();
        log.info("Clicked on Sikulix link and navigating to the page");
        waitForSeconds(3);
    }
}
