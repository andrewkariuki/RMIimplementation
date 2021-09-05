package com.example.toyenginermi;

import com.example.toyenginermi.UserHelpers.User;
import com.example.toyenginermi.UserHelpers.UserModel;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class LoginUser implements ITask<Boolean>{
	private static final String _EMAIL = "andrew4kariuki@gmail.com";
	private static final String _PASSWORD = "Andrew32@33334";
	
	public Boolean userLogin(String email, String password) {
		UserModel userModel = new UserModel();
		User user = userModel.selectByEmail(email);
		
		if(user == null){
			System.out.println("No user with that email");
			return false;
		}
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	@Override
	public Boolean execute() throws SQLException {
		return userLogin(_EMAIL, _PASSWORD);
	}
}
