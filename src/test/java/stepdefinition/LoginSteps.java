package stepdefinition;


import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmanager.PageObjectManager;

public class LoginSteps extends BaseClass
{
	PageObjectManager pom = new PageObjectManager(driver);
	@Given("user is on login page")
	public void user_is_on_login_page()
	{
		// already launched in hooks
	}
	
	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String username,String password) 
	{
		pom.getLoginPage().enterUsername(username);
		pom.getLoginPage().enterPassword(password);
	}
	
	@When("user clicks login button")
	public void user_clicks_login_button() 
	{
		pom.getLoginPage().clickLogin();
	}
	

	@Then("user should see {string}")
	public void user_should_see(String result)
	{
		if(result.equals("success"))
		{
			Assert.assertTrue(pom.getLoginPage().isHomePageTitleDisplayed(), "Homepage title is displayed");
		}
		else if(result.equals("error"))
		{
			Assert.assertTrue(pom.getLoginPage().isErrorDisplayed(), "Error message not displayed");
		}
		
	}
}
