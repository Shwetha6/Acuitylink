package HI_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Design1.Constant_Acuity;
import Design1.Data_Acuity;

public class HI_Login {
	
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
/*	@BeforeTest
	public void init4()
	{
		System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}*/
	
	@Test
	public WebDriver hiLogin() throws InterruptedException
	{
		try
		{
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String email1=Data_Acuity.getCellData(2, 12); 
			String password1=Data_Acuity.getCellData(2, 13);
			
			System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			if(driver!=null) {
			wait = new WebDriverWait(driver,6);
		
		
		driver.findElement(By.id("samlUserEmail")).sendKeys(email1);
		driver.findElement(By.id("samlLoginBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys(password1);
		driver.findElement(By.id("loginBtnId")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.titleContains("Acuity Link"));
		String t= driver.getTitle();
		System.out.println("Title of the page:"+t);
		Reporter.log("Title of the page:"+t,true);
		SoftAssert s= new SoftAssert();
		s.assertEquals(t, "Acuity Link");
		Reporter.log("Login successful", true);
		WebElement ele1= driver.findElement(By.xpath("//button[@title='Create a New Service Request']"));
		String t1= ele1.getText();
		System.out.println("Tab name:"+t1);
		Reporter.log("Button present is:"+ t1, true);
		SoftAssert s1= new SoftAssert();
		s1.assertEquals(t1, "Create a Service Request");
		Reporter.log("HI Validation successful", true);
		Thread.sleep(2000);
		
		
			}else {
				System.out.println("driver is nnull");
			}
			return driver;
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}

}
