package org.fasttrack.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.CreateAccountSteps;
import org.fasttrack.steps.LoginSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CreateAccountTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private CreateAccountSteps createAccountSteps;

    @Test
    public void fillUpFieldsWithValidInformationTest(){
        loginSteps.navigateToHomepage();
        createAccountSteps.navigateToCreateAccountPage();
        createAccountSteps.insertDataIntoFields("Auto", "Test", "autotest@mailinator.com", "autotest1234", "autotest1234");
        createAccountSteps.clickRegistrationButton();
        createAccountSteps.verifyRegisterIsComplete();
    }

    @Test
    public void verifyIfEmptyFieldsHaveValidationAdviceTest(){
        loginSteps.navigateToHomepage();
        createAccountSteps.navigateToCreateAccountPage();
        createAccountSteps.clickRegistrationButton();
        createAccountSteps.verifyIfValidationAdviceIsDisplayed();
    }

    @Test
    public void oneFieldLeftEmptyTest(){
        loginSteps.navigateToHomepage();
        createAccountSteps.navigateToCreateAccountPage();
        createAccountSteps.insertDataIntoFields("Auto", "Test", "", "autotest1234", "autotest1234");
        createAccountSteps.clickRegistrationButton();
        createAccountSteps.verifyIfValidationAdviceIsDisplayed();
    }
}
