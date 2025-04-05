package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class AccountRegistrationTest extends BasePage {

    public AccountRegistrationTest(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement agreeButton;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement confirmMsg;

    public void enterFirstName(String fName) {
        firstName.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        lastName.sendKeys(lName);
    }

    public static String generateDummyEmail() {
        String emailPrefix = "testuser";
        String domain = "@example.com";
        int randomNumber = new Random().nextInt(100);
        return emailPrefix + randomNumber + domain;
    }

    public void enterEmail() {
        email.sendKeys(AccountRegistrationTest.generateDummyEmail());
    }

    public void enterTelephone(String phone) {
        telephone.sendKeys(phone);
    }

    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void enterConfirmPassword(String confirmPwd) {
        confirmPassword.sendKeys(confirmPwd);
    }

    public void clickAgreeButton() {
        agreeButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public String getConfirmationMessage() {
        try {
            return confirmMsg.getText();
        }
        catch (Exception e){
            return e.getMessage();
        }

    }












}
