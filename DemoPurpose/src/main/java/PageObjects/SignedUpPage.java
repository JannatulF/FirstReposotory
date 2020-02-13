package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignedUpPage {

	
	public WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	By firstName=By.id("signup:fname");
	By lastName=By.id("signup:lname");
	By birthDay=By.id("BirthDate");
	By emailAddress=By.id("signup:email");
	By mailingAddress=By.id("signup:street");
	By city=By.id("signup:city");
	By state=By.id("signup:state");
	By postalCode=By.id("signup:zip");
	By password=By.id("signup:password");
	
	By home=By.linkText("Home");
	By contactUs=By.linkText("Contact Us");
	By signedUpSignedUp=By.id("signup:signup");
	
	public WebElement getFirstNameRequred() {
		return driver.findElement(firstNameRequred);
	}

	public WebElement getSecondNameRequred() {
		return driver.findElement(secondNameRequred);
	}

	public WebElement getBirthdayRequred() {
		return driver.findElement(birthdayRequred);
	}

	public WebElement getEmailAddressRequred() {
		return driver.findElement(emailAddressRequred);
	}

	public WebElement getMailingAddressRequred() {
		return driver.findElement(mailingAddressRequred);
	}

	public WebElement getCityRequred() {
		return driver.findElement(cityRequred);
	}

	public WebElement getStateRequred() {
		return driver.findElement(stateRequred);
	}

	public WebElement getPostalCodeRequred() {
		return driver.findElement(postalCodeRequred);
	}

	public WebElement getPasswordRequred() {
		return driver.findElement(passwordRequred);
	}
	
	By firstNameRequred=By.xpath("//*[@id=\"signup\"]/fieldset/div[1]/span");
	By secondNameRequred=By.xpath("//*[@id=\"signup\"]/fieldset/div[2]/span");
	By birthdayRequred=By.xpath("//*[@id=\"signup\"]/fieldset/div[1]/span");
	By emailAddressRequred=By.xpath("//*[@id=\"signup\"]/fieldset/div[4]/span");//*[@id="signup"]/fieldset/div[4]/span
	By mailingAddressRequred=By.xpath("//*[@id=\"signup\"]/fieldset/div[5]/span");
	By cityRequred=By.xpath("//*[@id=\"signup\"]/fieldset/div[6]/span");//*[@id="signup"]/fieldset/div[4]/span
	By stateRequred=By.xpath("//*[@id=\"signup\"]/fieldset/div[7]/span");//*[@id="signup"]/fieldset/div[7]/span
	By postalCodeRequred=By.xpath("//*[@id=\"signup\"]/fieldset/div[8]/span");
	By passwordRequred=By.xpath("//*[@id=\"signup\"]/fieldset/div[9]/span");
	
	
	By continueButton=By.id("signup:continue");
	
	public WebElement getContinue() {
		return driver.findElement(continueButton);
	}

	
	public WebElement getSignedUpSignedUp() {
		return driver.findElement(signedUpSignedUp);
	}

	public SignedUpPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}

	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	public WebElement getLastName() {
		return driver.findElement(lastName);
	}

	public WebElement getBirthDay() {
		return driver.findElement(birthDay);
	}

	public WebElement getEmailAddress() {
		return driver.findElement(emailAddress);
	}

	public WebElement getMailingAddress() {
		return driver.findElement(mailingAddress);
	}

	public WebElement getCity() {
		return driver.findElement(city);
	}

	public WebElement getState() {
		return driver.findElement(state);
	}

	public WebElement getPostalCode() {
		return driver.findElement(postalCode);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getHome() {
		return driver.findElement(postalCode);
	}

	public WebElement getContactUs() {
		return driver.findElement(password);
	}

	
}
