package AllTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingOrLoginPage;
import resources.Base;
import resources.ReadExelFile;

public class LoginTest extends BaseTest {
	
	 public static Logger log =LogManager.getLogger(Base.class.getName());

	
    
    @DataProvider(name="inputdata")

    public Object[][] getcellData() throws IOException {
//step1: Locate the path of excel file    	 
    	 ReadExelFile config = new ReadExelFile("C:\\Users\\703177838.INDCORP\\Desktop\\demo.xlsx");
//step2: create workbook instance from excel sheet. 		

	 int rowcount = config.getRowCount("Sheet2");
	 int cellcount = config.getColumnCount("Sheet2");
	
	 Object data[][] = new Object[rowcount][cellcount];
	
	      for(int i=1;i<rowcount;i++){
	    	  
		  Row r =config.getSheet(1).getRow(i);
		
		  for(int j = 0;j<cellcount;j++){
			Cell c = r.getCell(j);
			data[i][j] = c.getStringCellValue();
		}
	}
	
	return data;
	
}
    
    @Test(priority=1,dataProvider="inputdata")
    public void validateLoginField(String email,String password) {
    	LandingOrLoginPage ll=new LandingOrLoginPage(driver);
    	if(email.equalsIgnoreCase("  ")& password.equalsIgnoreCase("  ")) {
    		ll.getEmail().sendKeys("");
        	ll.getPassword().sendKeys("");
        	ll.getLogin().click();
        	  getEmptyValidation(ll );
    	}
    	
    	else if(password.equalsIgnoreCase("invalid")) {
    		ll.getEmail().sendKeys(email);
        	ll.getPassword().sendKeys(password);
        	ll.getLogin().click();
        	getInvalidValidation(ll);
    	}else {
    		ll.getEmail().sendKeys(email);
        	ll.getPassword().sendKeys(password);
        	ll.getLogin().click();
        	getValidValidation(ll);
    	}
    	
  
    }
    private void getInvalidValidation(LandingOrLoginPage ll) {
    	String errorMsgExpectedEmail=ll.getEmailLoginMsg().getText();
        String errorMsgActualEmail="Non-existing email, please try again.";
        
    	Assert.assertEquals(errorMsgActualEmail, errorMsgExpectedEmail);
		
	}

	private void getValidValidation(LandingOrLoginPage ll) {
		String detailsTextExpected=ll.getDetails().getText();
    	System.out.println(detailsTextExpected);
        String detailsTextActual="";
        
    	Assert.assertEquals(detailsTextActual, detailsTextExpected);
		
	}

	private void getEmptyValidation(LandingOrLoginPage ll) {
		
    	String errorMsgExpectedEmail=ll.getEmailLoginMsg().getText();
        String errorMsgActualEmail="Please enter your e-mail";
        
    	Assert.assertEquals(errorMsgActualEmail, errorMsgExpectedEmail);
    	
    	String errorMsgExpectedPassword=ll.getPwdLoginMsg().getText();
        String errorMsgActualPassword="Please enter your password";
        
        Assert.assertEquals(errorMsgActualPassword, errorMsgExpectedPassword);
	}
	



}
