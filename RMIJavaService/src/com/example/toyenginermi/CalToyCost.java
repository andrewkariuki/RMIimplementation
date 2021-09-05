package com.example.toyenginermi;

import com.example.toyenginermi.ToyHelpers.Toy;
import com.example.toyenginermi.ToyHelpers.ToyModel;

import java.util.List;

public class CalToyCost implements ITask<List<Toy>> {
	
	public List<Toy> callToyCost(){
		ToyModel toyModel = new ToyModel();
		return toyModel.selectAll();
	}
	
	@Override
	public List<Toy> execute()  {
		return callToyCost();
	}
}
