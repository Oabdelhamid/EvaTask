package stepdefinitions;

import hooks.Hooks;
import POM.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AdminUserSteps {

    private final WebDriver driver;
    private int recordsBefore, recordsAfter;

    public AdminUserSteps() {
        this.driver = Hooks.driver;
    }


    @Given("the user logs in with username {string} and password {string}")
    public void theUserLogsIn(String username, String password) {
        new Login(driver).Negative()
                .AddUsernameAndPassword(username, password)
                .ClickLoginButton();
    }

    @When("the user navigates to the Admin page")

    public void navigateToAdminPage() {
        new Dashbaord(driver).NagivateToAdminPage();    }

    @When("the user adds a new admin user with username {string}")
    public void addNewAdminUser(String newUsername) {
        recordsBefore = new AdminBeforeNewUser(driver).NumberOfRecordsBeforeAddNewUser();
        new AddNewAdmin(driver).addUserRole()
                .addUserStatus()
                .addEmployeeName("Thomas")
                .addUserNameAndPassword(newUsername, "Omar1234@")
                .AddSaveButton();
        recordsAfter = new AdminAfterNewUser(driver).NumberOfRecordsAfterAddNewUser();
    }

    @Then("the total number of admin records should increase by 1")
    public void verifyAdminRecordIncreased() {
        Assert.assertEquals(recordsAfter, recordsBefore + 1);
    }

    @Given("the user searches for admin username {string}")
    public void searchAdminUser(String username) {
        new Dashbaord(driver).NagivateToAdminPage();
        recordsBefore = new AdminAfterNewUser(driver).NumberOfRecordsAfterAddNewUser();
        new AdminAfterNewUser(driver).SearchForUserName(username);
    }

    @When("the user deletes the admin user")
    public void deleteAdminUser() {
        new AdminAfterNewUser(driver).DeleteNewUser();
        new Dashbaord(driver).NagivateToAdminPage();
        recordsAfter = new AdminAfterNewUser(driver).NumberOfRecordsAfterDeleteNewUser();

    }

    @Then("move to admin page and make sure the total number of admin records should decrease by 1")
    public void verifyAdminRecordDecreased() {

        Assert.assertEquals(recordsAfter, recordsBefore-1);
    }
}
