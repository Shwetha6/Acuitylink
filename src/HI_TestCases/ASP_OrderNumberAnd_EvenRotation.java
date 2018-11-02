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

public class ASP_OrderNumberAnd_EvenRotation extends Display_Selectionlogic
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
	
	 //To check whether Add ASP button is displayed, clickable and ASP is added in the Order Number and Even Rotation section
	@Test
	public void OrderNumberEvenRotationSection()
	{
		try
		{	
			
		Display_Selectionlogic ord = new Display_Selectionlogic();
		driver = ord.VerifySelectionLogicPage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	    WebElement ele17=driver.findElement(By.xpath("//h2[contains(text(),'Order Number and Even Rotation')]"));
		String t15=ele17.getText();
		System.out.println("Title:"+ t15);
		SoftAssert s11= new SoftAssert();
		s11.assertEquals(ele17, "Order Number and Even Rotation");
		Reporter.log("Order Number and Even Rotation section is present", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 pad0 topContentHead']//div[4]//div[1]//div[2]//button[1]")).click();
		Thread.sleep(3000);
		WebElement ele18=driver.findElement(By.xpath("//h4[contains(text(),'Ambulance Service Providers')]"));
		String t16=ele18.getText();
		System.out.println("Title of the pop up:"+ t16);
		s11.assertEquals(ele18, "Ambulance Service Providers");
		Reporter.log("Ambulance Service Providers pop up is displayed: Hence Add ASP button is present and clickable in Order Number and Even Rotation section", true);
		List<WebElement> aspname2 = driver.findElements(By.xpath("//div[@id='addAspModal']//div[contains(@class,'modal-body')]"));
		//System.out.println(aspname.size());
		for(WebElement e2: aspname2) {
		System.out.println(e2.getText());
		}
		Reporter.log("ASP's in the pop up are listed", true);
		driver.findElement(By.xpath("//button[@class='btn aq-btn aq-btn-sm padL10 padR10 addOrder'][contains(text(), 'Add')]")).click();
		Thread.sleep(4000);
		WebElement ele19=driver.findElement(By.xpath("//table[@id='orderRotation']//button[@type='button'][contains(text(),'Remove')]"));
		String t17=ele19.getText();
		System.out.println("Button name is:"+ t17);
		s11.assertEquals(ele19, "Remove");
		Reporter.log("Remove button is present:Hence ASP has been added in the Order Number and Even Rotation section", true);
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
