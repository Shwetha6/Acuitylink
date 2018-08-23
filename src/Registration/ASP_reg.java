package Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ASP_reg 
{
	@Test
	public void aspreg() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
	driver.manage().window().maximize();
	driver.findElement(By.xpath("(//button[@id=''])[2]")).click();
    driver.findElement(By.name("aspName")).clear();
    driver.findElement(By.name("aspName")).sendKeys("ASP");
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
    driver.findElement(By.id("streetAddress")).sendKeys("11 Ridgewood Drive");
    driver.findElement(By.id("zipCode")).click();
    driver.findElement(By.id("zipCode")).sendKeys("02115");
    driver.findElement(By.name("aspLicenseNumber")).click();
    driver.findElement(By.name("aspLicenseNumber")).clear();
    driver.findElement(By.name("aspLicenseNumber")).sendKeys("1345");
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("Shwetha");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("K");
    Thread.sleep(10000);
    driver.findElement(By.xpath("(//input[@name='userEmail'])[2]")).sendKeys("sl1@grr.la");
    driver.findElement(By.name("phoneNumber")).clear();
    driver.findElement(By.name("phoneNumber")).sendKeys("1234567890");
    Thread.sleep(5000);
    driver.findElement(By.id("aspSubmit")).click();
    
	
	
	
	}

}
