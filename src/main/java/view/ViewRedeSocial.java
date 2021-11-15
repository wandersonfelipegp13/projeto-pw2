package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UrlRedeSocialDAO;
import modelo.UrlRedeSocial;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewRedeSocial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfDep;
	private JTextField tfUrl;
	private UrlRedeSocial rede;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRedeSocial frame = new ViewRedeSocial();
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
	public ViewRedeSocial() {
		setTitle("Gerenciar Redes Sociais");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 434, 228);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 27, 95, 14);
		panel.add(lblNewLabel);
		
		JLabel lblIdDeputado = new JLabel("ID Deputado");
		lblIdDeputado.setForeground(Color.WHITE);
		lblIdDeputado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdDeputado.setBounds(10, 52, 95, 14);
		panel.add(lblIdDeputado);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setForeground(Color.WHITE);
		lblUrl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUrl.setBounds(10, 77, 95, 14);
		panel.add(lblUrl);
		
		tfId = new JTextField();
		tfId.setBounds(115, 24, 269, 20);
		panel.add(tfId);
		tfId.setColumns(10);
		
		tfDep = new JTextField();
		tfDep.setColumns(10);
		tfDep.setBounds(115, 49, 269, 20);
		panel.add(tfDep);
		
		tfUrl = new JTextField();
		tfUrl.setColumns(10);
		tfUrl.setBounds(115, 74, 269, 20);
		panel.add(tfUrl);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dados();
				UrlRedeSocialDAO dao = new UrlRedeSocialDAO();
				dao.setup();
				dao.create(rede);
				dao.exit();
			}
		});
		btnNewButton.setBounds(42, 118, 167, 23);
		panel.add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dados();
				UrlRedeSocialDAO dao = new UrlRedeSocialDAO();
				dao.setup();
				dao.update(rede);
				dao.exit();
			}
		});
		btnAtualizar.setBounds(219, 118, 165, 23);
		panel.add(btnAtualizar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UrlRedeSocialDAO dao = new UrlRedeSocialDAO();
				dao.setup();
				rede = dao.read(Integer.parseInt(tfId.getText()));
				dao.exit();
				set();
			}
		});
		btnBuscar.setBounds(42, 152, 167, 23);
		panel.add(btnBuscar);
		
		JButton btnNewButton_1_1 = new JButton("Deletar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dados();
				UrlRedeSocialDAO dao = new UrlRedeSocialDAO();
				dao.setup();
				dao.delete(rede);
				dao.exit();
			}
		});
		btnNewButton_1_1.setBounds(219, 152, 165, 23);
		panel.add(btnNewButton_1_1);
	}
	
	private void dados() {
		rede = new UrlRedeSocial();
		rede.setId(Integer.parseInt(tfId.getText()));
		rede.setIdDeputado(Integer.parseInt(tfDep.getText()));
		rede.setUrl(tfUrl.getText());
	}
	
	private void set() {
		tfId.setText(rede.getId() + "");
		tfDep.setText(rede.getIdDeputado() + "");
		tfUrl.setText(rede.getUrl());
	}

}
