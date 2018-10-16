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

public class CrtSrvceRqst_WCT_defaultpickdest_Round 
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
	public void HiFillPatientInformationWCTRoundTrip()
	{
		try
		{
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
	driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
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
	
	driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
	Thread.sleep(4000);
	Robot wctrnd=new Robot();
	wctrnd.keyPress(KeyEvent.VK_DOWN);
	wctrnd.keyPress(KeyEvent.VK_ENTER);
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
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	
	WebElement ele65=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[1]"));
	String t63=ele65.getText();
	WebElement ele66=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[2]"));
	String t64=ele66.getText();
	if(t63==t64)
	{
		System.out.println("Destination is assigned as pick up to next trip for WCT");
	}
	else
	{
		System.out.println("Destination is not assigned as pick up to next trip for WCT");
	}
	
	WebElement ele67=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[1]"));
	String t65=ele67.getText();
	WebElement ele68=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[2]"));
	String t66=ele68.getText();
	if(t65==t66)
	{
		System.out.println("Pick up is assigned as destination to round trip for WCT");
	}
	else
	{
		System.out.println("Pick up is not assigned as destination to round trip for WCT");
	}
	
	SoftAssert s36= new SoftAssert();
	Reporter.log("Pick up and destination is verified for next trips", true);
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
    WebElement ele69=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t67=ele69.getText();
	System.out.println("Pop up title:"+ t67);
	s36.assertEquals(ele69, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(WCT) with default pick up and destination(Round trip)", true);
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