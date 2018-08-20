package Logins;

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
	
 
}
}
