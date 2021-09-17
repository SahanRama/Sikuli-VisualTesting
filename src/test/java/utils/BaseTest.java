package utils;

import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass()
    public void openHomePage() {
        BaseUtil.initializeLogger();
        BaseUtil.openBrowser();
    }

}
