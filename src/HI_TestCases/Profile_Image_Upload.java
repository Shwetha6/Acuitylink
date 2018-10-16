package HI_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Profile_Image_Upload 
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	
	//To check whether image is uploaded in the profile section
	@Test
	public void HiUploadPicInProfile()
	{
		try
		{
	driver.findElement(By.xpath("//button[@class='btn aq-btn'][contains(text(), 'Edit Information')]")).click();
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//a[contains(text(),'Upload Image')]")).sendKeys("C:\\Users\\Shwetha KP\\Desktop\\Hospital.jpg");
	driver.findElement(By.xpath("//a[contains(text(),'Upload Image')]")).click();
	//driver.findElement(By.xpath("//a[contains(text(),'Upload Image')]")).sendKeys("C:\\Users\\Shwetha KP\\Desktop\\Hospital.jpg");
	Thread.sleep(2000);
	
    Reporter.log("Pages are clickable", true);
			
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
