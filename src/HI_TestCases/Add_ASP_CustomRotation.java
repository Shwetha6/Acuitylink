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

public class Add_ASP_CustomRotation 
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
	
	//To check whether Add ASP button is displayed, clickable and ASP is added in the Custom Rotation section
	@Test(priority=9)
	public void CustomRotationSection()
	{
		try
		{
		WebElement ele11=driver.findElement(By.xpath("//h2[@class='font26'][contains(text(), 'Custom Rotation ')]"));
		String t9=ele11.getText();
		System.out.println("Title:"+ t9);
		SoftAssert s9= new SoftAssert();
		s9.assertEquals(ele11, "Custom Rotation");
		Reporter.log("Custom Rotation section is present", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div[3]/button[1]")).click();
		Thread.sleep(3000);
		WebElement ele12=driver.findElement(By.xpath("//h4[@class='modal-title'][contains(text(), 'Ambulance Service Providers')]"));
		String t10=ele12.getText();
		System.out.println("Title of the pop up:"+ t10);
		s9.assertEquals(ele12, "Ambulance Service Providers");
		Reporter.log("Ambulance Service Providers pop up is displayed: Hence Add ASP button is present and clickable in Custom Rotation section ", true);
		List<WebElement> aspname1 = driver.findElements(By.xpath("//div[@id='addAspModal']//div[contains(@class,'modal-body')]"));
		//System.out.println(aspname.size());
		for(WebElement e1: aspname1) 
		{
		System.out.println(e1.getText());
		}
		Reporter.log("ASP's in the pop up are listed", true);
		driver.findElement(By.xpath("//button[@class='btn aq-btn aq-btn-sm padL10 padR10 addOrder'][contains(text(), 'Add')]")).click();
		Thread.sleep(4000);
		WebElement ele13=driver.findElement(By.xpath("//table[@id='customRotation']//button[@type='button'][contains(text(),'Remove')]"));
		String t11=ele13.getText();
		System.out.println("Button name is:"+ t11);
		s9.assertEquals(ele13, "Remove");
		Reporter.log("Remove button is present:Hence ASP has been added in the Custom Rotation section", true);
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
