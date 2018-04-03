package DataDrivenFramework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;


public class LoginFail {
	WebDriver driver;
	XSSFSheet sheet;
	String filepath = "C:/Users/A638108/Desktop/Selenium/TestData";
	String filename="LoginFail.xlsx";
	
	@Test(dataProvider="testdataprovider")
	public void Home(String username, String password) throws Exception
	{

		System.setProperty("webdriver.chrome.driver", "C:/Users/A638108/Desktop/Selenium/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:/Users/A638108/Desktop/Selenium/geckodriver-v0.19.1-win64/geckodriver.exe");
		driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertTrue(false);
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));				
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			try {
				CaptureScreenshot.utility(driver, result.getName());
			} catch (Exception e) {
			System.out.println("Failed Screenshots"+e.getMessage());	
			}
		}
		driver.quit();
	}
	
	
	
	@DataProvider(name ="testdataprovider")
	public Object[][] getDatafromXL() throws Exception
	{	
		ReadExcel re = new ReadExcel();
		sheet = re.getExcelData(filepath,filename);
		int noOfRows=re.rowNum(sheet);
		System.out.println("rowNum:" +noOfRows);
		int noOfCols=re.colNum(sheet);
		System.out.println("colNum:" +noOfCols);
		
		Object data[][] = new Object[noOfRows][noOfCols];
		for(int i=0; i< noOfRows;i++ )
		{
			for (int j=0; j< noOfCols;j++)
			{
				data[i][j]=re.getData(sheet,i,j);
			}
		}		
		return data;
	}
			
}
