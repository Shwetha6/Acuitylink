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

public class Pages_Clickable_BuildinglistPage 
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
	
	//To check whether pages are clickable in Building list page
	@Test
	public void HiBuildingPagination()
	{
		try
		{
			
			HI_Login pages = new HI_Login();
			driver = pages.hiLogin();
	driver.findElement(By.xpath("//img[contains(@src,'avatar.png')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[contains(@class,'linkProf')]/a[1]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(),'Add Building Location')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@class='paginate_button '][contains(text(),'2')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='paginate_button '][contains(text(),'1')]")).click();
	Thread.sleep(2000);	
    System.out.println("Pagination verified");
    Reporter.log("Pages are clickable", true);
			
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
