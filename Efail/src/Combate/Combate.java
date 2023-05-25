package Combate;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Efectos.*;
import Movimientos.*;
import Partida.Interfaz;

//String[] opciones = new String[] {};

//int eleccion = JOptionPane.showOptionDialog(null, "Contenido", "Título", 0, 0, null, opciones, "Preseleccionado");

public class Combate {

	/*
	 * Hay dos metodos de dano, uno para cuando el jugador ataca y otro para cuando
	 * defiende. Esto se debe al equilibrio entre el jugador y los enemigos, para
	 * poder utilizar una escala de estadisticas lógica y reducir el dano que hace
	 * el enemigo al jugador.
	 */

	/**
	 * 
	 * @param objetivo
	 * @param atacante
	 * @return
	 */
	public static int formulaDano(Jugable atacante, Enemigo objetivo) {

		int total;

		total = atacante.getAtaque() * (atacante.getNivel() / (5 * objetivo.getNivel() + 1))
				+ (atacante.getAtaque() - objetivo.getDefensa()) - objetivo.getBloqueo();

		return total;

	}

	/**
	 * 
	 * @param atacante
	 * @param objetivo
	 * @return
	 */
	public static int formulaDanoRival(Enemigo atacante, Jugable objetivo) {

		int total;

		total = atacante.getAtaque() * (atacante.getNivel() / (7 * objetivo.getNivel() + 1))
				+ (atacante.getAtaque() - objetivo.getDefensa()) - objetivo.getBloqueo();

		return total;

	}

	/**
	 * 
	 * @param mazo
	 * @return
	 */
	public static Carta[] barajeo(Carta[] mazo) {

		Carta[] mazoAux = new Carta[mazo.length];
		int[] comprobados = new int[mazo.length];
		boolean estaRepartido = false;

		for (int i = 0; i < mazoAux.length; i++) {

			estaRepartido = false;

			int num = (int) (Math.random() * (mazo.length + 0.99));

			for (int j = 0; j < comprobados.length; j++) {

				if (num == comprobados[j]) {
					estaRepartido = true;

				}
			}

			if (!estaRepartido) {

				mazoAux[i] = mazo[num - 1];
				comprobados[i] = num;

			} else {

				i--;
			}

		}
		return mazoAux;

	}

	public static boolean puedeElegirRival(Carta carta) {

		boolean sePuedeElegirRival = false;

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

		for (int i = 0; i < spfx.size(); i++) {

			Efecto efectosAux[] = spfx.get(i).getEfectos();

			Carta cartaAux = new Carta(-1, "CartaAuxiliar", spfx.get(i).getDescripcion(), carta.getElemento(), 0,
					carta.getClase(), efectosAux);

			/*
			 * Esta sentencia recursiva vuelve a llamar al metodo de ejecutar carta, que al
			 * principio separa los efectos especiales de los normales
			 */

			if (puedeElegirRival(cartaAux))
				sePuedeElegirRival = true;

		}

		for (int i = 0; i < nfx.size(); i++) {

			if (!nfx.get(i).isObjetivo())
				sePuedeElegirRival = true;

		}

		return sePuedeElegirRival;

	}

	// Método terminado
	/**
	 * 
	 * @param NPC
	 */
	public static void inicioCombate(Enemigo NPC) {

		JOptionPane.showMessageDialog(null, "¡Ha aparecido un " + NPC.getNombre() + " de nivel " + NPC.getNivel() + "!",
				"¡Encuentro!", 0, NPC.getIconoEnemigo());

	}

	// Falta duplicar el método para que sea tolerable a dos o tres enemigos.
	/**
	 * 
	 * @param jugador
	 * @param NPC
	 */
	public static void menuCombate(Jugable jugador, Enemigo NPC) {

		EfectosEspeciales sp = new EfectosEspeciales();
		boolean finTurno = false, tiroCarta = false;
		Carta[] mazoAux, mano;

		Terreno terreno = new Terreno(null, null, null, null, null, null, null, null, jugador, NPC, NPC, NPC);

		terreno.setDescartes(new Carta[jugador.getMazo().length]);
		terreno.setDestierro(new Carta[jugador.getMazo().length]);
		terreno.setMazoRestante(barajeo(jugador.getMazo()));
		terreno.setEfectosEnJugador(new Efecto[] { sp.tesonDeGerrero });
		terreno.setEfectosEnEnemigo1(new Efecto[] { sp.tensionDeEnemigo });

		int numCartas = 5;

		int contadorDescarte = 0;

		mano = new Carta[numCartas];

		/*
		 * Este complicado if-else se encarga de dos cosas. Repartir cartas que tiene el
		 * jugador y definir el mazo restante del turno. Para ello, si la longitud es
		 * mayor del numero de cartas que se roban el siguiente mazo se crea con esa
		 * longitud restada y sin las cartas robadas. En caso contrario se reciclan las
		 * cartas descartadas ya barajadas, se repone el mazo y la mano con las cartas
		 * restantes del mazo con el paso intermedio de eliminar de descartes las cartas
		 * "recicladas". NO PROBADA
		 */

		if (terreno.getMazoRestante().length <= numCartas) {

			mazoAux = new Carta[terreno.getDescartes().length - terreno.getMazoRestante().length];

			for (int i = 0; i < terreno.getMazoRestante().length; i++) {
				mano[i] = terreno.getMazoRestante()[i];

			}

			for (int i = terreno.getMazoRestante().length; i < numCartas - terreno.getMazoRestante().length; i++) {
				mano[i] = terreno.getDescartes()[i];
			}

			for (int i = 0; i < mazoAux.length; i++) {
				mazoAux[i] = terreno.getDescartes()[i + terreno.getMazoRestante().length];
			}

			terreno.setDescartes(mazoAux);
			terreno.setMazoRestante(terreno.getDescartes());
			terreno.setDescartes(new Carta[] {});

		} else {

			mazoAux = new Carta[terreno.getMazoRestante().length - 5];

			for (int i = 0; i < mazoAux.length; i++) {
				mazoAux[i] = terreno.getMazoRestante()[i + 5];
				mano[i] = terreno.getMazoRestante()[i + 5];

			}

			terreno.setMazoRestante(mazoAux);

		}

		terreno.setMano(mano);

		do {

			String opciones[] = new String[terreno.getMano().length + 2];
			ArrayList<Carta> cartasMano = new ArrayList<Carta>();

			for (int i = 0; i < opciones.length - 2; i++) {

				opciones[i] = terreno.getMano()[i].getNombre();
				cartasMano.add(terreno.getMano()[i]);

			}

			opciones[opciones.length - 2] = "Finalizar turno";
			opciones[opciones.length - 1] = "?";

			do {

				int eleccionCarta = JOptionPane.showOptionDialog(null,
						Interfaz.creaInterfazBatalla(jugador, NPC, terreno), "Combate contra " + NPC.getNombre(), 0, 0,
						null, opciones, "?");

				int eleccionObjetivo;

				if (eleccionCarta == opciones.length - 2) {

					//TO DO FINALIZAR TURNO - - - - - - - -  - - - - -  - --  
					
					
					
					
				} else if (eleccionCarta == opciones.length - 1) {

					//"?" --------------------------------------------------------------------------------------------------------------------
					
					Interfaz.informacionGeneral(terreno, jugador);
					
				} else {

					if (puedeElegirRival(cartasMano.get(eleccionCarta))) {

						eleccionObjetivo = JOptionPane.showOptionDialog(null, "Elige un objetivo para tu carta",
								"Combate contra " + NPC.getNombre(), 0, 0, null,
								new String[] { "Atrás", NPC.getNombre() }, "Atrás");

						Carta.ejecutarCarta(cartasMano.get(eleccionCarta), terreno, eleccionObjetivo);

					} else {

						eleccionObjetivo = JOptionPane.showOptionDialog(null, "Elige un objetivo para tu carta",
								"Combate contra " + NPC.getNombre(), 0, 0, null, new String[] { "Atrás", "Tú" },
								"Atrás");

						if (eleccionObjetivo != 0) {
							Carta.ejecutarCarta(cartasMano.get(eleccionCarta), terreno, -1);
						}

					}

					if (eleccionObjetivo != 0) {

						// COMPROBAR SI LA CARTA SE DESTIERRA
						// ---------------------------------------------

						Carta[] descartesAux = new Carta[terreno.getDescartes().length + 1];

						for (int j = 0; j < terreno.getDescartes().length; j++) {

							descartesAux[j] = terreno.getDescartes()[j];

						}
						descartesAux[terreno.getDescartes().length] = cartasMano.get(eleccionCarta);

						cartasMano.remove(eleccionCarta);
						tiroCarta = true;
					}

				}

			} while (!tiroCarta);

			mano = new Carta[cartasMano.size()];

			for (int i = 0; i < cartasMano.size(); i++) {

				mano[i] = cartasMano.get(i);

			}

			terreno.setMano(mano);

			terreno.setDescartes(barajeo(terreno.getDescartes()));

		} while (!finTurno);

	}

}
