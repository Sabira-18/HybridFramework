package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager 
{
	public static ExtentReports extent;
	public static ExtentReports getReportInstance()
	{
		if (extent == null) {
			String path = System.getProperty("user.dir")+ "/reports/ExtentReport.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Automation Test Results");
			reporter.config().setDocumentTitle("Test Execution Report");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Saabira");
		}
		return extent;
	}

}
