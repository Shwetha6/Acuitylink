package Logins;

import Registration.ASP_reg;
import Registration.HI_reg;

public class Main_class 
{
 public static void main(String args[]) throws InterruptedException
 {
	 ASP_login asp= new ASP_login();
	 asp.asp();
	 HI_login hi= new HI_login();
	 hi.hilogin();
	
	Acuity_admin_login admin= new Acuity_admin_login();
	admin.acuity();
	
	 HI_reg hireg=new HI_reg();
	 hireg.hireg();
	 
	 ASP_reg aspreg= new ASP_reg();
	 aspreg.aspreg();
	 
	
 
}
}
