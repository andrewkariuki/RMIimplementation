package com.example.toyenginermi;

import com.example.toyenginermi.UserHelpers.User;
import com.example.toyenginermi.UserHelpers.UserModel;

import java.sql.SQLException;

public class CreateUser implements ITask<Boolean> {
	
	private static final String _NAME = "Andrew Kariuki";
	private static final String _EMAIL = "andrew6kariuki@gmail.com";
	private static final String _PASSWORD = "Andrew32@33334";
	
	public Boolean registerUser(String name, String email, String password ) throws SQLException {
		
		UserModel userModel = new UserModel();
		User user = new User(name, email, password);
		return userModel.insert(user);
	}
	
	@Override
	public Boolean execute() throws SQLException {
		return registerUser(_NAME, _EMAIL, _PASSWORD);
	}
}
