
import com.studysimple.pageObjects.android.OfferPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AppiumBasics extends BaseTest {


    @Test
    public void performTest() throws InterruptedException {

        OfferPageObject offerPageObject = new OfferPageObject(driver);
        System.out.println("Driver from AppiumBasic is  "+driver);
        offerPageObject.getAPKInfo();
        offerPageObject.checkOKButton(1);
        offerPageObject.checkOKButton(2);

        offerPageObject.departTrainStation();

        }

    }

/*
{
    "appium:devicename": "SayantanPhone",
    "appium:udid": "emulator-5554",
    "platformName": "Android",
    "appium:platformVersion": "12",
    "appium:app": "/Users/sayantan.tarafdar/Desktop/Codebase/MobileAutomationTesting/src/test/resources/dmrc.apk",
    "appium:automationName": "UiAutomator2",
    "appium:appPackage": "com.sraoss.dmrc",
    "appium:appActivity": "com.dmrc.app.ui.activity.SplashActivity"
}



    com.sraoss.dmrc:id/tvFristStation
    com.sraoss.dmrc:id/tvLastStation
*/


