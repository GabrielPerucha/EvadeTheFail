package Movimientos;

import java.util.ArrayList;
import java.util.Iterator;

import ClasesEntidades.Enemigo;
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

	public static void ejecutarCarta(Carta carta, Terreno terreno, int objetivo) {

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

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador()
								.setAtaque((int) (terreno.getJugador().getAtaque() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);

						terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "defensa":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador()
								.setDefensa((int) (terreno.getJugador().getDefensa() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);

						terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "vida":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador()
								.setVida((int) (terreno.getJugador().getVida() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);

						terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "vidaRestante":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador().setVidaRestante(
								(int) (terreno.getJugador().getVidaRestante() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

					} else {

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "manaRestante":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador().setManaRestante(
								(int) (terreno.getJugador().getManaRestante() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

					} else {

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "bloqueo":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador()
								.setBloqueo((int) (terreno.getJugador().getBloqueo() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);

						terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "probCritico":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador().setProbCritico(
								(int) (terreno.getJugador().getProbCritico() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);

						terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "danoCritico":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador().setDanoCritico(
								(int) (terreno.getJugador().getDanoCritico() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);

						terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "dano":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador().setVidaRestante(
								(int) (terreno.getJugador().getVidaRestante() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));


					} else {

						Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				// Este caso se trata de un efecto "trait" que pondría al jugador una etiqueta,
				// es un tipo de efecto especial por programar
				default:

					Efecto[] efectosEnJug = new Efecto[terreno.getEfectosEnJugador().length + 1];

					for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

						efectosEnJug[j] = terreno.getEfectosEnJugador()[j];

					}

					efectosEnJug[terreno.getEfectosEnJugador().length] = nfx.get(i);

				}

				// Si el objetivo del efecto es el enemigo
			} else {

				Enemigo enemigoAfectado;
				Efecto[] efectosDelEnemigo;

				switch (objetivo) {

				case 1:
					enemigoAfectado = terreno.getE1();
					efectosDelEnemigo = terreno.getEfectosEnEnemigo1();
					break;
				case 2:
					enemigoAfectado = terreno.getE2();
					efectosDelEnemigo = terreno.getEfectosEnEnemigo2();

					break;
				case 3:
					enemigoAfectado = terreno.getE3();
					efectosDelEnemigo = terreno.getEfectosEnEnemigo3();

					break;
				default:
					//Inicializar variables aquí para evitar que el programa pete
					enemigoAfectado = terreno.getE1();
					efectosDelEnemigo = terreno.getEfectosEnEnemigo1();
				}

				switch (nfx.get(i).getEstadistica()) {

				case "ataque":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado.setAtaque((int) (enemigoAfectado.getAtaque() * nfx.get(i).getMultiplicador()
								+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}

						efectosAux[efectosDelEnemigo.length] = nfx.get(i);

						efectosDelEnemigo = efectosAux;

					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
						
					}

					break;
				
				case "defensa":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado.setDefensa((int) (enemigoAfectado.getDefensa() * nfx.get(i).getMultiplicador()
								+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}

						efectosAux[efectosDelEnemigo.length] = nfx.get(i);

						efectosDelEnemigo = efectosAux;

					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
					}

					break;

				case "vida":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado.setVida((int) (enemigoAfectado.getVida() * nfx.get(i).getMultiplicador()
								+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}

						efectosAux[efectosDelEnemigo.length] = nfx.get(i);

						efectosDelEnemigo = efectosAux;

					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
					}

					break;

				case "vidaRestante":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado.setVidaRestante((int) (enemigoAfectado.getVidaRestante()
								+ enemigoAfectado.getVida() * nfx.get(i).getMultiplicador() + nfx.get(i).getSumador()));


					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
					}

					break;

				case "probCritico":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado
								.setProbCritico((int) (enemigoAfectado.getProbCritico() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}

						efectosAux[efectosDelEnemigo.length] = nfx.get(i);

						efectosDelEnemigo = efectosAux;

					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
					}

					break;

				case "danoCritico":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado
								.setDanoCritico((int) (enemigoAfectado.getDanoCritico() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}

						efectosAux[efectosDelEnemigo.length] = nfx.get(i);

						efectosDelEnemigo = efectosAux;

					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
					}

					break;

				case "dano":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado.setVidaRestante(
								(int) (enemigoAfectado.getVidaRestante() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
					}

					break;

				// Este caso se trata de un efecto "trait" que pondría al jugador una etiqueta,
				// es un tipo de efecto especial por programar
				default:

					Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

					for (int j = 0; j < efectosDelEnemigo.length; j++) {

						efectosAux[j] = efectosDelEnemigo[j];

					}

					efectosAux[efectosDelEnemigo.length] = nfx.get(i);

				}

				switch (objetivo) {

				case 1:
					terreno.setE1(enemigoAfectado);
					terreno.setEfectosEnEnemigo1(efectosDelEnemigo);
					break;
				case 2:
					terreno.setE1(enemigoAfectado);
					terreno.setEfectosEnEnemigo1(efectosDelEnemigo);

					break;
				case 3:
					terreno.setE1(enemigoAfectado);
					terreno.setEfectosEnEnemigo1(efectosDelEnemigo);

					break;
				
				default:
						

				}
			}

		}

		for (int i = 0; i < spfx.size(); i++) {

			Efecto efectosAux[] = spfx.get(i).getEfectos();

			Carta cartaAux = new Carta(-1, "CartaAuxiliar", spfx.get(i).getDescripcion(), carta.getElemento(), 0,
					carta.getClase(), efectosAux);

			/*
			 * Esta sentencia recursiva vuelve a llamar al metodo de ejecutar carta, que al
			 * principio separa los efectos especiales de los normales
			 */
			ejecutarCarta(cartaAux, terreno, objetivo);

		}

	}

}
