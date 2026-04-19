package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AddToCartTest extends BaseClass
{
	@Test(dataProvider ="cartData")
	public void addToCartTest(String username,String password)
	{
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		HomePage hp = new HomePage(driver);
		hp.clickAddToCart();
		hp.clickCart();
		Assert.assertEquals(hp.getProductName(), "Sauce Labs Backpack");
	}
	@DataProvider(name="cartData")
	public Object[][] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/testdata/LoginData.xlsx";
		ExcelUtility excel = new ExcelUtility("./src/test/resources/LoginData.xlsx");
		return excel.getSheetData("LoginData");
	}
	}
	

