package web.steps;
import io.qameta.allure.Step;
import web.pages.LoginPage;

public class LoginSteps {

    protected LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }


    @Step("Enter valid driver's email or phone")
    public LoginSteps enterEmailOrPhone(String emailOrPhone) {
        loginPage.enterDriverEmailOrPhone(emailOrPhone);
        return this;
    }

    @Step("Enter valid company's email")
    public LoginSteps emailCompanyInput(String email) {
        loginPage.emailCompanyInput(email);
        return this;
    }

    @Step("Enter valid driver's password")
    public LoginSteps enterDriverPassword(String driverPassword) {
        loginPage.enterDriverPassword(driverPassword);
        return this;
    }

    @Step("Enter valid company's password")
    public LoginSteps enterCompanyPassword(String companyPassword) {
        loginPage.enterCompanyPassword(companyPassword);
        return this;
    }

    @Step("Click Submit")
    public LoginSteps clickSubmitButton() {
        loginPage.clickSubmitButton();
        return this;
    }

    @Step("Click Driver Login")
    public LoginSteps clickDriverLogin() {
        loginPage.clickDriverLogin();
        return this;
    }

    @Step("Click Driver Logout")
    public LoginSteps clickDriverLogout() {
        loginPage.clickDriverLogout();
        return this;
    }

    @Step("Click Company Login")
    public LoginSteps clickCompanyLogIn() {
        loginPage.clickCompanyLogIn();
        return this;
    }

    @Step("Click Company Logout")
    public LoginSteps clickCompanyLogout() {
        loginPage.clickCompanyLogout();
        return this;
    }

    @Step("Check Driver Account")
    public LoginSteps assertCheckDriverAccount() {
        loginPage.checkEnterDriverAccount();
        return this;
    }

    @Step("Check Company Account")
    public LoginSteps assertCheckCompanyAccount() {
        loginPage.checkEnterCompanyAccount();
        return this;
    }
}
