package banking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class user {
	private Scanner scanner;
	private Connection connection;
	public user(Scanner scanner,Connection connection) {
		this.scanner=scanner;
		this.connection=connection;
	}
public void registration() {
	System.out.println("full name");
	String full_name= scanner.next();
	System.out.println("email");
	String email= scanner.next();
	System.out.println("password");
	String password= scanner.next();
	if(user_exist(email)) {
		System.out.println("user already exists for this email ");
		return;
	}
	String Query="INSERT INTO user(full_name,email,password) VALUES(?,?,?)";
	try {
	PreparedStatement preparedStatement=connection.prepareStatement(Query);	
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



public boolean user_exist(String email) {
	String query="Select*FROM User WHERE email =? ";
	 try {
		 PreparedStatement preparedStatement= connection.prepareStatement(query);
		 preparedStatement.setString(1, email);
		
		 ResultSet resultSet =preparedStatement.executeQuery();
if(resultSet.next()) {
	return true;
}
else {
	return false;
}

	 }
	 catch(SQLException e) {
		 e.printStackTrace();
	 }

	return false;
}
public String login() {
	 System.out.println("email");
	 String email=scanner.next();
	 System.out.println("password");
	 String password =scanner.next();
	 String login_query="Select*FROM user WHERE email =? AND password=?";
	 try {
		 PreparedStatement preparedStatement= connection.prepareStatement(login_query);
		 preparedStatement.setString(1, email);
		 preparedStatement.setString(2, password);
		 ResultSet resultSet =preparedStatement.executeQuery();
if(resultSet.next()) {
	return email;
}
else {
	return null;
}

	 }
	 catch(SQLException e) {
		 e.printStackTrace();
	 }

return null;
}}
