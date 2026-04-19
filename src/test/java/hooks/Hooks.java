package hooks;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ExtentManager;
import utilities.ScreenshotUtil;

public class Hooks extends BaseClass
{
	public static ExtentReports extent = ExtentManager.getReportInstance();
	public static ExtentTest test;
	@Before
	public void beforeScenario(Scenario scenario) throws IOException
	{
		setup(); // browser launch
		test=extent.createTest(scenario.getName());
	}
	@After
	public void afterScenario(Scenario scenario)
	{
		if(scenario.isFailed())
{
	String path= ScreenshotUtil.captureScreenshot(scenario.getName());
	test.fail("Test failed").addScreenCaptureFromPath(path);
	System.out.println("screenshot saved at:" + path);
	}
		else
		{
			test.pass("Test Passed");
		}
		extent.flush();
		System.out.println("HOOKS WORKING");
		tearDown(); // browser close
		
	}

}
