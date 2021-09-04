package com.example.toyenginermi;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateUser implements ITask<Integer> {
	
	private static final String _NAME = "Andrew Kariuki";
	private static final String _EMAIL = "andrew4kariuki@gmail.com";
	private static final String _PASSWORD = "Andrew32@33334";
	
	public Integer registerUser(String name, String email, String password ) throws SQLException {
		final String query = "INSERT INTO user(name, email, password) VALUES(?,?,?)";
		
		String encryptedPass = encryptPassword(password);
		
		Helpers helpers = new Helpers();
		ResultSet user = helpers.emailExits(email);
		
		if(user.next()) {
			System.out.println("User ith the email " + email + " already exists:");
			return 0;
		};
		
		PreparedStatement preparedStatement =
				DBConn.getConnection().prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, encryptedPass);
		
		System.out.println("User registration successful");
		
		return preparedStatement.executeUpdate();
	}
	
	
	
	public String encryptPassword(String password){
		return org.mindrot.jbcrypt.BCrypt.hashpw(password, org.mindrot.jbcrypt.BCrypt.gensalt());
//		return BCrypt.withDefaults().hashToString(12, password.toCharArray());
	}
	
	@Override
	public Integer execute() throws RemoteException, SQLException {
		return registerUser(_NAME, _EMAIL, _PASSWORD);
	}
}
