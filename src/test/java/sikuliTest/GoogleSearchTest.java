package sikuliTest;

import data.ImageSet;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.GooglePage;
import utils.BaseTest;
import utils.BaseUtil;
import utils.SikuliUtils;

public class GoogleSearchTest extends BaseTest {
    @Test
    public void verifyCorrectSikuliXLogoIsVisibleInHomePage(){
        BaseUtil.navigateToURL("https://www.google.com/");
        GooglePage.typeTextOnGoogleSearch("Sikulix");

        //click on the Google search button using sikulix
        SikuliUtils.clickOnImage(ImageSet.IMAGE_GOOGLE_SEARCH_BUTTON);

        //click on the Sikulix link on google search results
        GooglePage.clickOnSikulixLink();
        SoftAssert softAssert = new SoftAssert();

        //verify the correct image logo is displayed on Sikulix page
        softAssert.assertTrue(SikuliUtils.isElementPresent(ImageSet.IMAGE_SIKULIX_LOGO),"Sikulix Logo is not Visible");
        softAssert.assertAll();


    }

}
