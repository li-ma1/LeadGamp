package api;

import api.service.CompaniesService;
import api.service.ServerService;

public class BaseApiTest {
    protected static ServerService serverApi;
    protected static CompaniesService companyApi;

    public BaseApiTest() {
        serverApi = new ServerService();
        companyApi = new CompaniesService();
    }
}
