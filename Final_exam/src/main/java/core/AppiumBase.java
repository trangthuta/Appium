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
        uiAutomator2Options.setUdid("emulator-5554");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAppPackage("com.banggood.client");
        uiAutomator2Options.setAppActivity("com.banggood.client.module.home.MainActivity");
        uiAutomator2Options.setChromedriverExecutable("G:\\chromedriver.exe");

        this.driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), uiAutomator2Options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void verifyElement(WebElement e, String msg) {
        wait.until(ExpectedConditions.visibilityOf(e));
        Assert.assertTrue(e.isDisplayed(), msg);
    }


    public void verifyManyElements(List<String> expectedResult, List<WebElement> elements) {
        List<String> actualTexts = new ArrayList<>();
        if (elements.isEmpty()) {
            System.out.println("No elements found to verify.");
            Assert.fail("No elements found to verify.");
            return;
        }

        for (WebElement e : elements) {
            if (!e.getText().trim().isEmpty()) {
                actualTexts.add(e.getText().trim());
            } else {
                String s = e.getAttribute("content-desc");
                actualTexts.add(s.trim());
            }
        }
        Assert.assertEquals(expectedResult.size(), actualTexts.size(), "Expected and actual lists size mismatch!");
        for (int i = 0; i < expectedResult.size(); i++) {
            Assert.assertEquals(expectedResult.get(i).trim(), actualTexts.get(i).trim(), "Mismatch at index " + i + " element expect:  " + expectedResult.get(i) + " but displayed : " + actualTexts.get(i));
        }
    }


    public void clickButton(WebElement e) {
        wait.until(ExpectedConditions.elementToBeClickable(e));
        e.click();
    }

    public void verifyNumberElements(int num, List<WebElement> ls) {
        Assert.assertEquals(num, ls.size(), " Không hiển thị đủ " + num + " phần tử ");
    }


}
