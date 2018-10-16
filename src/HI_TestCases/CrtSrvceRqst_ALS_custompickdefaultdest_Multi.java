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

public class CrtSrvceRqst_ALS_custompickdefaultdest_Multi 
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
	public void HiFillPatientInformationALSCustomAndDefaultMulti()
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
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			String datetime2=Data_Acuity.getCellData(34, 4);
			String datetime3=Data_Acuity.getCellData(34, 5);
			String datetime4=Data_Acuity.getCellData(34, 6);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
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
	Robot alsmul1=new Robot();
	alsmul1.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
	Thread.sleep(4000);
	alsmul1.keyPress(KeyEvent.VK_DOWN);	
	alsmul1.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("searchId1")).sendKeys(desthi);
	Thread.sleep(4000);
	alsmul1.keyPress(KeyEvent.VK_DOWN);	
	alsmul1.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[5]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[2]")).click();
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	
	
	driver.findElement(By.id("searchId2")).sendKeys(desthi);
	Thread.sleep(4000);
	alsmul1.keyPress(KeyEvent.VK_DOWN);	
	alsmul1.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[3]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[3]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[7]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[3]")).click();
	
	driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("searchId3")).sendKeys(desthi);
	Thread.sleep(4000);
	alsmul1.keyPress(KeyEvent.VK_DOWN);	
	alsmul1.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[4]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[4]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[9]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[4]")).click();
	
	driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("searchId4")).sendKeys(desthi);
	Thread.sleep(4000);
	alsmul1.keyPress(KeyEvent.VK_DOWN);	
	alsmul1.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[5]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[5]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[11]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[5]")).click();
	
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
	WebElement ele74=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t72=ele74.getText();
	System.out.println("Pop up title:"+ t72);
	SoftAssert s41= new SoftAssert();
	s41.assertEquals(ele74, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and default destination for multiple destination", true);
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
