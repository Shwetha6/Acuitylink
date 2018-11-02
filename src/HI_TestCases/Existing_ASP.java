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

public class Existing_ASP extends ASP_Page
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
/*	@BeforeTest
	public void init4()
	{
		System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}*/
	
	@Test
	public void AddExistingAsp() throws InterruptedException
	{
		try
		{
			
			ASP_Page ext = new ASP_Page();
			driver = ext.VerifyAspPage();
			
			driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(), 'Add Existing ASP')]")).click();
			WebElement ele3=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB20'][contains(text(), 'Existing Ambulance Service Providers')]"));
			String t3=ele3.getText();
			System.out.println("Title of the page:"+ t3);
			SoftAssert s4= new SoftAssert();
			s4.assertEquals(ele3, "Existing Ambulance Service Providers");
			Reporter.log("Add Existing ASP button is clickable", true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[contains(@src, '../images/leftArrow.png')]")).click();
			Thread.sleep(4000);
			s4.assertEquals(ele3, "Existing Ambulance Service Providers");
			Reporter.log("Back button is clickable:Existing Ambulance Service Providers page is displayed", true);
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
