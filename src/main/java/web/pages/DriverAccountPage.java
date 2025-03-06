package web.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static web.drivers.DriverManager.clickOnElement;
import static web.drivers.DriverManager.getDriver;
import static web.helpers.Waiters.*;

public class DriverAccountPage extends BasePage{

    private WebElement buttonAccept(String nameCompany) {
        String xpath = String.format("//p[contains(text(), '%s')]/parent::*/parent::*//button[text()='Accept']", nameCompany);
        return getDriver().findElement(By.xpath(xpath));
    }

    private WebElement buttonDecline(String nameCompany) {
        String xpath = String.format("//*[contains(text(), '%s')]/parent::*/parent::*//button[text()='Decline']", nameCompany);
        return getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//button[contains(text(), 'Just do not like it')]")
    private WebElement buttonReason;

    @FindBy(xpath = "//button[contains(text(), 'Submit')]")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//button[text() = \"Let's check!\"]")
    private WebElement popUpButton;

    public void clickButtonAccept(String nameCompany) {
        waitElement(buttonAccept(nameCompany));
        scrollToElement(buttonAccept(nameCompany));
        clickOnElement(buttonAccept(nameCompany));
    }

    public void clickButtonAcceptPopUp() {
        waitElement(popUpButton);
        scrollToElement(popUpButton);
        clickOnElement(popUpButton);
    }

    public void clickButtonDecline(String nameCompany) {
        waitElement(buttonDecline(nameCompany));
        scrollToElement(buttonDecline(nameCompany));
        clickOnElement(buttonDecline(nameCompany));
    }

    public void clickReasonDecline() {
        clickOnElement(buttonReason);
        clickOnElement(buttonSubmit);
    }

}
