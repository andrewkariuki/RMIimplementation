package com.example.toyenginermi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface IRMI extends Remote {
	<T> T executeTask(ITask<T> t) throws SQLException, RemoteException;
}
