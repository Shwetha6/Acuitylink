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

public class ASP_SetPercentageAllotment extends Add_ASP_CustomRotation 
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
	
	@Test
	public void SetPercentageListAsp()
	{
		try
		{
			
			Add_ASP_CustomRotation setpercent = new Add_ASP_CustomRotation();
			driver = setpercent.CustomRotationSection();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		WebElement ele14=driver.findElement(By.xpath("//button[@class='btn aq-btn allotmentPopupClass'][contains(text(),'Set % of Allotment')]"));
		String t12=ele14.getText();
		System.out.println("Button name is:"+ t12);
		SoftAssert s10= new SoftAssert();
		s10.assertEquals(ele14, "Set % of Allotment");
		driver.findElement(By.xpath("//button[@class='btn aq-btn allotmentPopupClass'][contains(text(),'Set % of Allotment')]")).click();
		Thread.sleep(4000);
		WebElement ele15=driver.findElement(By.xpath("//h4[@class='modal-title'][contains(text(),'SET % ALLOTMENT')]"));
		String t13=ele15.getText();
		System.out.println("Pop up title is:"+ t13);
		s10.assertEquals(ele15, "SET % ALLOTMENT");
		Reporter.log("Set % of Allotment button is present and clickable", true);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left']")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(),'100%')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
		Thread.sleep(3000);
		WebElement ele16=driver.findElement(By.xpath("//td[@class='aspRotationPer']"));
		String t14=ele16.getText();
		s10.assertEquals(ele16, "100%");
		Reporter.log("% set to 100%", true);
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
