package com.example.toyenginermi;

import org.mindrot.jbcrypt.BCrypt;

import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUser implements ITask<Boolean>{
	private static final String _EMAIL = "andrew4kariuki@gmail.com";
	private static final String _PASSWORD = "Andrew32@33334";
	
	public Boolean userLogin(String email, String password) throws SQLException {
		Helpers helpers = new Helpers();
		ResultSet user = helpers.emailExits(email);
		
		if(!user.next()) {
			System.out.println("Incorrect email");
			return false;
		}
		
		String hashedPassword = "";
		
		while (user.next()){
			hashedPassword = user.getString("password");
		}
		
		if (!BCrypt.checkpw(password, hashedPassword)){
			System.out.println("Incorrect email or password try again");
			return false;
		}
		
		return true
	}
	
	@Override
	public Boolean execute() throws RemoteException, SQLException {
		return userLogin(_EMAIL, _PASSWORD);
	}
}
