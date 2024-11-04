package screens;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeDecorScreen extends AppiumBase {
    public HomeDecorScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.banggood.client:id/iv_filter")
    private WebElement filterIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_name\" and @text=\"COD\"]")
    private WebElement cod;

    @FindBy(id = "com.banggood.client:id/btn_done")
    private WebElement doneButton;

    @FindBy(xpath = "(//android.widget.FrameLayout[@resource-id=\"com.banggood.client:id/item_view\"])[1]/android.view.ViewGroup")
    private WebElement firstProduct;


    public  void filterItemCod(){
        wait.until(ExpectedConditions.visibilityOf(filterIcon)) ;
        filterIcon.click();
        wait.until(ExpectedConditions.visibilityOf(cod)) ;
        cod.click();
    }

    public void clickOnDoneButton(){
        wait.until(ExpectedConditions.visibilityOf(doneButton)) ;
        doneButton.click();
    }

    public void clickFirstProduct(){
        wait.until(ExpectedConditions.visibilityOf(firstProduct)) ;
        firstProduct.click();
    }

}
