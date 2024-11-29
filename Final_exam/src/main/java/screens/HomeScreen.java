package screens;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.utils.Swipe.swipeUntilElementIsDisplayed;

public class HomeScreen extends AppiumBase {
    public HomeScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowNotiButton;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.banggood.client:id/tab_icon\"])[1]")
    private WebElement categoryIcon;


    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.banggood.client:id/channel_list\"]/android.widget.LinearLayout")
    private WebElement hotCategory;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_title\" and @text=\"Smartphones\"]")
    private WebElement smartPhone;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_product_name\" and @text=\"  Ulefone Armor 26 Ultra 5G 200MP Quad Camera 64MP Night Vision 121dB Thunder Speaker 15600mAh 120W Fast Charge 24GB 512GB Dimensity 8020 NFC 6.78 inch 120Hz IP68 IP69K Waterproof Rugged Smartphone\"]")
    private WebElement chooseProduct;

    @FindBy(id = "com.banggood.client:id/main_tab_account")
    private WebElement accountIcon;

    @FindBy(id = "com.banggood.client:id/tv_view_all")
    private WebElement viewAllOrder;


    public void turnOffPopUpNoti() {
        wait.until(ExpectedConditions.visibilityOf(allowNotiButton));
        allowNotiButton.click();
    }

    public void clickOnCategoryIcon() {
        wait.until(ExpectedConditions.visibilityOf(categoryIcon));
        categoryIcon.click();
    }

    public void scrollToHotCategory() {
        swipeUntilElementIsDisplayed(driver, "mid_to_top", smartPhone);
        wait.until(ExpectedConditions.visibilityOf(smartPhone));
    }

    public  void clickOnSmartPhone(){
        wait.until(ExpectedConditions.visibilityOf(smartPhone));
        smartPhone.click();
    }

    public void  chooseProduct(){
        swipeUntilElementIsDisplayed(driver , "mid_to_top" , chooseProduct) ;
        wait.until(ExpectedConditions.visibilityOf(chooseProduct));
        chooseProduct.click();
    }

    public void  clickOnAccountIcon(){
        wait.until(ExpectedConditions.visibilityOf(accountIcon));
        accountIcon.click();
    }

    public void  clickOnViewAllOrder(){
        wait.until(ExpectedConditions.visibilityOf(viewAllOrder));
        viewAllOrder.click();
    }


}
