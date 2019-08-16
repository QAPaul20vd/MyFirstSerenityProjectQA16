package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class CheckoutPage extends PageObject {

    @FindBy(css = ".col-1 h3")
    private WebElementFacade checkoutOptions;

    @FindBy(css = "#login-email")
    private WebElementFacade emailField;

    @FindBy(css = "#login-password")
    private WebElementFacade passwordField;

    @FindBy(css = ".col-2 button")
    private WebElementFacade loginButton;

    @FindBy(css = ".welcome-msg")
    private WebElementFacade loggedInMesage;

    @FindBy(css = "#checkoutSteps button")
//    private List<WebElementFacade> listOfContinueButton;
    private WebElementFacade continueButton;

    @FindBy(css = "#checkoutSteps .step-title span")
    private List<WebElementFacade> listOfCheckoutSteps;

    @FindBy(css = "input[title*=this]")
    private WebElementFacade shipToThisAddressButton;

    @FindBy(css = "input[title*=different]")
    private WebElementFacade shipToDifferentAddressButton;

    @FindBy(css = "input[title*=Use]")
    private WebElementFacade useBillingAddressButton;

    @FindBy(css = "input[id*=free]")
    private WebElementFacade freeShippingButton;

    @FindBy(css = "#payment-buttons-container button")
    private WebElementFacade paymentButton;

    @FindBy(css = "button[title*=Place]")
    private WebElementFacade placeOrderButton;

    public void verifyUserNotLoggedIn() {
        checkoutOptions.shouldBeCurrentlyVisible();
    }

    public void setEmailField(String email) {
        typeInto(emailField, email);
    }

    public void setPasswordField(String password) {
        typeInto(passwordField, password);
    }

    public void clickLogin() {
        clickOn(loginButton);
    }

    public void verifyUserIsLoggedIn(String username) {
        loggedInMesage.shouldContainText(("Welcome, " + username + "!").toUpperCase());
    }
    @FindBy(css = "h1")
    private WebElementFacade successMsg;

    public void fillCheckoutFields() {

        clickOn(shipToDifferentAddressButton);
        clickOn(continueButton);
        waitFor(useBillingAddressButton);
        clickOn(useBillingAddressButton);//
        clickOn(findBy("#co-shipping-form button"));
        clickOn(freeShippingButton);//
        clickOn(findBy("#co-shipping-method-form button"));
        waitFor(paymentButton);
        clickOn(paymentButton);
        waitFor(placeOrderButton);
        clickOn(placeOrderButton);
        waitForTextToAppear("Your order # is:", 10000);
    }

    public void orderIsComplete(){
        successMsg.shouldContainText(("Your order has been received.").toUpperCase());
    }


}
