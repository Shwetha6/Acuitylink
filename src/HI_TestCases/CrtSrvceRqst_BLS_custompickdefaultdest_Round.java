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

public class CrtSrvceRqst_BLS_custompickdefaultdest_Round extends HI_Login
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	@Test
	public void HiFillPatientInformationBLSRoundcustompickdefaultdest()
	{
		try
		{
			
			HI_Login bls2 = new HI_Login();
			driver = bls2.hiLogin();
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
			
			
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Basic')]")).click();
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
			driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
			driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
			driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
			Robot blscd=new Robot();
			blscd.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(3000);
	
			driver.findElement(By.id("searchId0")).sendKeys(desthi);
			Thread.sleep(4000);
			blscd.keyPress(KeyEvent.VK_DOWN);	
			blscd.keyPress(KeyEvent.VK_ENTER);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();

		    driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
			driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
			driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
			driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
			Thread.sleep(3000);
			
			
			/*driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
			driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
			Thread.sleep(3000);*/
			
			driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
			
			
			SoftAssert s62= new SoftAssert();
			
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
		    WebElement ele98=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
			String t96=ele98.getText();
			System.out.println("Pop up title:"+ t96);
			s62.assertEquals(ele98, "Service request successfully created.");
			Reporter.log("Service request successfully created pop up is displayed(BLS) with custom pick up and default destination(Round trip)", true);
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
