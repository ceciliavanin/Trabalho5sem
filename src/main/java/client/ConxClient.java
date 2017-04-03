package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import server.Server;

public class ConxClient extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txfIp;
	private JTextField txfPorta;
	private JButton buttonDesconectar;
	private JButton buttonConectar;
	private JLabel lblNome;
	private JTextField txfMeuNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConxClient frame = new ConxClient();
					frame.setVisible(true);
					frame.configurar();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConxClient() {
		setTitle("Conectar Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 105);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 75, 65, 30, 38, 66, 96, 109, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		panel_1.add(lblNome, gbc_lblNome);

		txfMeuNome = new JTextField();
		GridBagConstraints gbc_txfMeuNome = new GridBagConstraints();
		gbc_txfMeuNome.gridwidth = 5;
		gbc_txfMeuNome.insets = new Insets(0, 0, 5, 5);
		gbc_txfMeuNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfMeuNome.gridx = 1;
		gbc_txfMeuNome.gridy = 0;
		panel_1.add(txfMeuNome, gbc_txfMeuNome);
		txfMeuNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Endereço IP:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		txfIp = new JTextField();
		txfIp.setText("127.0.0.1");
		GridBagConstraints gbc_txfIp = new GridBagConstraints();
		gbc_txfIp.gridwidth = 2;
		gbc_txfIp.insets = new Insets(0, 0, 0, 5);
		gbc_txfIp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfIp.gridx = 1;
		gbc_txfIp.gridy = 1;
		panel_1.add(txfIp, gbc_txfIp);
		txfIp.setColumns(10);
		
				JLabel lblNewLabel_1 = new JLabel("Porta:");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel_1.gridx = 3;
				gbc_lblNewLabel_1.gridy = 1;
				panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txfPorta = new JTextField();
		txfPorta.setText("1818");
		GridBagConstraints gbc_txfPorta = new GridBagConstraints();
		gbc_txfPorta.insets = new Insets(0, 0, 0, 5);
		gbc_txfPorta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfPorta.gridx = 4;
		gbc_txfPorta.gridy = 1;
		panel_1.add(txfPorta, gbc_txfPorta);
		txfPorta.setColumns(10);

		buttonConectar = new JButton("Conectar");
		GridBagConstraints gbc_buttonConectar = new GridBagConstraints();
		gbc_buttonConectar.insets = new Insets(0, 0, 0, 5);
		gbc_buttonConectar.gridx = 5;
		gbc_buttonConectar.gridy = 1;
		panel_1.add(buttonConectar, gbc_buttonConectar);

		buttonDesconectar = new JButton("Desconectar");
		GridBagConstraints gbc_buttonDesconectar = new GridBagConstraints();
		gbc_buttonDesconectar.anchor = GridBagConstraints.WEST;
		gbc_buttonDesconectar.gridx = 6;
		gbc_buttonDesconectar.gridy = 1;
		panel_1.add(buttonDesconectar, gbc_buttonDesconectar);
	}



	private SimpleDateFormat datefor = new SimpleDateFormat("dd/MM/yyyy H:mm:ss:SSS");


	private Server servidor;


	private Client cliente;

	private Registry registry;

	private String meunome;


	public void configurarAuto(String string, int i) {

		configurar();
		txfMeuNome.setText(string);
		int x = 0;
		int y = 0 + (i * 240);
		setBounds(x, y, 640, 240);
		
	}

	
	protected void configurar() {

		buttonConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conectar();
			}
		});

		buttonDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desconectar();
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				desconectar();
			}
		});
	}


	protected void conectar() {

		meunome = txfMeuNome.getText().trim();
		if (meunome.length() == 0) {
			JOptionPane.showMessageDialog(this, "Favor, digite um nome.");
			return;
		}

		String host = txfIp.getText().trim();
		if (!host.matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}")) {
			JOptionPane.showMessageDialog(this, "O endereço é inválido, favor digite novamente.");
			return;
		}

		String strPorta = txfPorta.getText().trim();
		if (!strPorta.matches("[0-9]+") || strPorta.length() > 5) {
			JOptionPane.showMessageDialog(this, "A porta deve ter um valor numérico de 5 dígitos.");
			return;
		}
		int intPorta = Integer.parseInt(strPorta);


		try {
			registry = LocateRegistry.getRegistry(host, intPorta);

			servidor = (Server) registry.lookup(Server.SERVICO);
			setCliente((Client) UnicastRemoteObject.exportObject((Remote) this, 0));

			buttonDesconectar.setEnabled(true);

			buttonConectar.setEnabled(false);
			txfMeuNome.setEnabled(false);
			txfIp.setEnabled(false);
			txfPorta.setEnabled(false);

			buttonConectar.setEnabled(false);

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Desconecta do servidor.
	 */
	protected void desconectar() {
		try {

			if (servidor != null) {
				String nome = null;
				servidor.apresentacao(nome);
				UnicastRemoteObject.unexportObject((Remote) this, true);

				servidor = null;
			}

			buttonDesconectar.setEnabled(false);

			buttonConectar.setEnabled(true);
			txfMeuNome.setEnabled(true);
			txfIp.setEnabled(true);
			txfPorta.setEnabled(true);

			buttonConectar.setEnabled(true);

			registry = null;
			servidor = null;

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public SimpleDateFormat getDatefor() {
		return datefor;
	}

	public void setDatefor(SimpleDateFormat datefor) {
		this.datefor = datefor;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}
	

}
