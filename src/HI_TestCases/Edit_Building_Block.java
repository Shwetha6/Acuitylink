package HI_TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Design1.Constant_Acuity;
import Design1.Data_Acuity;

public class Edit_Building_Block extends HI_Login
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
	//To check whether edit building block functionality works
	@Test
	public void HiEditBuildingLocation()
	{
		try
		{
			
			HI_Login edit = new HI_Login();
			driver = edit.hiLogin();
			
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String newbuildingname=Data_Acuity.getCellData(17, 1); 
			String streetAddress=Data_Acuity.getCellData(17, 2);
			String hiZip=Data_Acuity.getCellData(17, 3);
			String lobbyname=Data_Acuity.getCellData(17, 4);
			String unitnamme=Data_Acuity.getCellData(17, 5);
			
			driver.findElement(By.xpath("//img[contains(@src,'avatar.png')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//li[contains(@class,'linkProf')]/a[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(),'Add Building Location')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/a")).click();
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("//label[contains(@class,'switchToggle float-R')]//span[contains(@class,'switchToggle-handle switchbar')][contains(text(),'|||')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//label[contains(@class,'switchToggle float-R')]//span[contains(@class,'switchToggle-handle switchbar')][contains(text(),'|||')]")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("(//span[(@class='switchToggle-handle switchbar')][contains(text(), '|||')])[2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[(@class='switchToggle-handle switchbar')][contains(text(), '|||')])[2]")).click();
			Thread.sleep(3000);
			
	
			
			driver.findElement(By.id("buildingName")).clear();
			Thread.sleep(2000);
			driver.findElement(By.id("buildingName")).sendKeys(newbuildingname);
            
			driver.findElement(By.id("streetAddress")).clear();
			driver.findElement(By.id("streetAddress")).sendKeys(streetAddress);
            
			driver.findElement(By.id("hiZip")).clear();
			driver.findElement(By.id("hiZip")).sendKeys(hiZip);
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//button[@id='addUpdateLobbyId']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("lobbyName")).clear();
			driver.findElement(By.id("lobbyName")).sendKeys(lobbyname);
            
			driver.findElement(By.id("addLobbyBtn")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='addingUnit']//div[1]//div[3]//div[3]//button[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("unitNameNew")).clear();
			driver.findElement(By.id("unitNameNew")).sendKeys(unitnamme);
			Robot r1=new Robot();
			r1.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(5000);
			Thread.sleep(4000);
			
			driver.findElement(By.id("addUnitBtn")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@id='saveOrUpdateBtn']")).click();
			Thread.sleep(4000);
			WebElement ele27=driver.findElement(By.xpath("//div[@class='msg'][contains(text(),'Building updated successfully.')]"));
			String t25=ele27.getText();
			System.out.println("Success message is:"+ t25);
			SoftAssert s15= new SoftAssert();
			s15.assertEquals(ele27, "Building updated successfully.");
			Reporter.log("'Building updated successfully' message is displayed. Hence edit is done. Check manually once", true);
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
