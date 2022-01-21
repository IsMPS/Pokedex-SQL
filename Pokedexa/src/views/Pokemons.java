package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import app.Programa;
import models.Pokemon;
import utils.Almacen;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Pokemons {

	private JFrame frame;
	private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
	private int num = 0;
//	private JFrame parent;
	private String user;

	/**
	 * @param frame
	 * @param accion
	 * @param pokemon
	 * @param num
	 */
	public Pokemons(JFrame parent, String user, int pok) {
		super();
		this.num=pok;
		pokemon=Almacen.pokemones();
//		this.parent=parent;
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
		
		JButton btnFlechaIzq = new JButton("");
		btnFlechaIzq.setBackground(new Color(178, 34, 34));
		btnFlechaIzq.setIcon(new ImageIcon("Img/flechaizq.png"));
		btnFlechaIzq.setBounds(10, 202, 68, 67);
		frame.getContentPane().add(btnFlechaIzq);
		
		JButton btnFlechaDer = new JButton("");
		btnFlechaDer.setBackground(new Color(178, 34, 34));
		btnFlechaDer.setIcon(new ImageIcon("Img/flechader.png"));
		btnFlechaDer.setBounds(626, 202, 68, 67);
		frame.getContentPane().add(btnFlechaDer);
		
		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setForeground(new Color(255, 255, 255));
		lblTipo.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblTipo.setBounds(273, 374, 54, 28);
		frame.getContentPane().add(lblTipo);
		
		JLabel lblTipoImg = new JLabel("");
		lblTipoImg.setBounds(337, 374, 117, 24);
		frame.getContentPane().add(lblTipoImg);
		
		JLabel lblAltura = new JLabel("Altura :");
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblAltura.setBounds(259, 405, 68, 28);
		frame.getContentPane().add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso :");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblPeso.setBounds(269, 433, 54, 28);
		frame.getContentPane().add(lblPeso);
		
		JLabel lblAlturaVar = new JLabel(pokemon.get(num).getAltura()+" m");
		lblAlturaVar.setForeground(Color.WHITE);
		lblAlturaVar.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblAlturaVar.setBounds(337, 405, 105, 28);
		frame.getContentPane().add(lblAlturaVar);
		
		JLabel lblPesoVar = new JLabel(pokemon.get(num).getPeso()+" Kg");
		lblPesoVar.setForeground(Color.WHITE);
		lblPesoVar.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblPesoVar.setBounds(337, 433, 105, 28);
		frame.getContentPane().add(lblPesoVar);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblNombre.setBounds(246, 350, 83, 28);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblNombreVar = new JLabel(pokemon.get(num).getNombre()+"");
		lblNombreVar.setForeground(Color.WHITE);
		lblNombreVar.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblNombreVar.setBounds(337, 350, 165, 28);
		frame.getContentPane().add(lblNombreVar);
		
		JButton btnNew = new JButton("Crear pokemon");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantallaCrear();
			}
		});
		btnNew.setBounds(525, 452, 144, 28);
		frame.getContentPane().add(btnNew);
		
		JButton btnSAlir = new JButton("Menu");
		btnSAlir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSAlir.setBounds(38, 452, 144, 28);
		frame.getContentPane().add(btnSAlir);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(206, 43, 296, 254);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPokemonImg = new JLabel("");
		lblPokemonImg.setBounds(148, 5, 0, 0);
		panel.add(lblPokemonImg);
		frame.setBounds(100, 100, 720, 530);
		
		frame.setVisible(true);
		
				btnFlechaIzq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rest();
				}
			});
			btnFlechaDer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sum();
				}
			});
	}
	
	public void rest() {
		if(num<=1) {
			num = pokemon.size()-1;
		}else {
			num = num - 1;
		}
		actualizarPantalla();
	}
//	
	public void sum() {
		if(num>=pokemon.size()-1) {
				num = 0;
		}else {
				num = num + 1;
		}
		actualizarPantalla();
	}
//	
	public void actualizarPantalla(){
//		SwingUtilities.updateComponentTreeUI(frame);
//		frame.validate();
//		frame.repaint();
		frame.dispose();
		new Pokemons(frame,user,num);
		}
	
	public void pantallaCrear() {
		frame.setVisible(false);
		new CrearPokemon(frame,user);
		
	}
	
	public void salir() {
		frame.dispose();
		new Pokedex(user);
	}
}
