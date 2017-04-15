package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.IServer;

public class ConexClient {

	public ConexClient() throws RemoteException, NotBoundException {
		super();
	};
	public String conectar(Client cliente) {
		Registry registry;
		String retorno;
		try {
			registry = LocateRegistry.getRegistry(cliente.getIpCli(), cliente.getPortaCli());
			IServer servico = (IServer) registry.lookup(IServer.NOME_SERVICO);
			retorno = cliente.getNomeCli() + " se conectou!";
		} catch (RemoteException | NotBoundException e) {
			retorno = "Não foi possível realizar conexão.";
			e.printStackTrace();
		}
		return retorno;			
	};

}
