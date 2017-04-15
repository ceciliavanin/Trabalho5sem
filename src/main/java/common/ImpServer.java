package common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.Client;
import search.Listas;


public class ImpServer extends UnicastRemoteObject implements IServer {

	public ImpServer() throws RemoteException {
		super();
	}

	public void registrarCliente(Client c) throws RemoteException {

		ImpServer servidor = new ImpServer();

		IServer servico;

		try {
			servico = (IServer) UnicastRemoteObject.exportObject(servidor, 0);
			Registry registry = LocateRegistry.createRegistry(1818);
			registry.rebind(servico.NOME_SERVICO, servico);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void publicarListaArquivos(Client c, List<Arquivo> lista) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public Map<Client, List<Arquivo>> procurarArquivo(String query, TiposDeFiltro tipoFiltro, String filtro)
			throws RemoteException {
		List<String> resultado = new ArrayList<>();
		
		Pattern pat = Pattern.compile(".*" + query + ".*");
		
		for (String nome : Listas.DADOS) {
			Matcher m = pat.matcher(nome.toLowerCase());
			if (m.matches()) {
				resultado.add(nome);
			}
		}
		
		for (String res : resultado) {
			System.out.println(res);
		}
		return null;
	}

	public byte[] baixarArquivo(Client cli, Arquivo arq) throws RemoteException {
		Path path = Paths.get(arq.getPath());
		try {
			byte[] dados = Files.readAllBytes(path);
			return dados;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void desconectar(Client c) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
