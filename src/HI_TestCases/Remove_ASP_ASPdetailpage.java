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

public class Remove_ASP_ASPdetailpage 
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	
	//To Remove ASP service provider using 'Remove' button in the ASP detail page
	@Test(priority=5)
	public void RemoveAspFromAspdetailPage() throws InterruptedException
	{
		try
		{
    Thread.sleep(3000);
    driver.findElement(By.xpath("//a[@class='aspDetail dis-ellipsis']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[@class='btn aq-btn aspRemove'][contains(text(), 'Remove')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@class='bootbox-body'][contains(text(), 'Are you sure that you want to remove?')]")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/button[2]")).click();
    System.out.println("Success message: ASP removed using 'Remove' button from ASP detail page" );
    WebElement ele6= driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'ASP removed successfully.')]"));
    String t5 = ele6.getText();
    SoftAssert s6= new SoftAssert();
    s6.assertEquals(ele6, "ASP removed successfully.");
    Reporter.log("ASP has been successfully removed using 'Remove' button in the ASP detail page", true);
    Thread.sleep(2000);
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
