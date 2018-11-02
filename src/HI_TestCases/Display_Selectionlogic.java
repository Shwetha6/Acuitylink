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

public class Display_Selectionlogic extends HI_Login
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	
	@Test
	public WebDriver VerifySelectionLogicPage()
	{
		try
		{
			
			HI_Login sel = new HI_Login();
			driver = sel.hiLogin();
driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(), 'ASPs & Configuration')]")).click();
Thread.sleep(2000);
driver.findElement(By.linkText("Selection Logic")).click();
WebElement ele7=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB25'][contains(text(), 'Selection Logic')]"));
String t5=ele7.getText();
System.out.println("Page title:"+ t5);
SoftAssert s7= new SoftAssert();
s7.assertEquals(ele7, "Selection Logic");
Reporter.log("Selection logic page is displayed", true);
Thread.sleep(3000);
return driver;
		 }
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	
}
