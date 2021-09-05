package com.example.toyenginermi;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUser implements ITask<Boolean>{
	private static final String _EMAIL = "andrew4kariuki@gmail.com";
	private static final String _PASSWORD = "Andrew32@33334";
	
	public Boolean userLogin(String email, String password) throws SQLException {
		return true;
	}
	
	@Override
	public Boolean execute() throws SQLException {
		return userLogin(_EMAIL, _PASSWORD);
	}
}
