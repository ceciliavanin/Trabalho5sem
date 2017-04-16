package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.table.AbstractTableModel;
import client.Client;

public class ResultadoModel extends AbstractTableModel{


	private Object[][] matrix;

	public ResultadoModel(Map<Client, List<Arquivo>> dados) {

		int tempCli = 0;
		for (Entry<Client, List<Arquivo>> e : dados.entrySet()) {
			if (e.getValue() != null) {
				tempCli += e.getValue().size();
			}
		}

		matrix = new Object[tempCli][4];
		
		List<Client> list = new ArrayList<>(dados.keySet());
		
		list.sort((o1, o2) -> o1.getNomeCli().compareTo(o2.getNomeCli()));
		
		int cont = 0;
		for (Client cli : list) {
			for (Arquivo arq : dados.get(cli)) {
				matrix[cont][0] = cli.getIdCli();
				matrix[cont][1] = cli.getNomeCli();
				matrix[cont][2] = arq.getId();
				matrix[cont][3] = arq.getNomeArq();
				cont++;
			}
		}
	}

	@Override
	public int getRowCount() {
		return matrix[0].length;
	}

	@Override
	public int getColumnCount() {
		return matrix.length;
		
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return matrix[arg0][arg1];
	}
	
	public Arquivo getMeuItem(int row) {
		Arquivo arq = new Arquivo();
		arq.setId(row);
		return arq;
	}

}
