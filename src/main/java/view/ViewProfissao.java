package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ProfissaoDAO;
import modelo.Profissao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewProfissao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfProf;
	private JTextField tfTitle;
	private JTextField tfDep;
	private Profissao p;
	private JTextField tfUri;
	private JTextField tfData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProfissao frame = new ViewProfissao();
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
	public ViewProfissao() {
		setTitle("Gerenciar Profissões");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 434, 308);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 45, 110, 14);
		panel.add(lblNewLabel);
		
		JLabel lblIdTipoProfisso = new JLabel("ID tipo Profissão");
		lblIdTipoProfisso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdTipoProfisso.setForeground(Color.WHITE);
		lblIdTipoProfisso.setBounds(10, 70, 110, 14);
		panel.add(lblIdTipoProfisso);
		
		JLabel lblTtulo = new JLabel("Título");
		lblTtulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTtulo.setForeground(Color.WHITE);
		lblTtulo.setBounds(10, 95, 110, 14);
		panel.add(lblTtulo);
		
		JLabel lblIdDdeputado = new JLabel("ID Deputado");
		lblIdDdeputado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdDdeputado.setForeground(Color.WHITE);
		lblIdDdeputado.setBounds(10, 120, 110, 14);
		panel.add(lblIdDdeputado);
		
		tfId = new JTextField();
		tfId.setBounds(130, 42, 270, 20);
		panel.add(tfId);
		tfId.setColumns(10);
		
		tfProf = new JTextField();
		tfProf.setColumns(10);
		tfProf.setBounds(130, 67, 270, 20);
		panel.add(tfProf);
		
		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(130, 92, 270, 20);
		panel.add(tfTitle);
		
		tfDep = new JTextField();
		tfDep.setColumns(10);
		tfDep.setBounds(130, 117, 270, 20);
		panel.add(tfDep);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dados();
				ProfissaoDAO dao = new ProfissaoDAO();
				dao.setup();
				dao.create(p);
				dao.exit();
			}
		});
		btnNewButton.setBounds(43, 227, 167, 23);
		panel.add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dados();
				ProfissaoDAO dao = new ProfissaoDAO();
				dao.setup();
				dao.update(p);
				dao.exit();
			}
		});
		btnAtualizar.setBounds(233, 227, 167, 23);
		panel.add(btnAtualizar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfissaoDAO dao = new ProfissaoDAO();
				dao.setup();
				p = dao.read(Integer.parseInt(tfId.getText()));
				dao.exit();
				set();
			}
		});
		btnBuscar.setBounds(43, 261, 167, 23);
		panel.add(btnBuscar);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dados();
				ProfissaoDAO dao = new ProfissaoDAO();
				dao.setup();
				dao.delete(p);
				dao.exit();
			}
		});
		btnDelete.setBounds(233, 261, 167, 23);
		panel.add(btnDelete);
		
		tfUri = new JTextField();
		tfUri.setColumns(10);
		tfUri.setBounds(130, 145, 270, 20);
		panel.add(tfUri);
		
		JLabel lblUri = new JLabel("URI");
		lblUri.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUri.setForeground(Color.WHITE);
		lblUri.setBounds(10, 148, 110, 14);
		panel.add(lblUri);
		
		tfData = new JTextField();
		tfData.setColumns(10);
		tfData.setBounds(130, 176, 270, 20);
		panel.add(tfData);
		
		JLabel lblDataHora = new JLabel("Data Hora");
		lblDataHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataHora.setForeground(Color.WHITE);
		lblDataHora.setBounds(10, 179, 110, 14);
		panel.add(lblDataHora);
	}
	
	private void dados() {
		p = new Profissao();
		p.setId(Integer.parseInt(tfId.getText()));
		p.setUri(tfUri.getText());
		p.setDataHora(tfData.getText());
		p.setCodTipoProfissao(Integer.parseInt(tfProf.getText()));
		p.setTitulo(tfTitle.getText());
		p.setIdDeputado(Integer.parseInt(tfDep.getText()));	
	}
	
	private void set() {
		tfId.setText(p.getId() + "");
		tfUri.setText(p.getUri());
		tfData.setText(p.getDataHora());
		tfProf.setText(p.getCodTipoProfissao() + "");
		tfTitle.setText(p.getTitulo());
		tfDep.setText(p.getIdDeputado() + "");	
	}

}
