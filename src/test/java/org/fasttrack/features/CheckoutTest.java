package org.fasttrack.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.Utils.Constants;
import org.fasttrack.steps.AddToCartSteps;
import org.fasttrack.steps.CheckoutSteps;
import org.fasttrack.steps.LoginSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CheckoutTest  {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private AddToCartSteps addToCartSteps;

    @Steps
    private CheckoutSteps checkoutSteps;

    @Test
    public void checkoutUserNotLoggedIn(){

        loginSteps.navigateToHomepage();

        addToCartSteps.navigateToVipMenu();
        addToCartSteps.performAddToCart();
        addToCartSteps.verifyAddingToCart();

        checkoutSteps.proceedToCheckout();
        checkoutSteps.verifyUserNotLoggedIn();
    }

    @Test
    public void checkoutUserLogInAfterAddingToCart(){

        loginSteps.navigateToHomepage();
        addToCartSteps.navigateToVipMenu();
        addToCartSteps.clickOnItem(0);
        addToCartSteps.selectColor(0);
        addToCartSteps.selectDesiredSize(0);
        addToCartSteps.addToCart();
        addToCartSteps.verifyAddingToCart();

        checkoutSteps.proceedToCheckout();
        checkoutSteps.verifyUserNotLoggedIn();
        checkoutSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        checkoutSteps.checkUserLoggedIn(Constants.USER_NAME);

        checkoutSteps.completeCheckoutFields();
        checkoutSteps.verifyCheckoutComplete();
    }



}
