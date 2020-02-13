package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingOrLoginPage {

	
	public WebDriver driver;
	
	By title=By.cssSelector(".text-center>h2");
	
	By login=By.id("login-form:login");
	
	By email=By.id("login-form:email");
	By password=By.id("login-form:password");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}

	
	By emailLoginErrorMsg=By.xpath("//*[@id=\'login-messages\']/table/tbody/tr[1]/td");
	By pwdLoginErrorMsg=By.xpath("//*[@id=\'login-messages\']/table/tbody/tr[2]/td");
	
	By signup=By.id("login-form:signup");
	By webserviceLink=By.linkText("Webservice");
	By contactUsLink=By.linkText("Contact Us");
	
	By details=By.id("logout-form:details");
	
	
	public WebElement getDetails() {
		return driver.findElement(details);
	}
	
	public WebElement getContactUsLink() {
		return driver.findElement(contactUsLink);
	}
	public WebElement getWebserviceLink() {
		return driver.findElement(webserviceLink);
	}

	public LandingOrLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}

	public WebElement getEmailLoginMsg()
	{
		return driver.findElement(emailLoginErrorMsg);
	}
	
	public WebElement getPwdLoginMsg()
	{
		return driver.findElement(pwdLoginErrorMsg);
	}
	
	public WebElement getSignup()
	{
		return driver.findElement(signup);
	}
	
}
