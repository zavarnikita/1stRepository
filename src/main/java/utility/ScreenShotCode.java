package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotCode {

	
	public static String ScreenShot(WebDriver driver) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = "G:\\Automation Testing\\test.jpg";
		File desg=new File(path);
		FileHandler.copy(source, desg);
		
		return path;
	}
}
