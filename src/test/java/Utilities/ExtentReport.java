package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {


        if (extent == null) {
            String reportName = "ExtentReport_" + System.currentTimeMillis() + ".html";
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + reportName);

            // Optional configuration
            htmlReporter.config().setDocumentTitle("Automation Test Results");
            htmlReporter.config().setReportName("Automation Test Report");
            htmlReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}
