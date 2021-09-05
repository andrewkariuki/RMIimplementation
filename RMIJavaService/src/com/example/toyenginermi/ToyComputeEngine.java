package com.example.toyenginermi;

import com.example.toyenginermi.ToyHelpers.Toy;
import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;

import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

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
			
			loginUserTask();
			
			System.out.println(Constants._SERVER + Constants.SERVER_PORT);
		}catch (IOException | LipeRMIException | SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public <T> T executeTask(ITask<T> t) throws SQLException, RemoteException {
		return t.execute();
	}
	
	public void getAllToys() throws SQLException, RemoteException {
	 	List<Toy> toys = new CalToyCost().execute();
		for(Toy t : toys) {
			System.out.println(t.getId()+", "+t.getName()+", "+t.getPrice()+", "+t.getQuantity());
		}
	}
	
	public void addToyPriceTask() throws SQLException {
		new AddToyPrice().execute();
	}
	
	public void deleteToyPriceTask() throws RemoteException {
		new DeleteToyPrice().execute();
	}
	
	public void updateToyPriceTask() throws RemoteException {
		new UpdateToyPrice().execute();
	}
	
	public void  registerUserTask() throws SQLException, RemoteException {
		new CreateUser().execute();
	}
	
	public void loginUserTask() throws SQLException {
		new LoginUser().execute();
	}
}
