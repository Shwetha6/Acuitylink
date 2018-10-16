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

public class Check_Addbuilding_Backbutton_Functionality 
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
	
	//To check whether add building block and back button functionality works
	@Test
	public void HIProfileAddBuildingLocation()
	{
		try
		{
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String buildingname=Data_Acuity.getCellData(11, 5); 
			String lobbyname=Data_Acuity.getCellData(11, 6);
			String floorname=Data_Acuity.getCellData(11, 7);
			String unitName=Data_Acuity.getCellData(11, 8);
			String phoneNumber=Data_Acuity.getCellData(11, 9);
			
			
			driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(),'Add Building Location')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024 hiBuildingDetails'][contains(text(),'Add Building')]")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("buildingName")).sendKeys(buildingname);
			driver.findElement(By.xpath("//button[@class='btn aq-btn addUpdateLobbyClass'][contains(text(),'Add Lobby')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("lobbyName")).sendKeys(lobbyname);
			driver.findElement(By.id("addLobbyBtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn addUpdateFloorClass'][contains(text(),'Add Floor')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("floors")).sendKeys(floorname);
			driver.findElement(By.id("unitName")).sendKeys(unitName);
			driver.findElement(By.id("phoneNumber")).sendKeys(phoneNumber);
			driver.findElement(By.id("addFloorBtn")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("saveOrUpdateBtn")).click();
			Thread.sleep(4000);
			WebElement ele25= driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'Building created successfully.')]"));
            String t23 = ele25.getText();
            System.out.println("Success message:"+ t23);
            SoftAssert s14= new SoftAssert();
            s14.assertEquals(ele25, "Building created successfully.");
            Reporter.log("Building information successfully added", true);
            driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024 hiBuildingDetails'][contains(text(),'Add Building')]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//img[contains(@src, '../images/leftArrow.png')]")).click();
            Thread.sleep(4000);
            WebElement ele26=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB20'][contains(text(),'Building List (National Institute of Medical Care)')]"));
			String t24=ele26.getText();
			System.out.println("Page title is:"+ t24);
			s14.assertEquals(ele25, "Building List (National Institute of Medical Care)");
			Reporter.log("Building List page is displayed. Hence back button is clickable", true);
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
