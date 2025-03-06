package core.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class Swipe {
    public static void swipeUntilElementIsDisplayed(AndroidDriver driver, String direction, WebElement element) {
        while (!isElementDisplayed(element)) {
            Dimension size = driver.manage().window().getSize();
            int startx, endx, starty, endy;

            switch (direction.toLowerCase()) {
                case "left":
                    // Vuốt từ phải sang trái
                    startx = (int) (size.width * 0.9);
                    endx = (int) (size.width * 0.1);
                    starty = size.height / 2;
                    swipe(driver, startx, starty, endx, starty, 1000); // Vuốt trái
                    break;
                case "right":
                    // Vuốt từ trái sang phải
                    startx = (int) (size.width * 0.1);
                    endx = (int) (size.width * 0.9);
                    starty = size.height / 2;
                    swipe(driver, startx, starty, endx, starty, 1000); // Vuốt phải
                    break;
                case "mid_to_bottom":
                    // Vuốt từ giữa xuống dưới
                    startx = size.width / 2;
                    starty = size.height / 2;
                    endy = (int) (size.height * 0.9); // Kết thúc tại 90% chiều cao màn hình
                    swipe(driver, startx, starty, startx, endy, 1000); // Vuốt xuống
                    break;
                case "mid_to_top":
                    // Vuốt từ giữa lên trên
                    startx = size.width / 2;
                    starty = size.height / 2;
                    endy = (int) (size.height * 0.1); // Kết thúc tại 10% chiều cao màn hình
                    swipe(driver, startx, starty, startx, endy, 1000); // Vuốt lên
                    break;
                case "right_to_up":
                    // Vuốt từ bên phải lên trên
                    startx = (int) (size.width * 0.9);
                    starty = (int) (size.height * 0.8);
                    endy = (int) (size.height * 0.2); // Kết thúc tại 20% chiều cao màn hình
                    swipe(driver, startx, starty, startx, endy, 1000); // Vuốt lên
                    break;
                case "right_to_bottom":
                    // Vuốt từ bên phải xuống dưới
                    startx = (int) (size.width * 0.9);
                    starty = (int) (size.height * 0.2);
                    endy = (int) (size.height * 0.8); // Kết thúc tại 80% chiều cao màn hình
                    swipe(driver, startx, starty, startx, endy, 1000); // Vuốt xuống
                    break;
                case "left_to_up":
                    // Vuốt từ bên trái lên trên
                    startx = (int) (size.width * 0.1);
                    starty = (int) (size.height * 0.8);
                    endy = (int) (size.height * 0.2); // Kết thúc tại 20% chiều cao màn hình
                    swipe(driver, startx, starty, startx, endy, 1000); // Vuốt lên
                    break;
                case "left_to_bottom":
                    // Vuốt từ bên trái xuống dưới
                    startx = (int) (size.width * 0.1);
                    starty = (int) (size.height * 0.2);
                    endy = (int) (size.height * 0.8); // Kết thúc tại 80% chiều cao màn hình
                    swipe(driver, startx, starty, startx, endy, 1000); // Vuốt xuống
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction: " + direction);
            }
        }
    }

    public static void swipe(AndroidDriver driver, int startx, int starty, int endx, int endy, long duration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipeSequence = new Sequence(finger, 1);

        swipeSequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startx, starty));
        swipeSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipeSequence.addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), endx, endy));
        swipeSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipeSequence));
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
