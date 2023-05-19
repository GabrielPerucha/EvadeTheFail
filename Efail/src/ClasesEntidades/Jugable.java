package ClasesEntidades;

import javax.swing.Icon;

import Movimientos.Carta;

public class Jugable extends Entidad {

	/*
	 * TO DO Creación de clases hijas con diferentes estilos de personajes
	 */

	protected int mana;
	protected String clase;
	protected Icon iconoJugador;
	protected Carta[] Mazo;
	

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Icon getIconoJugador() {
		return iconoJugador;
	}

	public void setIconoJugador(Icon iconoJugador) {
		this.iconoJugador = iconoJugador;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public Carta[] getMazo() {
		return Mazo;
	}

	public void setMazo(Carta[] mazo) {
		Mazo = mazo;
	}

	public Jugable(String nombre, int vida, int velocidad, int ataque, int defensa, int bloqueo, int probCritico,
			int dañoCritico, int nivel, int mana, String clase, Icon iconoJugador, Carta[] mazo) {
		super(nombre, vida, velocidad, ataque, defensa, bloqueo, probCritico, dañoCritico, nivel);
		this.mana = mana;
		this.clase = clase;
		this.iconoJugador = iconoJugador;
		Mazo = mazo;
	}

	

}
