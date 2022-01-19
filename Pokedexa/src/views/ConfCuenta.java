package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.UsersDAO;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.Programa;

import java.awt.Font;

public class ConfCuenta {

	private JFrame frame;
	private JFrame julioiglesias;
	private String user;
	private String newuser;
	private JTextField textFieldNombre;
	private JPanel panel;
	private JButton btnCambiar;
	private JButton btnBorrar;
	private JButton btnSalirCon;
	private JButton btnSalirCambName;



	public ConfCuenta(JFrame parent, String user) {
		this.julioiglesias=parent;
		this.user = user;
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pokedex");
		frame.getContentPane().setBackground(new Color(178, 34, 34));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 720, 530);
		
		panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		this.panel.setBounds(177, 225, 340, 244);
		frame.getContentPane().add(panel);
		this.panel.setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(103, 98, 139, 20);
		this.panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblTexto = new JLabel("Introduce tu nuevo nombre");
		lblTexto.setForeground(Color.WHITE);
		lblTexto.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setBounds(10, 11, 320, 30);
		panel.add(lblTexto);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiar();
			}
		});
		btnConfirmar.setBounds(127, 151, 89, 23);
		panel.add(btnConfirmar);
		
		btnSalirCambName = new JButton("Atr\u00E1s");
		btnSalirCambName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				btnCambiar.setVisible(true);
				btnSalirCon.setVisible(true);
				btnBorrar.setVisible(true);
			}
		});
		btnSalirCambName.setBounds(108, 210, 123, 23);
		panel.add(btnSalirCambName);
		panel.setVisible(false);
		
		btnSalirCon = new JButton("Atr\u00E1s");
		btnSalirCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Pokedex(user);
			}
		});
		btnSalirCon.setBounds(285, 438, 123, 23);
		frame.getContentPane().add(btnSalirCon);
		
		JLabel minilogo = new JLabel("");
		minilogo.setIcon(new ImageIcon("C:\\Users\\alumno\\Pictures\\pokemon\\AAAAAAAAAAA.png"));
		minilogo.setBounds(596, 438, 108, 53);
		frame.getContentPane().add(minilogo);
		
		JLabel logogrande = new JLabel("");
		logogrande.setIcon(new ImageIcon("C:\\Users\\alumno\\Pictures\\pokemon\\pixelpoke.png"));
		logogrande.setBounds(177, 59, 340, 137);
		frame.getContentPane().add(logogrande);
		
		btnCambiar = new JButton("Cambiar Nombre");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarUser();
			}
		});
		btnCambiar.setBounds(280, 335, 139, 23);
		frame.getContentPane().add(btnCambiar);
		
		btnBorrar = new JButton("Borrar Cuenta");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		btnBorrar.setBounds(280, 369, 139, 23);
		frame.getContentPane().add(btnBorrar);
		frame.setVisible(true);
	}
	
	public void cambiarUser() {
		btnCambiar.setVisible(false);
		btnSalirCon.setVisible(false);
		btnBorrar.setVisible(false);
		panel.setVisible(true);
	}
	
	public void cambiar() {
		this.newuser= textFieldNombre.getText();
		if(!newuser.isEmpty()) {
			if(!UsersDAO.consultaN(newuser)) {
				this.user=UsersDAO.cambiar(user,this.newuser);
				panel.setVisible(false);
				btnCambiar.setVisible(true);
				btnSalirCon.setVisible(true);
				btnBorrar.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "El nombre está en uso.");
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Introduce un nombre");
		}
	}
	
	public void borrar() {
		frame.setVisible(false);
		UsersDAO.borrar(user);
		new Programa();
	}
}
