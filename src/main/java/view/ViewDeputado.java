package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DeputadoDAO;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelo.Deputado;

public class ViewDeputado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Deputado deputado;

	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfUri;
	private JTextField tfNome;
	private JTextField tfLegIni;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField tfLegFin;
	private JLabel lblNewLabel_5;
	private JTextField tfNomeCivil;
	private JLabel lblSiglasexo;
	private JTextField tfDataNasc;
	private JTextField tfDataFalec;
	private JTextField tfMuni;
	private JLabel lblCpf;
	private JTextField tfCpf;
	private JComboBox<String> cbSexo;
	private JComboBox<String> cbUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDeputado frame = new ViewDeputado();
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
	public ViewDeputado() {
		setTitle("Gerenciar Deputados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 583, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 567, 381);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(24, 54, 99, 14);
		panel.add(lblNewLabel);

		tfID = new JTextField();
		tfID.setBounds(133, 47, 45, 20);
		panel.add(tfID);
		tfID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("URI");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(24, 90, 99, 14);
		panel.add(lblNewLabel_1);

		tfUri = new JTextField();
		tfUri.setColumns(10);
		tfUri.setBounds(133, 87, 383, 20);
		panel.add(tfUri);

		JLabel lblNewLabel_2 = new JLabel("nome");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(24, 126, 99, 14);
		panel.add(lblNewLabel_2);

		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(133, 123, 121, 20);
		panel.add(tfNome);

		tfLegIni = new JTextField();
		tfLegIni.setColumns(10);
		tfLegIni.setBounds(133, 165, 121, 20);
		panel.add(tfLegIni);

		lblNewLabel_3 = new JLabel("Legislatura Inicial");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(24, 168, 99, 14);
		panel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Legislatura Final");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(264, 168, 112, 14);
		panel.add(lblNewLabel_4);

		tfLegFin = new JTextField();
		tfLegFin.setColumns(10);
		tfLegFin.setBounds(390, 165, 126, 20);
		panel.add(tfLegFin);

		lblNewLabel_5 = new JLabel("Nome Civil");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(264, 126, 112, 14);
		panel.add(lblNewLabel_5);

		tfNomeCivil = new JTextField();
		tfNomeCivil.setColumns(10);
		tfNomeCivil.setBounds(390, 123, 126, 20);
		panel.add(tfNomeCivil);

		lblSiglasexo = new JLabel("Sexo");
		lblSiglasexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSiglasexo.setForeground(Color.WHITE);
		lblSiglasexo.setBounds(385, 50, 40, 14);
		panel.add(lblSiglasexo);

		cbSexo = new JComboBox<String>();
		cbSexo.setModel(new DefaultComboBoxModel<String>(new String[] { "M", "F" }));
		cbSexo.setBounds(435, 46, 81, 22);
		panel.add(cbSexo);

		JLabel lblNewLabel_6 = new JLabel("Data Nascimento");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(24, 207, 99, 14);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("Data Falecimento");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setBounds(264, 207, 112, 14);
		panel.add(lblNewLabel_6_1);

		tfDataNasc = new JTextField();
		tfDataNasc.setColumns(10);
		tfDataNasc.setBounds(133, 204, 121, 20);
		panel.add(tfDataNasc);

		tfDataFalec = new JTextField();
		tfDataFalec.setColumns(10);
		tfDataFalec.setBounds(390, 204, 126, 20);
		panel.add(tfDataFalec);

		JLabel lblNewLabel_7 = new JLabel("UF Nascimento");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(24, 243, 99, 14);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Município Nascimento");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(199, 243, 149, 14);
		panel.add(lblNewLabel_8);

		tfMuni = new JTextField();
		tfMuni.setColumns(10);
		tfMuni.setBounds(358, 240, 158, 20);
		panel.add(tfMuni);

		cbUf = new JComboBox<String>();
		cbUf.setModel(new DefaultComboBoxModel<String>(
				new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbUf.setBounds(133, 239, 56, 22);
		panel.add(cbUf);

		JButton btUp = new JButton("Atualizar");
		btUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dadosDep();

				DeputadoDAO dao = new DeputadoDAO();
				dao.setup();
				dao.update(deputado);
				dao.exit();

			}
		});
		btUp.setBounds(283, 287, 233, 23);
		panel.add(btUp);

		JButton btAdd = new JButton("Adicionar");
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dadosDep();

				DeputadoDAO dao = new DeputadoDAO();
				dao.setup();
				dao.create(deputado);
				dao.exit();

			}
		});
		btAdd.setBounds(24, 287, 249, 23);
		panel.add(btAdd);

		JButton btRead = new JButton("Buscar");
		btRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeputadoDAO dao = new DeputadoDAO();
				dao.setup();
				deputado = dao.read(Integer.parseInt(tfID.getText()));
				dao.exit();
				if (deputado != null) {
					infDep();
				} else {
					JOptionPane.showMessageDialog(null, "Deputado não encontrado!");
				}

			}
		});
		btRead.setBounds(24, 321, 249, 23);
		panel.add(btRead);

		JButton btDel = new JButton("Deletar");
		btDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dadosDep();

				DeputadoDAO dao = new DeputadoDAO();
				dao.setup();
				dao.delete(deputado);
				dao.exit();

			}
		});
		btDel.setBounds(283, 321, 233, 23);
		panel.add(btDel);

		lblCpf = new JLabel("CPF");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setBounds(188, 50, 40, 14);
		panel.add(lblCpf);

		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(251, 47, 125, 20);
		panel.add(tfCpf);
	}

	private void dadosDep() {

		deputado = new Deputado();
		deputado.setId(Integer.parseInt(tfID.getText()));
		deputado.setUri(tfUri.getText());
		deputado.setNome(tfNome.getText());
		deputado.setIdLegislaturaInicial(Integer.parseInt(tfLegIni.getText()));
		deputado.setIdLegislaturaFinal(Integer.parseInt(tfLegFin.getText()));
		deputado.setNomeCivil(tfNomeCivil.getText());
		deputado.setCpf(tfCpf.getText());
		deputado.setSiglaSexo(cbSexo.getSelectedItem().toString());
		deputado.setDataNascimento(tfDataNasc.getText());
		deputado.setDataFalecimento(tfDataFalec.getText());
		deputado.setUfNascimento(cbUf.getSelectedItem().toString());
		deputado.setMunicipioNascimento(tfMuni.getText());

	}

	private void infDep() {

		tfID.setText(deputado.getId() + "");
		tfUri.setText(deputado.getUri());
		tfNome.setText(deputado.getNome());
		tfLegIni.setText(deputado.getIdLegislaturaInicial() + "");
		tfLegFin.setText(deputado.getIdLegislaturaFinal() + "");
		tfNomeCivil.setText(deputado.getNomeCivil());
		tfCpf.setText(deputado.getCpf());

		cbSexo.setSelectedItem(deputado.getSiglaSexo());

		tfDataNasc.setText(deputado.getDataNascimento());
		tfDataFalec.setText(deputado.getDataFalecimento());

		cbUf.setSelectedItem(deputado.getUfNascimento());

		tfMuni.setText(deputado.getMunicipioNascimento());

	}
}
