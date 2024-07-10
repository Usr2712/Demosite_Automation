package Pages;


import ReaderFiles.ConfigReader;
import ReaderFiles.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;

public class LoginPage {

    private WebDriver driver;

    ExcelReader testdata = new ExcelReader();

    static String username = "root";

    String dbUrl = "jdbc:mysql://localhost:3306/logindetails?autoReconnect=true&useSSL=false";
    //Database Password
    static String password = "Usr@2712";

    //Query to Execute
    static String query = "Select *from usercreds;";

    // Connection object
    static Connection con = null;
    // Statement object
    private static Statement stmt;

    static String UserNameinDB;
    static String PasswordinDb;


    private static ConfigReader configReader;
    static Properties prop;

    @FindBy(xpath = "//input[@id='txt-username']")
    static WebElement UserName;

    @FindBy(xpath = "//input[@id='txt-password']")
    static WebElement Password;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    static WebElement Login;

    @FindBy(xpath = "//p[contains(text(),'Login failed! Please ensure the username and password are valid.')]")
    static WebElement ErrMessage;

    @FindBy(xpath = "//*[@id=\"appointment\"]/div/div/div/h2")
    static WebElement Loginpageopened;


    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void OpenPage() {

        configReader = new ConfigReader();
        prop = configReader.init_prop();
        driver.get(prop.getProperty("Url"));
        driver.manage().window().maximize();


    }

    public void LoginwithCredentials() throws FileNotFoundException {


        UserName.sendKeys(testdata.username);
        Password.sendKeys(testdata.password);
        Login.click();


    }

    @Test
    public void setUp() throws SQLException, ClassNotFoundException {
   Class.forName("com.mysql.cj.jdbc.Driver");


        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String User = rs.getString(1);
            String Pass = rs.getString(2);

            UserNameinDB = rs.getString(1);
            PasswordinDb = rs.getString(2);
        }
        // closing DB Connection
        con.close();
    }



    public void LoginwithCredentialsFromDB() throws Exception {


        setUp();
        UserName.sendKeys(UserNameinDB);
        Password.sendKeys(PasswordinDb);
        Login.click();


    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }


    public void LoginWithCredentialsFromExamples(String uname, String pword) {

        UserName.sendKeys(uname);
        Password.sendKeys(pword);
        Login.click();


    }

    public String ErrormsgValidation() {

        return ErrMessage.getText();


    }

    public void PassCredentialsThroughDatatable(String uname, String pword) {

        UserName.clear();
        UserName.sendKeys(uname);
        Password.clear();
        Password.sendKeys(pword);
        Login.click();

    }

    public void loginpageopened() {

        Loginpageopened.isDisplayed();
    }

}