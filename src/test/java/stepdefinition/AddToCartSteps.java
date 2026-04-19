package stepdefinition;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmanager.PageObjectManager;

public class AddToCartSteps extends BaseClass

{
	PageObjectManager pom = new PageObjectManager(driver);
	@When("user adds product to cart")
	public void user_adds_product_to_cart()
	{
		pom.getHomePage().clickAddToCart();
	   
	}
	@When("user navigates to cart page")
	public void user_navigates_to_cart_page() 
	{
	    pom.getHomePage().clickCart();
	}
	@Then("user should see the added product")
	public void user_should_see_the_added_product() 
	{
	 String productName = pom.getHomePage().getProductName();
	 Assert.assertEquals(productName, "Sauce Labs Backpack","Product not added correctly");
	}

}