package Logins;

import HI_TestCases.ASP_Page;
import Registration.ASP_reg;

public class Main_class 
{
 public static void main(String args[]) throws Exception
 {
	/* ASP_login asp= new ASP_login();
	 asp.asp();*/
	 HI_login hi= new HI_login();
	 hi.HiLogin();
	 
	 ASP_Page asp=new ASP_Page();
	 asp.VerifyAspPage();
	
	/*Acuity_admin_login admin= new Acuity_admin_login();
	admin.acuity();
	*/
	
	/* HI_reg hireg=new HI_reg();
	 hireg.hireg();
	 
	 //ASP_reg aspreg= new ASP_reg();
	// aspreg.aspreg();
	 */
	
 
}
}
