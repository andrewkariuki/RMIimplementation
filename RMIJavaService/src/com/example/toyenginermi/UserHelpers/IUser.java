package com.example.toyenginermi.UserHelpers;


import java.sql.SQLException;
import java.util.List;

public interface IUser {
	void createUserTable();
	
	Boolean insert(User user);
	
	User selectById(int id) throws SQLException;
	
	List<User> selectAll();
	
	Boolean delete(int id);
	
	Boolean update(User user,int id);
	
	User selectByEmail(String Email);
}
