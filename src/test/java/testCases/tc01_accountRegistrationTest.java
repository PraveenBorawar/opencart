package testCases;

import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationTest;
import pageObjects.HomePage;

public class tc01_accountRegistrationTest extends BaseClass {

    @Test(groups = {"regression","master"})
    public void verifyRegistration(){

            HomePage h = new HomePage(driver);
            h.clickMyAccount();
            h.clickRegister();

            String password = randomAlphanumeric();
            AccountRegistrationTest regPage = new AccountRegistrationTest(driver);
            regPage.enterFirstName(randomString());
            regPage.enterLastName("user");
            regPage.enterEmail();
            regPage.enterTelephone("9876543210");
            regPage.enterPassword(password);
            regPage.enterConfirmPassword(password);
            regPage.clickAgreeButton();
            regPage.clickContinueButton();

            String confimationMsg = regPage.getConfirmationMessage();
            Assert.assertEquals(confimationMsg, "Your Account Has Been Created!");

    }

}
