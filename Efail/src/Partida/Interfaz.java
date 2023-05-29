package Partida;

import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Combate.*;
import Efectos.*;
import Movimientos.*;

public class Interfaz {

	/**
	 * 
	 * @return
	 */
	public static int menuInicial() {

		// Editar para convertir las opciones a botones

		boolean esCorrecto = false, tutorialVisto = false;
		int eleccion;

		do {
			String[] botones;

			if (tutorialVisto) {

				botones = new String[] { "PARTIDA NUEVA", "PARTIDA RÁPIDA", "CONTINUAR", "ANTIGUAS LEYENDAS" };
			} else {

				botones = new String[] { "PARTIDA NUEVA", "PARTIDA RÁPIDA", "CONTINUAR", "ANTIGUAS LEYENDAS",
						"¡Eh, tú! ¿Acaso eres nuevo aquí?" };
			}

			eleccion = JOptionPane.showOptionDialog(null,
					"------------------------------------------------------------------------------------------------BIENVENIDO------------------------------------------------------------------------------------------------\n\n\n\n\n\n",
					"Evade the fail: Menú Principal", 0, 0, null, botones, "PARTIDA NUEVA");

			if (eleccion == 0 || eleccion == 1 || eleccion == 2 || eleccion == 3) {

				esCorrecto = true;

			} else if (eleccion == 4) {

				if (!tutorialVisto) {

					// Llamar al tutorial

					tutorialVisto = true;
				}
			} else {

			}
		} while (!esCorrecto);

		return eleccion;
	}

	/**
	 * 
	 * @param eleccion
	 */
	public static void seleccionador(int eleccion) {

		switch (eleccion) {
		case 0:
			// Llamar al metodo necesario para comenzar la partida rapida
			break;
		case 1:
			// Llamar al metodo necesario para comenzar la partida
			break;
		case 2:
			// Llamar al metodo necesario para ver los nombres de los jugadores que
			// terminaron el juego
			break;
		case 3:
			// Llamar al metodo necesario para comenzar la partida rapida
			break;
		default:

		}

	}

	public static boolean esStat(EfectoSobreEstadisticas efecto) {

		if (efecto.getEstadistica().equals("ataque") || efecto.getEstadistica().equals("defensa")
				|| efecto.getEstadistica().equals("bloqueo") || efecto.getEstadistica().equals("vida")
				|| efecto.getEstadistica().equals("probCritico") || efecto.getEstadistica().equals("danoCritico")
				|| efecto.getEstadistica().equals("vidaRestante") || efecto.getEstadistica().equals("manaRestante")) {

			return true;

		} else

			return false;
	}

	/**
	 * 
	 * @param jugador
	 * @param NPC
	 * @param Terreno.terreno
	 * @return
	 */
	public static String creaInterfazBatalla(Jugable jugador, Enemigo NPC) {

		String contenido = "", espacios1 = " ", espacios2 = "", espacios3 = " ";
		int longitudNombreJugador = jugador.getNombre().length();

		if (jugador.getNivel() < 9) {
			espacios1 = espacios1.concat(" ");
			espacios3 = espacios3.concat(" ");
		}
		if (jugador.getVida() < 3) {
			espacios3 = espacios3.concat("  ");
		}

		for (int i = 0; i < 25; i++) {

			espacios3 = espacios3.concat(" ");

		}

		espacios1 = espacios1.concat(espacios3);

		espacios3 = espacios3.concat(espacios3);

		for (int i = 0; i < 16 - jugador.getNombre().length(); i++) {

			espacios2 = espacios2.concat(" ");

		}

		contenido = "\n\n\n\nNv: " + jugador.getNivel() + " " + jugador.getNombre() + espacios2 + espacios1
				+ "          " + "Nv: " + NPC.getNivel() + " " + NPC.getNombre() + "\n\nHP: "
				+ Terreno.terreno.getJugador().getVidaRestante() + "/" + jugador.getVida() + espacios3
				+ Terreno.terreno.getE1().getVidaRestante() + "/" + NPC.getVida() + " " + NPC.getSiguienteAccion().getNombre()
				+ "\n" + "Maná: " + jugador.getMana() + "/" + jugador.getManaRestante() + "\n\n\n";

		return contenido;
	}

	/**
	 * 
	 * @param jugador
	 * @param NPC
	 * @param NPC2
	 * @param Terreno.terreno
	 * @return
	 */
	public static String creaInterfazBatalla(Jugable jugador, Enemigo NPC, Enemigo NPC2) {

		String contenido = "", espacios1 = " ", espacios2 = "", espacios3 = " ", espacios4 = "                  ";
		int longitudNombreJugador = jugador.getNombre().length();

		if (jugador.getNivel() < 9) {
			espacios1 = espacios1.concat(" ");
			espacios3 = espacios3.concat(" ");
		}
		if (jugador.getVida() < 3) {
			espacios3 = espacios3.concat("  ");
		}

		for (int i = 0; i < 25; i++) {

			espacios3 = espacios3.concat(" ");

		}

		espacios1 = espacios1.concat(espacios3);

		espacios3 = espacios3.concat(espacios3);

		for (int i = 0; i < 16 - jugador.getNombre().length(); i++) {

			espacios2 = espacios2.concat(" ");

		}

		contenido = "\n\n\n\nNv: " + jugador.getNivel() + " " + jugador.getNombre() + espacios2 + espacios1
				+ "          " + "Nv: " + NPC.getNivel() + " " + NPC.getNombre() + "\n\nHP: "
				+ Terreno.terreno.getJugador().getVidaRestante() + "/" + jugador.getVida() + espacios3 + NPC.getVidaRestante()
				+ "/" + NPC.getVida() + " " + NPC.getSiguienteAccion().getNombre() + "\n" + "Maná: " + jugador.getMana()
				+ "/" + jugador.getManaRestante() + "\n\n\n" + espacios4 + espacios3 + "Nv: " + NPC2.getNivel() + " "
				+ NPC2.getNombre() + "\n\n" + espacios4 + espacios3 + NPC.getVidaRestante() + "/" + NPC.getVida() + " "
				+ NPC.getSiguienteAccion().getNombre() + "\n\n\n\n";

		return contenido;
	}

	/**
	 * 
	 * @param jugador
	 * @param NPC
	 * @param NPC2
	 * @param NPC3
	 * @param Terreno.terreno
	 * @return
	 */
	public static String creaInterfazBatalla(Jugable jugador, Enemigo NPC, Enemigo NPC2, Enemigo NPC3) {

		String contenido = "", espacios1 = " ", espacios2 = "", espacios3 = " ", espacios4 = "                  ";
		int longitudNombreJugador = jugador.getNombre().length();

		if (jugador.getNivel() < 9) {
			espacios1 = espacios1.concat(" ");
			espacios3 = espacios3.concat(" ");
		}
		if (jugador.getVida() < 3) {
			espacios3 = espacios3.concat("  ");
		}

		for (int i = 0; i < 25; i++) {

			espacios3 = espacios3.concat(" ");

		}

		espacios1 = espacios1.concat(espacios3);

		espacios3 = espacios3.concat(espacios3);

		for (int i = 0; i < 16 - jugador.getNombre().length(); i++) {

			espacios2 = espacios2.concat(" ");

		}

		contenido = espacios4 + espacios3 + "Nv: " + NPC3.getNivel() + " " + NPC3.getNombre() + "\n\n" + espacios4
				+ espacios3 + NPC3.getVidaRestante() + "/" + NPC3.getVida() + " "
				+ NPC3.getSiguienteAccion().getNombre() + "\n\n\n\nNv: " + jugador.getNivel() + " "
				+ jugador.getNombre() + espacios2 + espacios1 + "          " + "Nv: " + NPC.getNivel() + " "
				+ NPC.getNombre() + "\n\nHP: " + Terreno.terreno.getJugador().getVidaRestante() + "/" + jugador.getVida()
				+ espacios3 + NPC.getVidaRestante() + "/" + NPC.getVida() + " " + NPC.getSiguienteAccion().getNombre()
				+ "\n" + "Maná: " + jugador.getMana() + "/" + jugador.getManaRestante() + "\n\n\n" + espacios4
				+ espacios3 + "Nv: " + NPC2.getNivel() + " " + NPC2.getNombre() + "\n\n" + espacios4 + espacios3
				+ NPC2.getVidaRestante() + "/" + NPC2.getVida() + " " + NPC2.getSiguienteAccion().getNombre()
				+ "\n\n\n\n";

		return contenido;
	}

	/**
	 * 
	 * @param efecto
	 * @param display
	 */
	public static String displayEfectos(EfectoSobreEstadisticas efecto) {

		String display = "";

		display = display + "\n" + efecto.getEstadistica();

		if (!esStat(efecto)) {
			display = display + " (Efecto especial)";
		} else if (efecto.getMultiplicador() < 1 || efecto.getSumador() < 0) {

			display = display + ("-");

		} else if (efecto.getMultiplicador() > 1 || efecto.getSumador() > 0) {

			display = display + ("+");

		}

		if (efecto.getRetardo() > 1 && efecto.getRetardo() != 0) {

			display = display + ("      en " + efecto.getRetardo() + " turnos");

		} else if (efecto.getRetardo() != 0) {

			display = display + ("      en " + efecto.getRetardo() + " turno");

		} else {

			display = display + ("      duración: " + efecto.getDuracion());

		}

		return display;

	}

	/**
	 * 
	 * @param carta
	 * @return
	 */
	public static String displayCarta(Carta carta) {

		String display = "";

		display = display + "\nNombre: " + carta.getNombre();

		display = display + "\nClase: " + carta.getClase();

		display = display + "\nCoste: " + carta.getCoste();

		display = display + "\nElemento: " + carta.getElemento();

		display = display + "\nEfectos: \n\n";

		for (int i = 0; i < carta.getEfectos().length; i++) {

			display = display + displayEfectos(Combate.castEfectos(carta.getEfectos())[i]);

		}

		display = display + "\n\n\n \"" + carta.getDescripcion() + "\"";

		return display;

	}

	/**
	 * 
	 * @param enemigo
	 * @param efectos
	 * @return
	 */
	public static String displayEnemigo(Enemigo enemigo, Efecto[] efectos) {

		String display = "";

		display = display + "\nNombre: " + enemigo.getNombre();

		display = display + "\nNivel: " + enemigo.getNivel();

		display = display + "\nVida: " + enemigo.getVidaRestante() + " / " + enemigo.getVida();

		display = display + "\n\nElemento: " + enemigo.getElemento();

		display = display + "\nAtaque: " + enemigo.getAtaque();

		display = display + "\nDefensa: " + enemigo.getDefensa();

		display = display + "\nBloqueo: " + enemigo.getBloqueo();

		display = display + "\n\nProbabilidad de crítico: " + enemigo.getProbCritico();

		display = display + "\n\nDaño crítico: " + enemigo.getDanoCritico();

		display = display + "\n\nSiguiente acción: \n -" + enemigo.getSiguienteAccion().getNombre() + "\n\n"
				+ enemigo.getSiguienteAccion().getDescripcion();

		display = display + "\nEfectos: \n\n";

		for (int i = 0; i < efectos.length; i++) {

			display = display + displayEfectos(Combate.castEfectos(efectos)[i]);

		}

		display = display + "\n\n\n \"" + enemigo.getDescripcion() + "\"";

		return display;
	}

	/**
	 * 
	 * @param Terreno.terreno
	 */
	public static void informacionGeneral() {

		String[] opciones = new String[] { "Estado", "Cartas", "Enemigos", "Atrás" };

		switch (JOptionPane.showOptionDialog(null, "-Creo que necesito pensarme mejor mi movimiento...",
				"Ventana de información: Selección", 0, 0, null, opciones, "Atrás")) {

		case 0:

			informacionJugador();
			informacionGeneral();
			break;

		case 1:

			informacionCartas();
			informacionGeneral();
			break;

		case 2:

			informacionEnemigo(0);
			informacionGeneral();
			break;

		case 3:

			break;

		default:

		}

	}

	/**
	 * 
	 * @param Terreno.terreno
	 */
	public static void informacionJugador() {

		int espaciosN = 16 - Terreno.terreno.getJugador().getNombre().length();
		String espaciosNombre = " ";

		for (int i = 0; i < espaciosN; i++) {
			espaciosNombre.concat(" ");
		}

		String efectos = "Efectos: ";

		EfectoSobreEstadisticas[] efJug = Combate.castEfectos(Terreno.terreno.getEfectosEnJugador());

		for (int i = 0; i < efJug.length; i++) {

			efectos = efectos + displayEfectos(efJug[i]) + "\n";

		}

		switch (JOptionPane.showOptionDialog(null,
				Terreno.terreno.getJugador().getNombre() + espaciosNombre + "Nv: " + Terreno.terreno.getJugador().getNivel() + "\n\n" +

						"Maná:                                          " + Terreno.terreno.getJugador().getMana() + "\n\n"
						+ "Ataque:                                       " + Terreno.terreno.getJugador().getAtaque() + "\n\n"
						+ "Defensa:                                     " + Terreno.terreno.getJugador().getDefensa() + "\n\n"
						+ "Bloqueo:                                      " + Terreno.terreno.getJugador().getBloqueo() + "\n\n"
						+ "Probabilidad de critico:           " + Terreno.terreno.getJugador().getAtaque() + "\n\n"
						+ "Daño crítico:                               " + Terreno.terreno.getJugador().getAtaque() + "\n\n\n\n"
						+

						efectos + "\n\n",
				Terreno.terreno.getJugador().getNombre() + " el " + Terreno.terreno.getJugador().getClase(), 0, 0, null,
				new String[] { "Efectos", "Atrás" }, espaciosNombre)) {

		case 0:

			informacionEfectos(efJug, 0);
			informacionJugador();
			break;

		default:

		}

	}

	/**
	 * 
	 * @param Terreno.terreno
	 */
	public static void informacionCartas() {

		String[] opciones = new String[] { "Mano", "Mazo", "En Espera",
				"Descartes (" + Terreno.terreno.getDescartes().length + ")",
				"Desterradas (" + Terreno.terreno.getDestierro().length + ")", "Atrás" };

		switch (JOptionPane.showOptionDialog(null, "-Voy a revisar dónde están mis cartas...",
				"Ventana de información de cartas: Selección", 0, 0, null, opciones, "Atrás")) {

		case 0:

			informacionMazo(Terreno.terreno.getMano(), 1);
			informacionCartas();
			break;

		case 1:

			informacionMazo(Terreno.terreno.getJugador().getMazo(), 1);
			informacionCartas();
			break;

		case 2:

			informacionMazo(Terreno.terreno.getMazoRestante(), 1);
			informacionCartas();
			break;

		case 3:

			informacionMazo(Terreno.terreno.getDescartes(), 1);
			informacionCartas();
			break;
			
		case 4:

			informacionMazo(Terreno.terreno.getDestierro(), 1);
			informacionCartas();
			break;
			
		

		default:

		}

	}

	/**
	 * 
	 * @param mazo
	 * @param posicionEnMazo
	 */
	public static void informacionMazo(Carta[] mazo, int posicionEnMazo) {

		String[] opciones = new String[3];

		opciones[0] = "<<";
		opciones[1] = "Atrás";
		opciones[2] = ">>";

		if (mazo.length == 0) {

			JOptionPane.showMessageDialog(null, "No hay cartas aquí...", "Vacío", 0);
			
		} else

			switch (JOptionPane.showOptionDialog(null,
					"\n\n\nPosicion: " + posicionEnMazo + "\n\n" + displayCarta(mazo[posicionEnMazo-1]) + "\n\n\n",
					"Carta nº " + mazo[posicionEnMazo-1].getID() + ", " + mazo[posicionEnMazo-1].getNombre(), 0, 0, null,
					opciones, "Atrás")) {

			case 0:

				if (posicionEnMazo == 1) {
					posicionEnMazo = mazo.length;
				}

				posicionEnMazo--;

				informacionMazo(mazo, posicionEnMazo);
				break;

			case 1:

				break;

			case 2:

				if (posicionEnMazo == mazo.length ) {
					posicionEnMazo = 0;
				}

				posicionEnMazo++;

				informacionMazo(mazo, posicionEnMazo);
				break;

			}

	}

	/**
	 * 
	 * @param Terreno.terreno
	 * @param puntero
	 */
	public static void informacionEnemigo(int puntero) {

		boolean e2 = true, e3 = true;

		// esto comprueba si hay un segunodo o un tercer enemigo
		try {

			Terreno.terreno.getE2();

		} catch (Exception e) {

			e2 = false;
			e3 = false;

		}

		try {

			Terreno.terreno.getE3();

		} catch (Exception e) {

			e3 = false;

		}

		String[] opciones = new String[3];

		opciones[0] = "<<";
		opciones[1] = "Atrás";
		opciones[2] = ">>";

		int eleccion = 0;

		if (puntero == 0) {

			eleccion = JOptionPane.showOptionDialog(null,
					displayEnemigo(Terreno.terreno.getE1(), Terreno.terreno.getEfectosEnEnemigo1()), Terreno.terreno.getE1().getNombre(), 0, 0,
					null, opciones, "Atrás");

			if (eleccion != 1)
				informacionEnemigo(0);

		}

		if (!e2) {

			if (eleccion != 1)
				informacionEnemigo(0);

		} else if (e2 && !e3) {

			if (eleccion != 1)
				eleccion = JOptionPane.showOptionDialog(null,
						displayEnemigo(Terreno.terreno.getE2(), Terreno.terreno.getEfectosEnEnemigo2()), Terreno.terreno.getE2().getNombre(), 0,
						0, null, opciones, "Atrás");

			if (eleccion != 1)
				informacionEnemigo(0);

		} else {

			if (puntero == 1) {

				eleccion = JOptionPane.showOptionDialog(null,
						displayEnemigo(Terreno.terreno.getE1(), Terreno.terreno.getEfectosEnEnemigo1()), Terreno.terreno.getE1().getNombre(), 0,
						0, null, opciones, "Atrás");

				if (eleccion == 0)
					informacionEnemigo(3);
				else if (eleccion == 2)
					informacionEnemigo(2);

			} else if (puntero == 2) {

				eleccion = JOptionPane.showOptionDialog(null,
						displayEnemigo(Terreno.terreno.getE2(), Terreno.terreno.getEfectosEnEnemigo2()), Terreno.terreno.getE2().getNombre(), 0,
						0, null, opciones, "Atrás");

				if (eleccion == 0)
					informacionEnemigo(1);
				else if (eleccion == 2)
					informacionEnemigo(3);

			} else if (puntero == 3) {

				eleccion = JOptionPane.showOptionDialog(null,
						displayEnemigo(Terreno.terreno.getE3(), Terreno.terreno.getEfectosEnEnemigo3()), Terreno.terreno.getE3().getNombre(), 0,
						0, null, opciones, "Atrás");

				if (eleccion == 0)
					informacionEnemigo(2);
				else if (eleccion == 2)
					informacionEnemigo(1);

			}

		}

	}

	/**
	 * 
	 * @param efectos
	 * @param pagina
	 */
	public static void informacionEfectos(EfectoSobreEstadisticas[] efectos, int pagina) {

		boolean modoPaginas = false, salir = false;

		int paginasTotales = efectos.length / 3;

		String[] opciones;

		if (efectos.length < 4) {

			opciones = new String[efectos.length];

			for (int i = 0; i < opciones.length; i++) {

				opciones[i] = displayEfectos(efectos[i]);

			}

		} else {

			modoPaginas = true;
			opciones = new String[6];
			if (efectos.length > (pagina + 1) * 3) {

				opciones[1] = displayEfectos(efectos[1 * (pagina + 1)]);
				opciones[2] = displayEfectos(efectos[2 * (pagina + 1)]);
				opciones[3] = displayEfectos(efectos[3 * (pagina + 1)]);

			} else {

				switch ((efectos.length - 3 * (pagina))) {

				case 1:

					opciones = new String[4];
					opciones[1] = displayEfectos(efectos[1]);

					break;

				case 2:

					opciones = new String[5];
					opciones[1] = displayEfectos(efectos[1]);
					opciones[2] = displayEfectos(efectos[2]);

					break;

				case 3:

					opciones = new String[6];
					opciones[1] = displayEfectos(efectos[1 * (pagina + 1)]);
					opciones[2] = displayEfectos(efectos[2 * (pagina + 1)]);
					opciones[3] = displayEfectos(efectos[3 * (pagina + 1)]);

					break;

				}

			}

			opciones[0] = "<<";
			opciones[opciones.length - 2] = ">>";
			opciones[opciones.length - 1] = "Atrás";

		}

		int eleccion = JOptionPane.showOptionDialog(null, "\n\n\n\nElige el efecto que quieras comprobar\n\n\n\n",
				"Selección de efectos: Página " + pagina, 0, 0, null, opciones, "Atrás");

		if (modoPaginas) {

			if (eleccion == 0) {

				if (pagina == 0) {

					pagina = paginasTotales + 1;

				}
				pagina--;

			} else if (eleccion == opciones.length - 2) {

				if (pagina == paginasTotales) {

					pagina = -1;

				}

				pagina++;

			} else if (eleccion == opciones.length - 1) {

				salir = true;

			} else if (esStat(efectos[eleccion])) {

				JOptionPane.showOptionDialog(null,
						efectos[eleccion].getEstadistica().toUpperCase() + "\nMultiplica por "
								+ efectos[eleccion].getMultiplicador() + "\nModifica directamente "
								+ efectos[eleccion].getSumador() + "\n\n" + "Dura " + efectos[eleccion].getDuracion()
								+ " turnos.\nTarda " + efectos[eleccion].getRetardo() + " turnos en activarse",
						displayEfectos(efectos[eleccion]), 0, 0, null, new String[] { "Atrás" }, "Atrás");

			} else {

				JOptionPane.showOptionDialog(null,
						efectos[eleccion].getEstadistica().toUpperCase() + "\nAplica la etiqueta "
								+ efectos[eleccion].getEstadistica() + "\nDura " + efectos[eleccion].getDuracion()
								+ " turnos.\nTarda " + efectos[eleccion].getRetardo() + " turnos en activarse",
						displayEfectos(efectos[eleccion]), 0, 0, null, new String[] { "Atrás" }, "Atrás");
			}
			if (!salir)
				informacionEfectos(efectos, pagina);
		}
	}

}
