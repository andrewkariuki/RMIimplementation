package com.example.toyenginermi;

import java.rmi.RemoteException;
import java.sql.SQLException;

public interface ITask<T> {
	T execute() throws RemoteException, SQLException;
}
