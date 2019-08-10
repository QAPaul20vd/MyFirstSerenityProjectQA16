package org.fasttrack.steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.CartPage;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.ProductsPage;
import org.junit.Assert;


public class AddToCartSteps extends PageObject {

    private HomePage homePage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    @Step
    public void navigateToVipMenu(){
        homePage.clickVip();
    }

    @Step
    public void performAddToCart(){
        productsPage.clickAddToCart();
    }

    @Step
    public void addToCart(){
        productsPage.addToCart();
    }

    @Step
    public void verifyAddingToCart(){
        cartPage.verifyProductIsAddedToCart();
    }

    @Step
    public void modifyQuantity(String desiredQty){
        cartPage.modifyQuantity(desiredQty);
        cartPage.updateQuantity();
    }

    @Step
    public void checkCalculation(String qty){
        Assert.assertTrue("Subtotal is not correct!",cartPage.verifyModifiedQuantitySubTotal(qty));
    }

    @Step
    public void continueShopping(){
        cartPage.clickContinueShopping();
    }

    @Step
    public void clickOnItem(int noOfProduct){
        productsPage.clickOnProductDetail(noOfProduct);
    }

    @Step
    public void selectColor(int noColor){
        productsPage.selectColor(noColor);
    }

    @Step
    public void selectDesiredSize(int noSize){
        productsPage.clickOneSize(noSize);
    }

    @Step
    public void verifySum(){
        Assert.assertTrue("Subtotal is not correct!",cartPage.verifySubtotalOfDifferentProducts());
    }









}
