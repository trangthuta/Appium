package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AppiumBase {
    public static AndroidDriver driver;
    public static WebDriverWait wait;

    public void createDriver() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("Uiautomator2");
        uiAutomator2Options.setUdid("emulator-5556");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAppPackage("com.banggood.client");
        uiAutomator2Options.setAppActivity("com.banggood.client.module.home.MainActivity");
        uiAutomator2Options.setChromedriverExecutable("G:\\chromedriver.exe");

        this.driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), uiAutomator2Options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
