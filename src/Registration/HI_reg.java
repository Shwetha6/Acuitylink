package Registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HI_reg 
{
	@Test
	public void hireg() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
	driver.manage().window().maximize();
	 driver.findElement(By.xpath("//button[contains(text(),'Register as Health')]")).click();
	    //driver.findElement(By.id("hiName")).click();
	    //driver.findElement(By.id("hiName")).clear();
	    driver.findElement(By.id("hiName")).sendKeys("hi");
	    driver.findElement(By.id("hiName")).sendKeys(Keys.TAB);
	    Thread.sleep(10000);   
	    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'-- Select Type -- *')]")).click();
	       
	    driver.manage().timeouts().implicitlyWait(50 ,TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Hospital')]")).click();
	   //new Select(driver.findElement(By.id("hitype"))).selectByVisibleText(type);
	    driver.findElement(By.name("streetAddress")).click();
	    driver.findElement(By.name("streetAddress")).clear();
	    driver.findElement(By.name("streetAddress")).sendKeys("11 Ridgewood Drive");
	    driver.findElement(By.id("hiZip")).click();
	    driver.findElement(By.id("hiZip")).sendKeys("02115");
	    driver.findElement(By.id("hiLicenseNumber")).clear();
	    driver.findElement(By.id("hiLicenseNumber")).sendKeys("1235");
	    driver.findElement(By.id("hiAdminFirstName")).clear();
	    driver.findElement(By.id("hiAdminFirstName")).sendKeys("Shwetha");
	    driver.findElement(By.id("hiAdminLastName")).clear();
	    driver.findElement(By.id("hiAdminLastName")).sendKeys("K");
	    //driver.findElement(By.xpath("//form[@id='hiRegistrationForm']/div[3]/div")).click();
	    driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("shwethak@grr.la");
	    driver.findElement(By.id("hiAdminPhoneNo")).clear();
	    driver.findElement(By.id("hiAdminPhoneNo")).sendKeys("1234567890");
	    Thread.sleep(4000);
	    driver.findElement(By.id("hiSubmit")).click();
	    
	  }

	  
	}
	

