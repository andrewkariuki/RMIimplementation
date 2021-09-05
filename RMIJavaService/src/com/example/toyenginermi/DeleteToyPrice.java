package com.example.toyenginermi;

import com.example.toyenginermi.ToyHelpers.ToyModel;

public class DeleteToyPrice implements ITask<Boolean> {
	
	public Boolean deleteToyPrice(int id){
		ToyModel toyModel = new ToyModel();
		return toyModel.delete(id);
	}
	
	@Override
	public Boolean execute(){
		return deleteToyPrice(3);
	}
}
