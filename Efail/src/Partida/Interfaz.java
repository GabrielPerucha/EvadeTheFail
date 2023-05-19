package Partida;

import javax.swing.JOptionPane;

import ClasesEntidades.*;

public class Interfaz {

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

	public static String creaInterfazBatalla(Jugable jugador, Enemigo NPC) {

		String contenido = "", espacios1 = " ", espacios2 = "", espacios3=" ";
		int longitudNombreJugador = jugador.getNombre().length();

		if (jugador.getNivel() < 9) {
			espacios1 = espacios1.concat(" ");
			espacios3 = espacios3.concat(" ");
		}
		if (jugador.getVida() < 3) {
			espacios3 = espacios3.concat(" ");
		}
		
		for (int i = 0; i < 26; i++) {

			espacios3 = espacios3.concat(" ");

		}
		
		for (int i = 0; i < 16 - jugador.getNombre().length(); i++) {

			espacios2 = espacios2.concat(" ");

		}

		contenido = "\n\n\n\nNv: " + jugador.getNivel() + " " + jugador.getNombre() + espacios2 + espacios1 + "          "
				+ "Nv: "+NPC.getNivel()+ " " +NPC.getNombre() +"\n\nHP: " +jugador.getVida() + espacios3 + NPC.getVida()+" " +NPC.getSiguienteAccion();

		return contenido;
	}
	
	public static String creaInterfazBatalla(Jugable jugador, Enemigo NPC1, Enemigo NPC2, Enemigo NPC3) {

		String contenido = "", espacios1 = " ", espacios2 = "", espacios3=" ";
		int longitudNombreJugador = jugador.getNombre().length();

		if (jugador.getNivel() < 9) {
			espacios1 = espacios1.concat(" ");
			espacios3 = espacios3.concat(" ");
		}
		if (jugador.getVida() < 3) {
			espacios3 = espacios3.concat(" ");
		}
		
		for (int i = 0; i < 26; i++) {

			espacios3 = espacios3.concat(" ");

		}
		
		for (int i = 0; i < 16 - jugador.getNombre().length(); i++) {

			espacios2 = espacios2.concat(" ");

		}

		contenido = "\n\n\n\nNv: " + jugador.getNivel() + " " + jugador.getNombre() + espacios2 + espacios1 + "          "
				+ "Nv: "+NPC2.getNivel()+ " " +NPC2.getNombre() +"\n\nHP: " +jugador.getVida() + espacios3 + NPC2.getVida()+" " +NPC2.getSiguienteAccion();

		return contenido;
	}

}
