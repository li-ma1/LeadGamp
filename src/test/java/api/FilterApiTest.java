package api;

import org.junit.jupiter.api.Test;
import static web.helpers.UserPropertiesReader.*;


public class FilterApiTest extends BaseApiTest {

    @Test
    public String checkApiFiltersWithOneParameter() {
        return companyApi.checkOneFilters(COMPANY_EMAIL, COMPANY_PASSWORD, "zip", INPUT_SEARCH, "count.All" );
    }

}
