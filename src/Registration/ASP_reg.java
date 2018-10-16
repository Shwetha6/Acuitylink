package Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Design1.Constant_Acuity;
import Design1.Data_Acuity;

public class ASP_reg 
{
	WebDriver driver;
	@BeforeTest
	public void init3()
	{
		System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
		driver.manage().window().maximize();
	}
	@Test
	public void aspreg() throws InterruptedException
	{
		try
		{
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet2");
			String aspname=Data_Acuity.getCellData(2, 0); 
			String streetaddress=Data_Acuity.getCellData(2, 1);
			String zip=Data_Acuity.getCellData(2, 2);
			String aspLicenseNo=Data_Acuity.getCellData(2, 3);
			String firstName=Data_Acuity.getCellData(2, 4);
			String lastName=Data_Acuity.getCellData(2, 5);
			String email=Data_Acuity.getCellData(2, 6);
			String phoneNumber=Data_Acuity.getCellData(2, 7);
			
			

	driver.findElement(By.xpath("(//button[@id=''])[2]")).click();
    driver.findElement(By.name("aspName")).clear();
    driver.findElement(By.name("aspName")).sendKeys(aspname);
    driver.findElement(By.name("aspName")).sendKeys(Keys.TAB);
    Thread.sleep(10000);
    
    driver.findElement(By.xpath("//form[@id='aspRegistrationForm']/div/div[2]/div/button/span[1]")).click();
  //driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Nothing Selected *')]")).click();
    driver.findElement(By.xpath("//form[@id='aspRegistrationForm']/div/div[2]/div/div/ul/li/a/span")).click();
   // driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'WCT (Wheelchair Transit)')]")).click();
    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'CCT')]")).click();
    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'ALS')]")).click();
    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'BLS')]")).click();
    Thread.sleep(10000);
    driver.findElement(By.id("streetAddress")).click();
    driver.findElement(By.id("streetAddress")).clear();
    driver.findElement(By.id("streetAddress")).sendKeys(streetaddress);
    driver.findElement(By.id("zipCode")).click();
    driver.findElement(By.id("zipCode")).sendKeys(zip);
    driver.findElement(By.name("aspLicenseNumber")).click();
    driver.findElement(By.name("aspLicenseNumber")).clear();
    driver.findElement(By.name("aspLicenseNumber")).sendKeys(aspLicenseNo);
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys(firstName);
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys(lastName);
    Thread.sleep(10000);
    driver.findElement(By.xpath("(//input[@name='userEmail'])[2]")).sendKeys(email);
    driver.findElement(By.name("phoneNumber")).clear();
    driver.findElement(By.name("phoneNumber")).sendKeys(phoneNumber);
    Thread.sleep(5000);
    driver.findElement(By.id("aspSubmit")).click();
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
