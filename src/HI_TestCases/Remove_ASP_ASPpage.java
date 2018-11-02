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

public class Remove_ASP_ASPpage extends ASP_Page
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	//To Remove ASP service provider using 'Remove' button in the ASP page
	@Test
	public void RemoveAsp() throws InterruptedException
	{
		try
		{
			
			ASP_Page rem = new ASP_Page();
			driver = rem.VerifyAspPage();
			
	driver.findElement(By.xpath("//button[@class='btn aq-btn wauto aspRemove'][contains(text(), 'Remove')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='bootbox-body'][contains(text(), 'Are you sure that you want to remove?')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	Thread.sleep(2000);
    WebElement ele5= driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'ASP removed successfully.')]"));
    String t4 = ele5.getText();
    System.out.println("Success message:"+ t4);
    SoftAssert s5= new SoftAssert();
    s5.assertEquals(ele5, "ASP removed successfully.");
    Reporter.log("ASP has been successfully removed", true);
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
