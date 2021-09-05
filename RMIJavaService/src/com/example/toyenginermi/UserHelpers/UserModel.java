package com.example.toyenginermi.UserHelpers;

import com.example.toyenginermi.DBConn;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel implements IUser {
	
	@Override
	public void createUserTable() {
	
	}
	
	@Override
	public Boolean insert(User user) {
		try {
			final String query = "INSERT INTO user(name, email, password) VALUES(?,?,?)";
			String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
			
			PreparedStatement preparedStatement =
					DBConn.getConnection().prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, hashedPassword);
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return true;
	}
	
	@Override
	public User selectById(int id) {
		User user = new User();
		try {
			final String query = "SELECT * FROM user WHERE id = ?";
			PreparedStatement preparedStatement =
					DBConn.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public List<User> selectAll() {
		List<User> users = new ArrayList<>();
		try {
			final String query = "SELECT * FROM user";
			PreparedStatement preparedStatement =
					DBConn.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				
				users.add(user);
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public Boolean delete(int id) {
		try {
			final String query = "DELETE FROM user WHERE id = ?";
			PreparedStatement preparedStatement =
					DBConn.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public Boolean update(User user, int id) {
		try {
			final String query = "UPDATE user SET name = ?, email = ?, password = ? WHERE id = ?";
			String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
			
			PreparedStatement preparedStatement =
					DBConn.getConnection().prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, hashedPassword);
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return true;
	}
	
	@Override
	public User selectByEmail(String Email) {
		User user = new User();
		try {
			final String query = "SELECT * FROM user WHERE email = ?";
			PreparedStatement preparedStatement =
					DBConn.getConnection().prepareStatement(query);
			preparedStatement.setString(1, Email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
}
