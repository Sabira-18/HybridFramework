package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentManager;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener
{
	
ExtentReports extent = ExtentManager.getReportInstance();
ExtentTest test;

@Override
public void onTestStart(ITestResult result)
{
	test= extent.createTest(result.getMethod().getMethodName());
}
@Override
public void onTestSuccess(ITestResult result)
{
	test.pass("Test Passed");
}


@Override
public void onTestFailure(ITestResult result)
{
	ScreenshotUtil.captureScreenshot(result.getName());
	System.out.println("Screenshot captured for Failed test"+ result.getName());
}
@Override
public void onFinish(ITestContext context)
{
	extent.flush();
}
}
