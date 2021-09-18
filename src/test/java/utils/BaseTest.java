package utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass()
    public void openHomePage() {
        BaseUtil.initializeLogger();
        BaseUtil.openBrowser();
    }

    @AfterClass()
    public void closeBrowser() {
        BaseUtil.closeBrowser();
    }

}
