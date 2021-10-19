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
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import conexion.conexionSQL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;



public class sesion extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;


	conexionSQL cc=new conexionSQL();
	Connection con=cc.conexion();	
	private JLabel lblNewLabel;
	
	
	
	public void ValidarUsuario() {
		
		int resultado=0;
		
		String pass=String.valueOf(txtPassword.getPassword());
		String usuario=txtUsuario.getText();
		String SQL="select * from usuario where nombre_usuario='"+usuario+"' and password_usuario='"+pass+"'";		
		
		
		
		try {

			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(SQL);
			
			if (rs.next()) {
				resultado=1;
				
				if (resultado==1) {
				
					my_construction form = new my_construction();
					form.setVisible(true);
					this.dispose();
				}
				
				
			}else {
				JOptionPane.showMessageDialog(null,"Error de acceso, Usuario no existe");
			}
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
		}

		
		
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sesion frame = new sesion();
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
	public sesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("usuario");
		lblLogin.setForeground(Color.YELLOW);
		lblLogin.setBackground(Color.BLACK);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(74, 80, 55, 17);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("contrase\u00F1a");
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(74, 130, 89, 17);
		contentPane.add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(175, 80, 141, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(175, 130, 141, 20);
		contentPane.add(txtPassword);
		
		JButton btnIngresar = new JButton("Ingresar");
		
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ValidarUsuario();
				
			}
		});
		
		
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIngresar.setBounds(162, 188, 89, 23);
		contentPane.add(btnIngresar);
		
		lblNewLabel = new JLabel("Sistema My Construction");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(122, 23, 211, 23);
		contentPane.add(lblNewLabel);
	}

}
