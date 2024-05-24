package br.edu.exemplo.view;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.exemplo.dao.AlunoDAO;
import br.edu.exemplo.model.Aluno;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtRA;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtDataNascimento;
	private JTextField txtEndereco;
	private JComboBox cmbPeriodo;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	private JButton btnConsultar;
	private JButton btnListar;
	private TextArea txtListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("RA");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 57, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(10, 111, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Data de nascimento");
		lblNewLabel_3.setBounds(10, 156, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Endereço");
		lblNewLabel_4.setBounds(10, 204, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Periodo");
		lblNewLabel_5.setBounds(10, 254, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtRA = new JTextField();
		txtRA.setBounds(144, 8, 468, 20);
		contentPane.add(txtRA);
		txtRA.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(144, 54, 468, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(144, 108, 468, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(144, 153, 468, 20);
		contentPane.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(144, 201, 468, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		cmbPeriodo = new JComboBox();
		cmbPeriodo.setModel(new DefaultComboBoxModel(new String[] {"Selecionar uma ação", "Manha", "Tarde", "Noite"}));
		cmbPeriodo.setBounds(144, 250, 468, 22);
		contentPane.add(cmbPeriodo);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRA.setText(null);
				txtNome.setText(null);
				txtEmail.setText(null);
				txtListar.setText(null);
				txtEndereco.setText(null);
				txtDataNascimento.setText(null);
				cmbPeriodo.setSelectedIndex(0);
			}
		});
		btnNovo.setBounds(10, 419, 89, 23);
		contentPane.add(btnNovo);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setRa(Integer.parseInt(txtRA.getText()));
				aluno.setNome(txtNome.getText());
				aluno.setEmail(txtEmail.getText());
				aluno.setDataNascimento(txtDataNascimento.getText());
				aluno.setEndereco(txtEndereco.getText());
				aluno.setPeriodo(cmbPeriodo.getSelectedItem().toString());
				
				try {
					//DAO >> Data Acess Object;
					AlunoDAO dao = new AlunoDAO();
					dao.salvar(aluno);
					
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				
				
			}
		});
		btnSalvar.setBounds(109, 419, 89, 23);
		contentPane.add(btnSalvar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setRa(Integer.parseInt(txtRA.getText()));
				aluno.setNome(txtNome.getText());
				aluno.setEmail(txtEmail.getText());
				aluno.setDataNascimento(txtDataNascimento.getText());
				aluno.setEndereco(txtEndereco.getText());
				aluno.setPeriodo(cmbPeriodo.getSelectedItem().toString());
				
				try {
					//DAO >> Data Acess Object;
					AlunoDAO dao = new AlunoDAO();
					dao.Atualizar(aluno);
					
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnAtualizar.setBounds(208, 419, 89, 23);
		contentPane.add(btnAtualizar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setRa(Integer.parseInt(txtRA.getText()));
				
				try {
					//DAO >> Data Acess Object;
					AlunoDAO dao = new AlunoDAO();
					dao.Excluir(aluno);
					
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnExcluir.setBounds(307, 419, 89, 23);
		contentPane.add(btnExcluir);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ra = Integer.parseInt(txtRA.getText());
					AlunoDAO dao = new AlunoDAO();
					Aluno aluno = dao.consultar(ra);
					txtNome.setText(aluno.getNome());
					txtEmail.setText(aluno.getEmail());
					txtEndereco.setText(aluno.getEndereco());
					txtDataNascimento.setText(aluno.getDataNascimento());
					cmbPeriodo.setSelectedItem(aluno.getPeriodo());
					
					
					
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,e1);
					
				}
			}
		});
		btnConsultar.setBounds(406, 419, 89, 23);
		contentPane.add(btnConsultar);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(505, 419, 89, 23);
		contentPane.add(btnListar);
		
		txtListar = new TextArea();
		txtListar.setBounds(10, 274, 602, 134);
		contentPane.add(txtListar);
	}
}
