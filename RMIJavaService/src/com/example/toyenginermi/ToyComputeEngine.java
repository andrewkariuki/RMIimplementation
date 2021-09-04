package com.example.toyenginermi;

import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;

import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ToyComputeEngine extends UnicastRemoteObject implements IRMI {
	public ToyComputeEngine() throws RemoteException {
		super();
		
		try{
			CallHandler callHandler = new CallHandler();
			callHandler.registerGlobal(IRMI.class, this);
			Server server = new Server();
			
			server.bind(Constants.SERVER_PORT, callHandler);
			server.addServerListener(new IServerListener() {
				@Override
				public void clientConnected(Socket socket) {
					System.out.println(Constants._CLIENT + socket.getInetAddress());
				}
				
				@Override
				public void clientDisconnected(Socket socket) {
					System.out.println(Constants.CLIENT_ + socket.getInetAddress());
				}
			});
			
			System.out.println(Constants._SERVER + Constants.SERVER_PORT);
		}catch (IOException | LipeRMIException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public <T> T executeTask(ITask<T> t) throws SQLException, RemoteException {
		return t.execute();
	}
}
