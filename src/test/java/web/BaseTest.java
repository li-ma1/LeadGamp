package web;

import api.service.CompaniesService;
import api.service.ServerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import web.steps.*;

import web.drivers.DriverManager;

import java.util.Set;

import static web.helpers.UserPropertiesReader.BASE_URL;

public class BaseTest {
    protected static LoginSteps loginSteps;
    protected DriverAccountSteps driverAccountSteps;
    protected CompanyAccountSteps companyAccountSteps;
    protected static ServerService serverApi;
    protected static CompaniesService companyApi;

    public BaseTest() {
        refreshPages();
        serverApi = new ServerService();
        companyApi = new CompaniesService();
    }

    protected void open(String baseUrl, String pageUrl) {
        DriverManager.getDriver()
                .get(baseUrl + pageUrl);
    }

    protected void openInNewTab(String pageUrl) {
        String originalWindow = DriverManager.getDriver().getWindowHandle();
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.open();");
        Set<String> allWindows = DriverManager.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                DriverManager.getDriver().switchTo().window(window);
                break;
            }
        }
        DriverManager.getDriver().get(BASE_URL + pageUrl);
    }

    @BeforeEach
    public void driverInitialization() {
        DriverManager.getDriver();
        refreshPages();
    }

    @AfterEach
    public void clearCache() {
        DriverManager.resetDriver();
    }

    private void refreshPages() {
        loginSteps = new LoginSteps();
        driverAccountSteps = new DriverAccountSteps();
        companyAccountSteps = new CompanyAccountSteps();
    }

    public void closeDriver() {
        DriverManager.closeDriver();
    }
}

