package screens;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartScreen extends AppiumBase {
    public CartScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.banggood.client:id/tv_product_name")
    private WebElement name;

    @FindBy(id = "com.banggood.client:id/tv_product_options")
    private WebElement size;

    @FindBy(id = "com.banggood.client:id/tv_product_price")
    private WebElement price;

    @FindBy(id = "com.banggood.client:id/edit_qty")
    private WebElement quantity;

    public void verifyCartScreen(){
        //verifyName
        wait.until(ExpectedConditions.visibilityOf(name)) ;
        Assert.assertTrue(name.isDisplayed());

        //verify price
        wait.until(ExpectedConditions.visibilityOf(price)) ;
        Assert.assertTrue(price.isDisplayed());

        //verify size
        wait.until(ExpectedConditions.visibilityOf(size)) ;
        Assert.assertTrue(size.isDisplayed());

        //verify quantity
        wait.until(ExpectedConditions.visibilityOf(quantity)) ;
        Assert.assertTrue(quantity.isDisplayed());
    }
}
