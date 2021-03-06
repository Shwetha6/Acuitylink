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

public class CrtSrvceReqst_WCT_defaultpickcustomdest_Round extends HI_Login
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	@Test
	public void HiFillPatientInformationWCTRoundTripdefaultpickcustomdest()
	{
		try
		{
			
			HI_Login w6 = new HI_Login();
			driver = w6.hiLogin();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String note=Data_Acuity.getCellData(23, 8);
			
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			
			
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Wheelchair')]")).click();
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
	
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
	driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
	driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
	Robot wctdc=new Robot();
	wctdc.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);

driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);

SoftAssert s60= new SoftAssert();

driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
Thread.sleep(2000);
driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
Thread.sleep(3000);
WebElement ele96=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
String t94=ele96.getText();
System.out.println("Pop up title:"+ t94);
s60.assertEquals(ele96, "Service request successfully created.");
Reporter.log("Service request successfully created pop up is displayed(WCT) with default pick up and custom destination(Round trip)", true);
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
