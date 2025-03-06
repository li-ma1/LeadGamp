package web.steps;
import io.qameta.allure.Step;
import web.pages.DriverAccountPage;


public class DriverAccountSteps {

    protected DriverAccountPage driverAccountPage;

    public DriverAccountSteps() {
        driverAccountPage = new DriverAccountPage();
    }


    @Step("Click on button Accept")
    public DriverAccountSteps clickButtonAccept(String nameCompany) {
        driverAccountPage.clickButtonAccept(nameCompany);
        return this;
    }

    @Step("Click on button Accept on PopUp")
    public DriverAccountSteps clickButtonAcceptOnPopUp() {
        driverAccountPage.clickButtonAcceptPopUp();
        return this;
    }

    @Step("Click on button Decline")
    public DriverAccountSteps clickButtonDecline(String nameCompany) {
        driverAccountPage.clickButtonDecline(nameCompany);
        return this;
    }

    @Step("Click on reason Decline")
    public DriverAccountSteps clickReasonDecline() {
        driverAccountPage.clickReasonDecline();
        return this;
    }

}
