package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class ScreenshotUtil extends BaseClass
{
public static String captureScreenshot (String testName)
{
	if (driver == null)
	{
		System.out.println("Driver is null. Screenshot Skipped");
		return "";
	}
	String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	String filePath = "screenshots/"+ testName + "_"+ timeStamp + ".png";
	TakesScreenshot ts= (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File destination = new File(filePath);
	try 
	{
		FileUtils.copyFile(source, destination);
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	return filePath;
}
}
