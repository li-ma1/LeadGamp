package api;

import org.junit.jupiter.api.Test;
import static web.helpers.UserPropertiesReader.*;


public class FilterTest extends BaseApiTest {

    @Test
    public void companyLoginApiTest() {
        companyApi.checkFilters(COMPANY_EMAIL, COMPANY_PASSWORD, "zip", "12345", "type-trailers", "7");
    }

}
