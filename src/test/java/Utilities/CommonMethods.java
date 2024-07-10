package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Factory.DriverFactory.driver;

public class CommonMethods {


    public void takeScreenshot() {
        // Take screenshot and save it as a file
        File Scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String filename = new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());

           String  destinationPath = "C:\\Users\\DELL\\Sai\\CucumberFramework\\target\\Screenshots\\";


        try {

            //FileUtils.copyFile(screenshotFile, new File("C:\\Users\\DELL\\Sai\\CucumberFramework\\target\\Screenshots"+"_" + TimeStamp + ".png"));
File Des = new File(destinationPath+filename);
           FileUtils.copyFile(Scr, Des);

        } catch (IOException e) {
            e.printStackTrace();

    }}
}
