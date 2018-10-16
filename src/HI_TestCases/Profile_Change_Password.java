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

import Design1.Data_Acuity;

public class Profile_Change_Password 
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	
	@Test
	public void HiChangePassword()
	{
		try
		{
			String oldpassword=Data_Acuity.getCellData(17, 7); 
			String newpassword=Data_Acuity.getCellData(17, 8);
			String confirmpassword=Data_Acuity.getCellData(17, 9);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='aq-btn aq-btn-trans'][contains(text(),'Change Password')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("oldPassword")).sendKeys(oldpassword);
			Thread.sleep(2000);
			driver.findElement(By.id("password")).sendKeys(newpassword);
			Thread.sleep(2000);
			driver.findElement(By.id("conpassword")).sendKeys(confirmpassword);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn wauto savePass'][contains(text(),'Update Password')]")).click();
			Thread.sleep(3000);
			WebElement ele35 = driver.findElement(By.xpath("//div[@class='msg'][contains(text(),'Password updated successfully.')]"));
			String t33=ele35.getText();
			System.out.println("Success message is:"+ t33);
			SoftAssert s19= new SoftAssert();
			s19.assertEquals(ele35, "Password updated successfully.");
			Reporter.log("Password changed successfully", true);
			
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
