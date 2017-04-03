package client;
// teste teste teste

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.ServerRMI;

public class Client {

	public static void main(String[] args) {

		Registry registry;
		try {
			registry = LocateRegistry.getRegistry("192.168.103.174", 1818);
			ServerRMI servico = (ServerRMI) registry.lookup(ServerRMI.SERVICO);

			BuscaSimples ts = new BuscaSimples();
			System.out.println("Vou mandar para o servidor");

			String retorno = servico.executar(ts);

			System.out.println("Retorno do servidor: " + retorno);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
