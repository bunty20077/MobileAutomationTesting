package com.studysimple.pageObjects.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class OfferPageObject {

    AndroidDriver driver;

    public OfferPageObject(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @AndroidFindBy(id = "permission_allow_button")
    private WebElement allow2 ;

    @AndroidFindBy(id = "button1")
    private WebElement allow1 ;

    @AndroidFindBy(className = "android.widget.Button")
    private  List<WebElement> buttonElements2 ;

    @FindBy(id = "com.sraoss.dmrc:id/tvStationDepart")
    private WebElement departStation ;


    @FindBy(id = "com.sraoss.dmrc:id/tvStationDestination")
    private WebElement destinationStation ;

    public void getAPKInfo() throws InterruptedException {
        System.out.println("Get Apk Info");
        String packageName = driver.getCurrentPackage();
        String activityName = driver.currentActivity();
        System.out.print("Package Name is " + packageName);
        System.out.print("Activity Name is " + activityName);
        Thread.sleep(10000);
    }


    public void checkOKButton(int count){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if(count == 1 ){
            List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
            for(WebElement button : buttons){
                System.out.println("Button name is "+button.getText());
                if(button.getText().equals("OK")){
                    button.click();
                }
            }
        }else{
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement button = driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
            button.click();
        }
    }





    public void departTrainStation(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        departStation.click();
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView")).click();
        destinationStation.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
