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
	protected int vidaRestante;
	
	public int getVidaRestante() {
		return vidaRestante;
	}

	public void setVidaRestante(int vidaRestante) {
		this.vidaRestante = vidaRestante;
	}

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

	/**
	 * 
	 * @param nombre
	 * @param nivel
	 * @param vida
	 * @param vidaRestante
	 * @param ataque
	 * @param defensa
	 * @param probCritico
	 * @param danoCritico
	 * @param bloqueo
	 * @param mana
	 * @param clase
	 * @param iconoJugador
	 * @param mazo
	 */
	public Jugable(String nombre, int nivel, int vida, int vidaRestante, int ataque, int defensa, int probCritico,
			int danoCritico, int bloqueo, int mana, String clase, Icon iconoJugador, Carta[] mazo) {
		super(nombre, vida, ataque, defensa, bloqueo, probCritico, danoCritico, nivel);
		this.vidaRestante = vidaRestante;
		this.mana = mana;
		this.clase = clase;
		this.iconoJugador = iconoJugador;
		Mazo = mazo;
	}

}
