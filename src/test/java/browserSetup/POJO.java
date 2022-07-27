package browserSetup;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class POJO {
	
	public static WebDriver OpenChromeBrowser() 
	{
	
		System.setProperty("webdriver.chrome.driver","src"+File.separatorChar+"test"+File.separatorChar+"resources"+File.separatorChar+"Browser"+File.separatorChar+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		return driver;
	}
	
//	public static WebDriver OpenFirefoxBrowser()
//	{
//		System.setProperty("webdriver.firefox.driver","G:\\Firefox1\\geckodriver.exe");
//		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver win32\\chromedriver.exe");
//		//WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
//	driver.get("http://youtube.com");
//		return driver;
//	}

}
