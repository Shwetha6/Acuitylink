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
	
	public class Add_New_ASP extends ASP_Page
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
		public void AddNewAsp() throws InterruptedException
		{
			try
			{
				
				ASP_Page asp = new ASP_Page();
				driver=asp.VerifyAspPage();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				//To check whether "Add New ASP to Acuity Link Network" pop up can be closed
				driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(), 'Add New ASP')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[1]/button[1]")).click();
				Thread.sleep(3000);
				System.out.println("Add New ASP to Acuity Link Network pop up is closed");
					
				//Adding new ASP by fetching data from excel
				Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
				String aspname=Data_Acuity.getCellData(11, 1); 
				String email=Data_Acuity.getCellData(11, 2);
				String phno=Data_Acuity.getCellData(11, 3);
				
			driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(), 'Add New ASP')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("aspName")).sendKeys(aspname);
			driver.findElement(By.id("newUserEmail")).sendKeys(email);
			driver.findElement(By.id("newPhoneNumber")).sendKeys(phno);
			Thread.sleep(3000);
			driver.findElement(By.id("newASPBtn")).click();
			Thread.sleep(3000);
			if(driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'Request has been sent successfully.')]")).isDisplayed())
	        {
	        	System.out.println("New ASP created");
	        }
			else
			{
				System.out.println("Test case fail");
			}
			WebElement ele1=driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'Request has been sent successfully.')]"));
			String t3=ele1.getText();
			System.out.println("Success message:"+ t3);
			SoftAssert s3= new SoftAssert();
			s3.assertEquals(ele1, "Request has been sent successfully.");
			Reporter.log("New ASP created", true);
			}
			
			catch (Exception e) 
			{
				 //TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
