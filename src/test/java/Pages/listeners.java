package Pages;



import Utilities.CommonMethods;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener {

CommonMethods commonMethods = new CommonMethods();


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Pass");


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {

      System.out.println("Failed");
        System.out.println("The name of the testcase failed is :"+result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Start");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Finish");
    }
}
