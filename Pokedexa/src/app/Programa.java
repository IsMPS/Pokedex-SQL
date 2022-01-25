package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import views.Login;
import views.Register;

public class Programa {

	private JFrame frmPokedex;
	
	// database pokedex -> tabla Users -> columnas username, pass.
	// database pokedex -> tabla pokemon -> columnas idPoke, Nombre, Peso, Altura, Tipo, Tipo2

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
		frmPokedex.setIconImage(Toolkit.getDefaultToolkit().getImage("Img/pokebola.png"));
		frmPokedex.getContentPane().setBackground(new Color(178, 34, 34));
		frmPokedex.getContentPane().setLayout(null);
		frmPokedex.setBounds(100, 100, 720, 530);
//		urllogobig = new URL("https://drive.google.com/file/d/1TO66mQ93nq_J2Jk6P0AT7Jx2EYjcyX0U/view?usp=sharing");
//		logobig = ImageIO.read(urllogobig);
		
		visual();
	}
	
	private void visual() {
		JButton login = new JButton("");
		login.setForeground(new Color(178, 34, 34));
		login.setBackground(new Color(178, 34, 34));
		login.setIcon(new ImageIcon("Img/chiquitologin.png"));
		login.setBorder(null);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.setVisible(false);
				new Login(frmPokedex);
			}
		});
		login.setBounds(195, 285, 89, 30);
		frmPokedex.getContentPane().add(login);
		
		JLabel minilogo = new JLabel("");
		minilogo.setIcon(new ImageIcon("Img/AAAAAAAAAAA.png"));
		minilogo.setBounds(596, 438, 108, 53);
		frmPokedex.getContentPane().add(minilogo);
		
		JLabel logogrande = new JLabel("");
		logogrande.setIcon(new ImageIcon("Img/pixelpoke.png"));
		logogrande.setBounds(177, 59, 340, 137);
		frmPokedex.getContentPane().add(logogrande);
		
		JButton register = new JButton("");
		register.setBorder(null);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.setVisible(false);
				new Register(frmPokedex);
			}
		});
		register.setBackground(new Color(178, 34, 34));
		register.setIcon(new ImageIcon("Img/registerr.png"));
		register.setBounds(409, 285, 108, 30);
		frmPokedex.getContentPane().add(register);
		
		JLabel pokeball = new JLabel("");
		pokeball.setIcon(new ImageIcon("Img/pokeballcerrada.png"));
		pokeball.setBounds(308, 248, 73, 67);
		frmPokedex.getContentPane().add(pokeball);
		
		frmPokedex.setVisible(true);
	}
}
