package screens;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.utils.Swipe.swipeUntilElementIsDisplayed;

public class CategoryScreen extends AppiumBase {
    public CategoryScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_category_name\" and @text=\"Home and Garden\"]")
    private WebElement homeAndGardenMenu;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_category_title\" and @text=\"Home Decor\"]")
    private  WebElement homeDecor ;


    public void clickOnHomeAndGarden() {
        swipeUntilElementIsDisplayed(driver, "left_to_up", homeAndGardenMenu);
        wait.until(ExpectedConditions.visibilityOf(homeAndGardenMenu));
        if (homeAndGardenMenu.isDisplayed()) {
            homeAndGardenMenu.click();
        }

    }

    public  void  clickOnHomeDecor(){
        wait.until(ExpectedConditions.visibilityOf(homeDecor));
        homeDecor.click();
    }
}
