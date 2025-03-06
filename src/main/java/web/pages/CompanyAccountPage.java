package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static web.drivers.DriverManager.*;
import static web.drivers.DriverManager.clickOnElement;
import static web.helpers.Waiters.*;

public class CompanyAccountPage extends BasePage {
    private WebElement clickOnDriver(String name) {
        String xpath = String.format("//*[contains(text(), '%s')]", name);
        return getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//button[contains(text(), 'Request for match')]")
    private WebElement clickRequest;

    @FindBy(xpath = "//button[contains(text(), 'Yes')]")
    private WebElement clickYes;

    private WebElement inviteToMatchForDriver(String name) {
        String xpath = String.format("//*[contains(text(), '%s')]/parent::*/parent::*/parent::*/td/div/button", name);
        return getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//button[contains(text(), 'Send request')]")
    private WebElement buttonSendRequest;

    @FindBy(xpath = "//div[contains(text(), 'Invite to match sent')]")
    private WebElement messageInviteToMatch;

    private WebElement messageContactRequested(String name) {
        String xpath = String.format("//*[contains(text(), '%s')]/parent::*/parent::*/parent::*/td/div/span[contains(text(), 'Contact requested')]", name);
        return getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//span[contains(text(), 'Matched Drivers')]/preceding-sibling::span")
    private WebElement numberOfMatchedDrivers;

    @FindBy(xpath = "//span[contains(text(), 'Basic Drivers')]/preceding-sibling::span")
    private WebElement numberOfBasicDrivers;

    private WebElement emailOfMatchedDriver(String name, String email) {
        String xpath = String.format("//*[contains(text(), '%s')]/parent::*/parent::*/parent::*/td//div//span[contains(text(),'%s')]", name, email);
        return getDriver().findElement(By.xpath(xpath));
    }

    private WebElement emailOfGetContact(String name, String emailContact) {
        String xpath = String.format("//p[text() = '%s']/parent::*/parent::*/parent::*//td/div/div/span/span[text() = '%s']", name, emailContact);
        return getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//input[@name = 'zip']")
    private WebElement inputSearch;

    @FindBy(xpath = "//span[contains(text(), 'Open advanced search')]")
    private WebElement advancedSearch;

    @FindBy(xpath = "//span[contains(text(), 'Match declined.')]")
    private WebElement declineMassage;

    private WebElement buttonGetContact(String nameContact) {
        String xpath = String.format("//p[text() = '%s']/parent::*/parent::*/parent::*//td/div/button[text() = 'Get contact']", nameContact);
        return getDriver().findElement(By.xpath(xpath));
    }

    public void clickButtonSendRequest() {
        waitElement(buttonSendRequest);
        scrollToElement(buttonSendRequest);
        clickOnElement(buttonSendRequest);
    }

    public void clickOnDriverLine(String name) {
        waitElement(clickOnDriver(name)).click();
    }

    public void clickOnRequest() {
        waitElement(clickRequest).click();
    }

    public void clickOnYes() {
        waitElement(clickYes).click();
    }

    public void clickInviteToMatchForDriver(String name) {
        waitElement(inviteToMatchForDriver(name));
        scrollToElement(inviteToMatchForDriver(name));
        clickOnElement(inviteToMatchForDriver(name));
    }

    public void clickGetContact(String nameContact) {
        waitElement(buttonGetContact(nameContact));
        scrollToElement(buttonGetContact(nameContact));
        clickOnElement(buttonGetContact(nameContact));
    }

    public void checkMessageInviteToMatch() {
        waitElement(messageInviteToMatch);
        scrollToElement(messageInviteToMatch);
    }

    public void checkMessageContactRequested(String name) {
        waitElement(messageContactRequested(name));
        scrollToElement(messageContactRequested(name));
    }

    public void checkEmailOfMatchedDriver(String name, String email) {
        waitElement(emailOfMatchedDriver(name, email));
        scrollToElement(emailOfMatchedDriver(name, email));
    }

    public void checkContact(String name, String emailContact) {
        waitElement(emailOfGetContact(name, emailContact));
        scrollToElement(emailOfGetContact(name, emailContact));
    }

    public void checkDeclineMassage() {
        waitElement(declineMassage);
        scrollToElement(declineMassage);
    }

    public void inputSearchDriver(String input) {
        waitElement(advancedSearch);
        clickOnElement(advancedSearch);
        clickOnElement(inputSearch);
        inputSearch(inputSearch, input);
    }

    public String numberOfMatchedDrivers() {
        return numberOfMatchedDrivers.getText();
    }

    public String numberOfBasicDrivers() {
        return numberOfBasicDrivers.getText();
    }
}
