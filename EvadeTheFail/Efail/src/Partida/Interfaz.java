package Partida;

import javax.swing.JOptionPane;

public class Interfaz {

	public static int menuInicial() {
		
		// Editar para convertir las opciones a botones
		
		boolean esCorrecto = false;
		String eleccion, mensaje = ("----------------BIENVENIDO----------------" + "\n\n" + "	0: PARTIDA RAPIDA\n\n"
				+ "	1: PARTIDA NUEVA\n\n" + " 2: CONTINUAR\n\n" + " 3: ANTIGUAS LEYENDAS\n\n"
				+ " 4: \"¡Eh, tú! ¿Acaso eres nuevo aquí?\"");
		do {

			eleccion = JOptionPane.showInputDialog(mensaje);

			if (eleccion.equals("0") || eleccion.equals("1") || eleccion.equals("2") || eleccion.equals("3")
					|| eleccion.equals("4")) {
				esCorrecto = true;
			}

		} while (!esCorrecto);

		return Integer.parseInt(eleccion);
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
		case 4:
			// Llamar al metodo necesario para explicar las funcionalidades de todos los
			// modos desde la perspectiva de un NPC
			break;
		default:

		}

	}

}
