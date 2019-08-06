package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://fasttrackit.org/selenium-test/customer/account/login/")
public class LoginPage extends PageObject {

    @FindBy(id = "email")
    private WebElementFacade emailField;

    @FindBy(id = "pass")
    private WebElementFacade passField;

    @FindBy(id = "send2")
    private WebElementFacade loginButton;

    @FindBy(css = ".error-msg span")
    private WebElementFacade errorMessageSpanWrongPassWord;

    @FindBy(css = ".validation-advice")
    private WebElementFacade errorMessage;

    public void setEmailField(String email) {
        typeInto(emailField, email);
    }

    public boolean emailFieldIsVisible(){
        return emailField.isCurrentlyVisible();
    }

    public void setPassField(String pass) {
        typeInto(passField, pass);
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public void verifyNotLoggedIn() {
        errorMessageSpanWrongPassWord.shouldContainText("Invalid login or password.");
    }

    public void verifyNotLoggedInWrongEmail(){
        errorMessage.isCurrentlyVisible();
    }



}
