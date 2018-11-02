package HI_TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
//import java.awt.List;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Design1.Constant_Acuity;
import Design1.Data_Acuity;

public class Activate_Deactivate_Building extends HI_Login
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	/*@BeforeTest
	public void init4()
	{
		System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}*/
	
	//To check whether buildings can be deactivated and activated
	@Test
	public void HiDeactivateBuilding()
	{
		try
		{
			
			HI_Login add = new HI_Login();
			driver = add.hiLogin();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		driver.findElement(By.xpath("//img[contains(@src,'avatar.png')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(@class,'linkProf')]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(),'Add Building Location')]")).click();
		Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@class='switchToggle-handle switchbar']/../../../td[2]/label/span[2]")).click();
	WebElement ele28= driver.findElement(By.xpath("//div[@class='bootbox-body'][contains(text(),'Are you sure you want to deactivate this Building?')]"));
	String t26=ele28.getText();
	SoftAssert s16= new SoftAssert();
	s16.assertEquals(ele28, "Are you sure you want to deactivate this Building?");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'OK')]")).click();
	Thread.sleep(3000);
	WebElement ele29=driver.findElement(By.xpath("//div[@class='msg'][contains(text(),'Deactivated successfully.')]"));
	String t27=ele29.getText();
	System.out.println("Success message is:"+ t27);
	s16.assertEquals(ele29, "Deactivated successfully.");
	Thread.sleep(3000);
	Reporter.log("'Building deactivated", true);
	
	driver.findElement(By.xpath("//span[@class='switchToggle-handle switchbar']/../../../td[2]/label/span[2]")).click();
	WebElement ele30= driver.findElement(By.xpath("//div[@class='bootbox-body'][contains(text(),'Are you sure you want to activate this Building?')]"));
	String t28=ele30.getText();
	s16.assertEquals(ele30, "Are you sure you want to activate this Building?");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'OK')]")).click();
	Thread.sleep(3000);
	WebElement ele31=driver.findElement(By.xpath("//div[@class='msg'][contains(text(),'Activated successfully.')]"));
	String t29=ele31.getText();
	System.out.println("Success message is:"+ t29);
	s16.assertEquals(ele31, "Activated successfully.");
	Reporter.log("'Building activated", true);
	Thread.sleep(3000);
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}


