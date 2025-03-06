package web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static web.helpers.Waiters.*;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
    private WebElement signUp;

    @FindBy(xpath = "//a[contains(text(), 'Log In')]")
    private WebElement logIn;

    @FindBy(xpath = "//div[contains(text(),'Driver Login')]")
    private WebElement driverLogin;

    @FindBy(xpath = "//div[contains(text(),'Company Login')]")
    private WebElement companyLogin;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@placeholder = 'Password']")
    private WebElement passwordCompanyInput;

    @FindBy(xpath = "//input[@placeholder = 'Email']")
    private WebElement emailCompanyInput;

    @FindBy(xpath = "//input[@placeholder = 'Password']")
    private WebElement passwordDriverInput;

    @FindBy(xpath = "//input[@placeholder = 'Email or phone number']")
    private WebElement emailOrPhoneDriverInput;

    @FindBy(xpath = "//h2[contains(text(), 'Personal Information')]")
    private WebElement checkEnterDriverAccount;

    @FindBy(xpath = "//button[contains(text(), 'New Search')]")
    private WebElement checkEnterCompanyAccount;

    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    private WebElement driverLogout;

    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    private WebElement companyLogout;

    public void enterDriverEmailOrPhone(String emailOrPhone) {
        waitElement(emailOrPhoneDriverInput);
        emailOrPhoneDriverInput.click();
        emailOrPhoneDriverInput.sendKeys(emailOrPhone);
    }

    public void enterDriverPassword(String driverPassword) {
        waitElement(passwordDriverInput);
        passwordDriverInput.click();
        passwordDriverInput.sendKeys(driverPassword);
    }

    public void emailCompanyInput(String email) {
        waitElement(emailCompanyInput);
        emailCompanyInput.click();
        emailCompanyInput.sendKeys(email);
    }

    public void enterCompanyPassword(String companyPassword) {
        waitElement(passwordCompanyInput);
        passwordCompanyInput.click();
        passwordCompanyInput.sendKeys(companyPassword);
    }

    public void clickSubmitButton() {
        waitElement(submitButton).click();
    }

    public void clickSignUp() {
        waitElement(signUp).click();
    }

    public void clickLogIn() {
        waitElement(logIn).click();
    }

    public void clickDriverLogin() {
        waitElement(driverLogin).click();
    }

    public void clickDriverLogout() {
        waitElement(driverLogout).click();
    }

    public void clickCompanyLogIn() {
        waitElement(companyLogin).click();
    }

    public void clickCompanyLogout() {
        waitElement(companyLogout).click();
    }

    public void checkEnterDriverAccount() {
        waitElement(checkEnterDriverAccount);
    }

    public void checkEnterCompanyAccount() {
        waitElement(checkEnterCompanyAccount);
    }

}


