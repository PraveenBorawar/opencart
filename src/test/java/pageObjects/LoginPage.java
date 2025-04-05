package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//input[@id='input-email']")
    WebElement addEmail ;

    @FindBy(xpath ="//input[@id='input-password']")
    WebElement addPassword;

    @FindBy(xpath ="//input[@value='Login']")
    WebElement loginButton;

    public void setEmail(String email) {
        addEmail.sendKeys(email);
    }

    public void setPassword(String password) {
        addPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
