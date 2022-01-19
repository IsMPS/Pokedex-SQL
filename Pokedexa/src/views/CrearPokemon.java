package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import utils.TipoPokemon;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearPokemon {

	private JFrame frame;
	private String[] tipos = {"Acero", "Agua", "Bicho", "Dragon", "Electrico","Fantasma", "Fuego", "Hada", "Hielo", "Lucha", "Normal", "Planta", "Psiquico", "Roca", "Siniestro", "Tierra", "Veneno", "Volador"};
	private JTextField NombrePok;
	private JTextField PesoPok;
	private JTextField textField_2;
	private JLabel lblTipo;
	private JLabel lblTipoPok;
	private JFrame ElJulio;
	private String getTipo;

	/**
	 * Create the application.
	 */
	public CrearPokemon(JFrame parent, String user){
		ElJulio = parent;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pokedex");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\alumno\\Pictures\\pokemon\\pokebola.png"));
		frame.getContentPane().setBackground(new Color(178, 34, 34));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblNombre.setBounds(47, 207, 257, 28);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setBounds(47, 248, 257, 28);
		frame.getContentPane().add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setBounds(70, 290, 234, 28);
		frame.getContentPane().add(lblAltura);
		
		NombrePok = new JTextField();
		NombrePok.setFont(new Font("Yu Gothic", Font.PLAIN, 17));
		NombrePok.setBounds(324, 207, 123, 28);
		frame.getContentPane().add(NombrePok);
		NombrePok.setColumns(10);
		
		PesoPok = new JTextField();
		PesoPok.setFont(new Font("Yu Gothic", Font.PLAIN, 17));
		PesoPok.setBounds(324, 247, 123, 30);
		frame.getContentPane().add(PesoPok);
		PesoPok.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Yu Gothic", Font.PLAIN, 17));
		textField_2.setBounds(324, 290, 123, 28);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSig = new JButton("Elegir tipo");
		btnSig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Siguiente() ;
			}
		});
		btnSig.setBounds(476, 328, 89, 23);
		frame.getContentPane().add(btnSig);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblTipo.setBounds(47, 328, 257, 28);
		frame.getContentPane().add(lblTipo);
		
		lblTipoPok = new JLabel(getTipo+"");
		lblTipoPok.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoPok.setForeground(Color.WHITE);
		lblTipoPok.setFont(new Font("Yu Gothic", Font.PLAIN, 17));
		lblTipoPok.setBounds(324, 329, 123, 28);
		frame.getContentPane().add(lblTipoPok);
		frame.setBounds(100, 100, 720, 530);
			
		frame.setVisible(true);
	}
	
	public void Siguiente() {
		getTipo = (String) JOptionPane.showInputDialog(frame,"Tipo Pokemon", "Tipo", 3, null, tipos,tipos[0]);
	}
}
