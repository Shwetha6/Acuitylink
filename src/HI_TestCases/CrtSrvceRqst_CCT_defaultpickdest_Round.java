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

public class CrtSrvceRqst_CCT_defaultpickdest_Round extends HI_Login
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
	public void HiFillPatientInformationCCTRoudtrip()
	{
		try
		{
			
			HI_Login cct5 = new HI_Login();
			driver = cct5.hiLogin();
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
			
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
		
	Thread.sleep(3000);		
	driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Critical')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
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
	Robot cctrnd=new Robot();
	cctrnd.keyPress(KeyEvent.VK_DOWN);
	cctrnd.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	
  /*  driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
	Thread.sleep(3000);*/
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	
	WebElement ele60=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[1]"));
	String t58=ele60.getText();
	WebElement ele61=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[2]"));
	String t59=ele61.getText();
	if(t58==t59)
	{
		System.out.println("Destination is assigned as pick up to next trip for CCT");
	}
	else
	{
		System.out.println("Destination is not assigned as pick up to next trip for CCT");
	}
	
	WebElement ele62=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[1]"));
	String t60=ele62.getText();
	WebElement ele63=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[2]"));
	String t61=ele63.getText();
	if(t60==t61)
	{
		System.out.println("Pick up is assigned as destination to round trip for CCT");
	}
	else
	{
		System.out.println("Pick up is not assigned as destination to round trip for CCT");
	}
	
	SoftAssert s36= new SoftAssert();
	Reporter.log("Pick up and destination is verified for next trips", true);
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
    WebElement ele64=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t62=ele64.getText();
	System.out.println("Pop up title:"+ t62);
	s36.assertEquals(ele64, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(CCT) with default pick up and destination(Round trip)", true);
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
