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

public class CrtSrvceRqst_CCT_custompickdest_Multi extends HI_Login
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
	public void HiFillPatientInformationCCTCustomMulti()
	{
		try
		{
			
			HI_Login cct3 = new HI_Login();
			driver = cct3.hiLogin();
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
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			String datetime2=Data_Acuity.getCellData(34, 4);
			String datetime3=Data_Acuity.getCellData(34, 5);
			String datetime4=Data_Acuity.getCellData(34, 6);
			
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Critical')]")).click();						
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
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
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
	driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
	driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
	Robot cctmul=new Robot();
	cctmul.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
	driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
	driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
	cctmul.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[contains(text(),'Custom Destination Address')]")).click();
	driver.findElement(By.xpath("//label[contains(text(),'Request for addition to Acuity Link network')]")).click();
	driver.findElement(By.id("destFacultyName1")).sendKeys(destination);
	driver.findElement(By.id("streetAddress1")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode1")).sendKeys(zipdest);
	cctmul.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId2']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId2']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
	driver.findElement(By.id("destFacultyName2")).sendKeys(destination);
	driver.findElement(By.id("streetAddress2")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode2")).sendKeys(zipdest);
	cctmul.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	
	
	driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId3']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId3']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
	driver.findElement(By.id("destFacultyName3")).sendKeys(destination);
	driver.findElement(By.id("streetAddress3")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode3")).sendKeys(zipdest);
	cctmul.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	
	
	driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
	Thread.sleep(3000);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId4']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId4']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
	driver.findElement(By.id("destFacultyName4")).sendKeys(destination);
	driver.findElement(By.id("streetAddress4")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode4")).sendKeys(zipdest);
	cctmul.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
	
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
	WebElement ele72=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t70=ele72.getText();
	System.out.println("Pop up title:"+ t70);
	SoftAssert s39= new SoftAssert();
	s39.assertEquals(ele72, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(CCT) with custom pick up and destination for multiple destination", true);
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
