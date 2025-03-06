package web.steps;

import io.qameta.allure.Step;
import web.pages.CompanyAccountPage;

public class CompanyAccountSteps {

    protected CompanyAccountPage companyAccountPage;

    public CompanyAccountSteps() {
        companyAccountPage = new CompanyAccountPage();
    }

    @Step("Click on button SendRequest")
    public CompanyAccountSteps clickButtonSendRequest() {
        companyAccountPage.clickButtonSendRequest();
        return this;
    }

    @Step("Click on button InviteToMatch")
    public CompanyAccountSteps clickInviteToMatchForDriver(String name) {
        companyAccountPage.clickInviteToMatchForDriver(name);
        return this;
    }

    @Step("Click on button GetContact")
    public CompanyAccountSteps clickGetContact(String nameContact) {
        companyAccountPage.clickGetContact(nameContact);
        return this;
    }

    @Step("Input in Search Field")
    public CompanyAccountSteps inputSearch(String input) {
        companyAccountPage.inputSearchDriver(input);
        return this;
    }

    @Step("Click on driver")
    public CompanyAccountSteps clickOnDriver(String name) {
        companyAccountPage.clickOnDriverLine(name);
        return this;
    }

    @Step("Click on button Request")
    public CompanyAccountSteps clickOnRequest() {
        companyAccountPage.clickOnRequest();
        return this;
    }

    @Step("Click on button Yes")
    public CompanyAccountSteps clickOnYes() {
        companyAccountPage.clickOnYes();
        return this;
    }

    @Step("Check info message Invite To Match")
    public CompanyAccountSteps checkMessageInviteToMatch() {
        companyAccountPage.checkMessageInviteToMatch();
        return this;
    }

    @Step("Check inscription Contact Requested")
    public CompanyAccountSteps checkMessageContactRequested(String name) {
        companyAccountPage.checkMessageContactRequested(name);
        return this;
    }

    @Step("Check email of matched driver")
    public CompanyAccountSteps checkEmailOfMatchedDriver(String name, String email) {
        companyAccountPage.checkEmailOfMatchedDriver(name, email);
        return this;
    }

    @Step("Check contact driver")
    public CompanyAccountSteps checkContact(String name, String emailContact) {
        companyAccountPage.checkContact(name, emailContact);
        return this;
    }

    @Step("Check decline from driver")
    public CompanyAccountSteps checkDeclineMassage() {
        companyAccountPage.checkDeclineMassage();
        return this;
    }

    @Step("Check number of matched driver")
    public String numberOfMatchedDrivers() {
        return companyAccountPage.numberOfMatchedDrivers();
    }

    @Step("Check number of basic driver")
    public String numberOfBasicDrivers() {
        return companyAccountPage.numberOfBasicDrivers();
    }

}
