package web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static web.helpers.UserPropertiesReader.BASE_URL;

public class LoginDriverTest extends BaseTest {

    @BeforeEach
    public void setUpTest() {
        open(BASE_URL,"auth/driver/sign-in");
    }

    @ParameterizedTest
    @CsvSource({"+13522773102, 123456789"})
    public static void driverLoginTestByEmail(String driverEmailOrPhone, String driverPassword) {
        loginSteps.enterEmailOrPhone(driverEmailOrPhone);
        loginSteps.enterDriverPassword(driverPassword);
        loginSteps.clickSubmitButton();
        loginSteps.assertCheckDriverAccount();
    }

    @AfterEach
    public void companyLogout(){
        loginSteps.clickDriverLogout();
    }
}