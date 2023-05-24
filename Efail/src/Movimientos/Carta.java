package Movimientos;

import java.util.ArrayList;
import java.util.Iterator;

import Combate.*;
import Efectos.*;

public class Carta extends Movimiento {

	// TO DO Creacion de cartas y establecer cuántas habrá y de que clase

	protected String elemento;
	protected int coste;
	protected String clase;
	protected int ID;
	protected Efecto[] efectos;

	public Efecto[] getEfectos() {
		return efectos;
	}

	public void setEfectos(Efecto[] efectos) {
		this.efectos = efectos;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	/**
	 * 
	 * @param ID
	 * @param nombre
	 * @param descripcion
	 * @param elemento
	 * @param coste
	 * @param clase
	 * @param efectos
	 */
	public Carta(int ID, String nombre, String descripcion, String elemento, int coste, String clase,
			Efecto[] efectos) {
		super(descripcion, nombre);
		this.ID = ID;
		this.efectos = efectos;
		this.elemento = elemento;
		this.coste = coste;
		this.clase = clase;
	}

	public static void ejecutarCarta(Carta carta, Terreno terreno) {

		// nfx = normal effects
		ArrayList<EfectoSobreEstadisticas> nfx = new ArrayList<EfectoSobreEstadisticas>();

		// spfx = special effects
		ArrayList<EfectoEspecial> spfx = new ArrayList<EfectoEspecial>();

		for (int i = 0; i < carta.getEfectos().length; i++) {

			/*
			 * El array de efectos de la carta almacena "Efecto", no
			 * "EfectoSobreEstadisticas" ni "EfectoEspecial". para poder llamarlos y ver su
			 * efecto real hubo que hacer dos arrayList y utilizar el try catch de if else.
			 * Si lanza una excepción es porque el cast no funcionó, por lo que no se trata
			 * de un EfectoSobreEstadisticas, sino de uno especial
			 */
			try {

				nfx.add((EfectoSobreEstadisticas) carta.getEfectos()[i]);

			} catch (Exception e) {

				spfx.add((EfectoEspecial) carta.getEfectos()[i]);

			}

		}

		// A partir de aquí sí ejecutamos los efectos como tal

		// Recorrer los efectos normales
		for (int i = 0; i < nfx.size(); i++) {

			// Si el objetivo del efecto eres tú:
			if (nfx.get(i).isObjetivo()) {

				if (terreno.getJugador().getClass().) {
					
				}
				
				nfx.get(i).getEstadistica();
				
				
				// Si el objetivo del efecto es el enemigo
			} else {
				
				
			}

		}

		for (int i = 0; i < spfx.size(); i++) {

		}

	}

	// Falta la creación de las cartas y ver dónde se crean.

}
