package Logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.awt.AWTException;

import Design1.Constant_Acuity;
import Design1.Data_Acuity;

public class Acuity_admin_login 
{
 WebDriver driver;
 
@BeforeTest
public void init()
{
System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
driver= new ChromeDriver();
driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
driver.manage().window().maximize();
}

@Test(priority=1)
	public void acuity() throws Exception
	{
	try
	{
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String email=Data_Acuity.getCellData(2, 0); 
			String password =Data_Acuity.getCellData(2, 1); 
			
		
		
			driver.findElement(By.id("email")).sendKeys(email);
			driver.findElement(By.id("password")).sendKeys(password);
	
		driver.findElement(By.id("loginBtnId")).click();
		Thread.sleep(3000);
		String t= driver.getTitle();
		//System.out.println(t);
		Reporter.log(t,true);
		SoftAssert s= new SoftAssert();
		s.assertEquals(t, "Acuity Link");
		Reporter.log("Login successful", true);
		WebElement ele1= driver.findElement(By.id("acuityVar"));
		String t1= ele1.getText();
		//System.out.println(t1);
		Reporter.log(t1, true);
	
		SoftAssert s1= new SoftAssert();
	
		s1.assertEquals(t1, "Manage Variables");
		
		Reporter.log("Acuity admin Validation successful", true);
	 
		driver.findElement(By.xpath("//img[contains(@src,'avatar.png')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(@class,'linkProf')]/a[2]")).click();
	}
	catch (Exception e) 
	{
		 //TODO Auto-generated catch block
		e.printStackTrace();
	}   
	}
	
		@Test(priority=2)
		public void acuityinvalid()
		{
			try
			{
					Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
					String emaili=Data_Acuity.getCellData(2, 3); 
					String passi =Data_Acuity.getCellData(2, 4); 
					
		driver.findElement(By.id("email")).sendKeys(emaili);
		driver.findElement(By.id("password")).sendKeys(passi);
		driver.findElement(By.id("loginBtnId")).click();
		
		if(driver.findElement(By.xpath("//li[text()= 'E-mail address is invalid']")).isDisplayed())
		{
			System.out.println("Test pass:Invalid email"); 
		}
		else
		{
			System.out.println("Test fail");
		}
		Thread.sleep(3000);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
	}
			catch (Exception e) 
			{
				 //TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		
		@Test(priority=3)
		public void acuityinvalid1()
		{
			try
			{
					Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
					String emaili1=Data_Acuity.getCellData(2, 6); 
					String passi1 =Data_Acuity.getCellData(2, 7); 
					
					Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys(emaili1);
		driver.findElement(By.id("password")).sendKeys(passi1);
		driver.findElement(By.id("loginBtnId")).click();
		
		if(driver.findElement(By.xpath("//div[text()= 'Username and Password does not match. Try again.']")).isDisplayed())
		{
			System.out.println("Test pass:Invalid email"); 
		}
		else
		{
			System.out.println("Test fail");
		}
		Thread.sleep(3000);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
	}
			catch (Exception e) 
			{
				 //TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

		@Test(priority=4)
		public void acuityinvalid2()
		{
			try
			{
				Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
				String email2=Data_Acuity.getCellData(6, 3); 
				String pass2 =Data_Acuity.getCellData(6, 4);
		
		driver.findElement(By.id("email")).sendKeys(email2);
		driver.findElement(By.id("password")).sendKeys(pass2);
		driver.findElement(By.id("loginBtnId")).click();
		if(driver.findElement(By.xpath("//div[text()= 'Username and Password does not match. Try again.']")).isDisplayed())
		{
			System.out.println("Test pass:Invalid email"); 
		}
		else
		{
			System.out.println("Test fail");
		}
		Thread.sleep(3000);
			}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
			}	
		
		
		
		
		

	@AfterTest
	public void close()
	{
		driver.close();
	}
}
	
	


   
		
	
	

