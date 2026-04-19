package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import listeners.TestListener;
import pages.LoginPage;
import utilities.ExcelUtility;

@Listeners(TestListener.class)

public class LoginTest extends BaseClass	
{
	@Test(dataProvider = "loginData")
	public void loginTest(String username,String password)
	{
		LoginPage lp = new LoginPage(driver);
		lp.login(username,password);
		Assert.assertTrue(lp.isHomePageTitleDisplayed(), "HomePageTitle is not Displayed.!");
		System.out.println("Login completed");
		}
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/testdata/LoginData.xlsx";
		ExcelUtility excel = new ExcelUtility("./src/test/resources/LoginData.xlsx");
		return excel.getSheetData("LoginData");
	}
	

}
