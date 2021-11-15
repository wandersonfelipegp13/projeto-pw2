package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.OcupacaoDAO;
import modelo.Deputado;
import modelo.Ocupacao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ViewOcupacao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfDep;
	private JTextField tfUri;
	private JTextField tfTitulo;
	private JTextField tfEntidade;
	private JTextField tfPais;
	private JTextField tfAnoIni;
	private JTextField tfAnoFim;
	private JComboBox<String> cbUf;
	private Ocupacao o;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOcupacao frame = new ViewOcupacao();
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
	public ViewOcupacao() {
		setTitle("Gerenciar Ocupações");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 434, 326);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 30, 124, 14);
		panel.add(lblNewLabel);

		JLabel lblIdDeputado = new JLabel("ID Deputado");
		lblIdDeputado.setForeground(Color.WHITE);
		lblIdDeputado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdDeputado.setBounds(10, 55, 124, 14);
		panel.add(lblIdDeputado);

		JLabel lblUri = new JLabel("URI");
		lblUri.setForeground(Color.WHITE);
		lblUri.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUri.setBounds(10, 80, 124, 14);
		panel.add(lblUri);

		JLabel lblTitulo = new JLabel("titulo");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setBounds(10, 105, 124, 14);
		panel.add(lblTitulo);

		JLabel lblEntidade = new JLabel("Entidade");
		lblEntidade.setForeground(Color.WHITE);
		lblEntidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntidade.setBounds(10, 130, 124, 14);
		panel.add(lblEntidade);

		JLabel lblEntidadeUf = new JLabel("UF");
		lblEntidadeUf.setForeground(Color.WHITE);
		lblEntidadeUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntidadeUf.setBounds(10, 155, 124, 14);
		panel.add(lblEntidadeUf);

		JLabel lblPais = new JLabel("País");
		lblPais.setForeground(Color.WHITE);
		lblPais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPais.setBounds(10, 180, 124, 14);
		panel.add(lblPais);

		JLabel lblAnoInicio = new JLabel("Ano Inicio");
		lblAnoInicio.setForeground(Color.WHITE);
		lblAnoInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnoInicio.setBounds(10, 205, 124, 14);
		panel.add(lblAnoInicio);

		JLabel lblAnoFim = new JLabel("Ano Fim");
		lblAnoFim.setForeground(Color.WHITE);
		lblAnoFim.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnoFim.setBounds(10, 230, 124, 14);
		panel.add(lblAnoFim);

		tfId = new JTextField();
		tfId.setBounds(144, 27, 258, 20);
		panel.add(tfId);
		tfId.setColumns(10);

		tfDep = new JTextField();
		tfDep.setColumns(10);
		tfDep.setBounds(144, 52, 258, 20);
		panel.add(tfDep);

		tfUri = new JTextField();
		tfUri.setColumns(10);
		tfUri.setBounds(144, 77, 258, 20);
		panel.add(tfUri);

		tfTitulo = new JTextField();
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(144, 102, 258, 20);
		panel.add(tfTitulo);

		tfEntidade = new JTextField();
		tfEntidade.setColumns(10);
		tfEntidade.setBounds(144, 127, 258, 20);
		panel.add(tfEntidade);

		tfPais = new JTextField();
		tfPais.setColumns(10);
		tfPais.setBounds(144, 177, 258, 20);
		panel.add(tfPais);

		tfAnoIni = new JTextField();
		tfAnoIni.setColumns(10);
		tfAnoIni.setBounds(144, 202, 258, 20);
		panel.add(tfAnoIni);

		tfAnoFim = new JTextField();
		tfAnoFim.setColumns(10);
		tfAnoFim.setBounds(144, 227, 258, 20);
		panel.add(tfAnoFim);

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dados();
				OcupacaoDAO dao = new OcupacaoDAO();
				dao.setup();
				dao.create(o);
				dao.exit();
			}
		});
		btnNewButton.setBounds(64, 258, 158, 23);
		panel.add(btnNewButton);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dados();
				OcupacaoDAO dao = new OcupacaoDAO();
				dao.setup();
				dao.update(o);
				dao.exit();
			}
		});
		btnAtualizar.setBounds(244, 258, 158, 23);
		panel.add(btnAtualizar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OcupacaoDAO dao = new OcupacaoDAO();
				dao.setup();
				o = dao.read(Integer.parseInt(tfId.getText()));
				dao.exit();
				set();
			}
		});
		btnBuscar.setBounds(64, 292, 158, 23);
		panel.add(btnBuscar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dados();
				OcupacaoDAO dao = new OcupacaoDAO();
				dao.setup();
				dao.delete(o);
				dao.exit();
			}
		});
		btnDeletar.setBounds(244, 292, 158, 23);
		panel.add(btnDeletar);

		cbUf = new JComboBox<String>();
		cbUf.setModel(new DefaultComboBoxModel<String>(
				new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbUf.setBounds(144, 151, 258, 22);
		panel.add(cbUf);
	}

	private void dados() {
		o = new Ocupacao();
		o.setId(Integer.parseInt(tfId.getText()));
		Deputado d = new Deputado();
		d.setId(Integer.parseInt(tfDep.getText()));
		o.setDeputado(d);
		o.setUri(tfUri.getText());
		o.setTitulo(tfTitulo.getText());
		o.setEntidade(tfEntidade.getText());
		o.setEntidadeUF(cbUf.getSelectedItem().toString());
		o.setEntidadePais(tfPais.getText());
		o.setAnoInicio(tfAnoIni.getText());
		o.setAnoFim(tfAnoFim.getText());
	}

	private void set() {
		tfId.setText(o.getId() + "");
		tfDep.setText(o.getDeputado().getId() + "");
		tfUri.setText(o.getUri());
		tfTitulo.setText(o.getTitulo());
		tfEntidade.setText(o.getEntidade());
		cbUf.setSelectedItem(o.getEntidadeUF());
		tfPais.setText(o.getEntidadePais());
		tfAnoIni.setText(o.getAnoInicio());
		tfAnoFim.setText(o.getAnoFim());
	}

}
