package org.fasttrack.features;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.Utils.Constants;
import org.fasttrack.steps.LoginSteps;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {


    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;

    @Test
    public void validLoginTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        loginSteps.checkLoggedIn(Constants.USER_NAME);
    }

    @Test
    public void invalidLoginTestWithWrongPassword() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_EMAIL, "aaaaaaaaa");
        loginSteps.checkNotLoggedIn();
    }

    @Test
    public void invalidLoginTestWithWrongEmail() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin("QAautotest@mailinator", Constants.USER_PASSWORD);
        loginSteps.checkNotLoggedInWrongMail();
    }

    @Test
    public void invalidLoginTestEmptyFields() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin("", "");
        loginSteps.checkNotLoggedInWrongMail();
    }


}
