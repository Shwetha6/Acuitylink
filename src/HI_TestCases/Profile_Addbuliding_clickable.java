package HI_TestCases;

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

public class Profile_Addbuliding_clickable extends HI_Login
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
	public void HIProfileAddBuildingButtonCheck() throws InterruptedException
	{
		try
		{
			
			HI_Login back = new HI_Login();
			driver = back.hiLogin();
			
			driver.findElement(By.xpath("//img[contains(@src,'avatar.png')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//li[contains(@class,'linkProf')]/a[1]")).click();
			Thread.sleep(3000);
			WebElement ele22=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB25'][contains(text(),'HI Profile')]"));
			String t20=ele22.getText();
			System.out.println("Page title is:"+ t20);
			SoftAssert s13= new SoftAssert();
			s13.assertEquals(ele22, "HI Profile");
			Reporter.log("Profile section is present and clickable", true);
			driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(),'Add Building Location')]")).click();
			Thread.sleep(3000);
			WebElement ele23=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB20'][contains(text(),'Building List (National Institute of Medical Care)')]"));
			String t21=ele23.getText();
			System.out.println("Page title is:"+ t21);
			s13.assertEquals(ele23, "Building List (National Institute of Medical Care)");
			Reporter.log("Add building location button is present and clickable", true);
			driver.findElement(By.xpath("//img[contains(@src, '../images/leftArrow.png')]")).click();
			Thread.sleep(4000);
			WebElement ele24=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB25'][contains(text(),'HI Profile')]"));
			String t22=ele24.getText();
			System.out.println("Page title is:"+ t22);
			s13.assertEquals(ele24, "HI Profile");
			Reporter.log("Profile section is displayed. Hence back button is clickable", true);
			
		}

		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		/*driver.findElement(By.xpath("//img[contains(@src,'avatar.png')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(@class,'linkProf')]/a[2]")).click();*/
	}
	
	
}
