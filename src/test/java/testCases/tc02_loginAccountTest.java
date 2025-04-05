package testCases;

import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class tc02_loginAccountTest extends BaseClass {

    @Test(groups = {"sanity","master"})
    public void verifyLogin(){

            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail(properties.getProperty("userEmail"));
            loginPage.setPassword(properties.getProperty("userPassword"));
            loginPage.clickLoginButton();

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.isMyAccountPageExist();
            Assert.assertTrue(targetPage);
    }

}
