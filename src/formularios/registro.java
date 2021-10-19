package formularios;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import conexion.conexionSQL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;



	
public class registro extends javax.swing.JFrame {
	

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;


	
	conexionSQL cc=new conexionSQL();
	Connection con=cc.conexion();
	private JLabel lblNewLabel;
	
	public void AgregarUsuario() {

		String SQL="insert into usuario(nombre_usuario,password_usuario) values (?,?)";		
		String pass=String.valueOf(txtPassword.getPassword());
		
		try {

			PreparedStatement pst=con.prepareStatement(SQL);
			pst.setString(1, txtUsuario.getText());
			pst.setString(2, pass);
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null,"Registro validado");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error de registro"+e.getMessage());
		}

		
		
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro frame = new registro();
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
	public registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(61, 65, 55, 24);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(61, 113, 87, 24);
		contentPane.add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(146, 69, 118, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(146, 117, 118, 20);
		contentPane.add(txtPassword);
		
		JButton btnAgregar = new JButton("Registrarme");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgregarUsuario();
				
			}
		});
		btnAgregar.setBounds(135, 186, 158, 23);
		contentPane.add(btnAgregar);
		
		lblNewLabel = new JLabel("Registro de Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(122, 11, 169, 34);
		contentPane.add(lblNewLabel);
	}
}
