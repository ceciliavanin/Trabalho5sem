package server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteObject;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import client.Client;
import common.Arquivo;
import common.Listas;
import common.MD5;
import common.TiposDeFiltro;

public class ImpServer extends RemoteObject implements IServer {

	private static final String PASTA_DOWNLOAD = "C:/share";
	private int PORTA_TCPIP;
	Map<Client, List<Arquivo>> padraoMap = new HashMap<>();

	public ImpServer() throws RemoteException {
		super();
	}

	public void registrarCliente(Client c) throws RemoteException {
		//
		ImpServer servidor = new ImpServer();

		IServer servico;

		try {
			servico = (IServer) UnicastRemoteObject.exportObject(this, 0);
			Registry registry = LocateRegistry.createRegistry(1818);
			registry.rebind(servico.NOME_SERVICO, servico);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void publicarListaArquivos(final Client c, final List<Arquivo> lista) throws RemoteException {
		if (padraoMap.containsKey(c)) {
			padraoMap.entrySet().forEach(map -> {
				if (map.getKey().equals(c)) {
					map.setValue(lista);
				}
			});

		} else {
		}
	}

	public Map<Client, List<Arquivo>> procurarArquivo(String query, TiposDeFiltro tipoFiltro)
			throws RemoteException {
		Map<Client, List<Arquivo>> resultadoMap = new HashMap<>();
		Map<Client, List<Arquivo>> padraoMap = new HashMap<>();

		File file = new File(PASTA_DOWNLOAD);
		
		File[] listFiles = file.listFiles();
		
		
		padraoMap.forEach((k, value) -> {
			List<Arquivo> list = new ArrayList<>();

			value.forEach(v -> {
				if (TiposDeFiltro.NOME.equals(tipoFiltro)) {
					if (v.getNomeArq().toLowerCase().contains(query.toLowerCase())) {
						list.add(v);
					}
				} else if (TiposDeFiltro.EXTENSAO.equals(tipoFiltro)) {
					if (v.getExtArq().toLowerCase().contains(query.toLowerCase())) {
						if (v.getNomeArq().toLowerCase().contains(query.toLowerCase())) {
							list.add(v);
						}
					}
				} else if (TiposDeFiltro.TAMANHO_MAX.equals(tipoFiltro)) {
					if (v.getTamanhoArq() >= Integer.valueOf(query)) {
						if (v.getNomeArq().toLowerCase().contains(query.toLowerCase())) {
							list.add(v);
						}
					}
				} else if (TiposDeFiltro.TAMANHO_MAX.equals(tipoFiltro)) {
					if (v.getTamanhoArq() <= Integer.valueOf(query)) {
						if (v.getNomeArq().toLowerCase().contains(query.toLowerCase())) {
							list.add(v);
						}
					}
				}
			});
			resultadoMap.put(k, list);
		});
		return resultadoMap;
	}

	public byte[] baixarArquivo(Client cli, Arquivo arq) throws RemoteException {

		Path path = Paths.get(arq.getPath());
		Arquivo arquivo = new Arquivo();
		
		try {
			byte[] dados = Files.readAllBytes(path);
			if (dados == null) {
				System.out.println("Veio nulo");
			} else {
				String bytesBaixado = MD5.getMD5Checksum(arq.getPath());
				if (arq.getMd5().equals(bytesBaixado)) {
					FileOutputStream fos = new FileOutputStream(arquivo.getNomeArq());
					fos.write(dados);
					fos.close();
					
					JOptionPane.showMessageDialog(null, "Arquivo baixado com sucesso!");
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Arquivo corrompido!");
					
				}
			}
			return dados;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void desconectar(Client c) throws RemoteException {

		if (padraoMap.containsKey(c)) {
			padraoMap.remove(c);

		} else {

		}
	}

}

