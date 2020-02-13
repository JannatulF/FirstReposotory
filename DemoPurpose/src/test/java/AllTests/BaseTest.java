package AllTests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;

import resources.Base;


public class BaseTest extends Base{
	
	public ExtentHtmlReporter extent;
	public ExtentTest logger;
	public ExtentReports reports;
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		// extent =new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\ExtentReportsTestNG.html");
		// reports=new ExtentReports();
		// reports.attachReporter(extent);
		 
      // extent=new ExtentReports(System.getProperty("user.dir")+"\\test-output\\ExtentReportsTestNG.html",true);
	}
	
	
	public String getScreenshot(String screenshotName) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest =System.getProperty("user.dir")+"/FailedTestScreenShots"+screenshotName;
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		
		return screenshotName;
		
	}
	 //Opening browser with the given URL and navigate to Registration Page
    @BeforeMethod
    public void openBrowser()
    {
    	driver.get(prop.getProperty("url"));
        
    }
    
    @AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}
}
