package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;

import dao.UsersDAO;
import models.User;
import utils.Almacen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField logusername;
	private JPasswordField logpassword;
	private ArrayList<User> usuario = new ArrayList<User>();
	private JFrame julioiglesias;

	/**
	 * Create the application.
	 */
	public Login(JFrame parent) {
		this.julioiglesias = parent;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		frame = new JFrame();
		frame.setTitle("Pokedex");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\alumno\\Pictures\\pokemon\\pokebola.png"));
		frame.getContentPane().setBackground(new Color(178, 34, 34));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 720, 530);

		visuallog();
	}

	public void visuallog() {
		JLabel minilogo = new JLabel("");
		minilogo.setIcon(new ImageIcon("C:\\Users\\alumno\\Pictures\\pokemon\\AAAAAAAAAAA.png"));
		minilogo.setBounds(596, 438, 108, 53);
		frame.getContentPane().add(minilogo);

		JLabel logogrande = new JLabel("");
		logogrande.setIcon(new ImageIcon("C:\\Users\\alumno\\Pictures\\pokemon\\pixelpoke.png"));
		logogrande.setBounds(177, 59, 340, 137);
		frame.getContentPane().add(logogrande);

		logusername = new JTextField();
		logusername.setBounds(349, 247, 109, 20);
		frame.getContentPane().add(logusername);
		logusername.setColumns(10);

		logpassword = new JPasswordField();
		logpassword.setBounds(349, 286, 109, 20);
		frame.getContentPane().add(logpassword);

		JLabel Tnombre = new JLabel("Username: ");
		Tnombre.setForeground(new Color(255, 255, 255));
		Tnombre.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		Tnombre.setBounds(230, 246, 109, 28);
		frame.getContentPane().add(Tnombre);

		JLabel TContraseña = new JLabel("Contrase\u00F1a: ");
		TContraseña.setForeground(new Color(255, 255, 255));
		TContraseña.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		TContraseña.setBounds(230, 287, 120, 25);
		frame.getContentPane().add(TContraseña);

		JButton logcheck = new JButton("ENTRAR");
		logcheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checklog();
			}
		});
		logcheck.setBounds(298, 335, 89, 23);
		frame.getContentPane().add(logcheck);

		JLabel loginpng = new JLabel("");
		loginpng.setIcon(new ImageIcon("C:\\Users\\alumno\\Pictures\\pokemon\\chiquitologin.png"));
		loginpng.setBounds(298, 183, 89, 53);
		frame.getContentPane().add(loginpng);

		JLabel piplup = new JLabel("");
		piplup.setIcon(new ImageIcon("C:\\Users\\alumno\\Pictures\\pokemon\\piplupnopetes.png"));
		piplup.setBounds(424, 178, 280, 330);
		frame.getContentPane().add(piplup);
		
		JButton btnSalir = new JButton("Atras");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana();
			}
		});
		btnSalir.setBounds(96, 438, 89, 23);
		frame.getContentPane().add(btnSalir);

		frame.setVisible(true);

	}

	public void checklog() {
		String us = logusername.getText();
		boolean dentro = false;
		char paslog[] = logpassword.getPassword();
		String passlog = new String(paslog);
		dentro= UsersDAO.login(us, passlog);
//		usuario = Almacen.cuentas();
//		for (User ario : usuario) {
//			if (passlog.equals(ario.getPasswd()) && us.equals(ario.getNick())) {
//				dentro = true;
//				break;
//			} 
//		}
		if(!dentro) {
			JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecta");
		} else {
			new Pokedex(us);
			frame.setVisible(false);
		}
	}
	
	public void ventana() {
		frame.setVisible(false);
		julioiglesias.setVisible(true);
	}
}
