package com.example.toyenginermi;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddToyPrice implements ITask<Integer> {
	final String toyName = "Toy";
	final double toyPrice = 12.33;
	final int toyQuantity = 12;
	
	public Integer addToyPrice(String toyName, double toyPrice, int toyQuantity)
			throws SQLException {
		final String query = "INSERT INTO toy(name, price, quantity) VALUES(?,?,?)";
		PreparedStatement preparedStatement =
				DBConn.getConnection().prepareStatement(query);
		preparedStatement.setString(1, toyName);
		preparedStatement.setDouble(2, toyPrice);
		preparedStatement.setInt(3, toyQuantity);
		return preparedStatement.executeUpdate();
	}
	
	@Override
	public Integer execute() throws SQLException {
		return addToyPrice(toyName, toyPrice,toyQuantity);
	}
}
