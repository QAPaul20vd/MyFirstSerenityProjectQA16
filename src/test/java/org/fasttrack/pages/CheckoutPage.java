package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://fasttrackit.org/selenium-test/checkout/onepage/")
public class CheckoutPage extends PageObject {

    @FindBy(css = ".col-1 h3")
    private WebElementFacade checkoutOptions;

    @FindBy(css = "#login-email")
    private WebElementFacade emailField;

    @FindBy(css = "#login-password")
    private WebElementFacade passwordField;

    @FindBy(css = ".col-2 button")
    private WebElementFacade loginButton;

    public void verifyUserNotLoggedIn(){
        checkoutOptions.shouldBeCurrentlyVisible();
    }

    public void setEmailField(String email){
        typeInto(emailField, email);
    }

    public void setPasswordField(String password){
        typeInto(passwordField, password);
    }

    public void clickLogin(){
        clickOn(loginButton);
    }





}
