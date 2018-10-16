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

public class Add_ASP_ExclusiveAmbSelection 
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


	   //To check whether Add ASP button is displayed, clickable and ASP is added in the Exclusive Ambulance section
		@Test
		public void ExclusiveAmbulanceSection()
		{
			try
			{
			WebElement ele8=driver.findElement(By.xpath("//h2[@class='font26'][contains(text(), 'Exclusive Ambulance ')]"));
			String t6=ele8.getText();
			System.out.println("Title:"+ t6);
			SoftAssert s8= new SoftAssert();
			s8.assertEquals(ele8, "Exclusive Ambulance");
			Reporter.log("Exclusive Ambulance section is present", true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]")).click();
			Thread.sleep(3000);
			WebElement ele9=driver.findElement(By.xpath("//h4[@class='modal-title'][contains(text(), 'Ambulance Service Providers')]"));
			String t7=ele9.getText();
			System.out.println("Title of the pop up:"+ t7);
			s8.assertEquals(ele9, "Ambulance Service Providers");
			Reporter.log("Ambulance Service Providers pop up is displayed: Hence Add ASP button is present and clickable in Exclusive Ambulance section ", true);
			List<WebElement> aspname = driver.findElements(By.xpath("//div[@id='addAspModal']//div[contains(@class,'modal-body')]"));
			//System.out.println(aspname.size());
			for(WebElement e: aspname) {
			System.out.println(e.getText());
			}
			Reporter.log("ASP's in the pop up are listed", true);
			driver.findElement(By.xpath("//button[@class='btn aq-btn aq-btn-sm padL10 padR10 addOrder'][contains(text(), 'Add')]")).click();
			Thread.sleep(4000);
			WebElement ele10=driver.findElement(By.xpath("//button[@class='btn aq-btn aq-btn-sm removeOrder'][contains(text(), 'Remove')]"));
			String t8=ele10.getText();
			System.out.println("Button name is:"+ t8);
			s8.assertEquals(ele10, "Remove");
			Reporter.log("Remove button is present:Hence ASP has been added in the Exclusive Ambulance section", true);
			 }
			catch (Exception e) 
			{
				 //TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	
	
}
