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

public class ASPbutton_Check_AvailableAppropriateSection 
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

	//To check whether Add ASP button is present in the Available appropriate ASP section
	@Test(priority=12)
	public void AvailableAppropriateASPSection()
	{
		try
		{
	WebElement ele20=driver.findElement(By.xpath("//h2[@class='font26'][contains(text(),'Available appropriate ASP ')]"));
	String t18=ele20.getText();
	System.out.println("Title:"+ t18);
	SoftAssert s12= new SoftAssert();
	s12.assertEquals(ele20, "Available appropriate ASP");
	Reporter.log("Available appropriate ASP section is present", true);
	WebElement ele21=driver.findElement(By.xpath("//h4[contains(text(),'Add ASP')]"));
	String t19=ele21.getText();
	System.out.println("Button name is:"+ t18);
	s12.assertEquals(ele21, "Add ASP");
	Reporter.log("Add ASP button is not present:Test case pass", true);
		}

		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}

