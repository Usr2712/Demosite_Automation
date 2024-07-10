package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "C:\\Users\\DELL\\Sai\\BrandNew\\SaiNewNew\\src\\test\\resources\\features\\ApppointmentCombinations.feature",
        glue={"stepdefinitions" },
        tags = "@Appointment2",
        plugin = {"pretty","html: target/cucumber-reports","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome=true
)

public class MyTestRunner extends AbstractTestNGCucumberTests {


}
