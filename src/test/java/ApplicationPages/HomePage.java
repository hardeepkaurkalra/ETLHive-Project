package ApplicationPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	
	WebDriver driver;
	 
	 
	public void LoginPageNew(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	@FindBy(xpath="(//span[text()='Home'])[1]")
	@CacheLookup
	WebElement homebutton;
	
	@FindBy(xpath="//span[text()='My Account']")
	@CacheLookup
	WebElement myaccount;
	
	@FindBy(xpath="//span[text()='My Cart']")
	@CacheLookup
	WebElement mycart;
	
	@FindBy(xpath="//span[text()='Wishlist']")
	@CacheLookup
	WebElement wishlist;
	
	@FindBy(xpath="//span[text()=' Log In']")
	@CacheLookup
	WebElement login;
	
	public void clickOnLogin(){
		login.click();
	}
	
	 public String getApplicationTitle(){
	    	
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	
		 return (driver.getTitle());
	    }

	
}
