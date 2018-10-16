package Logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Design1.Constant_Acuity;
import Design1.Data_Acuity;


public class ASP_login 
{
	WebDriver driver;
	
	@BeforeTest
	public void init1()
	{
		System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
	   driver= new ChromeDriver();
		driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
		driver.manage().window().maximize();
		}
	@Test
	public void asp() throws InterruptedException
	{
		try {
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String email1=Data_Acuity.getCellData(2, 3); 
			String password1=Data_Acuity.getCellData(2, 4); 
			
		driver.findElement(By.id("email")).sendKeys(email1);
		driver.findElement(By.id("password")).sendKeys(password1);
		driver.findElement(By.id("loginBtnId")).click();
		Thread.sleep(3000);
		
		String t= driver.getTitle();
		//System.out.println(t);
		Reporter.log(t,true);
		SoftAssert s= new SoftAssert();
		s.assertEquals(t, "Acuity Link");
		Reporter.log("Login successful", true);
		WebElement ele1= driver.findElement(By.linkText("Manage Divisions & HIs"));
		String t1= ele1.getText();
		//System.out.println(t1);
		Reporter.log(t1, true);
		SoftAssert s1= new SoftAssert();
		s1.assertEquals(t1, "Manage Divisions & HIs");
		Reporter.log("ASP Validation successful", true);
		
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
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
} 
