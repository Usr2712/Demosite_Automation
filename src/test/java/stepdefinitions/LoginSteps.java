package stepdefinitions;

import Factory.DriverFactory;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class LoginSteps extends DriverFactory {


    private static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());




    @Given("user is on login page")
    public void user_is_on_login_page() {

        loginPage.OpenPage();


    }



    @And("User logged with username and password")
    public void userLoggedWithUsernameAndPassword() throws FileNotFoundException {
        loginPage.LoginwithCredentials();

    }

    @And("User logged with username and password from db")
    public void userLoggedWithUsernameAndPasswordFromDb() throws Exception {

loginPage.LoginwithCredentialsFromDB();
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginPage.getLoginPageTitle();
        System.out.println("Page title is: " + title);
    }

    @And("User logged with {string} and {string}")
    public void userLoggedWithAnd(String uname, String pword) {

     loginPage.LoginWithCredentialsFromExamples( uname,pword);



    }

    @And("validate {string}")
    public void validate(String expectedErrormsg) {


        if(expectedErrormsg.contains("Login failed!")){


            System.out.println(expectedErrormsg);
            String ActualErrorMsg = loginPage.ErrormsgValidation();

            Assert.assertEquals(ActualErrorMsg,expectedErrormsg);

        }
        else {

            loginPage.loginpageopened();
        }

    }

    @And("User logged with username and password by Datatable")
    public void userLoggedWithUsernameAndPasswordByDatatable(DataTable dataTable) {

       List<List<String>> data = dataTable.asLists(String.class);
        String Uname= data.get(0).get(0);
        String Pword = data.get(0).get(1);

        System.out.println(Uname);
        System.out.println(Pword);
        loginPage.PassCredentialsThroughDatatable(Uname,Pword);
    }

    @And("User logged with username and password by Datatable with map")
    public void userLoggedWithUsernameAndPasswordByDatatableWithMap(DataTable dataTable) {

        List<Map<String,String>> listdata =dataTable.asMaps(String.class,String.class);
        for(Map<String ,String > mapdata:listdata) {
            String Uname = mapdata.get("Username");
            String Pword = mapdata.get("Password");
            System.out.println(Uname);
            System.out.println(Pword);
            loginPage.PassCredentialsThroughDatatable(Uname, Pword);
        }
    }


}
