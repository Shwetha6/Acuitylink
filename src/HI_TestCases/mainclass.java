package HI_TestCases;

public class mainclass 
{
	
	public static void main(String args[]) throws Exception
	{
		
	HI_Login hi=new HI_Login();
	hi.hiLogin();
	
	ASP_Page asp=new ASP_Page();
	asp.VerifyAspPage();
	
	HI_Logout log=new HI_Logout();
	log.logout();
	
	}
}
