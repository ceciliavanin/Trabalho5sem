package server;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

import client.BuscaSimples;
import common.ServerRMI;

public class Server extends Thread implements Runnable, ServerRMI {

	private static final int PORTA_TCPIP = 1818;

	private SimpleDateFormat datafor = new SimpleDateFormat("'[Servidor] 'dd/MM/yyyy H:mm:ss:SSS' -> '");

	@Override
	public void run() {

		apresentaConsole("Iniciando o servidor.");

		ServerRMI servico;
		try {

			servico = (ServerRMI) UnicastRemoteObject.exportObject(Server.this, 0);

			Registry registry = null;
			registry.rebind(ServerRMI.SERVICO, servico);

			apresentaConsole("Aguardando conexão...");

		} catch (Exception e) {

		System.err.println("ERRO: Verifique se a aplicação está ativa, ou então se a porta está disponível.\n");
		e.printStackTrace();
	}
	}

	public String apresentacao(String nome) throws RemoteException {
		apresentaConsole("Cliente " + nome + " se conectou.");
		return "Conexão Ok.";
	}

	private void apresentaConsole(String string) {
		System.out.println(datafor.format(new Date()) + string);
	}

	public static void main(String[] args) {
		new Server().start();
	}

	public void sair(String meunome) {
		// TODO Auto-generated method stub
		
	}

	public void enviarMensagem(String meunome, String destinatario, String mensagemPrivada) {
		// TODO Auto-generated method stub
		
	}

	public void enviarMensagemPublica(String meunome, String mensagem) {
		// TODO Auto-generated method stub
		
	}

	public String executar(BuscaSimples ts) {
		// TODO Auto-generated method stub
		return null;
	}
}
