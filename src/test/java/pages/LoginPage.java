package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//locators
	@FindBy(id = "user-name")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id = "login-button")
	WebElement loginBtn;
	@FindBy(className="title")
	WebElement homePageTitle;
	@FindBy(css = "h3[data-test='error']")
	WebElement errorMessage;
	//actions
	public void enterUsername(String user)
	{
	username.sendKeys(user);
	}
	public void enterPassword(String pass)
	{
	password.sendKeys(pass);
	}
	public void clickLogin()
	{
	loginBtn.click();
		
	}
	public boolean isHomePageTitleDisplayed()
	{
		return homePageTitle.isDisplayed();
	}
	public boolean isLoginPageDisplayed()
	{
		return loginBtn.isDisplayed();	
	}
	public boolean isErrorDisplayed()
	{
		return errorMessage.isDisplayed();
	}
	

}
