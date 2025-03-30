package web;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static web.helpers.UserPropertiesReader.*;

public class FilterTest extends BaseTest {

    @BeforeEach
    public void setUpTest() {
        open(BASE_URL, "");
    }

    @Test
    @Description("Проверка, что количество полученных водителей через апи и через фронт при одинаковом фильтре совпадает")
    public void checkFilters() throws InterruptedException {
        open(BASE_URL, "auth/company/sign-in");
        LoginCompanyTest.companyLoginTest(COMPANY_EMAIL, COMPANY_PASSWORD);
        companyAccountSteps.inputSearch(INPUT_SEARCH);
        String countFront = companyAccountSteps.checkCount();
        String countApi = companyApi.checkOneFilters(COMPANY_EMAIL, COMPANY_PASSWORD, "zip", INPUT_SEARCH, "count.All");
        Assertions.assertEquals(countFront, countApi);
    }

    @Test
    @Description("Проверка, что количество полученных водителей через апи и через фронт при одинаковых нескольких фильтрах совпадает")
    public void checkThreeFilters() throws InterruptedException {
        open(BASE_URL, "auth/company/sign-in");
        LoginCompanyTest.companyLoginTest(COMPANY_EMAIL, COMPANY_PASSWORD);
        companyAccountSteps.experienceSearch(FILTER_EXPERIENCE)
                .freightTypeSearch(FILTER_FREIGHTTYPE)
                .homeTimesSearch(FILTER_HOMETIMES);
        String countFront = companyAccountSteps.checkCount();
        System.out.println(countFront);
        String countApi = companyApi.checkThreeFilters(COMPANY_EMAIL, COMPANY_PASSWORD, "home_times[]", "1", "min_experience", "12", "type_trailers[]", "1", "count.All");
        System.out.println(countApi);
        Assertions.assertEquals(countFront, countApi);
    }

    @Test
    @Description("Проверка, что фильтр при пагинации остается тем же")
    public void checkPagination() throws InterruptedException {
        open(BASE_URL, "auth/company/sign-in");
        LoginCompanyTest.companyLoginTest(COMPANY_EMAIL, COMPANY_PASSWORD);
        companyAccountSteps.experienceSearch(FILTER_EXPERIENCE)
                .freightTypeSearch(FILTER_FREIGHTTYPE)
                .homeTimesSearch(FILTER_HOMETIMES);
        String valueSearch = companyAccountSteps.changePage();
        System.out.println(valueSearch);
        Assertions.assertEquals(valueSearch, "Experience: " + FILTER_EXPERIENCE + ", Freights: " + FILTER_FREIGHTTYPE + ", Home Time: " + FILTER_HOMETIMES + "");
    }

    @Test
    @Description("Проверка, что сервисным компаниям доступны сервсиные водители, а несервисным нет")
    public void checkServiceAccount() throws InterruptedException {
        open(BASE_URL, "auth/company/sign-in");
        LoginCompanyTest.companyLoginTest(COMPANY_EMAIL, COMPANY_PASSWORD);
        companyAccountSteps.inputSearch("12345");
        String countFrontNotService = companyAccountSteps.checkCount();
        System.out.println(countFrontNotService);
        loginSteps.clickCompanyLogout();
        LoginCompanyTest.companyLoginTest("lili456@li.com", COMPANY_PASSWORD);
        companyAccountSteps.inputSearch("12345");
        String countFrontService = companyAccountSteps.checkCount();
        System.out.println(countFrontService);
        Assertions.assertNotEquals(countFrontNotService, countFrontService);
    }

    @Test
    @Description("Проверка, что до мэтча емейл и телефон пустые через апи, а после - не пустые")
    public void checkValueEmailAndPhone() {
        String emailBefore = companyApi.checkOneFilters(COMPANY_EMAIL, COMPANY_PASSWORD, "zip", INPUT_SEARCH_CONTACT, "data.email");
        String phoneBefore = companyApi.checkOneFilters(COMPANY_EMAIL, COMPANY_PASSWORD, "zip", INPUT_SEARCH_CONTACT, "data.phone_number");
        System.out.println(emailBefore);
        System.out.println(phoneBefore);
        Assertions.assertEquals(emailBefore, "[null]");
        Assertions.assertEquals(phoneBefore, "[null]");
        open(BASE_URL, "auth/company/sign-in");
        LoginCompanyTest.companyLoginTest(COMPANY_EMAIL, COMPANY_PASSWORD);
        companyAccountSteps.inputSearch(INPUT_SEARCH_CONTACT);
        companyAccountSteps.clickGetContact(NAME_CONTACT);
        String emailAfter = companyApi.checkOneFilters(COMPANY_EMAIL, COMPANY_PASSWORD, "zip", INPUT_SEARCH_CONTACT, "data[0].email");
        String phoneAfter = companyApi.checkOneFilters(COMPANY_EMAIL, COMPANY_PASSWORD, "zip", INPUT_SEARCH_CONTACT, "data[0].phone_number");
        System.out.println(emailAfter);
        System.out.println(phoneAfter);
        Assertions.assertNotNull(emailAfter);
        Assertions.assertNotNull(phoneAfter);
        serverApi.getIdOfRelation(COMPANY_ID, DRIVER_CONTACT_ID);
        serverApi.deleteOfRelation();
    }
}
