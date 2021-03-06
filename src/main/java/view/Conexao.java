package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import client.Client;
import client.ConexClient;
import server.IServer;
import server.ImpServer;
import common.Arquivo;
import common.ResultadoModel;
import common.TiposDeFiltro;
import javax.swing.JTable;

public class Conexao extends JFrame {

	private JPanel contentPane;
	private JTextField nomeUsu;
	private JTextField ipConex;
	private JTextField porta;
	private JLabel lblPesquisarPor;
	private JComboBox selecao;
	private JPanel panel;
	private JButton btnConectar;
	private JButton btnDesconectar;
	private JTextField pchave;
	private JButton btnPesquisar;
	private JButton btnLimpar;
	private JScrollPane scrollPane;
	private JButton btnDownload;
	private JTextField textField_4;
	private JScrollPane scrollPane_1;
	private JTable table;
	private Boolean conect = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conexao frame = new Conexao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conexao() throws RemoteException {

		final Client cliente = new Client();
		final IServer servidor = new ImpServer();
		final Arquivo arq = new Arquivo();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 96, 134, 168, -55, 0 };
		gbl_contentPane.rowHeights = new int[] { 115, 43, 147, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 111, 121, 40, 89, 111, 106, 0 };
		gbl_panel.rowHeights = new int[] { 23, 20, 20, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		final JButton btnIniciaServidor = new JButton("Inicia Servidor");
		btnIniciaServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					servidor.registrarCliente(cliente);
					porta.setEnabled(false);
					ipConex.setEnabled(false);
					selecao.setEnabled(false);
					pchave.setEnabled(false);
					nomeUsu.setEnabled(false);
					btnConectar.setEnabled(false);
					btnLimpar.setEnabled(false);
					btnPesquisar.setEnabled(false);
					btnDownload.setEnabled(false);
				} catch (RemoteException e3) {
					e3.printStackTrace();
				}

			}
		});
		GridBagConstraints gbc_btnIniciaServidor = new GridBagConstraints();
		gbc_btnIniciaServidor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIniciaServidor.insets = new Insets(0, 0, 5, 5);
		gbc_btnIniciaServidor.gridwidth = 6;
		gbc_btnIniciaServidor.gridx = 0;
		gbc_btnIniciaServidor.gridy = 0;
		panel.add(btnIniciaServidor, gbc_btnIniciaServidor);

		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		panel.add(lblNome, gbc_lblNome);

		nomeUsu = new JTextField();
		GridBagConstraints gbc_nomeUsu = new GridBagConstraints();
		gbc_nomeUsu.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeUsu.insets = new Insets(0, 0, 5, 0);
		gbc_nomeUsu.gridwidth = 5;
		gbc_nomeUsu.gridx = 1;
		gbc_nomeUsu.gridy = 1;
		panel.add(nomeUsu, gbc_nomeUsu);
		nomeUsu.setColumns(10);

		JLabel lblIp = new JLabel("IP:");
		GridBagConstraints gbc_lblIp = new GridBagConstraints();
		gbc_lblIp.anchor = GridBagConstraints.EAST;
		gbc_lblIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIp.gridx = 0;
		gbc_lblIp.gridy = 2;
		panel.add(lblIp, gbc_lblIp);

		ipConex = new JTextField();
		GridBagConstraints gbc_ipConex = new GridBagConstraints();
		gbc_ipConex.fill = GridBagConstraints.HORIZONTAL;
		gbc_ipConex.insets = new Insets(0, 0, 5, 5);
		gbc_ipConex.gridx = 1;
		gbc_ipConex.gridy = 2;
		panel.add(ipConex, gbc_ipConex);
		ipConex.setColumns(10);

		JLabel lblPorta = new JLabel("Porta:");
		GridBagConstraints gbc_lblPorta = new GridBagConstraints();
		gbc_lblPorta.anchor = GridBagConstraints.EAST;
		gbc_lblPorta.insets = new Insets(0, 0, 5, 5);
		gbc_lblPorta.gridx = 2;
		gbc_lblPorta.gridy = 2;
		panel.add(lblPorta, gbc_lblPorta);

		porta = new JTextField();
		GridBagConstraints gbc_porta = new GridBagConstraints();
		gbc_porta.fill = GridBagConstraints.HORIZONTAL;
		gbc_porta.insets = new Insets(0, 0, 5, 5);
		gbc_porta.gridx = 3;
		gbc_porta.gridy = 2;
		panel.add(porta, gbc_porta);
		porta.setColumns(10);

		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnIniciaServidor.setEnabled(false);
				
				try {
					ConexClient cli = new ConexClient();
					cliente.setIpCli(ipConex.getText());
					cliente.setPortaCli(Integer.parseInt(porta.getText()));
					cliente.setNomeCli(nomeUsu.getText());
					
					cli.conectar(cliente);
				} catch (RemoteException | NotBoundException e1) {
					e1.printStackTrace();
				}
			}

		});
		GridBagConstraints gbc_btnConectar = new GridBagConstraints();
		gbc_btnConectar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConectar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConectar.gridx = 4;
		gbc_btnConectar.gridy = 2;
		panel.add(btnConectar, gbc_btnConectar);

		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					servidor.desconectar(cliente);
					porta.setEnabled(true);
					ipConex.setEnabled(true);
					selecao.setEnabled(true);
					pchave.setEnabled(true);
					nomeUsu.setEnabled(true);
					btnConectar.setEnabled(true);
					btnLimpar.setEnabled(true);
					btnPesquisar.setEnabled(true);
					btnDownload.setEnabled(true);
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnDesconectar = new GridBagConstraints();
		gbc_btnDesconectar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDesconectar.insets = new Insets(0, 0, 5, 0);
		gbc_btnDesconectar.gridx = 5;
		gbc_btnDesconectar.gridy = 2;
		panel.add(btnDesconectar, gbc_btnDesconectar);

		lblPesquisarPor = new JLabel("Pesquisar por:");
		GridBagConstraints gbc_lblPesquisarPor = new GridBagConstraints();
		gbc_lblPesquisarPor.anchor = GridBagConstraints.EAST;
		gbc_lblPesquisarPor.insets = new Insets(0, 0, 0, 5);
		gbc_lblPesquisarPor.gridx = 0;
		gbc_lblPesquisarPor.gridy = 3;
		panel.add(lblPesquisarPor, gbc_lblPesquisarPor);

		selecao = new JComboBox();
		GridBagConstraints gbc_selecao = new GridBagConstraints();
		gbc_selecao.fill = GridBagConstraints.HORIZONTAL;
		gbc_selecao.insets = new Insets(0, 0, 0, 5);
		gbc_selecao.gridx = 1;
		gbc_selecao.gridy = 3;
		panel.add(selecao, gbc_selecao);
		selecao.setModel(new DefaultComboBoxModel(TiposDeFiltro.values()));

		pchave = new JTextField();
		GridBagConstraints gbc_pchave = new GridBagConstraints();
		gbc_pchave.fill = GridBagConstraints.HORIZONTAL;
		gbc_pchave.gridwidth = 2;
		gbc_pchave.insets = new Insets(0, 0, 0, 5);
		gbc_pchave.gridx = 2;
		gbc_pchave.gridy = 3;
		panel.add(pchave, gbc_pchave);
		pchave.setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		GridBagConstraints gbc_btnPesquisar = new GridBagConstraints();
		gbc_btnPesquisar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPesquisar.insets = new Insets(0, 0, 0, 5);
		gbc_btnPesquisar.gridx = 4;
		gbc_btnPesquisar.gridy = 3;
		panel.add(btnPesquisar, gbc_btnPesquisar);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					servidor.procurarArquivo(pchave.getText(), (TiposDeFiltro) selecao.getSelectedItem());
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null, "Algo de errado n�o est� certo!");
					e1.printStackTrace();
				}
			}
		});

		btnLimpar = new JButton("Limpar");
		GridBagConstraints gbc_btnLimpar = new GridBagConstraints();
		gbc_btnLimpar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLimpar.gridx = 5;
		gbc_btnLimpar.gridy = 3;
		panel.add(btnLimpar, gbc_btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				pchave.setText("");

			}
		});

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);

		scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Cliente", "Arquivo" }) {
			boolean[] columnEditables = new boolean[] { true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		scrollPane_1.setViewportView(table);

		btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client cli = new Client();
				Arquivo arq = new Arquivo();
				try {
					servidor.baixarArquivo(cli, arq);
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null, "Erro!");
					e1.printStackTrace();
				}
			}
		});

		GridBagConstraints gbc_btnDownload = new GridBagConstraints();
		gbc_btnDownload.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDownload.insets = new Insets(0, 0, 5, 0);
		gbc_btnDownload.gridx = 3;
		gbc_btnDownload.gridy = 3;
		contentPane.add(btnDownload, gbc_btnDownload);

		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridheight = 2;
		gbc_textField_4.gridwidth = 4;
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 0;
		gbc_textField_4.gridy = 4;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
	}

	public void TelaMostraArquivos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carregar();
			}
		});
		contentPane.add(btnCarregar, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		carregar();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() >= 2) {
					mostraSelecionadoTabela();
				}
			}
		});
	}

	protected void mostraSelecionadoTabela() {
		int linhaSelecionada = table.getSelectedRow();
		if (linhaSelecionada < 0) {
		} else {
			int row = table.convertRowIndexToModel(linhaSelecionada);
			Arquivo arq = ((ResultadoModel) table.getModel()).getMeuItem(row);

		}
	}

	protected void carregar() {
		Map<Client, List<Arquivo>> dados = gerarDados();

		ResultadoModel modelo = new ResultadoModel(dados);

		table.setModel(modelo);

	}

	private Map<Client, List<Arquivo>> gerarDados() {

		Map<Client, List<Arquivo>> dados = new HashMap<>();

		for (int cliente = 1; cliente <= 100; cliente++) {

			Client cli = new Client();
			cli.setIdCli(cliente);
			cli.setNomeCli("Cliente " + cliente);

			List<Arquivo> lista = new ArrayList<>();
			for (int a = 1; a <= 100; a++) {
				Arquivo arq = new Arquivo();
				arq.setId(1);
				arq.setNomeArq("Arquivo " + a);

				lista.add(arq);
			}

			dados.put(cli, lista);
		}
		return dados;
	}

	private void publicaDadosTabela(Map<Client, List<Arquivo>> dados) {
		DefaultTableModel dtm = new DefaultTableModel(new Object[] { "Host", "Ip", "Port", "Arq", "Size" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		if (!dados.isEmpty()) {
			for (Entry<Client, List<Arquivo>> item : dados.entrySet()) {
				for (int i = 0; i < item.getValue().size(); i++) {
					dtm.addRow(new Object[] { item.getKey(), item.getKey().getIpCli(), item.getKey().getPortaCli(),
							item.getValue().get(i).getNomeArq(), item.getValue().get(i).getTamanhoArq() });
				}
			}
		}

		table.setModel(dtm);
	}


}