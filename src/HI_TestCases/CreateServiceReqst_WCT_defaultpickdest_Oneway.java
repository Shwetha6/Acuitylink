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

public class CreateServiceReqst_WCT_defaultpickdest_Oneway extends HI_Login
{
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
	
	@Test
	public void HiFillPatientInformationWCT()
	{
		try
		{
			
			HI_Login w1 = new HI_Login();
			driver = w1.hiLogin();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
		
	Thread.sleep(3000);		
	driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Wheelchair')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
	driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();		
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
	driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
	
	driver.findElement(By.id("searchId0")).sendKeys(desthi);
	Thread.sleep(4000);
	Robot wcttwo=new Robot();
	wcttwo.keyPress(KeyEvent.VK_DOWN);
	wcttwo.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Review and Submit')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele40=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t38=ele40.getText();
	System.out.println("Pop up title:"+ t38);
	SoftAssert s24= new SoftAssert();
	s24.assertEquals(ele40, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(WCT) with default pick up and destination(One-way)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
