package stepdefinition;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmanager.PageObjectManager;

public class LogoutSteps extends BaseClass
{
	PageObjectManager pom = new PageObjectManager(driver);
	
	@When("user clicks menu button")
	public void user_clicks_menu_button() 
	{
	    pom.getHomePage().clickMenu();
	}
	@Then("user clicks logout button")
	public void user_clicks_logout_button()
	{
		pom.getHomePage().clickLogout();
	}
	@Then("user should be navigated to login page")
	public void user_should_be_navigated_to_login_page()
	{
		Assert.assertTrue(pom.getLoginPage().isLoginPageDisplayed(),"user is not redirected to login page");
	}

}
