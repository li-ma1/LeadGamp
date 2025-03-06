package web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static web.helpers.UserPropertiesReader.BASE_URL;

public class LoginCompanyTest extends BaseTest {

    @BeforeEach
    public void setUpTest() {
        open(BASE_URL,"auth/company/sign-in");
    }

    @ParameterizedTest
    @CsvSource({"lili@tpbay.site, 123456789"})
    public static void companyLoginTest(String companyEmail, String companyPassword) {
        loginSteps.emailCompanyInput(companyEmail);
        loginSteps.enterCompanyPassword(companyPassword);
        loginSteps.clickSubmitButton();
        loginSteps.assertCheckCompanyAccount();
    }

    @AfterEach
    public void companyLogout(){
        loginSteps.clickCompanyLogout();
    }

}