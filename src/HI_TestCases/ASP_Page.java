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

public class ASP_Page extends HI_Login{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	
	
	
/*	@BeforeTest
	public void init4()
	{
		System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}*/

	//To check whether Ambulance Service Provider page is displayed
	
			@Test
			public WebDriver VerifyAspPage() throws InterruptedException 
			{
				try
				{
				HI_Login log = new HI_Login();
				driver=log.hiLogin();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				if(driver!=null) {
		WebElement local = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(), 'ASPs & Configuration')]"));
		
		local.click();}
				else {
					System.out.println("driver is null");
				}
		Thread.sleep(2000);
				
		Thread.sleep(3000);
		driver.findElement(By.linkText("Ambulance Service Providers")).click();
		WebElement ele=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB20'][contains(text(), 'Ambulance Service Providers')]"));
		String t2=ele.getText();
		System.out.println("Page title:"+ t2);
		SoftAssert s2= new SoftAssert();
		s2.assertEquals(ele, "Ambulance Service Providers");
		Reporter.log("Ambulance service provider page is displayed", true);
		Thread.sleep(3000);
		return driver;	
		}
				catch (Exception e) 
				{
					 //TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
	}
}
