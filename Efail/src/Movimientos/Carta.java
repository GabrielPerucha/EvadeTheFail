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

				switch (nfx.get(i).getEstadistica()) {

				case "ataque":
					
					if(nfx.get(i).getRetardo()==0) {
						
						terreno.getJugador().setAtaque((int)(
							terreno.getJugador().getAtaque()*nfx.get(i).getMultiplicador() + nfx.get(i).getSumador()));
						
						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length+1];
						
						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {
							
							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];
							
						}
						
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i); 
						
						terreno.setEfectosEnJugador(efectosEnJug);
						
					} else {
						
						//RETARDO --
						
					}
					
					
					break;
					
				case "defensa":
					
					if(nfx.get(i).getRetardo()==0) {
						
						terreno.getJugador().setDefensa((int)(
							terreno.getJugador().getDefensa()*nfx.get(i).getMultiplicador() + nfx.get(i).getSumador()));
						
						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length+1];
						
						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {
							
							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];
							
						}
						
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i); 
						
						terreno.setEfectosEnJugador(efectosEnJug);
						
					} else {
						
						//RETARDO --
						
					}
					
					break;
					
				case "vida":
					
					if(nfx.get(i).getRetardo()==0) {
						
						terreno.getJugador().setVida((int)(
							terreno.getJugador().getVida()*nfx.get(i).getMultiplicador() + nfx.get(i).getSumador()));
						
						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length+1];
						
						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {
							
							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];
							
						}
						
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i); 
						
						terreno.setEfectosEnJugador(efectosEnJug);
						
					} else {
						
						//RETARDO --
						
					}
					
					
					break;
					
				case "vidaRestante":
					
					if(nfx.get(i).getRetardo()==0) {
						
						terreno.getJugador().setVidaRestante((int)(
							terreno.getJugador().getVidaRestante()*nfx.get(i).getMultiplicador() + nfx.get(i).getSumador()));
						
						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length+1];
						
						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {
							
							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];
							
						}
						
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i); 
						
						terreno.setEfectosEnJugador(efectosEnJug);
						
					} else {
						
						//RETARDO --
						
					}
					
					
					break;
					
				case "manaRestante":
					
					if(nfx.get(i).getRetardo()==0) {
						
						terreno.getJugador().setManaRestante((int)(
							terreno.getJugador().getManaRestante()*nfx.get(i).getMultiplicador() + nfx.get(i).getSumador()));
						
						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length+1];
						
						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {
							
							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];
							
						}
						
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i); 
						
						terreno.setEfectosEnJugador(efectosEnJug);
						
					} else {
						
						//RETARDO --
						
					}
					
					
					break;
					
				case "bloqueo":
					
					if(nfx.get(i).getRetardo()==0) {
						
						terreno.getJugador().setBloqueo((int)(
							terreno.getJugador().getBloqueo()*nfx.get(i).getMultiplicador() + nfx.get(i).getSumador()));
						
						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length+1];
						
						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {
							
							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];
							
						}
						
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i); 
						
						terreno.setEfectosEnJugador(efectosEnJug);
						
					} else {
						
						//RETARDO --
						
					}
					
					
					break;
					
				case "probCritico":
					
					if(nfx.get(i).getRetardo()==0) {
						
						terreno.getJugador().setProbCritico((int)(
							terreno.getJugador().getProbCritico()*nfx.get(i).getMultiplicador() + nfx.get(i).getSumador()));
						
						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length+1];
						
						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {
							
							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];
							
						}
						
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i); 
						
						terreno.setEfectosEnJugador(efectosEnJug);
						
					} else {
						
						//RETARDO --
						
					}
					
					
					break;
					
				case "danoCritico":
					
					if(nfx.get(i).getRetardo()==0) {
						
						terreno.getJugador().setDanoCritico((int)(
							terreno.getJugador().getDanoCritico()*nfx.get(i).getMultiplicador() + nfx.get(i).getSumador()));
						
						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length+1];
						
						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {
							
							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];
							
						}
						
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i); 
						
						terreno.setEfectosEnJugador(efectosEnJug);
						
					} else {
						
						//RETARDO --
						
					}
					
					
					break;
					
				case "dano":
					
					if(nfx.get(i).getRetardo()==0) {
						
						terreno.getJugador().setVidaRestante((int)(
							terreno.getJugador().getVidaRestante()*nfx.get(i).getMultiplicador() + nfx.get(i).getSumador()));
						
						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length+1];
						
						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {
							
							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];
							
						}
						
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i); 
						
						terreno.setEfectosEnJugador(efectosEnJug);
						
					} else {
						
						//RETARDO --
						
					}
					
					break;

				}

				// Si el objetivo del efecto es el enemigo
			} else {

			}

		}

		for (int i = 0; i < spfx.size(); i++) {

		}

	}

	// Falta la creación de las cartas y ver dónde se crean.

}
