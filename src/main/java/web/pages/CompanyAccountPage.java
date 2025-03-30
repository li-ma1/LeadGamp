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
        String xpath = String.format("//*[contains(text(), '%s')][1]/parent::*/parent::*/parent::*/td/div/button", name);
        return getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//button[contains(text(), 'Send request')]")
    private WebElement buttonSendRequest;

    @FindBy(xpath = "//div[contains(text(), 'Invite to match sent')]")
    private WebElement messageInviteToMatch;

    private WebElement messageContactRequested(String name) {
        String xpath = String.format("//*[contains(text(), '%s')][1]/parent::*/parent::*/parent::*/td/div/span[contains(text(), 'Contact details requested')]", name);
        return getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//span[contains(text(), 'Matched Drivers')]/preceding-sibling::span")
    private WebElement numberOfMatchedDrivers;

    @FindBy(xpath = "//span[contains(text(), 'Basic Drivers')]/preceding-sibling::span")
    private WebElement numberOfBasicDrivers;

    @FindBy(xpath = "//span[text()='All']/span[text()]")
    private WebElement checkCountAfterFilter;

    private WebElement emailOfMatchedDriver(String name, String email) {
        String xpath = String.format("//*[contains(text(), '%s')]/parent::*/parent::*/parent::*/td//div//span[contains(text(),'%s')]", name, email);
        return getDriver().findElement(By.xpath(xpath));
    }

    private WebElement emailOfGetContact(String name, String emailContact) {
        String xpath = String.format("//p[text() = '%s']/parent::*/parent::*/parent::*//td/div/div/span/span[text() = '%s']", name, emailContact);
        return getDriver().findElement(By.xpath(xpath));
    }

    private WebElement inputExperience(String inputExperience) {
        String xpath = String.format("//p[text()='Experience']/parent::*//div[text() = '%s']", inputExperience);
        return getDriver().findElement(By.xpath(xpath));
    }

    private WebElement inputFreightType(String inputFreightType) {
        String xpath = String.format("//p[text()='Freight type']/parent::*//div[text() = '%s']", inputFreightType);
        return getDriver().findElement(By.xpath(xpath));
    }

    private WebElement inputHomeTimesSearch(String inputHomeTimesSearch) {
        String xpath = String.format("//p[text()='Home times']/parent::*//div[text() = '%s']", inputHomeTimesSearch);
        return getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//input[@name = 'zip']")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[contains(text(), 'New Search')]")
    private WebElement newSearch;

    @FindBy(xpath = "//span[contains(text(), 'Open advanced search')]")
    private WebElement advancedSearch;

    @FindBy(xpath = "//span[contains(text(), 'Match declined.')]")
    private WebElement declineMassage;

    @FindBy(xpath = "//p[text()='Experience']/parent::*//div[text()='Select...']/parent::*//div/input")
    private WebElement experienceInput;

    @FindBy(xpath = "//p[text()='Freight type']/parent::*//div[text()='Select...']/parent::*//div/input")
    private WebElement freightTypeInput;

    @FindBy(xpath = "//p[text()='Home times']/parent::*//div[text()='Select...']/parent::*//div/input")
    private WebElement homeTimesInput;

    @FindBy(xpath = "//a[@aria-label = 'Page 2']")
    private WebElement secondPage;

    @FindBy(xpath = "//a[@aria-label = 'Page 1']")
    private WebElement firstPage;

    @FindBy(xpath = "//span[text() = 'Return to basic search']")
    private WebElement returnBasicSearch;

    @FindBy(xpath = "//span[@class= 'styles_activeFilters__asqFn']")
    private WebElement checkSearch;

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
        waitElement(newSearch);
        clickOnElement(newSearch);
        waitElement(advancedSearch);
        clickOnElement(advancedSearch);
        clickOnElement(inputSearch);
        inputSearch(inputSearch, input);
    }

    public void experienceSearchDriver(String experience)  {
        waitElement(newSearch);
        clickOnElement(newSearch);
        waitElement(advancedSearch);
        clickOnElement(advancedSearch);
        waitElement(experienceInput);
        clickOnElement(experienceInput);
        inputSearch(experienceInput, experience);
        clickEnter();
        waitElement(inputExperience(experience));
    }

    public String changePage() {
        waitElement(secondPage);
        scrollToElement(secondPage);
        clickOnElement(secondPage);
        waitElement(firstPage);
        clickOnElement(firstPage);
        waitElement(returnBasicSearch);
        scrollToElement(returnBasicSearch);
        clickOnElement(returnBasicSearch);
        return getTextElement(checkSearch);
    }


    public void freightTypeSearchDriver(String freightType) {
        waitElement(freightTypeInput);
        clickOnElement(freightTypeInput);
        inputSearch(freightTypeInput, freightType);
        clickEnter();
        waitElement(inputFreightType(freightType));
        clickEnter();

    }

    public void homeTimesSearchDriver(String homeTimes) {
        waitElement(homeTimesInput);
        clickOnElement(homeTimesInput);
        inputSearch(homeTimesInput, homeTimes);
        clickEnter();
        waitElement(inputHomeTimesSearch(homeTimes));
    }

    public String checkCountAfterFilter() throws InterruptedException {
        Thread.sleep(5000);
        return checkCountAfterFilter.getText();
    }

    public String numberOfMatchedDrivers() {
        return numberOfMatchedDrivers.getText();
    }

    public String numberOfBasicDrivers() {
        return numberOfBasicDrivers.getText();
    }
}
