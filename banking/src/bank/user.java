package banking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
public class user {
	private Scanner sc;
	private Connection con;
	public user(Scanner sc,Connection con) {
		this.sc=sc;
		this.con=con;
	}
public void registration() {
	System.out.println("full name");
	String full_name= sc.nextLine();
	System.out.println("email");
	String email= sc.nextLine();
	System.out.println("password");
	String password= sc.nextLine();
	String Query="INSERT INTO user(full_name,email,password) VALUES(?,?,?)";
	try {
	PreparedStatement preparedStatement=con.prepareStatement(Query);	
	preparedStatement.setString(1, full_name);
	preparedStatement.setString(2, email);
	preparedStatement.setString(3, password);
	int affectedRows= preparedStatement.executeUpdate();
	if(affectedRows>0) {
		System.out.println("registration succesfull");
	}
	else {
		
		System.out.println("registration failed");                                                                 
	}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
 public String login() {
	 System.out.println("email");
	 String email=sc.nextLine();
	 System.out.println("password");
	 String password =sc.nextLine();
	 String login_query="Select*FROM User WHERE email =? AND password=?";
	 try {
		 PreparedStatement preparedStatement= con.prepareStatement(login_query);
		 preparedStatement.setString(1, email);
		 preparedStatement.setString(2, password);
		 ResultSet preparedStatement= PrepareStatement;


	 }
 }
}
