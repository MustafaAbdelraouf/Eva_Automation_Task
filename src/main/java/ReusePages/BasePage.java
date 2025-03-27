package ReusePages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import static java.lang.invoke.MethodHandles.lookup;

public class BasePage {
    public static WebDriver BasePageDriver;


     WebDriverWait wait = new WebDriverWait(BasePageDriver, Duration.ofSeconds(10));
    public static final Logger log = LogManager.getLogger(lookup().lookupClass());

    public BasePage(WebDriver mydriver) {
        BasePageDriver = mydriver;
    }

    private By Pagetitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    private By EmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private By EmployeeList = By.cssSelector("div.oxd-autocomplete-dropdown");
    private By EmployeeListItem = By.cssSelector("div.oxd-autocomplete-dropdown > div");

    public void Assertion_TitlePage(String title) {
        WebElement adminTitleElement = BasePageDriver.findElement(Pagetitle);
        String TitleText = adminTitleElement.getText();

        if (TitleText.equals(title)) {
            log.info(title + " title is present: " + TitleText);
        } else {
            log.warn("Expected " + title + " title but found: " + TitleText);
        }
    }

    @Step("Enter Employee Name")
    public void Enter_EmployeeName(String name) {
        WebElement employeeNameInput = BasePageDriver.findElement(EmployeeName);
        employeeNameInput.sendKeys(name);
        // Wait for the dropdown list to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeeList));
        // Capture all suggestions and click the desired one
        List<WebElement> suggestions = BasePageDriver.findElements(EmployeeListItem);
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equals(name)) {
                suggestion.click();
                break;
            }
        }
        log.info("Entered Employee Name: " + name);
    }


}
