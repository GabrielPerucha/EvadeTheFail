package ClasesEntidades;

import java.util.ArrayList;

import javax.swing.Icon;

import Combate.*;
import Efectos.*;
import Movimientos.*;

public class Enemigo extends Entidad {

	protected String elemento;
	protected String descripcion;
	protected Ataque[] ataques;
	protected Icon iconoEnemigo;
	protected Ataque siguienteAccion;
	protected int vidaRestante;

	public int getVidaRestante() {
		return vidaRestante;
	}

	public void setVidaRestante(int vidaRestante) {
		this.vidaRestante = vidaRestante;
	}

	public Ataque getSiguienteAccion() {
		return siguienteAccion;
	}

	public void setSiguienteAccion(Ataque siguienteAccion) {
		this.siguienteAccion = siguienteAccion;
	}

	public Icon getIconoEnemigo() {
		return iconoEnemigo;
	}

	public void setIconoEnemigo(Icon iconoEnemigo) {
		this.iconoEnemigo = iconoEnemigo;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Ataque[] getAtaques() {
		return ataques;
	}

	public void setAtaques(Ataque[] ataques) {
		this.ataques = ataques;
	}

	/*
	 * No se que coño le ha pasado al constructor para no hacer caso pero bueno, cambiando de esta forma los parámetros de entrada están como deberían haber estado siempre
	 */
	
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
	 * @param elemento
	 * @param descripcion
	 * @param ataques
	 * @param iconoEnemigo
	 * @param siguienteAccion
	 */
	public Enemigo(String nombre, int vida, int vidaRestante, int ataque, int defensa, int bloqueo, int probCritico,
			int danoCritico, int nivel, String elemento, String descripcion, Ataque[] ataques, Icon iconoEnemigo,
			Ataque siguienteAccion) {
		super(nombre, vida, ataque, defensa, bloqueo, probCritico, danoCritico, nivel);
		this.vidaRestante = vidaRestante;
		this.elemento = elemento;
		this.descripcion = descripcion;
		this.ataques = ataques;
		this.iconoEnemigo = iconoEnemigo;
		this.siguienteAccion = siguienteAccion;
	}

	/**
	 * 
	 * @param enemigo
	 * @param enemigoBase
	 */
	public static void ajustaParametros(Enemigo enemigo, Enemigo enemigoBase) {

		enemigo.setVida(enemigoBase.getVida() * enemigo.getNivel());
		enemigo.setVidaRestante(enemigo.getVida());
		enemigo.setAtaque(enemigoBase.getAtaque() * enemigo.getNivel());
		enemigo.setDefensa(enemigoBase.getDefensa() * enemigo.getNivel());

	}

	public static void ejecutarAtaque(Terreno terreno, int atacante) {

		Enemigo enemigo = new Enemigo("", 0, 0, 0, 0, 0, 0, 0, 0, "", "", null, null, null);
		Efecto [] efectosDelEnemigo = new Efecto[0];

		switch (atacante) {

		case 1:
			enemigo = terreno.getE1();
			efectosDelEnemigo = terreno.getEfectosEnEnemigo1();
			break;
		case 2:
			enemigo = terreno.getE2();
			efectosDelEnemigo = terreno.getEfectosEnEnemigo1();
			break;
		case 3:
			enemigo = terreno.getE3();
			efectosDelEnemigo = terreno.getEfectosEnEnemigo1();
			break;
		}

		// nfx = normal effects
		ArrayList<EfectoSobreEstadisticas> nfx = new ArrayList<EfectoSobreEstadisticas>();

		// spfx = special effects
		ArrayList<EfectoEspecial> spfx = new ArrayList<EfectoEspecial>();

		for (int i = 0; i < enemigo.getSiguienteAccion().getEfectos().length; i++) {

			/*
			 * El array de efectos de la carta almacena "Efecto", no
			 * "EfectoSobreEstadisticas" ni "EfectoEspecial". para poder llamarlos y ver su
			 * efecto real hubo que hacer dos arrayList y utilizar el try catch de if else.
			 * Si lanza una excepción es porque el cast no funcionó, por lo que no se trata
			 * de un EfectoSobreEstadisticas, sino de uno especial
			 */
			try {

				nfx.add((EfectoSobreEstadisticas) enemigo.getSiguienteAccion().getEfectos()[i]);

			} catch (Exception e) {

				spfx.add((EfectoEspecial) enemigo.getSiguienteAccion().getEfectos()[i]);

			}

		}

		// A partir de aquí sí ejecutamos los efectos como tal

		// Recorrer los efectos normales
		for (int i = 0; i < nfx.size(); i++) {

			// Si el objetivo del efecto es el atacante:
			if (nfx.get(i).isObjetivo()) {

				switch (nfx.get(i).getEstadistica()) {

				case "ataque":

					if (nfx.get(i).getRetardo() == 0) {

						enemigo
								.setAtaque((int) (enemigo.getAtaque() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

						//Eliminacion Semiautomatica

					} else {

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

					}

					break;

				case "defensa":

					if (nfx.get(i).getRetardo() == 0) {

						enemigo
								.setDefensa((int) (enemigo.getDefensa() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

						//Eliminacion Semiautomatica

					} else {

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

					}

					break;

				case "vida":

					if (nfx.get(i).getRetardo() == 0) {

						enemigo
								.setVida((int) (enemigo.getVida() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

						//Eliminacion Semiautomatica

					} else {

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

					}

					break;

				case "vidaRestante":

					if (nfx.get(i).getRetardo() == 0) {

						enemigo.setVidaRestante(
								(int) (enemigo.getVidaRestante() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

					} else {

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

					}

					break;

				case "bloqueo":

					if (nfx.get(i).getRetardo() == 0) {

						enemigo
								.setBloqueo((int) (enemigo.getBloqueo() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

						//Eliminacion Semiautomatica

					} else {

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

					}

					break;

				case "probCritico":

					if (nfx.get(i).getRetardo() == 0) {

						enemigo.setProbCritico(
								(int) (enemigo.getProbCritico() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

						//Eliminacion Semiautomatica

					} else {

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

					}

					break;

				case "danoCritico":

					if (nfx.get(i).getRetardo() == 0) {

						enemigo.setDanoCritico(
								(int) (enemigo.getDanoCritico() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

						//Eliminacion Semiautomatica

					} else {

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

					}

					break;

				case "dano":

					if (nfx.get(i).getRetardo() == 0) {

						enemigo.setVidaRestante(
								(int) (enemigo.getVidaRestante() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

					} else {

						Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosEnAtacante[j] = efectosDelEnemigo[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

					}

					break;

				// Este caso se trata de un efecto "trait" que pondría al jugador una etiqueta,
				// es un tipo de efecto especial por programar
				default:

					Efecto[] efectosEnAtacante = new Efecto[efectosDelEnemigo.length + 1];

					for (int j = 0; j < efectosDelEnemigo.length; j++) {

						efectosEnAtacante[j] = efectosDelEnemigo[j];

					}

					efectosEnAtacante[efectosDelEnemigo.length] = nfx.get(i);

				}
				
				switch (atacante) {

				case 1:
					terreno.setE1(enemigo);
					terreno.setEfectosEnEnemigo1(efectosDelEnemigo);
					break;
				case 2:
					terreno.setE2(enemigo);
					terreno.setEfectosEnEnemigo2(efectosDelEnemigo);
					break;
				case 3:
					terreno.setE3(enemigo);
					terreno.setEfectosEnEnemigo3(efectosDelEnemigo);
				}
				
				// Si el objetivo del efecto es el jugador
			} else {

				switch (nfx.get(i).getEstadistica()) {

				case "ataque":
					
					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador().setAtaque((int) (terreno.getJugador().getAtaque() * nfx.get(i).getMultiplicador()
								+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosAux[j] = terreno.getEfectosEnJugador()[j]; 
						}

						efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);

						terreno.setEfectosEnJugador(efectosAux);

					} else {

						Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosAux[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);

					}

					break;

				case "defensa":
					
					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador().setDefensa((int) (terreno.getJugador().getDefensa() * nfx.get(i).getMultiplicador()
								+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosAux[j] = terreno.getEfectosEnJugador()[j];

						}

						efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);

						terreno.setEfectosEnJugador(efectosAux);

					} else {

						Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosAux[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);
					}

					break;

				case "vida":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador().setVida((int) (terreno.getJugador().getVida() * nfx.get(i).getMultiplicador()
								+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosAux[j] = terreno.getEfectosEnJugador()[j];

						}

						efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);

						terreno.setEfectosEnJugador(efectosAux);

					} else {

						Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosAux[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);
					}

					break;

				case "vidaRestante":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador().setVidaRestante((int) (terreno.getJugador().getVidaRestante()
								+ terreno.getJugador().getVida() * nfx.get(i).getMultiplicador() + nfx.get(i).getSumador()));

					} else {

						Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosAux[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);
					}

					break;

				case "probCritico":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador()
								.setProbCritico((int) (terreno.getJugador().getProbCritico() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosAux[j] = terreno.getEfectosEnJugador()[j];

						}

						efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);

						terreno.setEfectosEnJugador(efectosAux);

					} else {

						Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosAux[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);
					}

					break;

				case "danoCritico":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador()
								.setDanoCritico((int) (terreno.getJugador().getDanoCritico() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosAux[j] = terreno.getEfectosEnJugador()[j];

						}

						efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);

						terreno.setEfectosEnJugador(efectosAux);

					} else {

						Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosAux[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);
					}

					break;

				case "dano":

					if (nfx.get(i).getRetardo() == 0) {

						terreno.getJugador().setVidaRestante(
								(int) (terreno.getJugador().getVidaRestante() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

					} else {

						Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

							efectosAux[j] = terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo() - 1);
						efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);
					}

					break;

				// Este caso se trata de un efecto "trait" que pondría al jugador una etiqueta,
				// es un tipo de efecto especial por programar
				default:

					Efecto[] efectosAux = new Efecto[terreno.getEfectosEnJugador().length + 1];

					for (int j = 0; j < terreno.getEfectosEnJugador().length; j++) {

						efectosAux[j] = terreno.getEfectosEnJugador()[j];

					}

					efectosAux[terreno.getEfectosEnJugador().length] = nfx.get(i);

				}

			}

		}

		for (int i = 0; i < spfx.size(); i++) {

			Efecto efectosAux[] = spfx.get(i).getEfectos();

			Ataque ataqueAux = new Ataque("", "AtaqueAuxiliar", enemigo.getSiguienteAccion().getProbabilidad(), enemigo.getSiguienteAccion().getPotencia(),
					efectosAux);

			switch (atacante) {

			case 1:
				terreno.getE1().setSiguienteAccion(ataqueAux);
				break;
			case 2:
				terreno.getE2().setSiguienteAccion(ataqueAux);
				break;
			case 3:
				terreno.getE3().setSiguienteAccion(ataqueAux);
			}
			
			/*
			 * Esta sentencia recursiva vuelve a llamar al metodo de ejecutar carta, que al
			 * principio separa los efectos especiales de los normales
			 */
			ejecutarAtaque(terreno, atacante);

		}

	}

}
