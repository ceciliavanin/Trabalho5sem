package common;

import java.util.List;
import java.util.Map;

import client.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {

	public static final String NOME_SERVICO = "JShare";

	/**
	 * Recebe informações de um novo cliente.
	 * 
	 * @param c
	 * @throws RemoteException
	 */
	public void registrarCliente(Client c) throws RemoteException;

	/**
	 * Recebe a lista de arquivos disponíveis no cliente.
	 * 
	 * @param c
	 * @param lista
	 * @throws RemoteException
	 */
	public void publicarListaArquivos(Client c, List<Arquivo> lista) throws RemoteException;

	/**
	 * Usado quando um cliente deseja procurar um arquivo pelo nome, o servidor
	 * lê todos os arquivos publicados e retorna uma mapa contendo os
	 * resultados em cada cliente.
	 * 
	 * @param nome
	 * @return
	 * @throws RemoteException
	 */
	public Map<Client, List<Arquivo>> procurarArquivo(String query, TiposDeFiltro tipoFiltro, String filtro)
			throws RemoteException;

	/**
	 * Recebe informações do arquivo e retorna o arquivo em formato de array
	 * de bytes.
	 * 
	 * @param arq
	 * @return
	 * @throws RemoteException
	 */
	public byte[] baixarArquivo(Client cli, Arquivo arq) throws RemoteException;

	/**
	 * Desconecta o cliente, tornando também indisponível seus arquivos para
	 * as buscas.
	 * 
	 * @param c
	 * @throws RemoteException
	 */
	public void desconectar(Client c) throws RemoteException;

}
