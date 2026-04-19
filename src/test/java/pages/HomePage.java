package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="react-burger-menu-btn")
	WebElement menuBtn;
	@FindBy(id="logout_sidebar_link")
	WebElement logoutBtn;
	public void clickMenu()
	{
		menuBtn.click();
	}
	public void clickLogout()
	{
		logoutBtn.click();
	}
	@FindBy(id="add-to-cart-sauce-labs-backpack")

	WebElement addToCartBtn;
	@FindBy(className="shopping_cart_link")
	WebElement cartIcon;
	@FindBy(className="inventory_item_name")
	WebElement productName;
		public void clickAddToCart()
		{
			addToCartBtn.click();
		}
		public void clickCart()
		{
			cartIcon.click();
		}
		public String getProductName()
		{
			return productName.getText(); 
		}
}
