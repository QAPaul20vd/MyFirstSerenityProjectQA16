package org.fasttrack.features;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.LoginSteps;
import org.fasttrack.steps.WishlistSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WishlistTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private WishlistSteps wishlistSteps;
    private LoginSteps loginSteps;

    private String userEmail = "QAautotest@mailinator.com";
    private String userPass = "autotest123";
    private String userName = "Auto Test";

    @Test
    public void addToWishlistNotLoggedIn(){
        wishlistSteps.navigateToSalePage();
        wishlistSteps.navigateToDetailsOfFirstProduct();
        wishlistSteps.clickAddToWishlist();
        wishlistSteps.userNotLoggedIn();

    }

    @Test
    public void addToWishlistLoggedIn(){
        wishlistSteps.navigateToLoginPage();
        wishlistSteps.performLogin(userEmail,userPass);
        wishlistSteps.navigateToSalePage();
        wishlistSteps.navigateToDetailsOfFirstProduct();
        wishlistSteps.clickAddToWishlist();
        wishlistSteps.successfullAddToWishlist();
        wishlistSteps.removeItemFromWishlist();
    }

}
