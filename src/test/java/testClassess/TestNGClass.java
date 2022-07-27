package testClassess;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browserSetup.POJO;
import pomClassess.Dashboard_AboutandLogouttab;
import pomClassess.Dashboard_Infotab;
import pomClassess.LoginPage;
import utility.ScreenShotCode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNGClass extends POJO{

	WebDriver driver;
	LoginPage obj1;
	String link;
	Dashboard_Infotab obj2;
	Dashboard_AboutandLogouttab obj3;
	SoftAssert s;
	ExtentReports extent;
	ExtentTest logger;
	
	String link1 ="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	  @BeforeTest
	  public void beforeTest() 
	  {
		  driver=OpenChromeBrowser();
	  }
	  @BeforeClass
	  public void beforeClass() 
	  {
		  obj1=new LoginPage(driver);
		  obj2=new Dashboard_Infotab(driver);
		  obj3=new Dashboard_AboutandLogouttab(driver);
	  }
	  @BeforeMethod
	  public void beforeMethod() throws InterruptedException 
	  {
		  ExtentHtmlReporter r=new ExtentHtmlReporter("G:\\Eclipse Workspace 2022\\OrangeHRM\\test-output\\velocity.html");
		  extent = new ExtentReports();
		  extent.attachReporter(r);
		  
		  logger=extent.createTest("verification");
		  logger=extent.createTest("myinfo");
		  logger=extent.createTest("Dashboard_AboutandLogouttab");
		  
		  System.out.println("try test");
	  }
	  @Test
	  public void verification() throws InterruptedException 
	  {
		  Thread.sleep(2000); 
		  obj1.UserName();
		  Thread.sleep(2000);
		  obj1.Password();
		  Thread.sleep(2000);
		  link = obj1.verifylink();
		  obj1.LoginButton();
		  Thread.sleep(2000);
		  
//		  if(link.equalsIgnoreCase(link1))
//		  {
//			  System.out.println("link: "+link );
//		  } 
//		  System.out.println("test 1");
	  s.assertEquals(link1, link);
	  }
	  @Test(priority = 1)
	  
	  public void myinfo() throws InterruptedException
	  {  
		  obj2.My_info();
		  Thread.sleep(2000);
		  System.out.println("test 2");
	  }
	  
	  @Test(priority = 2)//, enabled=false)
	  public void Dashboard_AboutandLogouttab() throws InterruptedException
	  {
		  Thread.sleep(2000);
		  obj3.WelcomeNameTab();
		  obj3.Aboutinfotab();
		  Thread.sleep(2000);
		  obj3.AboutClose();
		  Thread.sleep(2000);
		  System.out.println("test 3");
		  obj3.logout();
	  }
	  
	  @AfterMethod
		 //System.out.println("data");
		  public void tearDown(ITestResult result) throws IOException 
		  {
			if(result.getStatus()==ITestResult.FAILURE)
			{
				String temp=ScreenShotCode.ScreenShot(driver);
				
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			}

		  extent.flush();
		  
		  }
	  
	  
	  @AfterClass
	  public void afterClass() 
	  {
		  obj1=null;
		  obj2=null;
		  obj3=null;  
	  }
	  
	  @AfterTest
	  public void afterTest() 
	  {
		  driver.quit();
		  driver=null;
		  System.gc();
	  }
}
