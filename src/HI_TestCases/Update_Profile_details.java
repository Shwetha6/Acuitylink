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
import org.testng.asserts.SoftAssert;

public class Update_Profile_details extends HI_Login
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	@Test
	public void HiEditProfileDetails()
	{
		try
		{
			
			HI_Login update = new HI_Login();
			driver = update.hiLogin();
			
			driver.findElement(By.xpath("//img[contains(@src,'avatar.png')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//li[contains(@class,'linkProf')]/a[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn'][contains(text(), 'Edit Information')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='switchToggle-handle switchbar'][contains(text(), '|||')])[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn disClick'][contains(text(), 'Update Profile')]")).click();
			Thread.sleep(3000);
			WebElement ele32 = driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'Your profile has been updated successfully and sent for admin approval.')]"));
			String t30=ele32.getText();
			System.out.println("Success message is:"+ t30);
			SoftAssert s17= new SoftAssert();
			s17.assertEquals(ele32, "Your profile has been updated successfully and sent for admin approval.");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@class='btn aq-btn'][contains(text(), 'Edit Information')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='switchToggle-handle switchbar'][contains(text(), '|||')])[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn disClick'][contains(text(), 'Update Profile')]")).click();
			WebElement ele33 = driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'Your profile has been updated successfully and sent for admin approval.')]"));
			String t31=ele33.getText();
			System.out.println("Success message is:"+ t31);
			s17.assertEquals(ele32, "Your profile has been updated successfully and sent for admin approval.");
			Reporter.log("Profile has been updated successfully and sent for admin approval.", true);
			Thread.sleep(3000);
		}
	catch (Exception e) 
	{
		 //TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
}
