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

public class CrtSrvceReqst_ALS_custompickdest_Round 
{
	
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;	
	

	@Test
	public void HiFillPatientInformationALSRoundTrip()
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
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			
			
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
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
			driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
			driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
			driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
			Robot alsmul=new Robot();
			alsmul.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
			driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
			driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
			driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
			driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
			alsmul.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	
	SoftAssert s53= new SoftAssert();
	
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
    WebElement ele89=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t87=ele89.getText();
	System.out.println("Pop up title:"+ t87);
	s53.assertEquals(ele89, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and destination(Round trip)", true);
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
