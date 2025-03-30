package api;

import api.service.CompaniesService;
import api.service.ServerService;

public class BaseApiTest {
    protected static ServerService serverApi;
    public static CompaniesService companyApi;

    public BaseApiTest() {
        serverApi = new ServerService();
        companyApi = new CompaniesService();
    }

}
