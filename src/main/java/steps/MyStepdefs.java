package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.*;

public class MyStepdefs {
    HomeScreen homeScreen = new HomeScreen();
    CategoryScreen categoryScreen = new CategoryScreen();
    HomeDecorScreen homeDecorScreen = new HomeDecorScreen();
    DetailProductScreen detailProductScreen = new DetailProductScreen();
    CartScreen cartScreen = new CartScreen();
    LoginScreen loginScreen = new LoginScreen();

    @Given("Open Banggood Easy Online Shopping app")
    public void openBanggoodEasyOnlineShoppingApp() {
        homeScreen.turnOffPopUpNoti();
    }

    @When("Click to the Category on footer menu")
    public void clickToTheCategoryOnFooterMenu() {
        homeScreen.clickOnCategoryIcon();

    }


    @And("Scroll and click to Home and Garden in Left menu")
    public void scrollAndClickToHomeAndGardenInLeftMenu() {
        categoryScreen.clickOnHomeAndGarden();
    }

    @And("After the right category dsplayed , click to the Home Decor")
    public void afterTheRightCategoryDsplayedClickToTheHomeDecor() {
        categoryScreen.clickOnHomeDecor();
    }

    @And("Click to the Filter and select COD")
    public void clickToTheFilterAndSelectCOD() {
        homeDecorScreen.filterItemCod();
    }

    @And("Click Done")
    public void clickDone() {
        homeDecorScreen.clickOnDoneButton();

    }

    @And("Click first product")
    public void clickFirstProduct() {
        homeDecorScreen.clickFirstProduct();
    }

    @Then("Verify Product name should be displayed")
    public void verifyProductNameShouldBeDisplayed() {
        detailProductScreen.verifyProductName();
    }

    @And("Verify COD icon should be displayed")
    public void verifyCODIconShouldBeDisplayed() {
        detailProductScreen.verifyProductIconCod();
    }

    @When("At the Home Screen  , scroll to Hot Categories")
    public void atTheHomeScreenScrollToHotCategories() {
        homeScreen.scrollToHotCategory();
    }

    @And("Click to the SmartPhone category")
    public void clickToTheSmartPhoneCategory() {
        homeScreen.clickOnSmartPhone();
    }


    @And("Click to the  {string} \" product")
    public void clickToTheProduct(String arg0) {
        homeScreen.chooseProduct();
    }

    @And("The Product detail page should be display : Product name , product price , Buy now and Add to cart button")
    public void theProductDetailPageShouldBeDisplayProductNameProductPriceBuyNowAndAddToCartButton() {
        detailProductScreen.verifyProductDetails();
    }

    @And("Scroll to Shipping and Change Shipping Address to Alabama, United States and click continue")
    public void scrollToShippingAndChangeShippingAddressToAlabamaUnitedStatesAndClickContinue() {
        detailProductScreen.changeAddress();
    }

    @And("Click Add to cart")
    public void clickAddToCart() {
        detailProductScreen.clickOnAddToCart();
    }

    @And("Click Add to cart button")
    public void clickAddToCartButton() {
        detailProductScreen.clickOnAddToCart();
    }

    @And("Click con Cart icon on top")
    public void clickConCartIconOnTop() {
        detailProductScreen.clickOnCartIconOnTop();
    }

    @And("Verify product name , product size , product price and quatity should be displayed")
    public void verifyProductNameProductSizeProductPriceAndQuatityShouldBeDisplayed() {
        cartScreen.verifyCartScreen();
    }

    @When("Click Account on footer menu")
    public void clickAccountOnFooterMenu() {
        homeScreen.clickOnAccountIcon();
    }

    @And("Click View All Order")
    public void clickViewAllOrder() {
        homeScreen.clickOnViewAllOrder();

    }

    @And("Verify login screen should be displayed with : Email , password and sing-in button")
    public void verifyLoginScreenShouldBeDisplayedWithEmailPasswordAndSingInButton() {
        loginScreen.verifySignInScreen();
    }
}