package com.example.toyenginermi.ToyHelpers;

import com.example.toyenginermi.DBConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class ToyModel implements IToy{
	@Override
	public void createToyTable() {
	
	}
	
	@Override
	public Boolean insert(Toy toy) {
		try {
			final String query = "INSERT INTO toy(name, price, quantity) VALUES(?,?,?)";
			PreparedStatement preparedStatement =
					DBConn.getConnection().prepareStatement(query);
			preparedStatement.setString(1, toy.getName());
			preparedStatement.setDouble(2, toy.getPrice());
			preparedStatement.setInt(3, toy.getQuantity());
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return true;
	}
	
	@Override
	public Toy selectById(int id)   {
		Toy toy = new Toy();
		try {
			final String query = "SELECT * FROM toy WHERE id = ?";
			PreparedStatement preparedStatement =
					DBConn.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				toy.setId(resultSet.getInt("id"));
				toy.setName(resultSet.getString("name"));
				toy.setPrice(resultSet.getDouble("price"));
				toy.setQuantity(resultSet.getInt("quantity"));
			}
			return null;
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return toy;
	}
	
	@Override
	public List<Toy> selectAll() {
		List<Toy> toys = new ArrayList<>();
		
		try {
			final String query = "SELECT * FROM toy";
			PreparedStatement preparedStatement =
					DBConn.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Toy toy = new Toy();
				toy.setId(resultSet.getInt("id"));
				toy.setName(resultSet.getString("name"));
				toy.setPrice(resultSet.getDouble("price"));
				toy.setQuantity(resultSet.getInt("quantity"));
				
				toys.add(toy);
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return toys;
	}
	
	@Override
	public Boolean delete(int id) {
		try {
			final String query = "DELETE FROM toy WHERE id = ?";
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
	public Boolean update(Toy toy, int id) {
		try {
		final String query = "UPDATE toy SET name = ?, price = ?, quantity = ? WHERE id = ?";
		PreparedStatement preparedStatement =
					DBConn.getConnection().prepareStatement(query);
		preparedStatement.setString(1, toy.getName());
		preparedStatement.setDouble(2, toy.getPrice());
		preparedStatement.setInt(3, toy.getQuantity());
		preparedStatement.setInt(4, id);
		preparedStatement.executeUpdate();
		
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return true;
	}
	
	@Override
	public Boolean updatePrice(Toy toy, int id) {
		try {
			final String query = "UPDATE toy SET price = ? WHERE id = ?";
			PreparedStatement preparedStatement =
					DBConn.getConnection().prepareStatement(query);
			preparedStatement.setDouble(1, toy.getPrice());
			preparedStatement.setDouble(2, id);
			preparedStatement.executeUpdate();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return true;
	}
}
