import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    private AppiumDriverLocalService service;
    AndroidDriver driver;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {

        try{
            service = new AppiumServiceBuilder()
                    .usingPort(4723)
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    .build();
            service.start();
            if (service == null || !service.isRunning()) {
                throw new RuntimeException("An appium server node is not started!");
            } else {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setNewCommandTimeout(Duration.ofMillis(20000));
                options.setAdbExecTimeout(Duration.ofMillis(20000));
                options.setDeviceName("SayantanPhone");
                options.setApp("src/test/resources/dmrc.apk");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                System.out.println("Driver from Configure Appium "+driver);
            }
        }catch(Exception expection){
            expection.getStackTrace();
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
