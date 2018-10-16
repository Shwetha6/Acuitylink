package HI_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HI_Logout 
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;


@Test(priority=1)
public void logout()
{
	try
	{
	driver.findElement(By.xpath("//img[contains(@src,'avatar.png')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[contains(@class,'linkProf')]/a[2]")).click();
	}
	catch (Exception e) 
	{
		 //TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

@Test(priority=2)
public void close()
{
	driver.close();
}
}