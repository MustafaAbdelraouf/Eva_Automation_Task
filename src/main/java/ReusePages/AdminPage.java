package ReusePages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPage extends BasePage {

    public AdminPage(WebDriver mydriver) {
        super(mydriver);
    }

    private By AdminIcon = By.xpath("//a[contains(@href,'admin')]");
    private By AddButton = By.xpath("//button[text()=' Add ']");
    private By UserRole = By.xpath("(//div[text()='-- Select --'])[1]");
    private By Status = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]");
    private By hintUserName = By.xpath("//input[@placeholder='Type for hints...']");
    private By UserName = By.xpath("//label[text()='Username']/following::input[1]");
    private By Password = By.xpath("//label[text()='Password']/following::input[1]");
    private By confirmPass = By.xpath("//label[text()='Confirm Password']/following::input[1]");
    private By Save = By.xpath("//button[text()=' Save ']");
    private By cancel = By.xpath("//button[text()=' Cancel ']");
    private By SearchForEmployeeUserName = By.xpath("//label[text()='Username']/following::input[1]");

    private By SearchButton = By.xpath("//button[text()=' Search ']");
    private By ResetButton = By.xpath("//button[text()=' Reset ']");
    private By Message = By.xpath("//*[text()='Success']");
    private By Delete = By.xpath("//button[@type='button' and .//i[contains(@class,'trash')]][1]");
    private By ConfirmDelete = By.xpath("//button[text()=' Yes, Delete ']");
    private By edit = By.xpath("//button[@type='button' and .//i[contains(@class,'pencil-fill')]][1]");
    private By adminRecords = By.xpath("//DIV[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']");

    //--------------------------------------------------------------------------------------------------------------//
    //-----------------------------------------------------Functions-----------------------------------------------//
    @Step("Click on Admin Icon")
    public void Click_on_AdminIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(AdminIcon));
        BasePageDriver.findElement(AdminIcon).click();
        log.info("Clicked on Admin Icon");
    }

    @Step("Assert Admin Page Title")
    public void Assertion_AdminPage(String name) {
        Assertion_TitlePage(name);
    }


    @Step("Click on Add Employee Button")
    public void Click_on_Add_NewAdmin() {
        wait.until(ExpectedConditions.elementToBeClickable(AddButton));
        BasePageDriver.findElement(AddButton).click();
        log.info("Clicked on Add Employee Button");
    }

    @Step("Enter User Role")
    public void Enter_UserRole(String Role) throws InterruptedException {
        WebElement NAME = BasePageDriver.findElement(UserRole);
        NAME.sendKeys(Role);
        Thread.sleep(1000);
        NAME.sendKeys(Keys.UP);
        Thread.sleep(500);
        NAME.sendKeys(Keys.ENTER);
        log.info("Entered User Role");
    }

    @Step("Enter User Role")
    public void Enter_Employee_Name(String EnterHintName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hintUserName));
        WebElement NAME = BasePageDriver.findElement(hintUserName);
        NAME.sendKeys(EnterHintName);
        Thread.sleep(1000);
        NAME.sendKeys(Keys.UP);
        Thread.sleep(500);
        NAME.sendKeys(Keys.ENTER);

        log.info("Entered Employee Name: " + EnterHintName);
    }


    @Step("Enter user status")
    public void Enter_Status(String Status_name) throws InterruptedException {
        WebElement NAME = BasePageDriver.findElement(Status);
        NAME.sendKeys(Status_name);
        Thread.sleep(3000);
        NAME.sendKeys(Keys.UP);
        Thread.sleep(500);
        NAME.sendKeys(Keys.ENTER);
        log.info("Entered User Status");
    }


    public void Enter_UserName(String User_Name) {
        BasePageDriver.findElement(UserName).sendKeys(User_Name);
        log.info("Enter User Name: " + User_Name);
    }

    @Step("Enter Password")
    public void Enter_Password(String Pass) {
        BasePageDriver.findElement(Password).sendKeys(Pass);
        log.info("Entered Password");
    }

    @Step("Confirm Password")
    public void Confirm_Pass(String Pass) {
        BasePageDriver.findElement(confirmPass).sendKeys(Pass);
        log.info("Confirmed Password");
    }

    @Step("Click Submit Button")
    public void Click_Save() throws InterruptedException {
        BasePageDriver.findElement(Save).click();
        log.info("Clicked Submit Button");

    }

    @Step("Search For Employee")
    public void SearchForEmployee(String EmployeeName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchForEmployeeUserName));
        BasePageDriver.findElement(SearchForEmployeeUserName).sendKeys(EmployeeName);
        BasePageDriver.findElement(SearchButton).click();
        log.info("Search For Employee");
    }

    @Step("Search Reset")
    public void SearchReset() {
        BasePageDriver.findElement(ResetButton).click();
        log.info("Search Reset");
    }


    @Step("Deleting the employee record")
    public void DeleteRecord() {
        log.info("Deleting the record");
        BasePageDriver.findElement(Delete).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmDelete));
        BasePageDriver.findElement(ConfirmDelete).click();
        log.info("Record deleted");
    }

    @Step("Get all records of admin list")
    public String GetNumberOfAdmins() {

        return BasePageDriver.findElement(adminRecords).getText();

    }

    @Step("Delete the new user")
    public void deleteUser() throws InterruptedException {
        log.info("Deleting the new user.");
        BasePageDriver.findElement(Delete).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmDelete));
        BasePageDriver.findElement(ConfirmDelete).click();
        log.info("User successfully deleted.");
    }


}
