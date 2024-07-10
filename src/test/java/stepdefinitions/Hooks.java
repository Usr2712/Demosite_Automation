package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Factory.DriverFactory.driver;

public class Hooks   {

      /*  @After(order = 1)
        public void takeScraenshotOnFailure(Scenario scenario) {

            if (scenario.isFailed()) {

               File Scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String filename = new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());

                String  destinationPath = "C:\\Users\\DELL\\Sai\\CucumberFramework\\target\\Screenshots\\";
                try {

                    File Des = new File(destinationPath+filename);
                    FileUtils.copyFile(Scr, Des);

                    scenario.attach(src,"image/png", "screenshot");


                } catch (IOException e) {
                    e.printStackTrace();

                }}}*/
               @After
                public void takeScraenshotOnFailures(Scenario scenario) {

                    if (scenario.isFailed()) {

                        TakesScreenshot ts = (TakesScreenshot) driver;

                        byte[] src = ts.getScreenshotAs(OutputType.BYTES);
                        scenario.attach(src, "image/png", "screenshot");
                    }

                }




   @After
    public void teardown(){

        System.out.println("End");
       driver.quit();
    }



}