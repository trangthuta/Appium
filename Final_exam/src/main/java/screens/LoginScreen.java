package screens;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginScreen extends AppiumBase {
    public LoginScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.banggood.client:id/et_email")
    private WebElement email;

    @FindBy(id = "com.banggood.client:id/et_pwd")
    private WebElement password;

    @FindBy(id = "com.banggood.client:id/btn_sign_in")
    private WebElement signInButton;

    public void verifySignInScreen(){
        //verify email
        wait.until(ExpectedConditions.visibilityOf(email)) ;
        Assert.assertTrue(email.isDisplayed());

        //verify password
        wait.until(ExpectedConditions.visibilityOf(password)) ;
        Assert.assertTrue(password.isDisplayed());

        //verify sign in button
        wait.until(ExpectedConditions.visibilityOf(signInButton)) ;
        Assert.assertTrue(signInButton.isDisplayed());
    }
}
