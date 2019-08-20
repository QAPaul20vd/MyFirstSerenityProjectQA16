package org.fasttrack.steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.CreateAccountPage;
import org.fasttrack.pages.HomePage;
import org.junit.Assert;

public class CreateAccountSteps extends PageObject {

    private HomePage homePage;
    private CreateAccountPage createAccountPage;

    @Step
    public void navigateToCreateAccountPage(){
        homePage.clickAccount();
        homePage.clickRegisterLink();
    }

    @Step
    public void insertDataIntoFields(String firstName, String lastName, String email, String password, String confirmPassword){
        createAccountPage.setListOfRequiredInputFields(firstName, lastName, email, password, confirmPassword);
    }

    @Step
    public void clickRegistrationButton(){
        createAccountPage.clickRegisterButton();
    }

    @Step
    public void verifyIfValidationAdviceIsDisplayed(){
        Assert.assertTrue(createAccountPage.checkIfErrorMessageIsDisplayed());
    }

    @Step
    public void verifyRegisterIsComplete(){
        createAccountPage.isRegistered();
    }


}
