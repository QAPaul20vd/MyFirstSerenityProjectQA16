package org.fasttrack.steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.CartPage;
import org.fasttrack.pages.CheckoutPage;

public class CheckoutSteps extends PageObject {

    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Step
    public void proceedToCheckout(){
        cartPage.clickCheckoutButton();
    }

    @Step
    public void verifyUserNotLoggedIn(){
        checkoutPage.verifyUserNotLoggedIn();
    }

    @Step
    public void performLogin(String email, String password){
        checkoutPage.setEmailField(email);
        checkoutPage.setPasswordField(password);
        checkoutPage.clickLogin();
    }


}
