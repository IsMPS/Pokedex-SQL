package models;

import java.util.ArrayList;

import utils.TipoPokemon;

public class Pokemon {
	private ArrayList<Pokemon> poke = new ArrayList<Pokemon>();
	private String nombre;
	private int num;
	private double peso;
	private double altura;
	private TipoPokemon tipopok;
	private String tipo;
	private String tipo2;
	/**
	 * @param nombre
	 * @param num
	 * @param peso
	 * @param altura
	 */
	public Pokemon(String nombre, int num, double peso, double altura) {
		super();
		this.nombre = nombre;
		this.num = num;
		this.peso = peso;
		this.altura = altura;
		
//		switch(tipo.substring(0,1).toUpperCase()+tipo.substring(1)) {
//		case :
//			
//		break;
			
			
		
//		}
	}

	/**
	 * @return the poke
	 */
	public ArrayList<Pokemon> getPoke() {
		return poke;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @return the altura
	 */
	public double getAltura() {
		return altura;
	}
	
	
}
