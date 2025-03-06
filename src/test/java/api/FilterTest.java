package api;

import org.junit.jupiter.api.Test;
import static web.helpers.UserPropertiesReader.*;


public class FilterTest extends BaseApiTest {

    @Test
    public void companyLoginApiTest() {
        companyApi.getTokenOfCompany(COMPANY_EMAIL, COMPANY_PASSWORD);
    }

}
