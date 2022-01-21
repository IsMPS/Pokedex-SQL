package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import app.Programa;
import dao.UsersDAO;
import utils.Almacen;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField passwordconf;
	private JFrame julio;

	/**
	 * Create the application.
	 */
	public Register(JFrame julio) {
		this.julio = julio;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pokedex");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Img/pokebola.png"));
		frame.getContentPane().setBackground(new Color(178, 34, 34));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 720, 530);

		visualreg();
	}

	private void visualreg() {

		JButton Confirmar = new JButton("Confirmar");
		Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkreg();
			}
		});
		Confirmar.setBounds(306, 377, 99, 23);
		frame.getContentPane().add(Confirmar);

		JButton btnSalir = new JButton("Atras");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaProg();
			}
		});
		btnSalir.setBounds(96, 438, 89, 23);
		frame.getContentPane().add(btnSalir);

		JLabel minilogo = new JLabel("");
		minilogo.setIcon(new ImageIcon("Img/AAAAAAAAAAA.png"));
		minilogo.setBounds(596, 438, 108, 53);
		frame.getContentPane().add(minilogo);

		JLabel logogrande = new JLabel("");
		logogrande.setIcon(new ImageIcon("Img/pixelpoke.png"));
		logogrande.setBounds(177, 59, 340, 137);
		frame.getContentPane().add(logogrande);

		JLabel registerpng = new JLabel("");
		registerpng.setIcon(new ImageIcon("Img/registerr.png"));
		registerpng.setBounds(290, 179, 108, 53);
		frame.getContentPane().add(registerpng);

		username = new JTextField();
		username.setBounds(349, 247, 120, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);

		password = new JPasswordField();
		password.setBounds(349, 286, 120, 20);
		frame.getContentPane().add(password);

		passwordconf = new JPasswordField();
		passwordconf.setBounds(349, 328, 120, 20);
		frame.getContentPane().add(passwordconf);

		JLabel Tnombre = new JLabel("Username: ");
		Tnombre.setForeground(new Color(255, 255, 255));
		Tnombre.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		Tnombre.setBounds(241, 243, 109, 28);
		frame.getContentPane().add(Tnombre);

		JLabel TContraseña = new JLabel("Contrase\u00F1a: ");
		TContraseña.setForeground(new Color(255, 255, 255));
		TContraseña.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		TContraseña.setBounds(230, 287, 120, 25);
		frame.getContentPane().add(TContraseña);

		JLabel TConfContraseña = new JLabel("Confirma la contrase\u00F1a: ");
		TConfContraseña.setForeground(new Color(255, 255, 255));
		TConfContraseña.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		TConfContraseña.setBounds(134, 329, 204, 25);
		frame.getContentPane().add(TConfContraseña);

		JLabel pokdx = new JLabel("");
		pokdx.setIcon(new ImageIcon("Img/pokedeee.png"));
		pokdx.setBounds(338, -12, 454, 513);
		frame.getContentPane().add(pokdx);

		JLabel empoleon = new JLabel("");
		empoleon.setIcon(new ImageIcon("Img/porfavor.png"));
		empoleon.setBounds(0, 37, 289, 333);
		frame.getContentPane().add(empoleon);

		frame.setVisible(true);
	}

	public void ventanaProg() {
		frame.setVisible(false);
		julio.setVisible(true);
	}

	public void checkreg() {
		String us = username.getText();

		char pas[] = password.getPassword();
		String pass = new String(pas);

		char pasc[] = passwordconf.getPassword();
		String passc = new String(pasc);
		// Primer if que coincidan contraseñas
		if (pass.equals(passc)) {
			// Segundo if para saber que los campos no son nulos
			if (!us.isEmpty() && !pass.isEmpty()) {
				// Que no exista ya el usuario
				if (!UsersDAO.consultaN(us)) {
//					Almacen.meteCuentas(us, pass);
					UsersDAO.register(us, pass);
					frame.setVisible(false);
					new Programa();
				} else {
					JOptionPane.showMessageDialog(null, "El nombre está en uso.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Rellena todos los campos.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
		}
	}
}
