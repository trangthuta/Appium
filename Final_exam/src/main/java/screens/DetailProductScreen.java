package screens;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static core.utils.Swipe.swipeUntilElementIsDisplayed;

public class DetailProductScreen extends AppiumBase {
    public DetailProductScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.banggood.client:id/tv_product_name")
    private WebElement name;

    @FindBy(id = "com.banggood.client:id/tv_tag")
    private WebElement iconCOD;

    @FindBy(id = "com.banggood.client:id/tv_product_price")
    private WebElement price;

    @FindBy(id = "com.banggood.client:id/btn_slide_buy")
    private WebElement buyNow;

    @FindBy(id = "com.banggood.client:id/btn_slide_cart")
    private WebElement addToCart;

    @FindBy(id = "com.banggood.client:id/view_shipping_info")
    private WebElement shippingInfo;

    @FindBy(id = "com.banggood.client:id/tv_country_name")
    private WebElement addressBox;

    @FindBy(id = "com.banggood.client:id/et_search")
    private WebElement searchBox;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.banggood.client:id/rv\"]/android.widget.LinearLayout[2]")
    private WebElement resultSearch;

    @FindBy(id = "com.banggood.client:id/btn_continue")
    private WebElement continueButton;

    @FindBy(id = "com.banggood.client:id/menu_cart_icon")
    private WebElement cartIcon;



    public void verifyProductName() {
        wait.until(ExpectedConditions.visibilityOf(name));
        Assert.assertTrue(name.isDisplayed());
    }

    public void verifyProductIconCod() {
        wait.until(ExpectedConditions.visibilityOf(iconCOD));
        Assert.assertTrue(iconCOD.isDisplayed());
    }

    public void verifyProductPrice() {
        wait.until(ExpectedConditions.visibilityOf(price));
        Assert.assertTrue(price.isDisplayed());
    }

    public void verifyProductBuyNow() {
        wait.until(ExpectedConditions.visibilityOf(buyNow));
        Assert.assertTrue(buyNow.isDisplayed());
    }

    public void verifyProductAddToCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        Assert.assertTrue(addToCart.isDisplayed());
    }

    public void verifyProductDetails() {
        verifyProductName();
        verifyProductPrice();
        verifyProductBuyNow();
        verifyProductAddToCart();

    }

    public void changeAddress() {
        swipeUntilElementIsDisplayed(driver, "mid_to_top", shippingInfo);
        wait.until(ExpectedConditions.visibilityOf(shippingInfo));
        shippingInfo.click();

        wait.until(ExpectedConditions.visibilityOf(addressBox));
        addressBox.click();

        searchAddress("United States");
        searchAddress("Alabama");

        wait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();
    }


    public void searchAddress(String address) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.click();
        searchBox.sendKeys(address);
        wait.until(ExpectedConditions.visibilityOf(resultSearch));
        resultSearch.click();
    }

    public void clickOnAddToCart(){
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.click();
    }

    public void clickOnCartIconOnTop(){
        wait.until(ExpectedConditions.visibilityOf(cartIcon));
        cartIcon.click();
    }
}
