import POM.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class EvaTaskTest {
    WebDriver driver ;
  @BeforeClass
    public void setup(){
      ChromeOptions options = new ChromeOptions();
      options.enableBiDi().addArguments("Start-maximized");
      driver = new ChromeDriver(options);

  }

  @AfterClass
    public void TearDown(){
   // driver.quit();

  }

  @Test
    public void Login(){

     new Login(driver).Negative().AddUsernameAndPassword("Admin","admin123").ClickLoginButton();

  }

  @Test (dependsOnMethods = {"Login"})
  public void DashboardPage(){

    new Dashbaord(driver).NagivateToAdminPage();
  }


  @Test(dependsOnMethods = {"Login", "DashboardPage"})

  public void CheckIfUserAdded(){
    int Before = new AdminBeforeNewUser(driver).NumberOfRecordsBeforeAddNewUser();
   new AddNewAdmin(driver).addUserRole().addUserStatus().addEmployeeName("Thomas").addUserNameAndPassword("Omar1234","Omar1234@").addSaveButton();
    int After = new AdminAfterNewUser(driver).NumberOfRecordsAfterAddNewUser();
    Assert.assertEquals(After, Before+1);
  }
  @Test(dependsOnMethods = {"Login", "DashboardPage"})
  public void SearchForUserAndDeleteIt(){
    new AdminAfterNewUser(driver).SearchForUserName("Omar1234").DeleteNewUser();
    int BeforeDelete = new AdminAfterNewUser(driver).NumberOfRecordsAfterAddNewUser();
    int AfterDelete = new AdminAfterNewUser(driver).NumberOfRecordsAfterDeleteNewUser();
    Assert.assertEquals(AfterDelete, BeforeDelete-1);


  }




}
