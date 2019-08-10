package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.*;
import org.junit.Assert;

public class WishlistSteps {

    private DetailsPage detailsPage;
    private ProductsPage productsPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private MyWishlistPage myWishlistPage;

    @Step
    public void navigateToSalePage() {
        homePage.clickSale();
    }

    @Step
    public void navigateToDetailsOfFirstProduct() {
        productsPage.clickDetail();
    }

    @Step
    public void clickAddToWishlist() {
        detailsPage.clickWishlistButton();
    }

    @Step
    public void userNotLoggedIn() {
        loginPage.emailFieldIsVisible();
    }

    @Step
    public void navigateToLoginPage() {
        homePage.open();
        homePage.clickAccount();
        homePage.clickLoginLink();
    }

    @Step
    public void performLogin(String email, String pass) {
        loginPage.setEmailField(email);
        loginPage.setPassField(pass);
        loginPage.clickLoginButton();
    }

    @Step
    public void successfullAddToWishlist() {
        Assert.assertTrue("The user is not logged in!", myWishlistPage.successMsgIsDisplayed());

    }

    @Step
    public void removeItemFromWishlist() {
        myWishlistPage.clickRemoveItem();
        myWishlistPage.getAlert().accept();
    }

    @Step
    public void checkIfItemWasDeleted() {
        Assert.assertTrue("Wishlist is not empty!", myWishlistPage.checkWishlistIsEmpty());
    }

}
