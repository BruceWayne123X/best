package user.controller;
import java.util.Scanner;

import user.dao.UserCrud;
import user.dto.User;
public class UserMain  {/* Inside class Main User Data will
be collected here
*/
	static Scanner sc=new Scanner(System.in);/*Creating the object of
	Scanner for asking input from the user*/
	static UserCrud uc=new UserCrud();/* This is DAO - This layer
	will be involved in connection with database*/
	static int n;
  public static void main(String[] args) {
	  
	try {  
	do {
		System.out.println(" 😈😈😈 Welcome to USER4.0 World 😈😈😈 ");
		System.out.println("Enter your choice\n 1.Registration\n 2.Login\n"
				+" 3.Exit");
		int key=sc.nextInt();
		switch (key) {
		case 1:
			System.out.println(">>>>Registration<<<<");
			registration();
			break;
		case 2:
			System.out.println(">>>Welcome to Login Page<<<");
			login();
            break;
//		default:
//			System.out.println("Exit");
//			System.out.println("😊😊😊Thankyou😊😊😊\n Visit Again");
//			break;
		}
		n=key;//1
	} while (n!=3);
	System.out.println("Exit");
	System.out.println("😊😊😊Thankyou😊😊😊\n Visit Again");
	sc.close();
	} catch (Exception e) {
		System.out.println("Re Enter your data");
		//main(null);
		registration();
	}
	
}
private static void login() {
   System.out.println("Enter your Phone number");
   long phNo=sc.nextLong();
   System.out.println("Enter your password");
   String password=sc.next();
   User user=new User(phNo,password);
   try {
	int res=uc.loginData(user);
	if (res>0) {
		do {
			System.out.println(">>>Thanks for login<<<\n You can perform"+
		"operations\n Press 1 for fetching\n Press 2 for update\n"+
					" Press 3 for delete \n Press 4 for logout");
			int key=sc.nextInt();
			switch (key) {
			case 1:
				System.out.println("Fetch");
				uc.fetch(user);
				break;
			case 2:
				System.out.println("Update");
				try {
				uc.update(user);
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Delete");
				uc.delete(user);
				break;
			
			default:
				System.out.println("You are logout from the login page");
//				main(null);
				break;
			}
			n=key;
		}while(n!=4);
		
	} else {
		System.out.println("Login Unsuccessful");
         login();
	}
} catch (Exception e) {
	System.out.println("Invalid data format\n Please re-enter your data");
	login();
}
	
}

private static void registration() {
	int id;
	String name=null,email=null,password=null,dob=null,qual=null;
	long phNo=565576l;
	try {
    System.out.println("Set your id.....");
      id=sc.nextInt(); 

    System.out.println("Set your user name....");
     name=sc.next();
    System.out.println("Enter your email address");
     email=sc.next();
    System.out.println("Enter your phoneNo in numbers only");
     phNo=sc.nextLong();
    System.out.println("Set your password");
     password=sc.next();
    System.out.println("Enter your D.O.B in 'yyyy-mm-dd' only");
     dob=sc.next();
    System.out.println("Enter your maximum qualification");
     qual=sc.next();
	
    User user=new User(id,name,email,phNo,password,dob,qual);
    try {
		uc.saveData(user);
	} catch (Exception e) {
		System.out.println(" May be you have entered wrong date format \n"
				+"re-enter your data from begining");
		
	//	UserMain.registration();
	}
}
	catch (Exception e) {
		System.out.println("Invalid Data Format \nRe-enter your data\n"
				+"date format- 'yyyy-mm-dd' \n id format- number\n"+
				" PhoneNo format-Number");
		//registration();
	}
	
}

}	


