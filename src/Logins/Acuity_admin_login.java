package Logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Acuity_admin_login 
{
	@Test
	public void acuity() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("aqibm@grr.la");
		driver.findElement(By.id("password")).sendKeys("Aqib@123");
		driver.findElement(By.id("loginBtnId")).click();
		Thread.sleep(3000);
		String t= driver.getTitle();
		//System.out.println(t);
		Reporter.log(t,true);
		SoftAssert s= new SoftAssert();
		s.assertEquals(t, "Acuity Link");
		Reporter.log("Login successful", true);
		WebElement ele1= driver.findElement(By.linkText("Manage Variables"));
		String t1= ele1.getText();
		//System.out.println(t1);
		Reporter.log(t1, true);
	
		SoftAssert s1= new SoftAssert();
	
		s1.assertEquals(t1, "Manage Variables");
		
		Reporter.log("Acuity admin Validation successful", true);
	    WebElement ele = driver.findElement(By.linkText("Admin"));
	    Thread.sleep(2000);
	    Actions a = new Actions(driver);
	    a.moveToElement(ele).perform(); 
	    driver.findElement(By.linkText("Logout")).click();
	    driver.close();
	    
	    
		
	}	
		
	
	}

