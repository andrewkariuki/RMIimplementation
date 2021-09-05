package com.example.toyenginermi;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class CalculateCost implements ITask<Double>{
	
	public Double calculateCost (double price, int items){
		return price * items;
	}
	
	@Override
	public Double execute() throws RemoteException, SQLException {
		return calculateCost(3.3, 3);
	}
}
