package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseClass
{
	@Test
	public void LogoutTest()
	{
		LoginPage lp= new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		HomePage hp = new HomePage(driver);
		hp.clickMenu();
		hp.clickLogout();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
	
	}	

}
