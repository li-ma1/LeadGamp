package web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static web.helpers.UserPropertiesReader.*;

public class MatchCompanyDriverTest extends BaseTest {

    @BeforeEach
    public void setUpTest() {
        open(BASE_URL, "");
    }

    @AfterEach
    public void cleanTest() {
        serverApi.getIdOfRelation(COMPANY_ID, DRIVER_ID);
        serverApi.deleteOfRelation();
    }

    @Test
    public void checkMatchRequest() {
        open(BASE_URL, "auth/company/sign-in");
        LoginCompanyTest.companyLoginTest(COMPANY_EMAIL, COMPANY_PASSWORD);
        companyAccountSteps.inputSearch(INPUT_SEARCH)
                .clickInviteToMatchForDriver(NAME_DRIVER)
                .clickButtonSendRequest()
                .checkMessageContactRequested(NAME_DRIVER)
                .checkMessageInviteToMatch();
        String numberFirst = companyAccountSteps.numberOfMatchedDrivers();
        loginSteps.clickCompanyLogout();
        openInNewTab("auth/driver/sign-in");
        LoginDriverTest.driverLoginTestByEmail(DRIVER_PHONE, DRIVER_PASSWORD);
        driverAccountSteps
                .clickButtonAcceptOnPopUp()
                .clickButtonAccept(COMPANY_NAME);
        loginSteps.clickDriverLogout();
        openInNewTab("auth/company/sign-in");
        LoginCompanyTest.companyLoginTest(COMPANY_EMAIL, COMPANY_PASSWORD);
        companyAccountSteps.inputSearch(INPUT_SEARCH)
                .checkEmailOfMatchedDriver(NAME_DRIVER, EMAIL_DRIVER);
        String numberSecond = companyAccountSteps.numberOfMatchedDrivers();
        System.out.println("У компании было " + numberFirst + " Matched Drivers");
        System.out.println("У компании стало " + numberSecond + " Matched Drivers");
        Assertions.assertEquals(Integer.parseInt(numberFirst), Integer.parseInt(numberSecond) + 1);
    }

    @Test
    public void checkDeclineRequest() {
        open(BASE_URL, "auth/company/sign-in");
        LoginCompanyTest.companyLoginTest(COMPANY_EMAIL, COMPANY_PASSWORD);
        companyAccountSteps.inputSearch(INPUT_SEARCH)
                .clickInviteToMatchForDriver(NAME_DRIVER)
                .clickButtonSendRequest()
                .checkMessageContactRequested(NAME_DRIVER)
                .checkMessageInviteToMatch();
        String numberFirst = companyAccountSteps.numberOfMatchedDrivers();
        loginSteps.clickCompanyLogout();
        openInNewTab("auth/driver/sign-in");
        LoginDriverTest.driverLoginTestByEmail(DRIVER_PHONE, DRIVER_PASSWORD);
        driverAccountSteps
                .clickButtonAcceptOnPopUp()
                .clickButtonDecline(COMPANY_NAME)
                .clickReasonDecline();
        loginSteps.clickDriverLogout();
        openInNewTab("auth/company/sign-in");
        LoginCompanyTest.companyLoginTest(COMPANY_EMAIL, COMPANY_PASSWORD);
        companyAccountSteps.inputSearch(INPUT_SEARCH)
                .checkDeclineMassage();
        String numberSecond = companyAccountSteps.numberOfMatchedDrivers();
        System.out.println("У компании было " + numberFirst + " Matched Drivers");
        System.out.println("У компании осталось " + numberSecond + " Matched Drivers");
        Assertions.assertEquals(Integer.parseInt(numberFirst), Integer.parseInt(numberSecond));
    }

    @Test
    public void checkGetContactRequest() {
        open(BASE_URL, "auth/company/sign-in");
        LoginCompanyTest.companyLoginTest(COMPANY_EMAIL, COMPANY_PASSWORD);
        companyAccountSteps.inputSearch(INPUT_SEARCH_CONTACT);
        String numberFirst = companyAccountSteps.numberOfBasicDrivers();
        companyAccountSteps.clickGetContact(NAME_CONTACT)
                .checkContact(NAME_CONTACT, EMAIL_CONTACT);
        String numberSecond = companyAccountSteps.numberOfBasicDrivers();
//        System.out.println("У компании было " + numberFirst + " Basic Drivers");
//        System.out.println("У компании осталось " + numberSecond + " Basic Drivers");
        serverApi.getIdOfRelation(COMPANY_ID, DRIVER_CONTACT_ID);
        serverApi.deleteOfRelation();

//        Assertions.assertEquals(Integer.parseInt(numberFirst), Integer.parseInt(numberSecond) + 1);
    }

}
