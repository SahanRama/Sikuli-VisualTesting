package utils;


import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SikuliUtils extends BaseUtil {

   protected static Screen screen = new Screen(Screen.getPrimaryId());


    public static Boolean isElementPresent(String[] imageData){
       screen.click();
        Match matchResults = screen.exists(imageData[0]);
        if (matchResults == null)
            return false;
        else {
            double actualScore = matchResults.getScore() * 100.0;
            actualScore = BigDecimal.valueOf(actualScore).setScale(2, RoundingMode.UP).doubleValue();
            double imageScore = Double.parseDouble(imageData[1]);
            log.info(imageData[0] + " Actual score is : "+ actualScore + " (Expected : "+imageScore+")");
            System.out.println(imageData[0] + " Actual score is : "+ actualScore + " (Expected : "+imageScore+")");
            return actualScore >= imageScore;
        }
    }

    public static void captureScreenToImage(String toImageFilePath, String fileName){
        screen.capture().save(toImageFilePath,fileName);
    }
    public static void clickOnImage(String imageURL) {
       screen.click();
        Pattern image = new Pattern(imageURL);
        try {
            screen.wait(image, 20);
            screen.find(image);
            screen.click(image);
            BaseUtil.waitForSeconds(6);
        } catch (FindFailed e) {
            e.printStackTrace();
        }

    }
}
