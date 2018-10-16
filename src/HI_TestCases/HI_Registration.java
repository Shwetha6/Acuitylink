package HI_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Design1.Constant_Acuity;
import Design1.Data_Acuity;

public class HI_Registration 
{
	WebDriver driver;
	@BeforeTest
	public void init4()
	{
		System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
		driver.manage().window().maximize();
	}
	
	@Test
	public void hireg() throws InterruptedException
	{
		try
		{
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet3");
			String hiName=Data_Acuity.getCellData(2, 0); 
			String streetAddress=Data_Acuity.getCellData(2, 1);
			String zip=Data_Acuity.getCellData(2, 2);
			String hiLicenseNo=Data_Acuity.getCellData(2, 3);
			String hiFirstName=Data_Acuity.getCellData(2, 4);
			String hiLastName=Data_Acuity.getCellData(2, 5);
			String email=Data_Acuity.getCellData(2, 6);
			String hiPhoneNo=Data_Acuity.getCellData(2, 7);
		
	 driver.findElement(By.xpath("//button[contains(text(),'Register as Health')]")).click();
	    //driver.findElement(By.id("hiName")).click();
	    //driver.findElement(By.id("hiName")).clear();
	    driver.findElement(By.id("hiName")).sendKeys(hiName);
	    driver.findElement(By.id("hiName")).sendKeys(Keys.TAB);
	    Thread.sleep(10000);   
	    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'-- Select Type -- *')]")).click();
	       
	    driver.manage().timeouts().implicitlyWait(50 ,TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Hospital')]")).click();
	   //new Select(driver.findElement(By.id("hitype"))).selectByVisibleText(type);
	    driver.findElement(By.name("streetAddress")).click();
	    driver.findElement(By.name("streetAddress")).clear();
	    driver.findElement(By.name("streetAddress")).sendKeys(streetAddress);
	    driver.findElement(By.id("hiZip")).click();
	    driver.findElement(By.id("hiZip")).sendKeys(zip);
	    driver.findElement(By.id("hiLicenseNumber")).clear();
	    driver.findElement(By.id("hiLicenseNumber")).sendKeys(hiLicenseNo);
	    driver.findElement(By.id("hiAdminFirstName")).clear();
	    driver.findElement(By.id("hiAdminFirstName")).sendKeys(hiFirstName);
	    driver.findElement(By.id("hiAdminLastName")).clear();
	    driver.findElement(By.id("hiAdminLastName")).sendKeys(hiLastName);
	    //driver.findElement(By.xpath("//form[@id='hiRegistrationForm']/div[3]/div")).click();
	    driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
	    driver.findElement(By.id("hiAdminPhoneNo")).clear();
	    driver.findElement(By.id("hiAdminPhoneNo")).sendKeys(hiPhoneNo);
	    Thread.sleep(4000);
	    if(driver.findElement(By.id("hiSubmit")).isEnabled())
	    {
	    driver.findElement(By.id("hiSubmit")).click();
	    System.out.println("Element is clickable:Proceed to registration");
	    }
	    else
	    {
	    System.out.println("Element is not clickable:Test fail");
	    }
	    Thread.sleep(3000);
	    if(driver.findElement(By.id("email")).isDisplayed())
	    		{
	    	System.out.println("Registration successful");
	    		}
	    else
	    {
	    	System.out.println("Registration fail");
	    }
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	
	/*@AfterTest
	public void close()
	{
		driver.close();
	}
	*/
} 