package com.example.toyenginermi.ToyHelpers;

import java.sql.SQLException;
import java.util.List;

public interface IToy {
	
	void createToyTable();
	
	Boolean insert(Toy toy);
	
	Toy selectById(int id) throws SQLException;
	
	List<Toy> selectAll();
	
	Boolean delete(int id);
	
	Boolean update(Toy toy,int id);
	
	Boolean updatePrice(Toy toy, int id);
}
