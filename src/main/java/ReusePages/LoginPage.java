package ReusePages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver mydriver) {
        super(mydriver);
    }

    WebDriverWait wait = new WebDriverWait(BasePageDriver, Duration.ofSeconds(10));


    SoftAssert softAssert;
    //-------------------------------------------LOG IN--------------------------------------------------------------------//
    private By Company_title = By.xpath("//a[@href='https://www.orangehrm.com/']");
    private By Login_Title = By.xpath("//h5[text()='Login']");
    private By UserName = By.xpath("//input[@name='username']");
    private By Password = By.xpath("//input[@name='password']");
    private By Submit = By.xpath("//button[text()=' Login ']");
    private By Dashboard_title = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");
    private By Invalidalert = By.xpath("//*[text()='Invalid credentials']");

    //---------------------------------------------------------------------------------------------------------------------//
    //------------------------------------------------------- FUNCTIONS----------------------------------------------------//
    @Step("Verifying the login page title is '{LoginTitle}'")
    public void Assertion_Login(String LoginTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Login_Title));
        String Login = BasePageDriver.findElement(Login_Title).getText();
        SoftAssert so = new SoftAssert();
        so.assertEquals(Login, LoginTitle);
        log.info("You are in the login page. Expected title: '{}', Actual title: '{}'", LoginTitle, Login);
        so.assertAll();
    }

    public void enterUsername(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName));
        BasePageDriver.findElement(UserName).clear();
        BasePageDriver.findElement(UserName).sendKeys(name);

    }

    public void enterPassword(String password) {
        BasePageDriver.findElement(Password).clear();
        BasePageDriver.findElement(Password).sendKeys(password);

    }

    public void clickOnSubmit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Submit));
        BasePageDriver.findElement(Submit).click();
        log.info("You have entered the username and password");

    }
}
