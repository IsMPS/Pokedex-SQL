package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import app.Programa;

import javax.swing.JButton;

public class Pokedex {

	private JFrame frame;
	private JFrame prog;
	private String user;

	/**
	 * Create the application.
	 */
	public Pokedex(String user) {
		this.user=user;
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
		visual();
	}
	
	private void visual() {
		
		JLabel minilogo = new JLabel("");
		minilogo.setIcon(new ImageIcon("Img/AAAAAAAAAAA.png"));
		minilogo.setBounds(596, 438, 108, 53);
		frame.getContentPane().add(minilogo);
		
		JLabel logogrande = new JLabel("");
		logogrande.setIcon(new ImageIcon("Img/pixelpoke.png"));
		logogrande.setBounds(177, 59, 340, 137);
		frame.getContentPane().add(logogrande);
		
		JLabel pokeball = new JLabel("");
		pokeball.setIcon(new ImageIcon("Img/pokeballabierta.png"));
		pokeball.setBounds(309, 226, 73, 98);
		frame.getContentPane().add(pokeball);
		
		JButton btnSalir = new JButton("Cerrar sesi\u00F3n");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irmenuprin();
			}
		});
		btnSalir.setBounds(285, 438, 123, 23);
		frame.getContentPane().add(btnSalir);
		
		JButton btnEntrar = new JButton("Pokedex");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrarpoke();
			}
		});
		btnEntrar.setBounds(285, 335, 123, 23);
		frame.getContentPane().add(btnEntrar);
		
		JButton btnActualizar = new JButton("Configuraci\u00F3n");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conf();
			}
		});
		btnActualizar.setBounds(285, 369, 123, 23);
		frame.getContentPane().add(btnActualizar);
		
		frame.setVisible(true);
	}
	
	public void irmenuprin() {
		new Programa();
		frame.setVisible(false);
	}
	
	public void entrarpoke() {
		frame.setVisible(false);
		new Pokemons(frame,user,0);
	}
	
	public void conf() {
		frame.setVisible(false);
		new ConfCuenta(frame,user);
	}
}
