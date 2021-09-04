package com.example.toyenginermi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Helpers {
	public ResultSet emailExits(String email) throws SQLException {
		final String query = "SELECT * FROM user WHERE email = ?";
		PreparedStatement preparedStatement =
				DBConn.getConnection().prepareStatement(query);
		
		preparedStatement.setString(1, email);
		return preparedStatement.executeQuery();
	}
}
