package HI_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Design1.Constant_Acuity;
import Design1.Data_Acuity;

public class HI_Logout 
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;


@Test           //69
public void logout()
{
	try
	{
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
/*
@Test(priority=4)
public void close()
{
	driver.close();
}*/
}