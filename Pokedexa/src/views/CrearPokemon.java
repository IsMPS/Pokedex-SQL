package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import dao.PokemonsDAO;
import models.Pokemon;
import utils.TipoPokemon;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CrearPokemon {

	private JFrame frame;
	private String[] tipos = {"Ninguno","Acero", "Agua", "Bicho", "Dragon", "Electrico","Fantasma", "Fuego", "Hada", "Hielo", "Lucha", "Normal", "Planta", "Psiquico", "Roca", "Siniestro", "Tierra", "Veneno", "Volador"};
	private JTextField NombrePok;
	private JTextField PesoPok;
	private JTextField textField_2;
	private JLabel lblTipo;
	private JFrame ElJulio;
	private String getTipo;
	private JComboBox comboBox;
	private JComboBox comboBox2;
	private JTextField ID;
	private ArrayList<Integer> noID  = PokemonsDAO.getAllID();
	private boolean existe;
	private JButton btnNewButton;

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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Img/pokebola.png"));
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
		lblPeso.setBounds(47, 251, 257, 28);
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
		
		
		JButton btnSig = new JButton("Crear");
		btnSig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Siguiente();
			}
		});
		btnSig.setBounds(301, 419, 89, 23);
		frame.getContentPane().add(btnSig);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblTipo.setBounds(47, 331, 257, 28);
		frame.getContentPane().add(lblTipo);
		frame.setBounds(100, 100, 720, 530);
		
		comboBox2 = new JComboBox(tipos);
		comboBox2.setBounds(324, 367, 123, 27);
		frame.getContentPane().add(comboBox2);
		
		comboBox = new JComboBox(tipos);
		comboBox.setBounds(324, 329, 123, 27);
		frame.getContentPane().add(comboBox);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblId.setBounds(47, 168, 257, 28);
		frame.getContentPane().add(lblId);
		
		ID = new JTextField();
		ID.setFont(new Font("Yu Gothic", Font.PLAIN, 17));
		ID.setColumns(10);
		ID.setBounds(324, 168, 123, 28);
		frame.getContentPane().add(ID);
		
		btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atras();
			}
		});
		btnNewButton.setBounds(47, 457, 89, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 725, 530);
		
		frame.setVisible(true);
	}
	
	public void Atras() {
		frame.dispose();
		ElJulio.setVisible(true);
	}
	
	public void Siguiente() {
		existe = false;
		if(!ID.getText().isBlank() && !NombrePok.getText().isBlank() && !PesoPok.getText().isBlank() && !textField_2.getText().isBlank() && !((String) comboBox.getSelectedItem()).equals("Ninguno") ) {
			if(!((String) comboBox.getSelectedItem()).equals((String) comboBox2.getSelectedItem())) {
			
				noID = PokemonsDAO.getAllID();
				for (Integer i : noID) {
						if(i.intValue()==Integer.valueOf(ID.getText())) {
							existe=true;
						}
					}
				if(!existe) {
					String Nombre = NombrePok.getText();
					double Peso = Double.valueOf(PesoPok.getText());
					double altura = Double.valueOf(textField_2.getText());
					String tip1 = (String) comboBox.getSelectedItem();
					String tip2 = (String) comboBox2.getSelectedItem();
					int id = Integer.valueOf(ID.getText());
					Pokemon poko = new Pokemon(Nombre,id,Peso,altura,tip1,tip2);
					PokemonsDAO.insert(poko);
					Atras();
				}else {
					JOptionPane.showMessageDialog(frame, "Ese ID ya existe");
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Los tipos no pueden ser iguales");
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Te falta por rellenar algo");
		}
	}
}
