package common;
import java.rmi.Remote;
import java.rmi.RemoteException;

import client.BuscaSimples;

public interface ServerRMI extends Remote {


	public static final String SERVICO = "SERVICO_RMI";


	public String apresentacao(String nome) throws RemoteException;


	public String executar(BuscaSimples ts);

}
