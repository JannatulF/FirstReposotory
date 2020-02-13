package AllTests;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LandingOrLoginPage;
import resources.Base;

public class LandingLoginPageTest extends  BaseTest{
	
	 public static Logger log =LogManager.getLogger(Base.class.getName());
	 

	@Test(priority=1)
	public void validateTitleofLandingPage() {
		
		String expectedTitle = "InsuranceWeb: Home";
    	String actualTitle = driver.getTitle();
    	
		Assert.assertEquals(actualTitle, expectedTitle);    
	}
	
	
	
	@Test(priority=2)
	public void verifyElementsOfLandingPage() {
		LandingOrLoginPage ll=new LandingOrLoginPage(driver);
		ll.getSignup().isDisplayed();
		ll.getLogin().isDisplayed();
		ll.getWebserviceLink().isDisplayed();
		ll.getContactUsLink().isDisplayed();
	}
	
	@Test(priority=3)
	public void verifyRedirectedContactUsPage() {
		LandingOrLoginPage ll=new LandingOrLoginPage(driver);
		ll.getContactUsLink().click();
		
    	Set <String> allWindows = driver.getWindowHandles();
    	
    	for(String handle : allWindows)
    	{
    		driver.switchTo().window(handle);
    	}    	        	
    	  	
    	String expectedURL = "https://demo.borland.com/InsuranceWebExtJS/contact.jsf";
    	String actualURL = driver.getCurrentUrl();
    
    	Assert.assertEquals(actualURL, expectedURL);
    	
    	String expectedTitle = "InsuranceWeb: Automobile Instant Quote";
    	String actualTitle = driver.getTitle();
    	
    	Assert.assertEquals(actualTitle, expectedTitle);    	
	}
	
	@Test(priority=4)
	public void verifyRedirectedWebservicePage() {
		LandingOrLoginPage ll=new LandingOrLoginPage(driver);
		ll.getWebserviceLink().click();
		
    	Set <String> allWindows = driver.getWindowHandles();
    	
    	for(String handle : allWindows)
    	{
    		driver.switchTo().window(handle);
    	}    	        	
    	  	
    	String expectedURL = "https://demo.borland.com/InsuranceWebExtJS/webservices.jsf";
    	String actualURL = driver.getCurrentUrl();
    	
    	Assert.assertEquals(actualURL, expectedURL);
    	
    	String expectedTitle = "InsuranceWeb: Web Services";
    	String actualTitle = driver.getTitle();
    	
    	Assert.assertEquals(actualTitle, expectedTitle);    	
	}
	
	@Test(priority=5)
	public void signedUpRedirectedPage() {
		LandingOrLoginPage ll=new LandingOrLoginPage(driver);
        ll.getSignup().click();
		
    	Set <String> allWindows = driver.getWindowHandles();
    	
    	for(String handle : allWindows)
    	{
    		driver.switchTo().window(handle);
    	}    	        	
    	  	
    	String expectedURL = "https://demo.borland.com/InsuranceWebExtJS/signup.jsf";
    	String actualURL = driver.getCurrentUrl();
    	
    	Assert.assertEquals(actualURL, expectedURL);
    	
    	String expectedTitle = "InsuranceWeb: Sign up";
    	String actualTitle = driver.getTitle();
    	
    	Assert.assertEquals(actualTitle, expectedTitle);    	
	}
	





	
	
}
