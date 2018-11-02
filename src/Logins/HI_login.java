package Logins;

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

public class HI_login 
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	
	@BeforeTest
	public void init2()
	{
		System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://uat.acuity-link.com/acuityLink");  //Enter the URL
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test(priority=1)
	public void HiLogin() throws InterruptedException
	{
		try
		{
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String email1=Data_Acuity.getCellData(2, 12); 
			String password1=Data_Acuity.getCellData(2, 13);
			wait = new WebDriverWait(driver,6);
		 
		
		/*driver.findElement(By.id("samlUserEmail")).sendKeys(email2);
		driver.findElement(By.xpath("//button[@class='btn aq-btn'][contains(text(), 'Next')]")).click();
		driver.findElement(By.id("password")).sendKeys(password2);
		driver.findElement(By.id("loginBtnId")).click();*/
		
		driver.findElement(By.id("email")).sendKeys(email1);
		driver.findElement(By.id("password")).sendKeys(password1);
		driver.findElement(By.id("loginBtnId")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.titleContains("Acuity Link"));
		String t= driver.getTitle();
		System.out.println("Title of the page:"+t);
		Reporter.log("Title of the page:"+t,true);
		SoftAssert s= new SoftAssert();
		s.assertEquals(t, "Acuity Link");
		Reporter.log("Login successful", true);
		WebElement ele1= driver.findElement(By.xpath("//button[@title='Create a New Service Request']"));
		String t1= ele1.getText();
		System.out.println("Tab name:"+t1);
		Reporter.log("Button present is:"+ t1, true);
		SoftAssert s1= new SoftAssert();
		s1.assertEquals(t1, "Create a Service Request");
		Reporter.log("HI Validation successful", true);
		Thread.sleep(2000);
		
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
}
		
/*-----------------------------------------------------------------------------------------------	
	
		//To check whether Ambulance Service Provider page is displayed
		@Test(priority=2)
		public void VerifyAspPage()
		{
			try
			{
	driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(), 'ASPs & Configuration')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Ambulance Service Providers")).click();
	WebElement ele=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB20'][contains(text(), 'Ambulance Service Providers')]"));
	String t2=ele.getText();
	System.out.println("Page title:"+ t2);
	SoftAssert s2= new SoftAssert();
	s2.assertEquals(ele, "Ambulance Service Providers");
	Reporter.log("Ambulance service provider page is displayed", true);
	Thread.sleep(3000);
			}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

		
		-----------------------------------------------------------------------
		
		//Add new ASP
		@Test
		public void AddNewAsp() throws InterruptedException
		{
			try
			{
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
		
		
		
	----------------------------------------------------------------------------------------------	
		
		////To check whether "Existing Ambulance Service Providers" page is displayed
				@Test(priority=4)
				public void AddExistingAsp() throws InterruptedException
				{
					try
					{
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
						
					---------------------------------------------------------------------------------------------------------	
						
						//To Remove ASP service provider using 'Remove' button in the ASP page
						@Test(priority=5)
						public void RemoveAsp() throws InterruptedException
						{
							try
							{
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
		                
		         -------------------------------------------------------------------------------------
		                
		              //To Remove ASP service provider using 'Remove' button in the ASP detail page
						@Test(priority=6)
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
		              
		                
		   -----------------------------------------------------------------------------------------------------             
		                
		                //To check whether pagination is working
						@Test(priority=7)
						public void Pagination() throws InterruptedException
						{
							try
							{
		                Thread.sleep(2000);
		                driver.findElement(By.xpath("//a[@class='paginate_button ']")).click();
		                System.out.println("Pagination is clickable");
		                Thread.sleep(2000);
		         }
								catch (Exception e) 
								{
									 //TODO Auto-generated catch block
									e.printStackTrace();
								} 
							}
				
				------------------------------------------------------------------------------------------
				
				
				//To check whether selection logic page is displayed
				@Test(priority=8)
				public void VerifySelectionLogicPage()
				{
					try
					{
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
					 }
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
					
			--------------------------------------------------------------------------
			
			
			   //To check whether Add ASP button is displayed, clickable and ASP is added in the Exclusive Ambulance section
				@Test(priority=9)
				public void ExclusiveAmbulanceSection()
				{
					try
					{
					WebElement ele8=driver.findElement(By.xpath("//h2[@class='font26'][contains(text(), 'Exclusive Ambulance ')]"));
					String t6=ele8.getText();
					System.out.println("Title:"+ t6);
					SoftAssert s8= new SoftAssert();
					s8.assertEquals(ele8, "Exclusive Ambulance");
					Reporter.log("Exclusive Ambulance section is present", true);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]")).click();
					Thread.sleep(3000);
					WebElement ele9=driver.findElement(By.xpath("//h4[@class='modal-title'][contains(text(), 'Ambulance Service Providers')]"));
					String t7=ele9.getText();
					System.out.println("Title of the pop up:"+ t7);
					s8.assertEquals(ele9, "Ambulance Service Providers");
					Reporter.log("Ambulance Service Providers pop up is displayed: Hence Add ASP button is present and clickable in Exclusive Ambulance section ", true);
					List<WebElement> aspname = driver.findElements(By.xpath("//div[@id='addAspModal']//div[contains(@class,'modal-body')]"));
					//System.out.println(aspname.size());
					for(WebElement e: aspname) {
					System.out.println(e.getText());
					}
					Reporter.log("ASP's in the pop up are listed", true);
					driver.findElement(By.xpath("//button[@class='btn aq-btn aq-btn-sm padL10 padR10 addOrder'][contains(text(), 'Add')]")).click();
					Thread.sleep(4000);
					WebElement ele10=driver.findElement(By.xpath("//button[@class='btn aq-btn aq-btn-sm removeOrder'][contains(text(), 'Remove')]"));
					String t8=ele10.getText();
					System.out.println("Button name is:"+ t8);
					s8.assertEquals(ele10, "Remove");
					Reporter.log("Remove button is present:Hence ASP has been added in the Exclusive Ambulance section", true);
					 }
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
					
			-----------------------------------------------------------------------------------------------		
					
					
					//To check whether Add ASP button is displayed, clickable and ASP is added in the Custom Rotation section
				@Test(priority=10)
				public void CustomRotationSection()
				{
					try
					{
					WebElement ele11=driver.findElement(By.xpath("//h2[@class='font26'][contains(text(), 'Custom Rotation ')]"));
					String t9=ele11.getText();
					System.out.println("Title:"+ t9);
					SoftAssert s9= new SoftAssert();
					s9.assertEquals(ele11, "Custom Rotation");
					Reporter.log("Custom Rotation section is present", true);
					Thread.sleep(3000);
					driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div[3]/button[1]")).click();
					Thread.sleep(3000);
					WebElement ele12=driver.findElement(By.xpath("//h4[@class='modal-title'][contains(text(), 'Ambulance Service Providers')]"));
					String t10=ele12.getText();
					System.out.println("Title of the pop up:"+ t10);
					s9.assertEquals(ele12, "Ambulance Service Providers");
					Reporter.log("Ambulance Service Providers pop up is displayed: Hence Add ASP button is present and clickable in Custom Rotation section ", true);
					List<WebElement> aspname1 = driver.findElements(By.xpath("//div[@id='addAspModal']//div[contains(@class,'modal-body')]"));
					//System.out.println(aspname.size());
					for(WebElement e1: aspname1) 
					{
					System.out.println(e1.getText());
					}
					Reporter.log("ASP's in the pop up are listed", true);
					driver.findElement(By.xpath("//button[@class='btn aq-btn aq-btn-sm padL10 padR10 addOrder'][contains(text(), 'Add')]")).click();
					Thread.sleep(4000);
					WebElement ele13=driver.findElement(By.xpath("//table[@id='customRotation']//button[@type='button'][contains(text(),'Remove')]"));
					String t11=ele13.getText();
					System.out.println("Button name is:"+ t11);
					s9.assertEquals(ele13, "Remove");
					Reporter.log("Remove button is present:Hence ASP has been added in the Custom Rotation section", true);
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
					
			-------------------------------------------------------------------------------------		
					
					
					//Check whether Set % of Allotment button is present, clickable and check if the list of ASP's are listed
				@Test(priority=11)
				public void SetPercentageListAsp()
				{
					try
					{
					WebElement ele14=driver.findElement(By.xpath("//button[@class='btn aq-btn allotmentPopupClass'][contains(text(),'Set % of Allotment')]"));
					String t12=ele14.getText();
					System.out.println("Button name is:"+ t12);
					SoftAssert s10= new SoftAssert();
					s10.assertEquals(ele14, "Set % of Allotment");
					driver.findElement(By.xpath("//button[@class='btn aq-btn allotmentPopupClass'][contains(text(),'Set % of Allotment')]")).click();
					Thread.sleep(4000);
					WebElement ele15=driver.findElement(By.xpath("//h4[@class='modal-title'][contains(text(),'SET % ALLOTMENT')]"));
					String t13=ele15.getText();
					System.out.println("Pop up title is:"+ t13);
					s10.assertEquals(ele15, "SET % ALLOTMENT");
					Reporter.log("Set % of Allotment button is present and clickable", true);
					driver.findElement(By.xpath("//span[@class='filter-option pull-left']")).click();
					driver.findElement(By.xpath("//span[@class='text'][contains(text(),'100%')]")).click();
					driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
					Thread.sleep(3000);
					WebElement ele16=driver.findElement(By.xpath("//td[@class='aspRotationPer']"));
					String t14=ele16.getText();
					s10.assertEquals(ele16, "100%");
					Reporter.log("% set to 100%", true);
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
					
				----------------------------------------------------------------------------------------------	
					
					
					 //To check whether Add ASP button is displayed, clickable and ASP is added in the Order Number and Even Rotation section
				@Test(priority=12)
				public void OrderNumberEvenRotationSection()
				{
					try
					{	
				WebElement ele17=driver.findElement(By.xpath("//h2[contains(text(),'Order Number and Even Rotation')]"));
					String t15=ele17.getText();
					System.out.println("Title:"+ t15);
					SoftAssert s11= new SoftAssert();
					s11.assertEquals(ele17, "Order Number and Even Rotation");
					Reporter.log("Order Number and Even Rotation section is present", true);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 pad0 topContentHead']//div[4]//div[1]//div[2]//button[1]")).click();
					Thread.sleep(3000);
					WebElement ele18=driver.findElement(By.xpath("//h4[contains(text(),'Ambulance Service Providers')]"));
					String t16=ele18.getText();
					System.out.println("Title of the pop up:"+ t16);
					s11.assertEquals(ele18, "Ambulance Service Providers");
					Reporter.log("Ambulance Service Providers pop up is displayed: Hence Add ASP button is present and clickable in Order Number and Even Rotation section", true);
					List<WebElement> aspname2 = driver.findElements(By.xpath("//div[@id='addAspModal']//div[contains(@class,'modal-body')]"));
					//System.out.println(aspname.size());
					for(WebElement e2: aspname2) {
					System.out.println(e2.getText());
					}
					Reporter.log("ASP's in the pop up are listed", true);
					driver.findElement(By.xpath("//button[@class='btn aq-btn aq-btn-sm padL10 padR10 addOrder'][contains(text(), 'Add')]")).click();
					Thread.sleep(4000);
					WebElement ele19=driver.findElement(By.xpath("//table[@id='orderRotation']//button[@type='button'][contains(text(),'Remove')]"));
					String t17=ele19.getText();
					System.out.println("Button name is:"+ t17);
					s11.assertEquals(ele19, "Remove");
					Reporter.log("Remove button is present:Hence ASP has been added in the Order Number and Even Rotation section", true);
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
				
			------------------------------------------------------------------------------------------	
				
				
				//To check whether Add ASP button is present in the Available appropriate ASP section
				@Test(priority=13)
				public void AvailableAppropriateASPSection()
				{
					try
					{
				WebElement ele20=driver.findElement(By.xpath("//h2[@class='font26'][contains(text(),'Available appropriate ASP ')]"));
				String t18=ele20.getText();
				System.out.println("Title:"+ t18);
				SoftAssert s12= new SoftAssert();
				s12.assertEquals(ele20, "Available appropriate ASP");
				Reporter.log("Available appropriate ASP section is present", true);
				WebElement ele21=driver.findElement(By.xpath("//h4[contains(text(),'Add ASP')]"));
				String t19=ele21.getText();
				System.out.println("Button name is:"+ t18);
				s12.assertEquals(ele21, "Add ASP");
				Reporter.log("Add ASP button is not present:Test case pass", true);
					}

					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
				
			-------------------------------------------------------------------------------------------------	
				
				
				//To check whether profile is displayed and add building block button is clickable
				@Test(priority=14)
				public void HIProfileAddBuildingButtonCheck()
				{
					try
					{
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
				}
				
				
			----------------------------------------------------------------------------------------------	
				
				
				//To check whether add building block and back button functionality works
				@Test(priority=15)
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
						
						
						
			------------------------------------------------------------------------------------------------------			
						
					
				//To check whether edit building block functionality works
				@Test(priority=16)
				public void HiEditBuildingLocation()
				{
					try
					{
						String newbuildingname=Data_Acuity.getCellData(17, 1); 
						String streetAddress=Data_Acuity.getCellData(17, 2);
						String hiZip=Data_Acuity.getCellData(17, 3);
						String lobbyname=Data_Acuity.getCellData(17, 4);
						String unitnamme=Data_Acuity.getCellData(17, 5);
							
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
				
			-----------------------------------------------------------------------------------------------------
			
				//To check whether buildings can be deactivated and activated
				@Test(priority=17)
				public void HiDeactivateBuilding()
				{
					try
					{
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(),'Add Building Location')]")).click();
					Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@class='switchToggle-handle switchbar']/../../../td[2]/label/span[2]")).click();
				WebElement ele28= driver.findElement(By.xpath("//div[@class='bootbox-body'][contains(text(),'Are you sure you want to deactivate this Building?')]"));
				String t26=ele28.getText();
				SoftAssert s16= new SoftAssert();
				s16.assertEquals(ele28, "Are you sure you want to deactivate this Building?");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'OK')]")).click();
				Thread.sleep(3000);
				WebElement ele29=driver.findElement(By.xpath("//div[@class='msg'][contains(text(),'Deactivated successfully.')]"));
				String t27=ele29.getText();
				System.out.println("Success message is:"+ t27);
				s16.assertEquals(ele29, "Deactivated successfully.");
				Thread.sleep(3000);
				Reporter.log("'Building deactivated", true);
				
				driver.findElement(By.xpath("//span[@class='switchToggle-handle switchbar']/../../../td[2]/label/span[2]")).click();
				WebElement ele30= driver.findElement(By.xpath("//div[@class='bootbox-body'][contains(text(),'Are you sure you want to activate this Building?')]"));
				String t28=ele30.getText();
				s16.assertEquals(ele30, "Are you sure you want to activate this Building?");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'OK')]")).click();
				Thread.sleep(3000);
				WebElement ele31=driver.findElement(By.xpath("//div[@class='msg'][contains(text(),'Activated successfully.')]"));
				String t29=ele31.getText();
				System.out.println("Success message is:"+ t29);
				s16.assertEquals(ele31, "Activated successfully.");
				Reporter.log("'Building activated", true);
				Thread.sleep(3000);
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
				
				---------------------------------------------------------------------------------------------
				
				
				
				//To check whether pages are clickable in Building list page
				@Test(priority=18)
				public void HiBuildingPagination()
				{
					try
					{
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
	
	-------------------------------------------------------------------------------------------
				
				//To check whether profile details are updating
				@Test(priority=19)
				public void HiEditProfileDetails()
				{
					try
					{
						Thread.sleep(2000);
						driver.findElement(By.xpath("//img[contains(@src, '../images/leftArrow.png')]")).click();
						Thread.sleep(4000);
						driver.findElement(By.xpath("//button[@class='btn aq-btn'][contains(text(), 'Edit Information')]")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath("(//span[@class='switchToggle-handle switchbar'][contains(text(), '|||')])[1]")).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='btn aq-btn disClick'][contains(text(), 'Update Profile')]")).click();
						Thread.sleep(3000);
						WebElement ele32 = driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'Your profile has been updated successfully and sent for admin approval.')]"));
						String t30=ele32.getText();
						System.out.println("Success message is:"+ t30);
						SoftAssert s17= new SoftAssert();
						s17.assertEquals(ele32, "Your profile has been updated successfully and sent for admin approval.");
						Thread.sleep(3000);
						
						driver.findElement(By.xpath("//button[@class='btn aq-btn'][contains(text(), 'Edit Information')]")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath("(//span[@class='switchToggle-handle switchbar'][contains(text(), '|||')])[1]")).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='btn aq-btn disClick'][contains(text(), 'Update Profile')]")).click();
						WebElement ele33 = driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'Your profile has been updated successfully and sent for admin approval.')]"));
						String t31=ele33.getText();
						System.out.println("Success message is:"+ t31);
						s17.assertEquals(ele32, "Your profile has been updated successfully and sent for admin approval.");
						Reporter.log("Profile has been updated successfully and sent for admin approval.", true);
						Thread.sleep(3000);
					}
				catch (Exception e) 
				{
					 //TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
			
		-------------------------------------------------------------------------------------------------------	
			
				
				//To check whether image is uploaded in the profile section
				@Test(priority=)
				public void HiUploadPicInProfile()
				{
					try
					{
				driver.findElement(By.xpath("//button[@class='btn aq-btn'][contains(text(), 'Edit Information')]")).click();
				Thread.sleep(2000);
				//driver.findElement(By.xpath("//a[contains(text(),'Upload Image')]")).sendKeys("C:\\Users\\Shwetha KP\\Desktop\\Hospital.jpg");
				driver.findElement(By.xpath("//a[contains(text(),'Upload Image')]")).click();
				//driver.findElement(By.xpath("//a[contains(text(),'Upload Image')]")).sendKeys("C:\\Users\\Shwetha KP\\Desktop\\Hospital.jpg");
				Thread.sleep(2000);
				
			    Reporter.log("Pages are clickable", true);
						
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
					
				
			---------------------------------------------------------------------------------------------------	
				
				//To check whether password is changed successfully in the profile page
				@Test(priority=20)
				public void HiChangePassword()
				{
					try
					{
						String oldpassword=Data_Acuity.getCellData(17, 7); 
						String newpassword=Data_Acuity.getCellData(17, 8);
						String confirmpassword=Data_Acuity.getCellData(17, 9);
						
						Thread.sleep(2000);
						driver.findElement(By.xpath("//button[@class='aq-btn aq-btn-trans'][contains(text(),'Change Password')]")).click();
						Thread.sleep(2000);
						driver.findElement(By.id("oldPassword")).sendKeys(oldpassword);
						Thread.sleep(2000);
						driver.findElement(By.id("password")).sendKeys(newpassword);
						Thread.sleep(2000);
						driver.findElement(By.id("conpassword")).sendKeys(confirmpassword);
						Thread.sleep(2000);
						driver.findElement(By.xpath("//button[@class='btn aq-btn wauto savePass'][contains(text(),'Update Password')]")).click();
						Thread.sleep(3000);
						WebElement ele35 = driver.findElement(By.xpath("//div[@class='msg'][contains(text(),'Password updated successfully.')]"));
						String t33=ele35.getText();
						System.out.println("Success message is:"+ t33);
						SoftAssert s19= new SoftAssert();
						s19.assertEquals(ele35, "Password updated successfully.");
						Reporter.log("Password changed successfully", true);
						
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
				
			------------------------------------------------------------------------------------------------	
				
				//To check whether stage 2 is displayed in create service request page
				@Test(priority=21)
				public void HiCreateServiceRequest()
				{
					try
					{
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
						
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						WebElement ele36 = driver.findElement(By.xpath("//h4[contains(text(), 'PATIENT INFORMATION')]"));
						String t34=ele36.getText();
						System.out.println("Section title:"+ t34);
						SoftAssert s20= new SoftAssert();
						s20.assertEquals(ele36, "PATIENT INFORMATION");
						Reporter.log("PATIENT INFORMATION section is displayed", true);
						
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//To check whether service request is created with ALS
				@Test(priority=22)
				public void HiFillPatientInformationALS()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
				driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
				
				driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
				Thread.sleep(4000);
				Robot als=new Robot();
				als.keyPress(KeyEvent.VK_DOWN);	
				als.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
			    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("submitRequestButtonId")).click();
				Thread.sleep(2000);
				WebElement ele37=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t35=ele37.getText();
				System.out.println("Pop up title:"+ t35);
				SoftAssert s21= new SoftAssert();
				s21.assertEquals(ele37, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(ALS)", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
	-----------------------------------------------------------------------------------------------------------------------------
	           //To check whether service request is created with BLS
				@Test(priority=23)
				public void HiFillPatientInformationBLS()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
				
			    Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a/span[1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
				driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();		
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
				driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
				
				driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
				Thread.sleep(4000);
				Robot bls=new Robot();
				bls.keyPress(KeyEvent.VK_DOWN);
				bls.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
	            driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("submitRequestButtonId")).click();
				Thread.sleep(2000);
				WebElement ele38=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t36=ele38.getText();
				System.out.println("Pop up title:"+ t36);
				SoftAssert s22= new SoftAssert();
				s22.assertEquals(ele38, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(BLS)", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
		-----------------------------------------------------------------------------------------------------------------------
		
		
				//To check whether service request is created with CCT
				@Test(priority=24)
				public void HiFillPatientInformationCCT()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
					
				Thread.sleep(3000);		
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
				driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();		
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
				driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
				
				driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
				Thread.sleep(4000);
				Robot cct=new Robot();
				cct.keyPress(KeyEvent.VK_DOWN);
				cct.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
	            driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("submitRequestButtonId")).click();
				Thread.sleep(2000);
				WebElement ele39=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t37=ele39.getText();
				System.out.println("Pop up title:"+ t37);
				SoftAssert s23= new SoftAssert();
				s23.assertEquals(ele39, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(CCT)", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		--------------------------------------------------------------------------------------------------------
		
				
				//To check whether service request is created with WCT
				@Test(priority=25)
				public void HiFillPatientInformationWCT()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
					
				Thread.sleep(3000);		
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
				driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();		
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
				driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
				
				driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
				Thread.sleep(4000);
				Robot wct=new Robot();
				wct.keyPress(KeyEvent.VK_DOWN);
				wct.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
	            driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Review and Submit')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("submitRequestButtonId")).click();
				Thread.sleep(2000);
				WebElement ele40=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t38=ele40.getText();
				System.out.println("Pop up title:"+ t38);
				SoftAssert s24= new SoftAssert();
				s24.assertEquals(ele40, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(WCT)", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
	
	----------------------------------------------------------------------------------------------------------------
	
				
				//Create service request with custom pickup and destination address(ALS)
				@Test(priority=26)
				public void HiFillPatientInformationALSCustom()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String pickup=Data_Acuity.getCellData(29, 2);
						String streetaddress=Data_Acuity.getCellData(29, 3);
						String zip=Data_Acuity.getCellData(29, 4);
						String destination=Data_Acuity.getCellData(29, 5);
						String deststreet=Data_Acuity.getCellData(29, 6);
						String zipdest=Data_Acuity.getCellData(29, 7);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
						
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot als1=new Robot();
				als1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				als1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong[contains(text(), ' EMERGENCY RESPONSE')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("submitRequestButtonId")).click();
				Thread.sleep(2000);
				WebElement ele41=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t39=ele41.getText();
				System.out.println("Pop up title:"+ t39);
				SoftAssert s25= new SoftAssert();
				s25.assertEquals(ele41, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		---------------------------------------------------------------------------------------------------------------------		
				
				//Create service request with custom pickup and destination address(BLS)
				@Test(priority=27)
				public void HiFillPatientInformationBLSCustom()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String pickup=Data_Acuity.getCellData(29, 2);
						String streetaddress=Data_Acuity.getCellData(29, 3);
						String zip=Data_Acuity.getCellData(29, 4);
						String destination=Data_Acuity.getCellData(29, 5);
						String deststreet=Data_Acuity.getCellData(29, 6);
						String zipdest=Data_Acuity.getCellData(29, 7);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
					    driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot bls1=new Robot();
				bls1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				bls1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong[contains(text(), ' EMERGENCY RESPONSE')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("submitRequestButtonId")).click();
				Thread.sleep(2000);
				WebElement ele42=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t40=ele42.getText();
				System.out.println("Pop up title:"+ t40);
				SoftAssert s26= new SoftAssert();
				s26.assertEquals(ele42, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(BLS) with custom pick up and destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			-----------------------------------------------------------------------------------------------------------------	
				
				//Create service request with custom pickup and destination address(CCT)
				@Test(priority=28)
				public void HiFillPatientInformationCCTCustom()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String pickup=Data_Acuity.getCellData(29, 2);
						String streetaddress=Data_Acuity.getCellData(29, 3);
						String zip=Data_Acuity.getCellData(29, 4);
						String destination=Data_Acuity.getCellData(29, 5);
						String deststreet=Data_Acuity.getCellData(29, 6);
						String zipdest=Data_Acuity.getCellData(29, 7);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
					    driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot cct1=new Robot();
				cct1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				cct1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong[contains(text(), ' EMERGENCY RESPONSE')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("submitRequestButtonId")).click();
				Thread.sleep(2000);
				WebElement ele43=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t41=ele43.getText();
				System.out.println("Pop up title:"+ t41);
				SoftAssert s27= new SoftAssert();
				s27.assertEquals(ele43, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(CCT) with custom pick up and destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		-----------------------------------------------------------------------------------------------------	
				
				//Create service request with custom pickup and destination address(WCT)
		@Test(priority=2)
				public void HiFillPatientInformationWCTCustom()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String pickup=Data_Acuity.getCellData(29, 2);
						String streetaddress=Data_Acuity.getCellData(29, 3);
						String zip=Data_Acuity.getCellData(29, 4);
						String destination=Data_Acuity.getCellData(29, 5);
						String deststreet=Data_Acuity.getCellData(29, 6);
						String zipdest=Data_Acuity.getCellData(29, 7);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
					    driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot cct1=new Robot();
				cct1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				cct1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				driver.findElement(By.id("srDivId2")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("submitRequestButtonId")).click();
				Thread.sleep(2000);
				WebElement ele43=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t41=ele43.getText();
				System.out.println("Pop up title:"+ t41);
				SoftAssert s27= new SoftAssert();
				s27.assertEquals(ele43, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(CCT) with custom pick up and destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
}

		
				
	------------------------------------------------------------------------------------------------------------
	
	
	//Create service request with custom pickup and acuity link destination address(ALS)
	@Test(priority=29)
	public void HiFillPatientInformationALSCustomAndDefault()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
	driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
	driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
	Robot als2=new Robot();
	als2.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
	Thread.sleep(4000);
	Robot als=new Robot();
	als2.keyPress(KeyEvent.VK_DOWN);	
	als2.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong[contains(text(), ' EMERGENCY RESPONSE')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele44=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t42=ele44.getText();
	System.out.println("Pop up title:"+ t42);
	SoftAssert s28= new SoftAssert();
	s28.assertEquals(ele44, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and acuity network destination", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	-------------------------------------------------------------------------------------------------
	
	//Create service request with custom pickup and acuity link destination address(BLS)
	@Test(priority=30)
	public void HiFillPatientInformationBLSCustomAndDefault()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
	
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
	driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a/span[1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
    driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
	driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
	driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
	Robot bls2=new Robot();
	bls2.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
	Thread.sleep(4000);
	bls2.keyPress(KeyEvent.VK_DOWN);
	bls2.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele45=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t43=ele45.getText();
	System.out.println("Pop up title:"+ t43);
	SoftAssert s29= new SoftAssert();
	s29.assertEquals(ele45, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(BLS)using custom pick up and default destinaion", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	------------------------------------------------------------------------------------------------------------
	
	//Create service request with custom pickup and acuity link destination address(CCT)	
	@Test(priority=31)
	public void HiFillPatientInformationCCTCustomAndDefault()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
	
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
	driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
    driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
	driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
	driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
	Robot cct2=new Robot();
	cct2.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
	Thread.sleep(4000);
	
	cct2.keyPress(KeyEvent.VK_DOWN);
	cct2.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele46=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t44=ele46.getText();
	System.out.println("Pop up title:"+ t44);
	SoftAssert s30= new SoftAssert();
	s30.assertEquals(ele46, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(BLS)using custom pick up and default destinaion", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	---------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//To check whether service request is created for ALS with default pickup and custom destination
	@Test(priority=32)
	public void HiFillPatientInformationALSDefaultAndCustom()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
			
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
	driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
	
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
	driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
	driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
	Robot als3=new Robot();
	als3.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele47=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t45=ele47.getText();
	System.out.println("Pop up title:"+ t45);
	SoftAssert s31= new SoftAssert();
	s31.assertEquals(ele47, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(ALS) with default pick up and custom destination", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	-------------------------------------------------------------------------------------------------------------
	
	
	//To check whether service request is created for BLS with default pickup and custom destination
		@Test(priority=33)
		public void HiFillPatientInformationBLSDefaultAndCustom()
		{
			try
			{
				String firstname=Data_Acuity.getCellData(23, 1); 
				String lastname=Data_Acuity.getCellData(23, 2);
				String dob=Data_Acuity.getCellData(23, 3);
				String phno=Data_Acuity.getCellData(23, 4);
				String weight=Data_Acuity.getCellData(23, 5);
				String roomno=Data_Acuity.getCellData(23, 6);
				String desthi=Data_Acuity.getCellData(23, 7);
				String note=Data_Acuity.getCellData(23, 8);
				
				String destination=Data_Acuity.getCellData(29, 5);
				String deststreet=Data_Acuity.getCellData(29, 6);
				String zipdest=Data_Acuity.getCellData(29, 7);
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a/span[1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();

				driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
				
				
		driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
		driver.findElement(By.id("patientLastName")).sendKeys(lastname);
		driver.findElement(By.id("patientDob")).sendKeys(dob);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
		driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
		driver.findElement(By.id("patientWeight")).sendKeys(weight);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
		driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
		driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
		
		driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
		driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
		driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
		driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
		driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
		Robot bls3=new Robot();
		bls3.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("note")).sendKeys(note);
		driver.findElement(By.id("srDivId3")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("submitRequestButtonId")).click();
		Thread.sleep(2000);
		WebElement ele48=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
		String t46=ele48.getText();
		System.out.println("Pop up title:"+ t46);
		SoftAssert s32= new SoftAssert();
		s32.assertEquals(ele48, "Service request successfully created.");
		Reporter.log("Service request successfully created pop up is displayed(BLS) with default pick up and custom destination", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
			}
			catch (Exception e) 
			{
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	--------------------------------------------------------------------------------------------------------------------------
	
		//To check whether service request is created for CCT with default pickup and custom destination
				@Test(priority=34)
				public void HiFillPatientInformationCCTDefaultAndCustom()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String destination=Data_Acuity.getCellData(29, 5);
						String deststreet=Data_Acuity.getCellData(29, 6);
						String zipdest=Data_Acuity.getCellData(29, 7);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();

						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
				driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
				
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				Robot cct3=new Robot();
				cct3.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("submitRequestButtonId")).click();
				Thread.sleep(2000);
				WebElement ele49=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t47=ele49.getText();
				System.out.println("Pop up title:"+ t47);
				SoftAssert s33= new SoftAssert();
				s33.assertEquals(ele49, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(BLS) with default pick up and custom destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
	
	----------------------------------------------------------------------------------------------------------------
				
				
				//To check whether service request is created for ALS with default pick and destination(Round Trip)
	@Test(priority=35)
	public void HiFillPatientInformationALSRoundTrip()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			
			
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
	driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
	
	driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
	Thread.sleep(4000);
	Robot als=new Robot();
	als.keyPress(KeyEvent.VK_DOWN);	
	als.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	Thread.sleep(3000);
	//driver.findElement(By.id("puBuildingNameTemp1")).click();
	
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	
	WebElement ele50=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[1]"));
	String t48=ele50.getText();
	WebElement ele51=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[2]"));
	String t49=ele51.getText();
	if(t48==t49)
	{
		System.out.println("Destination is assigned as pick up to next trip");
	}
	else
	{
		System.out.println("Destination is not assigned as pick up to next trip");
	}
	
	WebElement ele52=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[1]"));
	String t50=ele52.getText();
	WebElement ele53=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[2]"));
	String t51=ele53.getText();
	if(t50==t51)
	{
		System.out.println("Pick up is assigned as destination to round trip");
	}
	else
	{
		System.out.println("Pick up is not assigned as destination to round trip");
	}
	
	SoftAssert s34= new SoftAssert();
	Reporter.log("Pick up and destination is verified for next trips", true);
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
    WebElement ele54=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t52=ele54.getText();
	System.out.println("Pop up title:"+ t52);
	s34.assertEquals(ele54, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(ALS)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
				
				
	---------------------------------------------------------------------------------------------------------
		
	//To check whether service request is created for BLS with default pick and destination(Round Trip)
	@Test(priority=36)
	public void HiFillPatientInformationBLSRoundTrip()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
	
    Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
	driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a/span[1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
	driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
	driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();		
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
	driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
	
	driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
	Thread.sleep(4000);
	Robot blsrnd=new Robot();
	blsrnd.keyPress(KeyEvent.VK_DOWN);
	blsrnd.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	
	WebElement ele55=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[1]"));
	String t53=ele55.getText();
	WebElement ele56=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[2]"));
	String t54=ele56.getText();
	if(t53==t54)
	{
		System.out.println("Destination is assigned as pick up to next trip for BLS");
	}
	else
	{
		System.out.println("Destination is not assigned as pick up to next trip for BLS");
	}
	
	WebElement ele57=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[1]"));
	String t55=ele57.getText();
	WebElement ele58=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[2]"));
	String t56=ele58.getText();
	if(t55==t56)
	{
		System.out.println("Pick up is assigned as destination to round trip for BLS");
	}
	else
	{
		System.out.println("Pick up is not assigned as destination to round trip for BLS");
	}
	
	SoftAssert s35= new SoftAssert();
	Reporter.log("Pick up and destination is verified for next trips", true);
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
    WebElement ele59=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t57=ele59.getText();
	System.out.println("Pop up title:"+ t57);
	s35.assertEquals(ele59, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(BLS)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
 -----------------------------------------------------------------------------------------------------------------   
	
	//To check whether service request is created for CCT with default pick and destination(Round Trip)
	@Test(priority=37)
	public void HiFillPatientInformationCCTRoudtrip()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
		
	Thread.sleep(3000);		
	driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
	driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
	driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
	driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();		
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
	driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
	
	driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
	Thread.sleep(4000);
	Robot cctrnd=new Robot();
	cctrnd.keyPress(KeyEvent.VK_DOWN);
	cctrnd.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	
    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	
	WebElement ele60=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[1]"));
	String t58=ele60.getText();
	WebElement ele61=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[2]"));
	String t59=ele61.getText();
	if(t58==t59)
	{
		System.out.println("Destination is assigned as pick up to next trip for CCT");
	}
	else
	{
		System.out.println("Destination is not assigned as pick up to next trip for CCT");
	}
	
	WebElement ele62=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[1]"));
	String t60=ele62.getText();
	WebElement ele63=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[2]"));
	String t61=ele63.getText();
	if(t60==t61)
	{
		System.out.println("Pick up is assigned as destination to round trip for CCT");
	}
	else
	{
		System.out.println("Pick up is not assigned as destination to round trip for CCT");
	}
	
	SoftAssert s36= new SoftAssert();
	Reporter.log("Pick up and destination is verified for next trips", true);
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
    WebElement ele64=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t62=ele64.getText();
	System.out.println("Pop up title:"+ t62);
	s36.assertEquals(ele64, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(CCT)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
				
	
	--------------------------------------------------------------------------------------------------------------------------
	
	//To check whether service request is created with WCT
	@Test(priority=38)
	public void HiFillPatientInformationWCTRoundTrip()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			
		
	Thread.sleep(3000);		
	driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
	driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
	driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
	driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();		
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
	driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
	
	driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
	Thread.sleep(4000);
	Robot wctrnd=new Robot();
	wctrnd.keyPress(KeyEvent.VK_DOWN);
	wctrnd.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	
	WebElement ele65=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[1]"));
	String t63=ele65.getText();
	WebElement ele66=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[2]"));
	String t64=ele66.getText();
	if(t63==t64)
	{
		System.out.println("Destination is assigned as pick up to next trip for WCT");
	}
	else
	{
		System.out.println("Destination is not assigned as pick up to next trip for WCT");
	}
	
	WebElement ele67=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[1]"));
	String t65=ele67.getText();
	WebElement ele68=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[2]"));
	String t66=ele68.getText();
	if(t65==t66)
	{
		System.out.println("Pick up is assigned as destination to round trip for WCT");
	}
	else
	{
		System.out.println("Pick up is not assigned as destination to round trip for WCT");
	}
	
	SoftAssert s36= new SoftAssert();
	Reporter.log("Pick up and destination is verified for next trips", true);
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
    WebElement ele69=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t67=ele69.getText();
	System.out.println("Pop up title:"+ t67);
	s36.assertEquals(ele69, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(WCT)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	----------------------------------------------------------------------------------------------------------------
	
	//Create service request with custom pickup and destination address with multi destination(ALS)
	@Test(priority=39)
	public void HiFillPatientInformationALSCustomMulti()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			String datetime2=Data_Acuity.getCellData(34, 4);
			String datetime3=Data_Acuity.getCellData(34, 5);
			String datetime4=Data_Acuity.getCellData(34, 6);
			
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
	driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
	driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
	Robot alsmul=new Robot();
	alsmul.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
	driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
	driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
	alsmul.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[contains(text(),'Custom Destination Address')]")).click();
	driver.findElement(By.xpath("//label[contains(text(),'Request for addition to Acuity Link network')]")).click();
	driver.findElement(By.id("destFacultyName1")).sendKeys(destination);
	driver.findElement(By.id("streetAddress1")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode1")).sendKeys(zipdest);
	alsmul.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId2']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId2']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
	driver.findElement(By.id("destFacultyName2")).sendKeys(destination);
	driver.findElement(By.id("streetAddress2")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode2")).sendKeys(zipdest);
	alsmul.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	
	
	driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId3']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId3']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
	driver.findElement(By.id("destFacultyName3")).sendKeys(destination);
	driver.findElement(By.id("streetAddress3")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode3")).sendKeys(zipdest);
	alsmul.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	
	
	driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId4']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId4']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
	driver.findElement(By.id("destFacultyName4")).sendKeys(destination);
	driver.findElement(By.id("streetAddress4")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode4")).sendKeys(zipdest);
	alsmul.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
	
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
	WebElement ele70=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t68=ele70.getText();
	System.out.println("Pop up title:"+ t68);
	SoftAssert s37= new SoftAssert();
	s37.assertEquals(ele70, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and destination for multiple destination", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	-------------------------------------------------------------------------------------------------------------
	
	
	
	//Create service request with custom pickup and destination address with multi destination(BLS)
		@Test(priority=40)
		public void HiFillPatientInformationBLSCustomMulti()
		{
			try
			{
				String firstname=Data_Acuity.getCellData(23, 1); 
				String lastname=Data_Acuity.getCellData(23, 2);
				String dob=Data_Acuity.getCellData(23, 3);
				String phno=Data_Acuity.getCellData(23, 4);
				String weight=Data_Acuity.getCellData(23, 5);
				String roomno=Data_Acuity.getCellData(23, 6);
				String desthi=Data_Acuity.getCellData(23, 7);
				String note=Data_Acuity.getCellData(23, 8);
				
				String pickup=Data_Acuity.getCellData(29, 2);
				String streetaddress=Data_Acuity.getCellData(29, 3);
				String zip=Data_Acuity.getCellData(29, 4);
				String destination=Data_Acuity.getCellData(29, 5);
				String deststreet=Data_Acuity.getCellData(29, 6);
				String zipdest=Data_Acuity.getCellData(29, 7);
				String datetime=Data_Acuity.getCellData(34, 2);
				String datetime1=Data_Acuity.getCellData(34, 3);
				String datetime2=Data_Acuity.getCellData(34, 4);
				String datetime3=Data_Acuity.getCellData(34, 5);
				String datetime4=Data_Acuity.getCellData(34, 6);
				
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a/span[1]")).click();				
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
				
		driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
		driver.findElement(By.id("patientLastName")).sendKeys(lastname);
		driver.findElement(By.id("patientDob")).sendKeys(dob);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
		driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
		driver.findElement(By.id("patientWeight")).sendKeys(weight);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
		driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
		driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
		driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
		Robot blsmul=new Robot();
		blsmul.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
		driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
		driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
		driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
		driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
		blsmul.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
		driver.findElement(By.id("addAnotherDestBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'Custom Destination Address')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Request for addition to Acuity Link network')]")).click();
		driver.findElement(By.id("destFacultyName1")).sendKeys(destination);
		driver.findElement(By.id("streetAddress1")).sendKeys(deststreet);
		driver.findElement(By.id("zipcode1")).sendKeys(zipdest);
		blsmul.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
		driver.findElement(By.id("addAnotherDestBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='destInfoTypeDivId2']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
		driver.findElement(By.xpath("//div[@id='customHiDivId2']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
		driver.findElement(By.id("destFacultyName2")).sendKeys(destination);
		driver.findElement(By.id("streetAddress2")).sendKeys(deststreet);
		driver.findElement(By.id("zipcode2")).sendKeys(zipdest);
		blsmul.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
		driver.findElement(By.id("addAnotherDestBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='destInfoTypeDivId3']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
		driver.findElement(By.xpath("//div[@id='customHiDivId3']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
		driver.findElement(By.id("destFacultyName3")).sendKeys(destination);
		driver.findElement(By.id("streetAddress3")).sendKeys(deststreet);
		driver.findElement(By.id("zipcode3")).sendKeys(zipdest);
		blsmul.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
		driver.findElement(By.id("addAnotherDestBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='destInfoTypeDivId4']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
		driver.findElement(By.xpath("//div[@id='customHiDivId4']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
		driver.findElement(By.id("destFacultyName4")).sendKeys(destination);
		driver.findElement(By.id("streetAddress4")).sendKeys(deststreet);
		driver.findElement(By.id("zipcode4")).sendKeys(zipdest);
		blsmul.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
		
		driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("note")).sendKeys(note);
		driver.findElement(By.id("srDivId3")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
		Thread.sleep(3000);
		WebElement ele71=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
		String t69=ele71.getText();
		System.out.println("Pop up title:"+ t69);
		SoftAssert s38= new SoftAssert();
		s38.assertEquals(ele71, "Service request successfully created.");
		Reporter.log("Service request successfully created pop up is displayed(BLS) with custom pick up and destination for multiple destination", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
		
			}
			catch (Exception e) 
			{
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	---------------------------------------------------------------------------------------------------------------
	
	
	
	
		//Create service request with custom pickup and destination address with multi destination(CCT)
				@Test(priority=41)
				public void HiFillPatientInformationCCTCustomMulti()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String pickup=Data_Acuity.getCellData(29, 2);
						String streetaddress=Data_Acuity.getCellData(29, 3);
						String zip=Data_Acuity.getCellData(29, 4);
						String destination=Data_Acuity.getCellData(29, 5);
						String deststreet=Data_Acuity.getCellData(29, 6);
						String zipdest=Data_Acuity.getCellData(29, 7);
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						String datetime2=Data_Acuity.getCellData(34, 4);
						String datetime3=Data_Acuity.getCellData(34, 5);
						String datetime4=Data_Acuity.getCellData(34, 6);
						
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();						
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
						
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot cctmul=new Robot();
				cctmul.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				cctmul.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName1")).sendKeys(destination);
				driver.findElement(By.id("streetAddress1")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode1")).sendKeys(zipdest);
				cctmul.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId2']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId2']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName2")).sendKeys(destination);
				driver.findElement(By.id("streetAddress2")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode2")).sendKeys(zipdest);
				cctmul.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId3']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId3']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName3")).sendKeys(destination);
				driver.findElement(By.id("streetAddress3")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode3")).sendKeys(zipdest);
				cctmul.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId4']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId4']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName4")).sendKeys(destination);
				driver.findElement(By.id("streetAddress4")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode4")).sendKeys(zipdest);
				cctmul.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele72=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t70=ele72.getText();
				System.out.println("Pop up title:"+ t70);
				SoftAssert s39= new SoftAssert();
				s39.assertEquals(ele72, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(CCT) with custom pick up and destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	
	
	--------------------------------------------------------------------------------------------------------------
				
				
				//Create service request with custom pickup and destination address with multi destination(WCT)
				@Test(priority=42)
				public void HiFillPatientInformationWCTCustomMulti()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String pickup=Data_Acuity.getCellData(29, 2);
						String streetaddress=Data_Acuity.getCellData(29, 3);
						String zip=Data_Acuity.getCellData(29, 4);
						String destination=Data_Acuity.getCellData(29, 5);
						String deststreet=Data_Acuity.getCellData(29, 6);
						String zipdest=Data_Acuity.getCellData(29, 7);
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						String datetime2=Data_Acuity.getCellData(34, 4);
						String datetime3=Data_Acuity.getCellData(34, 5);
						String datetime4=Data_Acuity.getCellData(34, 6);
						
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();						
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
						
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot wctmul=new Robot();
				wctmul.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				wctmul.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName1")).sendKeys(destination);
				driver.findElement(By.id("streetAddress1")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode1")).sendKeys(zipdest);
				wctmul.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId2']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId2']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName2")).sendKeys(destination);
				driver.findElement(By.id("streetAddress2")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode2")).sendKeys(zipdest);
				wctmul.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId3']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId3']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName3")).sendKeys(destination);
				driver.findElement(By.id("streetAddress3")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode3")).sendKeys(zipdest);
				wctmul.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId4']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId4']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName4")).sendKeys(destination);
				driver.findElement(By.id("streetAddress4")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode4")).sendKeys(zipdest);
				wctmul.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele73=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t71=ele73.getText();
				System.out.println("Pop up title:"+ t71);
				SoftAssert s40= new SoftAssert();
				s40.assertEquals(ele73, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(WCT) with custom pick up and destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		---------------------------------------------------------------------------------------------------------------		
				
				//Create service request with custom pickup and default destination address with multi destination(ALS)
				@Test(priority=43)
				public void HiFillPatientInformationALSCustomAndDefaultMulti()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String pickup=Data_Acuity.getCellData(29, 2);
						String streetaddress=Data_Acuity.getCellData(29, 3);
						String zip=Data_Acuity.getCellData(29, 4);
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						String datetime2=Data_Acuity.getCellData(34, 4);
						String datetime3=Data_Acuity.getCellData(34, 5);
						String datetime4=Data_Acuity.getCellData(34, 6);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
						
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot alsmul1=new Robot();
				alsmul1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
				Thread.sleep(4000);
				alsmul1.keyPress(KeyEvent.VK_DOWN);	
				alsmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId1")).sendKeys(desthi);
				Thread.sleep(4000);
				alsmul1.keyPress(KeyEvent.VK_DOWN);	
				alsmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[5]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[2]")).click();
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("searchId2")).sendKeys(desthi);
				Thread.sleep(4000);
				alsmul1.keyPress(KeyEvent.VK_DOWN);	
				alsmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[3]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[3]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[7]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[3]")).click();
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId3")).sendKeys(desthi);
				Thread.sleep(4000);
				alsmul1.keyPress(KeyEvent.VK_DOWN);	
				alsmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[4]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[4]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[9]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[4]")).click();
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId4")).sendKeys(desthi);
				Thread.sleep(4000);
				alsmul1.keyPress(KeyEvent.VK_DOWN);	
				alsmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[5]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[5]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[11]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[5]")).click();
				
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele74=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t72=ele74.getText();
				System.out.println("Pop up title:"+ t72);
				SoftAssert s41= new SoftAssert();
				s41.assertEquals(ele74, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and default destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
		-----------------------------------------------------------------------------------------------------------		
				
				//Create service request with custom pickup and default destination address with multi destination(BLS)
				@Test(priority=44)
				public void HiFillPatientInformationBLSCustomAndDefaultMulti()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String pickup=Data_Acuity.getCellData(29, 2);
						String streetaddress=Data_Acuity.getCellData(29, 3);
						String zip=Data_Acuity.getCellData(29, 4);
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						String datetime2=Data_Acuity.getCellData(34, 4);
						String datetime3=Data_Acuity.getCellData(34, 5);
						String datetime4=Data_Acuity.getCellData(34, 6);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
						
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot blsmul1=new Robot();
				blsmul1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
				Thread.sleep(4000);
				blsmul1.keyPress(KeyEvent.VK_DOWN);	
				blsmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId1")).sendKeys(desthi);
				Thread.sleep(4000);
				blsmul1.keyPress(KeyEvent.VK_DOWN);	
				blsmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[5]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[2]")).click();
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("searchId2")).sendKeys(desthi);
				Thread.sleep(4000);
				blsmul1.keyPress(KeyEvent.VK_DOWN);	
				blsmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[3]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[3]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[7]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[3]")).click();
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId3")).sendKeys(desthi);
				Thread.sleep(4000);
				blsmul1.keyPress(KeyEvent.VK_DOWN);	
				blsmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[4]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[4]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[9]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[4]")).click();
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId4")).sendKeys(desthi);
				Thread.sleep(4000);
				blsmul1.keyPress(KeyEvent.VK_DOWN);	
				blsmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[5]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[5]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[11]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[5]")).click();
				
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele75=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t73=ele75.getText();
				System.out.println("Pop up title:"+ t73);
				SoftAssert s41= new SoftAssert();
				s41.assertEquals(ele75, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(BLS) with custom pick up and destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			--------------------------------------------------------------------------------------------------------------------	
				
				
				//Create service request with custom pickup and default destination address with multi destination(CCT)
				@Test(priority=45)
				public void HiFillPatientInformationCCTCustomAndDefaultMulti()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String pickup=Data_Acuity.getCellData(29, 2);
						String streetaddress=Data_Acuity.getCellData(29, 3);
						String zip=Data_Acuity.getCellData(29, 4);
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						String datetime2=Data_Acuity.getCellData(34, 4);
						String datetime3=Data_Acuity.getCellData(34, 5);
						String datetime4=Data_Acuity.getCellData(34, 6);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
						
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot cctmul1=new Robot();
				cctmul1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
				Thread.sleep(4000);
				cctmul1.keyPress(KeyEvent.VK_DOWN);	
				cctmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId1")).sendKeys(desthi);
				Thread.sleep(4000);
				cctmul1.keyPress(KeyEvent.VK_DOWN);	
				cctmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[5]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[2]")).click();
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("searchId2")).sendKeys(desthi);
				Thread.sleep(4000);
				cctmul1.keyPress(KeyEvent.VK_DOWN);	
				cctmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[3]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[3]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[7]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[3]")).click();
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId3")).sendKeys(desthi);
				Thread.sleep(4000);
				cctmul1.keyPress(KeyEvent.VK_DOWN);	
				cctmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[4]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[4]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[9]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[4]")).click();
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId4")).sendKeys(desthi);
				Thread.sleep(4000);
				cctmul1.keyPress(KeyEvent.VK_DOWN);	
				cctmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[5]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[5]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[11]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[5]")).click();
				
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele76=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t74=ele76.getText();
				System.out.println("Pop up title:"+ t74);
				SoftAssert s42= new SoftAssert();
				s42.assertEquals(ele76, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(CCT) with custom pick up and destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
	------------------------------------------------------------------------------------------------------------------			
				
				
				//Create service request with custom pickup and default destination address with multi destination(WCT)
				@Test(priority=46)
				public void HiFillPatientInformationWCTCustomAndDefaultMulti()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String pickup=Data_Acuity.getCellData(29, 2);
						String streetaddress=Data_Acuity.getCellData(29, 3);
						String zip=Data_Acuity.getCellData(29, 4);
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						String datetime2=Data_Acuity.getCellData(34, 4);
						String datetime3=Data_Acuity.getCellData(34, 5);
						String datetime4=Data_Acuity.getCellData(34, 6);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
						
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot wctmul1=new Robot();
				wctmul1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
				Thread.sleep(4000);
				wctmul1.keyPress(KeyEvent.VK_DOWN);	
				wctmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId1")).sendKeys(desthi);
				Thread.sleep(4000);
				wctmul1.keyPress(KeyEvent.VK_DOWN);	
				wctmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[5]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[2]")).click();
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("searchId2")).sendKeys(desthi);
				Thread.sleep(4000);
				wctmul1.keyPress(KeyEvent.VK_DOWN);	
				wctmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[3]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[3]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[7]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[3]")).click();
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId3")).sendKeys(desthi);
				Thread.sleep(4000);
				wctmul1.keyPress(KeyEvent.VK_DOWN);	
				wctmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[4]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[4]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[9]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[4]")).click();
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId4")).sendKeys(desthi);
				Thread.sleep(4000);
				wctmul1.keyPress(KeyEvent.VK_DOWN);	
				wctmul1.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[5]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[5]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[11]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[5]")).click();
				
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele77=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t75=ele77.getText();
				System.out.println("Pop up title:"+ t75);
				SoftAssert s43= new SoftAssert();
				s43.assertEquals(ele77, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(WCT) with custom pick up and destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
	-------------------------------------------------------------------------------------------------------------------------			
				
				
	        //Create service request with default pickup and custom destination address with multi destination(ALS)
				@Test(priority=47)
				public void HiFillPatientInformationALSDefaultAndCustomMulti()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String destination=Data_Acuity.getCellData(29, 5);
						String deststreet=Data_Acuity.getCellData(29, 6);
						String zipdest=Data_Acuity.getCellData(29, 7);
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						String datetime2=Data_Acuity.getCellData(34, 4);
						String datetime3=Data_Acuity.getCellData(34, 5);
						String datetime4=Data_Acuity.getCellData(34, 6);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
						
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
				driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
				
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				Robot alsmulti=new Robot();
				alsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId1']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName1")).sendKeys(destination);
				driver.findElement(By.id("streetAddress1")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode1")).sendKeys(zipdest);
				alsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId2']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId2']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName2")).sendKeys(destination);
				driver.findElement(By.id("streetAddress2")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode2")).sendKeys(zipdest);
				alsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				Thread.sleep(2000);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId3']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId3']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName3")).sendKeys(destination);
				driver.findElement(By.id("streetAddress3")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode3")).sendKeys(zipdest);
				alsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId4']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId4']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName4")).sendKeys(destination);
				driver.findElement(By.id("streetAddress4")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode4")).sendKeys(zipdest);
				alsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele78=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t76=ele78.getText();
				System.out.println("Pop up title:"+ t76);
				SoftAssert s44= new SoftAssert();
				s44.assertEquals(ele78, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(ALS) with default pick up and custom destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
	------------------------------------------------------------------------------------------------------------------			
				
				 //Create service request with default pickup and custom destination address with multi destination(BLS)
				@Test(priority=48)
				public void HiFillPatientInformationBLSDefaultAndCustomMulti()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String destination=Data_Acuity.getCellData(29, 5);
						String deststreet=Data_Acuity.getCellData(29, 6);
						String zipdest=Data_Acuity.getCellData(29, 7);
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						String datetime2=Data_Acuity.getCellData(34, 4);
						String datetime3=Data_Acuity.getCellData(34, 5);
						String datetime4=Data_Acuity.getCellData(34, 6);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
					
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
				driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
				
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				Robot blsmulti=new Robot();
				blsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId1']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName1")).sendKeys(destination);
				driver.findElement(By.id("streetAddress1")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode1")).sendKeys(zipdest);
				blsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId2']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId2']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName2")).sendKeys(destination);
				driver.findElement(By.id("streetAddress2")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode2")).sendKeys(zipdest);
				blsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				Thread.sleep(2000);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId3']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId3']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName3")).sendKeys(destination);
				driver.findElement(By.id("streetAddress3")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode3")).sendKeys(zipdest);
				blsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId4']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId4']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName4")).sendKeys(destination);
				driver.findElement(By.id("streetAddress4")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode4")).sendKeys(zipdest);
				blsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele79=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t77=ele79.getText();
				System.out.println("Pop up title:"+ t77);
				SoftAssert s45= new SoftAssert();
				s45.assertEquals(ele79, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(BLS) with default pick up and custom destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
		---------------------------------------------------------------------------------------------------------------------		
			
				
				//Create service request with default pickup and custom destination address with multi destination(CCT)
				@Test(priority=49)
				public void HiFillPatientInformationCCTDefaultAndCustomMulti()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String destination=Data_Acuity.getCellData(29, 5);
						String deststreet=Data_Acuity.getCellData(29, 6);
						String zipdest=Data_Acuity.getCellData(29, 7);
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						String datetime2=Data_Acuity.getCellData(34, 4);
						String datetime3=Data_Acuity.getCellData(34, 5);
						String datetime4=Data_Acuity.getCellData(34, 6);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
					
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
				driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
				
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				Robot cctmulti=new Robot();
				cctmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId1']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName1")).sendKeys(destination);
				driver.findElement(By.id("streetAddress1")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode1")).sendKeys(zipdest);
				cctmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId2']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId2']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName2")).sendKeys(destination);
				driver.findElement(By.id("streetAddress2")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode2")).sendKeys(zipdest);
				cctmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				Thread.sleep(2000);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId3']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId3']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName3")).sendKeys(destination);
				driver.findElement(By.id("streetAddress3")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode3")).sendKeys(zipdest);
				cctmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId4']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId4']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName4")).sendKeys(destination);
				driver.findElement(By.id("streetAddress4")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode4")).sendKeys(zipdest);
				cctmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele80=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t78=ele80.getText();
				System.out.println("Pop up title:"+ t78);
				SoftAssert s46= new SoftAssert();
				s46.assertEquals(ele80, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(CCT) with default pick up and custom destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			--------------------------------------------------------------------------------------------------	
				
				
				//Create service request with default pickup and custom destination address with multi destination(WCT)
				@Test(priority=50)
				public void HiFillPatientInformationWCTDefaultAndCustomMulti()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String destination=Data_Acuity.getCellData(29, 5);
						String deststreet=Data_Acuity.getCellData(29, 6);
						String zipdest=Data_Acuity.getCellData(29, 7);
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						String datetime2=Data_Acuity.getCellData(34, 4);
						String datetime3=Data_Acuity.getCellData(34, 5);
						String datetime4=Data_Acuity.getCellData(34, 6);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
					
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
				driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
				
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				Robot wctmulti=new Robot();
				wctmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId1']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName1")).sendKeys(destination);
				driver.findElement(By.id("streetAddress1")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode1")).sendKeys(zipdest);
				wctmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId2']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId2']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName2")).sendKeys(destination);
				driver.findElement(By.id("streetAddress2")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode2")).sendKeys(zipdest);
				wctmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				Thread.sleep(2000);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId3']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId3']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName3")).sendKeys(destination);
				driver.findElement(By.id("streetAddress3")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode3")).sendKeys(zipdest);
				wctmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId4']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId4']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName4")).sendKeys(destination);
				driver.findElement(By.id("streetAddress4")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode4")).sendKeys(zipdest);
				wctmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele81=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t79=ele81.getText();
				System.out.println("Pop up title:"+ t79);
				SoftAssert s47= new SoftAssert();
				s47.assertEquals(ele81, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(WCT) with default pick up and custom destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			----------------------------------------------------------------------------------------------------	
				
				
				
				//Create service request with default pickup and default destination address with multi destination(ALS)
				@Test(priority=51)
				public void HiFillPatientInformationALSDefaultMulti()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
						String destination=Data_Acuity.getCellData(29, 5);
						String deststreet=Data_Acuity.getCellData(29, 6);
						String zipdest=Data_Acuity.getCellData(29, 7);
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						String datetime2=Data_Acuity.getCellData(34, 4);
						String datetime3=Data_Acuity.getCellData(34, 5);
						String datetime4=Data_Acuity.getCellData(34, 6);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
					
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
				driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
				
				driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
				Thread.sleep(4000);
				Robot alsmuldef=new Robot();
				alsmuldef.keyPress(KeyEvent.VK_DOWN);	
				alsmuldef.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
	            driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId1")).sendKeys(desthi);
				Thread.sleep(4000);
				alsmuldef.keyPress(KeyEvent.VK_DOWN);	
				alsmuldef.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[3]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[5]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[2]")).click();
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("searchId2")).sendKeys(desthi);
				Thread.sleep(4000);
				alsmuldef.keyPress(KeyEvent.VK_DOWN);	
				alsmuldef.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[3]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[4]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[7]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[3]")).click();
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId3")).sendKeys(desthi);
				Thread.sleep(4000);
				alsmuldef.keyPress(KeyEvent.VK_DOWN);	
				alsmuldef.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[4]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[5]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[9]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[4]")).click();
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId4")).sendKeys(desthi);
				Thread.sleep(4000);
				alsmuldef.keyPress(KeyEvent.VK_DOWN);	
				alsmuldef.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[5]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[6]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[11]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[5]")).click();
				
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele82=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t80=ele82.getText();
				System.out.println("Pop up title:"+ t80);
				SoftAssert s48= new SoftAssert();
				s48.assertEquals(ele82, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and default destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			-----------------------------------------------------------------------------------------------------------	
				
				
				
				
				//Create service request with default pickup and default destination address with multi destination(BLS)
				@Test(priority=52)
				public void HiFillPatientInformationBLSDefaultMulti()
				{
					try
					{
						String firstname=Data_Acuity.getCellData(23, 1); 
						String lastname=Data_Acuity.getCellData(23, 2);
						String dob=Data_Acuity.getCellData(23, 3);
						String phno=Data_Acuity.getCellData(23, 4);
						String weight=Data_Acuity.getCellData(23, 5);
						String roomno=Data_Acuity.getCellData(23, 6);
						String desthi=Data_Acuity.getCellData(23, 7);
						String note=Data_Acuity.getCellData(23, 8);
						
		
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a/span[1]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
						driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
					
						driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
						
						
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
				driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
				
				driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
				Thread.sleep(4000);
				Robot blsmuldef=new Robot();
				blsmuldef.keyPress(KeyEvent.VK_DOWN);	
				blsmuldef.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
	            driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId1")).sendKeys(desthi);
				Thread.sleep(4000);
				blsmuldef.keyPress(KeyEvent.VK_DOWN);	
				blsmuldef.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[3]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[5]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[2]")).click();
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("searchId2")).sendKeys(desthi);
				Thread.sleep(4000);
				blsmuldef.keyPress(KeyEvent.VK_DOWN);	
				blsmuldef.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[3]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[4]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[7]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[3]")).click();
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId3")).sendKeys(desthi);
				Thread.sleep(4000);
				blsmuldef.keyPress(KeyEvent.VK_DOWN);	
				blsmuldef.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[4]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[5]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[9]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[4]")).click();
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("searchId4")).sendKeys(desthi);
				Thread.sleep(4000);
				blsmuldef.keyPress(KeyEvent.VK_DOWN);	
				blsmuldef.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[5]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[6]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[11]")).click();
				driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[5]")).click();
				
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele83=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t81=ele83.getText();
				System.out.println("Pop up title:"+ t81);
				SoftAssert s48= new SoftAssert();
				s48.assertEquals(ele83, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(BLS) with custom pick up and default destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					catch (Exception e) 
					{
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
				
				
		--------------------------------------------------------------------------------------------------------------		
				
				
	//Create service request with default pickup and default destination address with multi destination(CCT)
	@Test(priority=53)
	public void HiFillPatientInformationCCTDefaultMulti()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			String datetime2=Data_Acuity.getCellData(34, 4);
			String datetime3=Data_Acuity.getCellData(34, 5);
			String datetime4=Data_Acuity.getCellData(34, 6);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
		
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
			
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
	driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
	
	driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
	Thread.sleep(4000);
	Robot cctmuldef=new Robot();
	cctmuldef.keyPress(KeyEvent.VK_DOWN);	
	cctmuldef.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("searchId1")).sendKeys(desthi);
	Thread.sleep(4000);
	cctmuldef.keyPress(KeyEvent.VK_DOWN);	
	cctmuldef.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[3]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[5]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[2]")).click();
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	
	
	driver.findElement(By.id("searchId2")).sendKeys(desthi);
	Thread.sleep(4000);
	cctmuldef.keyPress(KeyEvent.VK_DOWN);	
	cctmuldef.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[3]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[4]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[7]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[3]")).click();
	
	driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("searchId3")).sendKeys(desthi);
	Thread.sleep(4000);
	cctmuldef.keyPress(KeyEvent.VK_DOWN);	
	cctmuldef.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[4]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[5]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[9]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[4]")).click();
	
	driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("searchId4")).sendKeys(desthi);
	Thread.sleep(4000);
	cctmuldef.keyPress(KeyEvent.VK_DOWN);	
	cctmuldef.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[5]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[6]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[11]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[5]")).click();
	
	driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
	
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
	WebElement ele84=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t82=ele84.getText();
	System.out.println("Pop up title:"+ t82);
	SoftAssert s49= new SoftAssert();
	s49.assertEquals(ele84, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(CCT) with custom pick up and default destination for multiple destination", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
				
				
--------------------------------------------------------------------------------------------------------------

	
	//Create service request with default pickup and default destination address with multi destination(WCT)
		@Test(priority=54)
		public void HiFillPatientInformationWCTDefaultMulti()
		{
			try
			{
				String firstname=Data_Acuity.getCellData(23, 1); 
				String lastname=Data_Acuity.getCellData(23, 2);
				String dob=Data_Acuity.getCellData(23, 3);
				String phno=Data_Acuity.getCellData(23, 4);
				String weight=Data_Acuity.getCellData(23, 5);
				String roomno=Data_Acuity.getCellData(23, 6);
				String desthi=Data_Acuity.getCellData(23, 7);
				String note=Data_Acuity.getCellData(23, 8);
				
				String destination=Data_Acuity.getCellData(29, 5);
				String deststreet=Data_Acuity.getCellData(29, 6);
				String zipdest=Data_Acuity.getCellData(29, 7);
				String datetime=Data_Acuity.getCellData(34, 2);
				String datetime1=Data_Acuity.getCellData(34, 3);
				String datetime2=Data_Acuity.getCellData(34, 4);
				String datetime3=Data_Acuity.getCellData(34, 5);
				String datetime4=Data_Acuity.getCellData(34, 6);
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
				driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
				
				
		driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
		driver.findElement(By.id("patientLastName")).sendKeys(lastname);
		driver.findElement(By.id("patientDob")).sendKeys(dob);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
		driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
		driver.findElement(By.id("patientWeight")).sendKeys(weight);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
		driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
		driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
		
		driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
		Thread.sleep(4000);
		Robot wct03=new Robot();
		wct03.keyPress(KeyEvent.VK_DOWN);	
		wct03.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
	    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
		
		driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
		driver.findElement(By.id("addAnotherDestBtn")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("searchId1")).sendKeys(desthi);
		Thread.sleep(4000);
		wct03.keyPress(KeyEvent.VK_DOWN);	
		wct03.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[3]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[5]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[2]")).click();
		
		driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
		driver.findElement(By.id("addAnotherDestBtn")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("searchId2")).sendKeys(desthi);
		Thread.sleep(4000);
		wct03.keyPress(KeyEvent.VK_DOWN);	
		wct03.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[4]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[7]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[3]")).click();
		
		driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
		driver.findElement(By.id("addAnotherDestBtn")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("searchId3")).sendKeys(desthi);
		Thread.sleep(4000);
		wct03.keyPress(KeyEvent.VK_DOWN);	
		wct03.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[5]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[9]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[4]")).click();
		
		driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
		driver.findElement(By.id("addAnotherDestBtn")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("searchId4")).sendKeys(desthi);
		Thread.sleep(4000);
		wct03.keyPress(KeyEvent.VK_DOWN);	
		wct03.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[5]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[6]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[11]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[5]")).click();
		
		driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
		
		driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
		Thread.sleep(3000);
		WebElement ele85=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
		String t83=ele85.getText();
		System.out.println("Pop up title:"+ t83);
		SoftAssert s49= new SoftAssert();
		s49.assertEquals(ele85, "Service request successfully created.");
		Reporter.log("Service request successfully created pop up is displayed(WCT) with custom pick up and default destination for multiple destination", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
		
			}
			catch (Exception e) 
			{
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
*/

//---------------------------------------------------------------------------------------------	
	
/*//Create service request with custom pickup and acuity link destination address(WCT)-one way
	@Test(priority=2)
	public void HiFillPatientInformationCCTCustomAndDefault()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
	
  Thread.sleep(3000);
    driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
	driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
    driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
	driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
	driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
	Robot wcttwo=new Robot();
	wcttwo.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
	Thread.sleep(4000);
	
	wcttwo.keyPress(KeyEvent.VK_DOWN);
	wcttwo.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("srDivId2")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele46=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t44=ele46.getText();
	System.out.println("Pop up title:"+ t44);
	SoftAssert s30= new SoftAssert();
	s30.assertEquals(ele46, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(WCT)using custom pick up and default destinaion", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}*/
	
	//------------------------------------------------------------------------------------------------------------------
	
	
	//To check whether service request is created for WCT with default pickup and custom destination
	/*@Test(priority=2)
	public void HiFillPatientInformationWCTDefaultAndCustom()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();

			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
			
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
	driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
	
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
	driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
	driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
	Robot wctone=new Robot();
	wctone.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	driver.findElement(By.id("srDivId2")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele49=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t47=ele49.getText();
	System.out.println("Pop up title:"+ t47);
	SoftAssert s33= new SoftAssert();
	s33.assertEquals(ele49, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(WCT) with default pick up and custom destination", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

*/

//---------------------------------------------------------------------------------------------------------------

	
	//To check whether service request is created for ALS with custom pick and destination(Round Trip)
		/*@Test(priority=2)
		public void HiFillPatientInformationALSRoundTrip()
		{
			try
			{
				String firstname=Data_Acuity.getCellData(23, 1); 
				String lastname=Data_Acuity.getCellData(23, 2);
				String dob=Data_Acuity.getCellData(23, 3);
				String phno=Data_Acuity.getCellData(23, 4);
				String weight=Data_Acuity.getCellData(23, 5);
				String roomno=Data_Acuity.getCellData(23, 6);
				String desthi=Data_Acuity.getCellData(23, 7);
				String note=Data_Acuity.getCellData(23, 8);
				
				String pickup=Data_Acuity.getCellData(29, 2);
				String streetaddress=Data_Acuity.getCellData(29, 3);
				String zip=Data_Acuity.getCellData(29, 4);
				String destination=Data_Acuity.getCellData(29, 5);
				String deststreet=Data_Acuity.getCellData(29, 6);
				String zipdest=Data_Acuity.getCellData(29, 7);
				String datetime=Data_Acuity.getCellData(34, 2);
				String datetime1=Data_Acuity.getCellData(34, 3);
				
				
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
				
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
				driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
				
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot alsround=new Robot();
				alsround.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				alsround.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
		
		driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
		
		SoftAssert s53= new SoftAssert();
		
		driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
		driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("note")).sendKeys(note);
		driver.findElement(By.id("srDivId3")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
		Thread.sleep(3000);
	    WebElement ele89=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
		String t87=ele89.getText();
		System.out.println("Pop up title:"+ t87);
		s53.assertEquals(ele89, "Service request successfully created.");
		Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and destination(Round trip)", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
		
			}
			catch (Exception e) 
			{
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			*/		
		
	//----------------------------------------------------------------------------------------------------	
		
		
	//To check whether service request is created for BLS with custom pick and destination(Round Trip)
/*	@Test(priority=2)
	public void HiFillPatientInformationBLSRoundTrip()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			
			
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
			
			driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
			driver.findElement(By.id("patientLastName")).sendKeys(lastname);
			driver.findElement(By.id("patientDob")).sendKeys(dob);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
			driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
			driver.findElement(By.id("patientWeight")).sendKeys(weight);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
			driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
			driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
			driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
			Robot blsround=new Robot();
			blsround.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
			driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
			driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
			driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
			driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
			blsround.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	
	SoftAssert s54= new SoftAssert();
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
    WebElement ele90=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t88=ele90.getText();
	System.out.println("Pop up title:"+ t88);
	s54.assertEquals(ele90, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(BLS) with custom pick up and destination(Round trip)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
		
		
	//-----------------------------------------------------------------------------------------------------	
		
		
		
	//To check whether service request is created for CCT with custom pick and destination(Round Trip)
		/*@Test(priority=2)
		public void HiFillPatientInformationCCTRoundTrip()
		{
			try
			{
				String firstname=Data_Acuity.getCellData(23, 1); 
				String lastname=Data_Acuity.getCellData(23, 2);
				String dob=Data_Acuity.getCellData(23, 3);
				String phno=Data_Acuity.getCellData(23, 4);
				String weight=Data_Acuity.getCellData(23, 5);
				String roomno=Data_Acuity.getCellData(23, 6);
				String desthi=Data_Acuity.getCellData(23, 7);
				String note=Data_Acuity.getCellData(23, 8);
				
				String pickup=Data_Acuity.getCellData(29, 2);
				String streetaddress=Data_Acuity.getCellData(29, 3);
				String zip=Data_Acuity.getCellData(29, 4);
				String destination=Data_Acuity.getCellData(29, 5);
				String deststreet=Data_Acuity.getCellData(29, 6);
				String zipdest=Data_Acuity.getCellData(29, 7);
				String datetime=Data_Acuity.getCellData(34, 2);
				String datetime1=Data_Acuity.getCellData(34, 3);
				
				
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
				
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot cctround=new Robot();
				cctround.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				cctround.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
		
		driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
		
		SoftAssert s55= new SoftAssert();
		
		driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
		driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("note")).sendKeys(note);
		driver.findElement(By.id("srDivId3")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
		Thread.sleep(3000);
	    WebElement ele91=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
		String t89=ele91.getText();
		System.out.println("Pop up title:"+ t89);
		s55.assertEquals(ele91, "Service request successfully created.");
		Reporter.log("Service request successfully created pop up is displayed(CCT) with custom pick up and destination(Round trip)", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
		
			}
			catch (Exception e) 
			{
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		
	//-----------------------------------------------------------------------------------------------------	
		
	//To check whether service request is created for WCT with custom pick and destination(Round Trip)
		/*@Test(priority=2)
		public void HiFillPatientInformationWCTRoundTrip()
		{
			try
			{
				String firstname=Data_Acuity.getCellData(23, 1); 
				String lastname=Data_Acuity.getCellData(23, 2);
				String dob=Data_Acuity.getCellData(23, 3);
				String phno=Data_Acuity.getCellData(23, 4);
				String weight=Data_Acuity.getCellData(23, 5);
				String roomno=Data_Acuity.getCellData(23, 6);
				String desthi=Data_Acuity.getCellData(23, 7);
				String note=Data_Acuity.getCellData(23, 8);
				
				String pickup=Data_Acuity.getCellData(29, 2);
				String streetaddress=Data_Acuity.getCellData(29, 3);
				String zip=Data_Acuity.getCellData(29, 4);
				String destination=Data_Acuity.getCellData(29, 5);
				String deststreet=Data_Acuity.getCellData(29, 6);
				String zipdest=Data_Acuity.getCellData(29, 7);
				String datetime=Data_Acuity.getCellData(34, 2);
				String datetime1=Data_Acuity.getCellData(34, 3);
				
				
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
				
				driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
				driver.findElement(By.id("patientLastName")).sendKeys(lastname);
				driver.findElement(By.id("patientDob")).sendKeys(dob);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
				driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
				driver.findElement(By.id("patientWeight")).sendKeys(weight);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
				driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
				driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
				driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
				Robot wctround1=new Robot();
				wctround1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
				driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
				driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
				wctround1.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
		
		driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
		
		SoftAssert s56= new SoftAssert();
		
		driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
		driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
		Thread.sleep(3000);
	    WebElement ele92=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
		String t90=ele92.getText();
		System.out.println("Pop up title:"+ t90);
		s56.assertEquals(ele92, "Service request successfully created.");
		Reporter.log("Service request successfully created pop up is displayed(WCT) with custom pick up and destination(Round trip)", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
		
			}
			catch (Exception e) 
			{
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	//-----------------------------------------------------------------------------------------------------------	
		
	//To check whether service request is created for ALS with default pick up and custom destination(Round Trip)	
	/*@Test(priority=2)
	public void HiFillPatientInformationALSRoundTripdefaultpickcustomdest()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String note=Data_Acuity.getCellData(23, 8);
			
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			
			
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
	driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
	
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
	driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
	driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
	Robot alsdc=new Robot();
	alsdc.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);

driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);

SoftAssert s57= new SoftAssert();

driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
Thread.sleep(3000);
driver.findElement(By.id("note")).sendKeys(note);
driver.findElement(By.id("srDivId3")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
Thread.sleep(3000);
WebElement ele93=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
String t91=ele93.getText();
System.out.println("Pop up title:"+ t91);
s57.assertEquals(ele93, "Service request successfully created.");
Reporter.log("Service request successfully created pop up is displayed(ALS) with default pick up and custom destination(Round trip)", true);
Thread.sleep(3000);
driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();

	}
	catch (Exception e) 
	{
		 //TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/
		
	
	//-------------------------------------------------------------------------------------------------
	
	//To check whether service request is created for BLS with default pick up and custom destination(Round Trip)
	/*@Test(priority=2)
	public void HiFillPatientInformationBLSRoundTripdefaultpickcustomdest()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String note=Data_Acuity.getCellData(23, 8);
			
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			
			
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
	driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
	
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
	driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
	driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
	Robot blsdc=new Robot();
	blsdc.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);

driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);

SoftAssert s58= new SoftAssert();

driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
Thread.sleep(3000);
driver.findElement(By.id("note")).sendKeys(note);
driver.findElement(By.id("srDivId3")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
Thread.sleep(3000);
WebElement ele94=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
String t92=ele94.getText();
System.out.println("Pop up title:"+ t92);
s58.assertEquals(ele94, "Service request successfully created.");
Reporter.log("Service request successfully created pop up is displayed(BLS) with default pick up and custom destination(Round trip)", true);
Thread.sleep(3000);
driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();

	}
	catch (Exception e) 
	{
		 //TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	*/
	
//---------------------------------------------------------------------------------------------------------	
	
	
	
	
	//To check whether service request is created for CCT with default pick up and custom destination(Round Trip)
		/*@Test(priority=2)
		public void HiFillPatientInformationCCTRoundTripdefaultpickcustomdest()
		{
			try
			{
				String firstname=Data_Acuity.getCellData(23, 1); 
				String lastname=Data_Acuity.getCellData(23, 2);
				String dob=Data_Acuity.getCellData(23, 3);
				String phno=Data_Acuity.getCellData(23, 4);
				String weight=Data_Acuity.getCellData(23, 5);
				String roomno=Data_Acuity.getCellData(23, 6);
				String note=Data_Acuity.getCellData(23, 8);
				
				String destination=Data_Acuity.getCellData(29, 5);
				String deststreet=Data_Acuity.getCellData(29, 6);
				String zipdest=Data_Acuity.getCellData(29, 7);
				String datetime=Data_Acuity.getCellData(34, 2);
				String datetime1=Data_Acuity.getCellData(34, 3);
				
				
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
				
		driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
		driver.findElement(By.id("patientLastName")).sendKeys(lastname);
		driver.findElement(By.id("patientDob")).sendKeys(dob);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
		driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
		driver.findElement(By.id("patientWeight")).sendKeys(weight);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
		driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
		driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
		
		driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
		driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
		driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
		driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
		driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
		Robot cctdc=new Robot();
		cctdc.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);

	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);

	SoftAssert s59= new SoftAssert();

	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
	WebElement ele95=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t93=ele95.getText();
	System.out.println("Pop up title:"+ t93);
	s59.assertEquals(ele95, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(CCT) with default pick up and custom destination(Round trip)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();

		}
		catch (Exception e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
		
//------------------------------------------------------------------------------------------------------------
	
	
	
	
	//To check whether service request is created for WCT with default pick up and custom destination(Round Trip)
			/*@Test(priority=2)
			public void HiFillPatientInformationWCTRoundTripdefaultpickcustomdest()
			{
				try
				{
					String firstname=Data_Acuity.getCellData(23, 1); 
					String lastname=Data_Acuity.getCellData(23, 2);
					String dob=Data_Acuity.getCellData(23, 3);
					String phno=Data_Acuity.getCellData(23, 4);
					String weight=Data_Acuity.getCellData(23, 5);
					String roomno=Data_Acuity.getCellData(23, 6);
					String note=Data_Acuity.getCellData(23, 8);
					
					String destination=Data_Acuity.getCellData(29, 5);
					String deststreet=Data_Acuity.getCellData(29, 6);
					String zipdest=Data_Acuity.getCellData(29, 7);
					String datetime=Data_Acuity.getCellData(34, 2);
					String datetime1=Data_Acuity.getCellData(34, 3);
					
					
					driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
					driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
					driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
					driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
					driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
					driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
					
					driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
					
			driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
			driver.findElement(By.id("patientLastName")).sendKeys(lastname);
			driver.findElement(By.id("patientDob")).sendKeys(dob);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
			driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
			driver.findElement(By.id("patientWeight")).sendKeys(weight);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
			driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
			driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
			driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
			driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
			
			driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
			driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
			driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
			driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
			driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
			Robot wctdc=new Robot();
			wctdc.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);

		driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);

		SoftAssert s60= new SoftAssert();

		driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
		driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
		Thread.sleep(3000);
		WebElement ele96=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
		String t94=ele96.getText();
		System.out.println("Pop up title:"+ t94);
		s60.assertEquals(ele96, "Service request successfully created.");
		Reporter.log("Service request successfully created pop up is displayed(WCT) with default pick up and custom destination(Round trip)", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();

			}
			catch (Exception e) 
			{
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	//To check whether service request is created for ALS with custom pick up and default destination(Round Trip)
	/*@Test(priority=2)
	public void HiFillPatientInformationALSRoundcustompickdefaultdest()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			
			
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
			
			driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
			driver.findElement(By.id("patientLastName")).sendKeys(lastname);
			driver.findElement(By.id("patientDob")).sendKeys(dob);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
			driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
			driver.findElement(By.id("patientWeight")).sendKeys(weight);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
			driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
			driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
			driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
			Robot cctround=new Robot();
			cctround.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(3000);
	
			driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
			Thread.sleep(4000);
			Robot alscd=new Robot();
			alscd.keyPress(KeyEvent.VK_DOWN);	
			alscd.keyPress(KeyEvent.VK_ENTER);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();

		    driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
			driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
			driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
			driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
			Thread.sleep(3000);
			
			
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
			driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
			
			
			SoftAssert s61= new SoftAssert();
			
			driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
			driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("note")).sendKeys(note);
			driver.findElement(By.id("srDivId3")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
			Thread.sleep(3000);
		    WebElement ele97=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
			String t95=ele97.getText();
			System.out.println("Pop up title:"+ t95);
			s61.assertEquals(ele97, "Service request successfully created.");
			Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and default destination", true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
			
				}
				catch (Exception e) 
				{
					 //TODO Auto-generated catch block
					e.printStackTrace();
				}
			} */
	
	
	//----------------------------------------------------------------------------------------------
	
	
	//To check whether service request is created for BLS with custom pick up and default destination(Round Trip)
	/*@Test(priority=2)
	public void HiFillPatientInformationBLSRoundcustompickdefaultdest()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			
			
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
			
			driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
			driver.findElement(By.id("patientLastName")).sendKeys(lastname);
			driver.findElement(By.id("patientDob")).sendKeys(dob);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
			driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
			driver.findElement(By.id("patientWeight")).sendKeys(weight);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
			driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
			driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
			driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
			Robot blscd=new Robot();
			blscd.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(3000);
	
			driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
			Thread.sleep(4000);
			blscd.keyPress(KeyEvent.VK_DOWN);	
			blscd.keyPress(KeyEvent.VK_ENTER);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();

		    driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
			driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
			driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
			driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
			Thread.sleep(3000);
			
			
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
			driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
			
			
			SoftAssert s62= new SoftAssert();
			
			driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
			driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("note")).sendKeys(note);
			driver.findElement(By.id("srDivId3")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
			Thread.sleep(3000);
		    WebElement ele98=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
			String t96=ele98.getText();
			System.out.println("Pop up title:"+ t96);
			s62.assertEquals(ele98, "Service request successfully created.");
			Reporter.log("Service request successfully created pop up is displayed(BLS) with custom pick up and default destination", true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
			
				}
				catch (Exception e) 
				{
					 //TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
	*/
	
	
	//---------------------------------------------------------------------------------
	
	
	//To check whether service request is created for CCT with custom pick up and default destination(Round Trip)
	/*@Test(priority=2)
	public void HiFillPatientInformationCCTRoundcustompickdefaultdest()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			
			
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
			
			driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
			driver.findElement(By.id("patientLastName")).sendKeys(lastname);
			driver.findElement(By.id("patientDob")).sendKeys(dob);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
			driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
			driver.findElement(By.id("patientWeight")).sendKeys(weight);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
			driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
			driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
			driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
			Robot cctcd=new Robot();
			cctcd.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(3000);
	
			driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
			Thread.sleep(4000);
			cctcd.keyPress(KeyEvent.VK_DOWN);	
			cctcd.keyPress(KeyEvent.VK_ENTER);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();

		    driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
			driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
			driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
			driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
			Thread.sleep(3000);
			
			
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
			driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
			
			
			SoftAssert s63= new SoftAssert();
			
			driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
			driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("note")).sendKeys(note);
			driver.findElement(By.id("srDivId3")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
			Thread.sleep(3000);
		    WebElement ele99=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
			String t97=ele99.getText();
			System.out.println("Pop up title:"+ t97);
			s63.assertEquals(ele99, "Service request successfully created.");
			Reporter.log("Service request successfully created pop up is displayed(CCT) with custom pick up and default destination", true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
			
				}
				catch (Exception e) 
				{
					 //TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
	
	//----------------------------------------------------------------------------------------------------
	
	
	//To check whether service request is created for WCT with custom pick up and default destination(Round Trip)
	@Test(priority=2)
	public void HiFillPatientInformationWCTRoundcustompickdefaultdest()
	{
		try
		{
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			
			
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
			
			driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
			driver.findElement(By.id("patientLastName")).sendKeys(lastname);
			driver.findElement(By.id("patientDob")).sendKeys(dob);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
			driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
			driver.findElement(By.id("patientWeight")).sendKeys(weight);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
			driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
			driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
			driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
			Robot wctcd=new Robot();
			wctcd.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(3000);
	
			driver.findElement(By.xpath("(//input[@class='form-control aq-inp ui-autocomplete-input'])[2]")).sendKeys(desthi);
			Thread.sleep(4000);
			wctcd.keyPress(KeyEvent.VK_DOWN);	
			wctcd.keyPress(KeyEvent.VK_ENTER);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();

		    driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
			driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
			driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
			driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
			Thread.sleep(3000);
			
			
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
			driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
			
			
			SoftAssert s64= new SoftAssert();
			
			driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
			driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
			Thread.sleep(3000);
		    WebElement ele100=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
			String t98=ele100.getText();
			System.out.println("Pop up title:"+ t98);
			s64.assertEquals(ele100, "Service request successfully created.");
			Reporter.log("Service request successfully created pop up is displayed(WCT) with custom pick up and default destination", true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
			
				}
				catch (Exception e) 
				{
					 //TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
				
				
				
/*	//logout
	driver.findElement(By.xpath("//img[contains(@src,'avatar.png')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[contains(@class,'linkProf')]/a[2]")).click();
			
		
		
	@AfterTest
	

	
}
}*/