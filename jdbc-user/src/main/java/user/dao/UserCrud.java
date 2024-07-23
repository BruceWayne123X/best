//private int id;
//	private String name;
//	String email; 
//	long phNo; 
//	String password; 
//	String dob; 
//	String qual;
package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.jdbc.Driver;

import user.dto.User;

public class UserCrud {
	static int n=0;
	static Scanner sc=new Scanner(System.in);
public void saveData(User user) throws SQLException {
	DriverManager.registerDriver(new Driver());
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root & password=Dhruvjain20@sql");
	java.sql.PreparedStatement cs=con.prepareStatement("insert into userdata values(?,?,?,?,?,?,?);");
	
	cs.setInt(1,user.getId());
	cs.setString(2,user.getName());
	cs.setString(3,user.getEmail());
	cs.setLong(4,user.getPhNo());
	cs.setString(5,user.getPassword());
	cs.setString(6,user.getDob());
	cs.setString(7,user.getQual());
	int data=cs.executeUpdate();
    if (data>0) {
		System.out.println("rows inserted="+data);
		System.out.println("Registration Successful");
	} else {
        System.out.println("data not inserted");
	}
}
    public int loginData(User user) throws SQLException {
    	DriverManager.registerDriver(new Driver());
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root & password=Dhruvjain20@sql");
    	java.sql.PreparedStatement cs=con.prepareStatement("select * from user.userdata where phone=? and password=?;");
        cs.setLong(1,user.getPhNo());
    	cs.setString(2,user.getPassword());
    	ResultSet res = cs.executeQuery();
    	int c=0;
    	while (res.next()) {
		  System.out.println("login of Mr."+res.getString(2)+" is successful");
		  c++;
		}
    	return c;
    }
	public void fetch(User user) throws SQLException {
		DriverManager.registerDriver(new Driver());
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root & password=Dhruvjain20@sql");
    	java.sql.PreparedStatement cs=con.prepareStatement("select * from user.userdata where phone=? and password=?;");
    	cs.setLong(1, user.getPhNo());
    	cs.setString(2,user.getPassword());
    	ResultSet res = cs.executeQuery();
    	while (res.next()) {
			System.out.print(res.getInt(1)+" ");
			System.out.print(res.getString(2)+" ");
			System.out.print(res.getString(3)+" ");
			System.out.print(res.getLong(4)+" ");
			System.out.print(res.getString(5)+" ");
			System.out.print(res.getString(6)+" ");
			System.out.print(res.getString(7)+" ");
			
		}
	}
	public void update(User user) throws SQLException {
		DriverManager.registerDriver(new Driver());
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root & password=Dhruvjain20@sql");
    
    	System.out.println("What do you want to update\n Press 1 to"
    			+" update id\n Press 2 to update name\n Press 3 to update email\n"
    			+" Press 4 to update phNo\n Press 5 to update Password/n"
    			+" Press 6 to update dob\n Press 7 to update Qualification");
    	do {
			int key=sc.nextInt();
			switch (key) {
			case 1:
				System.out.println("Enter your new id");
				user.setId(sc.nextInt());
				PreparedStatement ps1=con.prepareStatement("update user.userData set id=? where phone=? and password=?");
				ps1.setInt(1, user.getId());
				ps1.setLong(2, user.getPhNo());
				ps1.setString(3, user.getPassword());
				int c1=ps1.executeUpdate();
				System.out.println(c1+" row updated");
				break;
			case 2:
				System.out.println("Enter your new user name");
				user.setName(sc.next());
				PreparedStatement ps2=con.prepareStatement("update user.userData set name=? where phone=? and password=?");
				ps2.setString(1, user.getName());
				ps2.setLong(2, user.getPhNo());
				ps2.setString(3, user.getPassword());
				int c2=ps2.executeUpdate();
				System.out.println(c2+" row updated");
				break;
			case 3:
				System.out.println("Enter your new email");
				user.setEmail(sc.next());
				PreparedStatement ps3=con.prepareStatement("update user.userData set email =? where phone=? and password=?");
				ps3.setString(1, user.getEmail());
				ps3.setLong(2, user.getPhNo());
				ps3.setString(3, user.getPassword());
				int c3=ps3.executeUpdate();
				System.out.println(c3+" row updated");
				break;
			case 4:
				System.out.println("Enter your new password ");
				user.setPhNo(sc.nextLong());
				PreparedStatement ps4=con.prepareStatement("update user.userData set phNo=? where phone=? and password=? ");
				ps4.setLong(1, user.getPhNo());
				ps4.setLong(2, user.getPhNo());
				ps4.setString(3, user.getPassword());
				int c4=ps4.executeUpdate();
				System.out.println(c4+" row updated");
				break;
			case 5:
				System.out.println("Enter your new Password");
				user.setPassword(sc.next());
				PreparedStatement ps5=con.prepareStatement("update user.userData set password=? where phone=? and password=? ");
				ps5.setString(1, user.getPassword());
				ps5.setLong(2, user.getPhNo());
				ps5.setString(3, user.getPassword());
				int c5=ps5.executeUpdate();
				System.out.println(c5+" row updated");
				break;
			case 6:
				System.out.println("Enter new dob");
				user.setDob(sc.next());
				PreparedStatement ps6=con.prepareStatement("update user.userData set d.o.b=? where phone=? and password=?");
				ps6.setString(1, user.getDob());
				ps6.setLong(2, user.getPhNo());
				ps6.setString(3, user.getPassword());
				int c6=ps6.executeUpdate();
				System.out.println(c6+" row updated");
				break;
			case 7:
				System.out.println("Enter new Qualification");
				user.setQual(sc.next());
				PreparedStatement ps7=con.prepareStatement("update user.userData set Qualification=? where phone=? and password=?");
				ps7.setString(1, user.getQual());
				ps7.setLong(2, user.getPhNo());
				ps7.setString(3, user.getPassword());
				int c7=ps7.executeUpdate();
				System.out.println(c7+" row updated");
				break;
			
			}
			 n=key;
		} while (n>7);
    	
		
	}
	public void delete(User user) throws SQLException {
		DriverManager.registerDriver(new Driver());
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root & password=Dhruvjain20@sql");
    	java.sql.PreparedStatement ps=con.prepareStatement("delete from user.userdata where phone=? and password=?;");
    	ps.setLong(1, user.getPhNo());
    	ps.setString(2,user.getPassword());
    	int count=ps.executeUpdate();
    	System.out.println(count+" account deleted");
	}
}

