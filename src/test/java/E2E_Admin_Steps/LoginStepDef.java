package E2E_Admin_Steps;

import ReusePages.AdminPage;
import ReusePages.LoginPage;
import ReuseTests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDef extends BaseTest {
    LoginPage lg;
    AdminPage adP;

    @Before
    public void setup() {
        Open_Browser();
        lg = new LoginPage(BaseTestDriver);
        adP = new AdminPage(BaseTestDriver);
    }

    @Given("I open the OrangeHRM login page")
    public void i_open_the_orange_hrm_login_page() throws InterruptedException {
        lg.Assertion_Login("Login");
        Thread.sleep(500);
    }

    @When("I enter the username {string}")
    public void i_enter_the_username(String username) throws InterruptedException {
        lg.enterUsername(username);
        Thread.sleep(500);
    }

    @When("I enter the password {string}")
    public void i_enter_the_password(String password) throws InterruptedException {
        lg.enterPassword(password);
        Thread.sleep(500);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        lg.clickOnSubmit();
    }

    @Then("I should see the dashboard with the title")
    public void i_should_see_the_dashboard_with_the_title() {
        lg.Assertion_TitlePage("Dashboard");
    }

    @When("I click on the Admin tab on the left side menu")
    public void i_click_on_the_admin_tab_on_the_left_side_menu() {
        adP.Click_on_AdminIcon();
        adP.Assertion_AdminPage("Admin");
    }
    //---------------------------------------

    @Then("I should see the number of records found")
    public void i_should_see_the_number_of_records_found() {
        String Count = adP.GetNumberOfAdmins();
        System.out.println("Before adding = " + Count);

    }

    @When("I click on the add button")
    public void i_click_on_the_add_button() {
        adP.Click_on_Add_NewAdmin();
    }

    @When("I fill the required data for a new user")
    public void i_fill_the_required_data_for_a_new_user() throws InterruptedException {

        adP.Enter_UserRole("Admin");
        Thread.sleep(1000);
        adP.Enter_Employee_Name("hh hh");
        Thread.sleep(1000);
        adP.Enter_Status("Enabled");
        Thread.sleep(1000);
        adP.Enter_UserName("Ahmed Mustafa");
        Thread.sleep(1000);
        adP.Enter_Password("Mustafa123");
        Thread.sleep(1000);
        adP.Confirm_Pass("Mustafa123");

    }

    @When("I click on the save button")
    public void i_click_on_the_save_button() throws InterruptedException {
        adP.Click_Save();
        Thread.sleep(5000);

    }


    @Then("I should see the number of records increased by {int}")
    public void i_should_see_the_number_of_records_increased_by(Integer increaseBy) throws InterruptedException {
        Thread.sleep(1000);
        String Count = adP.GetNumberOfAdmins();
        System.out.println("After adding = " + Count);
    }

    @When("I search with the username")
    public void i_search_with_the_username() throws InterruptedException {
        Thread.sleep(1000);
        adP.SearchForEmployee("Ahmed Mustafa");
        Thread.sleep(4000);

    }

    @When("I delete the new user")
    public void i_delete_the_new_user() throws InterruptedException {
        Thread.sleep(1000);
        adP.deleteUser();
        Thread.sleep(4000);

    }
    @Then("I should see the number of records decreased by {int}")
    public void i_should_see_the_number_of_records_decreased_by(Integer int1) throws InterruptedException {
        Thread.sleep(1000);
        adP.SearchReset();
        Thread.sleep(1000);
        String Count = adP.GetNumberOfAdmins();
        System.out.println("After Deleting = " + Count);
        Thread.sleep(2000);
    }

    @After
    public void Close() {
        Close_browser();
        lg = new LoginPage(BaseTestDriver);
        adP = new AdminPage(BaseTestDriver);
    }
}













