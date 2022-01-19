package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import dao.UsersDAO;
import views.Login;
import views.Register;

public class Programa {

	private JFrame frmPokedex;
	private JTextField textField;
	
	// pokedex -> tabla Users -> columnas username, pass.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa window = new Programa();
					window.frmPokedex.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Programa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokedex = new JFrame();
		frmPokedex.setTitle("Pokedex");
		frmPokedex.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\alumno\\Pictures\\pokemon\\pokebola.png"));
		frmPokedex.getContentPane().setBackground(new Color(178, 34, 34));
		frmPokedex.getContentPane().setLayout(null);
		frmPokedex.setBounds(100, 100, 720, 530);
		
		visual();
	}
	
	private void visual() {
		JButton login = new JButton("");
		login.setForeground(new Color(178, 34, 34));
		login.setBackground(new Color(178, 34, 34));
		login.setIcon(new ImageIcon("C:\\Users\\alumno\\Pictures\\pokemon\\chiquitologin.png"));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.setVisible(false);
				new Login(frmPokedex);
			}
		});
		login.setBounds(195, 285, 89, 30);
		frmPokedex.getContentPane().add(login);
		
		JLabel minilogo = new JLabel("");
		minilogo.setIcon(new ImageIcon("C:\\Users\\alumno\\Pictures\\pokemon\\AAAAAAAAAAA.png"));
		minilogo.setBounds(596, 438, 108, 53);
		frmPokedex.getContentPane().add(minilogo);
		
		JLabel logogrande = new JLabel("");
		logogrande.setIcon(new ImageIcon("C:\\Users\\alumno\\Pictures\\pokemon\\pixelpoke.png"));
		logogrande.setBounds(177, 59, 340, 137);
		frmPokedex.getContentPane().add(logogrande);
		
		JButton register = new JButton("");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.setVisible(false);
				new Register(frmPokedex);
			}
		});
		register.setBackground(new Color(178, 34, 34));
		register.setIcon(new ImageIcon("C:\\Users\\alumno\\Pictures\\pokemon\\registerr.png"));
		register.setBounds(409, 285, 108, 30);
		frmPokedex.getContentPane().add(register);
		
		JLabel pokeball = new JLabel("");
		pokeball.setIcon(new ImageIcon("C:\\Users\\alumno\\Pictures\\pokemon\\pokeballcerrada.png"));
		pokeball.setBounds(308, 248, 73, 67);
		frmPokedex.getContentPane().add(pokeball);
		
		frmPokedex.setVisible(true);
	}
}
