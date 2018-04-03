package DataDrivenFramework;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class CaptureScreenshot {

	public static void utility(WebDriver driver,String screenshotname) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screentshots/" + screenshotname + ".png"));
		System.out.println("Screenshots taken");
		
	}
	
}
