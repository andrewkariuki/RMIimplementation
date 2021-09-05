package com.example.toyenginermi;

import com.example.toyenginermi.ToyHelpers.Toy;
import com.example.toyenginermi.ToyHelpers.ToyModel;

public class UpdateToyPrice implements ITask<Boolean>{
	
	public Boolean updateToyPrice(double price, int id){
		ToyModel toyModel = new ToyModel();
		Toy toy = new Toy();
		toy.setPrice(price);
		return toyModel.updatePrice(toy, id);
	}
	
	@Override
	public Boolean execute()  {
		return updateToyPrice(3.99, 2);
	}
}
