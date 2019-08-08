package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.AccountPage;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.LoginPage;
import org.junit.Assert;

public class LoginSteps {

    private AccountPage accountPage;
    private HomePage homePage;
    private LoginPage loginPage;

    @Step
    public void navigateToLoginPage(){
        homePage.open();
        homePage.clickAccount();
        homePage.clickLoginLink();
    }

    @Step
    public void performLogin(String email, String pass){
        loginPage.setEmailField(email);
        loginPage.setPassField(pass);
        loginPage.clickLoginButton();
    }

    @Step
    public void checkLoggedIn(String username){
        Assert.assertTrue("The username is not correct!",accountPage.isLoggedIn(username));
    }

    @Step
    public void checkNotLoggedIn(){
        loginPage.verifyNotLoggedIn();
    }

    @Step
    public void checkNotLoggedInWrongMail(){
        loginPage.verifyNotLoggedInWrongEmail();
    }

    @Step
    public void navigateToHomepage(){
        homePage.open();
    }

}
