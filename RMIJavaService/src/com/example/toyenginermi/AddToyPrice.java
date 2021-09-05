package com.example.toyenginermi;


import com.example.toyenginermi.ToyHelpers.Toy;
import com.example.toyenginermi.ToyHelpers.ToyModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddToyPrice implements ITask<Boolean> {
	final String toyName = "Toy This that";
	final double toyPrice = 12.33;
	final int toyQuantity = 12;
	
	public Boolean addToyPrice(String toyName, double toyPrice, int toyQuantity) {
		ToyModel toyModel = new ToyModel();
		Toy toy = new Toy(toyName, toyPrice, toyQuantity);
		return toyModel.insert(toy);
	}
	
	@Override
	public Boolean execute() throws SQLException {
		return addToyPrice(toyName, toyPrice,toyQuantity);
	}
}
