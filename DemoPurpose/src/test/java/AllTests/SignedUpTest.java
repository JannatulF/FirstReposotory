package AllTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingOrLoginPage;
import PageObjects.SignedUpPage;
import resources.Base;
import resources.ReadExelFile;

public class SignedUpTest extends BaseTest {
	

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	boolean firstNameNullValidation;
	boolean lastNameNullValidation;
	boolean emailAddressNullValidation;
	boolean mailingNullValidation;
	boolean cityNullValidation;
	boolean stateNullValidation;
	boolean postalNulValidation;
	boolean passwordNullValidation;
	String actualErrorMsg = "required";
	
	boolean emailInvalidValidation;
	boolean emailAlreadyRegisteredValidation;
	
	String emailInvalidActualMsg="Email not valid";
	String emailAlreadyActualMsg="Email is already registered";
	
	boolean allvalidationOk;
	
	String birthday="12/03/1989";



	@Test
	public void validateTitleofSignedUpPage() {
		LandingOrLoginPage ll = new LandingOrLoginPage(driver);
		ll.getSignup().click();

		String expectedTitle = "InsuranceWeb: Sign up";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	

	@Test
	public void verifyAllSpecifiedFieldsOnSignedUpPage() {

		LandingOrLoginPage ll = new LandingOrLoginPage(driver);
		ll.getSignup().click();

		SignedUpPage sp = new SignedUpPage(driver);
		Assert.assertEquals(sp.getFirstName().isDisplayed(), true);
		Assert.assertEquals(sp.getLastName().isDisplayed(), true);
		Assert.assertEquals(sp.getBirthDay().isDisplayed(), true);
		Assert.assertEquals(sp.getEmailAddress().isDisplayed(), true);
		Assert.assertEquals(sp.getMailingAddress().isDisplayed(), true);
		Assert.assertEquals(sp.getCity().isDisplayed(), true);
		Assert.assertEquals(sp.getState().isDisplayed(), true);
		Assert.assertEquals(sp.getPostalCode().isDisplayed(), true);
		Assert.assertEquals(sp.getPassword().isDisplayed(), true);

	}
	
	@DataProvider(name="testdata")
	 public Object[][] TestDataFeed()
	 {
	  
	 ReadExelFile config = new ReadExelFile("C:\\Users\\703177838.INDCORP\\Desktop\\demo.xlsx");
	  
	 int rows = config.getRowCount(0);
	  
	 Object[][] credentials = new Object[rows][8];
	 
	for(int i=1;i<rows;i++)
	 {
	 credentials[i][0] = config.getData(0, i, 0);
	 credentials[i][1] = config.getData(0, i, 1);
	 credentials[i][2] = config.getData(0, i, 2);
	 credentials[i][3] = config.getData(0, i, 3);
	 credentials[i][4] = config.getData(0, i, 4);
	 credentials[i][5] = config.getData(0, i, 5);
	 credentials[i][6] = config.getData(0, i, 6);
	 credentials[i][7] = config.getData(0, i, 7);
	
	 }
	 return credentials;  
	 }
	
	  @Test(dataProvider="testdata")
	public void validateToAllFields(String firstName,String lastName,String emailAddress,String mailingAddress,String city,
			String state, String postalCode, String password) throws IOException {
		
		// one is inheritance

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		LandingOrLoginPage l = new LandingOrLoginPage(driver);
		l.getSignup().click();
		
		SignedUpPage sp = new SignedUpPage(driver);
		
		if(firstName.equalsIgnoreCase("  ")) {
			sp.getFirstName().sendKeys("");
			firstNameNullValidation=true;
		}else {
			firstNameNullValidation=false;
			sp.getFirstName().sendKeys(firstName);
			
		}

		if(lastName.equalsIgnoreCase("  ")) {
			lastNameNullValidation=true;
			sp.getLastName().sendKeys("");
		}else {
			lastNameNullValidation=false;
			sp.getLastName().sendKeys(lastName);
		}
		
		sp.getBirthDay().sendKeys(birthday);
		
		if(emailAddress.equalsIgnoreCase("  ")) {
			emailAddressNullValidation=true;
			sp.getEmailAddress().sendKeys("");
		}else if(emailAddress.contains("9")) {
			System.out.println(emailAddress);
			emailAddressNullValidation=false;
			emailInvalidValidation=true;
			sp.getEmailAddress().sendKeys(emailAddress);
		}else if(allvalidationOk==true) {
			emailAlreadyRegisteredValidation=false;
			sp.getEmailAddress().sendKeys(emailAddress);
		}
		else {
			emailInvalidValidation=false;
			emailAddressNullValidation=false;
			emailAlreadyRegisteredValidation=false;
			if(emailValidator(emailAddress)) {
				System.out.println(emailAddress);
				emailInvalidValidation=false;
				emailAddressNullValidation=false;
				emailAlreadyRegisteredValidation=true;
			}
			sp.getEmailAddress().sendKeys(emailAddress);
		}
		
		
		if(mailingAddress.equalsIgnoreCase("  ")) {
			mailingNullValidation=true;
			sp.getMailingAddress().sendKeys("");
		}else {
			mailingNullValidation=false;
			sp.getMailingAddress().sendKeys(mailingAddress);
		}
		
		if(city.equalsIgnoreCase("  ")) {
			cityNullValidation=true;
			sp.getCity().sendKeys("");
		}else {
			cityNullValidation=false;
			sp.getCity().sendKeys(city);
		}
		
		if(state.equalsIgnoreCase("None")) {
			stateNullValidation=true;
			sp.getState().sendKeys("None");
		}else {
			stateNullValidation=false;
			sp.getState().sendKeys(state);
		}
		
		if(postalCode.equalsIgnoreCase("  ")) {
			postalNulValidation=true;
			sp.getPostalCode().sendKeys("");
		}else {
			postalNulValidation=false;
			sp.getPostalCode().sendKeys(postalCode);
		}
		
		if(password.equalsIgnoreCase("  ")) {
			passwordNullValidation=true;
			sp.getPassword().sendKeys("");
		}else {
			passwordNullValidation=false;
			sp.getPassword().sendKeys(password);
		}
		
		sp.getSignedUpSignedUp().click();
		
		allvalidation( sp);
	
			
	}
	  
		private void allvalidation(SignedUpPage sp) {
			if(firstNameNullValidation==true) {
				String firstNameExpectedMsg=sp.getFirstNameRequred().getText();
				firstNameValidation(firstNameExpectedMsg);
				
			}
			
			if(lastNameNullValidation==true) {
				String lastNameExpectedMsg=sp.getSecondNameRequred().getText();
				lastNameValidation(lastNameExpectedMsg);
			}
			if(emailAddressNullValidation==true) {
				String emailAddressExpectedMsg=sp.getEmailAddressRequred().getText();
				emailAddressValidation( emailAddressExpectedMsg);
			}
			if(mailingNullValidation==true) {
				String mailingAddressExpectedMsg=sp.getMailingAddressRequred().getText();
				mailingAddressValidation( mailingAddressExpectedMsg);
			}
			if(cityNullValidation==true) {
				String cityExpectedMsg=sp.getCityRequred().getText();
				cityValidation( cityExpectedMsg);
			}
			if(stateNullValidation==true) {
				String stateExpectedMsg=sp.getStateRequred().getText();
				stateValidation( stateExpectedMsg);
			}
			if(postalNulValidation==true) {
				 String postalCodeExpectedMsg=sp.getPostalCodeRequred().getText();
				postalCodeValidation( postalCodeExpectedMsg);
			}
			
			if(passwordNullValidation==true) {
				String passwordExpectedMsg=sp.getPasswordRequred().getText();
				passwordValidation( passwordExpectedMsg);
			}
			
			if(emailInvalidValidation==true) {
				String emailInvalidActualMsg=sp.getEmailAddressRequred().getText();
				emailInvalidValidation(emailInvalidActualMsg);
			}
			if(emailAlreadyRegisteredValidation==true) {
				String emailAlredyRegisteredActualMsg=sp.getEmailAddressRequred().getText();
				emailAlreadyRegisteredValidation(emailAlredyRegisteredActualMsg,sp);
				
			}
			/*
			if(allvalidationOk==true) {
				System.out.println(String.valueOf(sp.getContinue().isDisplayed()));
				Assert.assertEquals(sp.getContinue().isDisplayed(), true);
			}*/
			
		
	}

		private void emailAlreadyRegisteredValidation(String msg, SignedUpPage sp) {
			// TODO Auto-generated method stub
			    Assert.assertEquals(msg, emailAlreadyActualMsg);
			//	allvalidationOk=true;
			    
				Assert.assertEquals(sp.getContinue().isDisplayed(), true);
		}


       
		private void emailInvalidValidation(String msg) {
			Assert.assertEquals(msg, emailInvalidActualMsg);
		
	   }

		public void firstNameValidation(String msg) {
    	  
    	 
			Assert.assertEquals(msg, actualErrorMsg);
			
		}
       
		public void lastNameValidation(String msg) {
			   
				Assert.assertEquals(msg, actualErrorMsg);
		}
       
 		public void emailAddressValidation(String msg) {
     	  
     	 
 			Assert.assertEquals(msg, actualErrorMsg);
 			
 		}
       
 		public void mailingAddressValidation(String msg) {
     	  
     	 
 			Assert.assertEquals(msg, actualErrorMsg);
 			
 		}
       
 		public void cityValidation(String msg) {
     	  
     	 
 			Assert.assertEquals(msg, actualErrorMsg);
 			
 		}
       
 		public void stateValidation(String msg) {
     	  
     	 
 			Assert.assertEquals(msg, actualErrorMsg);
 			
 		}
       
 		public void postalCodeValidation(String msg) {
     	  
     	 
 			Assert.assertEquals(msg, actualErrorMsg);
 			
 		}
       
   		public void passwordValidation(String msg) {
       	  
       	 
   			Assert.assertEquals(msg, actualErrorMsg);
   			
   		}
   		


	

}
