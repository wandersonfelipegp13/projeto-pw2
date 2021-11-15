package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.LegislaturaDAO;
import modelo.Legislatura;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLegislatura extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfUri;
	private JTextField tfDataIni;
	private JTextField tfDataFin;
	private JTextField tfDataEle;
	private Legislatura l;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLegislatura frame = new ViewLegislatura();
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
	public ViewLegislatura() {
		setTitle("Gerenciar Legislatura");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 487, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 471, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 39, 111, 14);
		panel.add(lblNewLabel);
		
		JLabel lblUri = new JLabel("URI");
		lblUri.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUri.setForeground(Color.WHITE);
		lblUri.setBounds(10, 64, 111, 14);
		panel.add(lblUri);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataInicio.setForeground(Color.WHITE);
		lblDataInicio.setBounds(10, 89, 111, 14);
		panel.add(lblDataInicio);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataFim.setForeground(Color.WHITE);
		lblDataFim.setBounds(10, 114, 111, 14);
		panel.add(lblDataFim);
		
		JLabel lblAnoEleio = new JLabel("Ano Eleição");
		lblAnoEleio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnoEleio.setForeground(Color.WHITE);
		lblAnoEleio.setBounds(10, 139, 111, 14);
		panel.add(lblAnoEleio);
		
		tfId = new JTextField();
		tfId.setBounds(143, 36, 281, 20);
		panel.add(tfId);
		tfId.setColumns(10);
		
		tfUri = new JTextField();
		tfUri.setColumns(10);
		tfUri.setBounds(143, 61, 281, 20);
		panel.add(tfUri);
		
		tfDataIni = new JTextField();
		tfDataIni.setColumns(10);
		tfDataIni.setBounds(143, 86, 281, 20);
		panel.add(tfDataIni);
		
		tfDataFin = new JTextField();
		tfDataFin.setColumns(10);
		tfDataFin.setBounds(143, 111, 281, 20);
		panel.add(tfDataFin);
		
		tfDataEle = new JTextField();
		tfDataEle.setColumns(10);
		tfDataEle.setBounds(143, 136, 281, 20);
		panel.add(tfDataEle);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dadosLeg();
				LegislaturaDAO dao = new LegislaturaDAO();
				dao.setup();
				dao.create(l);
				dao.exit();
			}
		});
		btnNewButton.setBounds(55, 179, 180, 23);
		panel.add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dadosLeg();
				LegislaturaDAO dao = new LegislaturaDAO();
				dao.setup();
				dao.update(l);
				dao.exit();
			}
		});
		btnAtualizar.setBounds(245, 179, 179, 23);
		panel.add(btnAtualizar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LegislaturaDAO dao = new LegislaturaDAO();
				dao.setup();
				l = dao.read(Integer.parseInt(tfId.getText()));
				dao.exit();
				pegaLeg();
			}
		});
		btnBuscar.setBounds(55, 213, 180, 23);
		panel.add(btnBuscar);
		
		JButton btnNewButton_1_1 = new JButton("Deletar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dadosLeg();
				LegislaturaDAO dao = new LegislaturaDAO();
				dao.setup();
				dao.delete(l);
				dao.exit();
			}
		});
		btnNewButton_1_1.setBounds(245, 213, 179, 23);
		panel.add(btnNewButton_1_1);
	}
	
	private void dadosLeg() {
		l = new Legislatura();
		l.setIdLegislatura(Integer.parseInt(tfId.getText()));
		l.setUri(tfUri.getText());
		l.setDataInicio(tfDataIni.getText());
		l.setDataFim(tfDataFin.getText());
		l.setAnoEleicao(Integer.parseInt(tfDataEle.getText()));
	}

	private void pegaLeg() {
		tfId.setText(l.getIdLegislatura() + "");
		tfUri.setText(l.getUri());
		tfDataIni.setText(l.getDataInicio());
		tfDataFin.setText(l.getDataFim());
		tfDataEle.setText(l.getAnoEleicao() + "");
	}
	
}
