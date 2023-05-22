package Combate;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Movimientos.*;
import Partida.Interfaz;

//String[] opciones = new String[] {};

//int eleccion = JOptionPane.showOptionDialog(null, "Contenido", "Título", 0, 0, null, opciones, "Preseleccionado");

public class Combate {

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

	// Método terminado
	public static void inicioCombate(Enemigo NPC) {

		JOptionPane.showMessageDialog(null, "¡Ha aparecido un " + NPC.getNombre() + " de nivel " + NPC.getNivel() + "!",
				"¡Encuentro!", 0, NPC.getIconoEnemigo());

	}

	// Falta duplicar el método para que sea tolerable a dos o tres enemigos.
	public static void menuCombate(Jugable jugador, Enemigo NPC) {

		boolean finCombate = false;
		Carta[] mazoAux, mano;

		Terreno terreno = new Terreno(null, null, null, null, jugador, NPC);

		terreno.setDescartes(new Carta[jugador.getMazo().length]);
		terreno.setDestierro(new Carta[jugador.getMazo().length]);
		terreno.setMazoRestante(barajeo(jugador.getMazo()));

		do {

			int numCartas = 5;
			mano = new Carta[numCartas];
			
			/*
			 * Este complicado if-else se encarga de dos cosas. Repartir cartas que tiene el jugador y definir el mazo restante del turno.
			 * Para ello, si la longitud es mayor del numero de cartas que se roban el siguiente mazo se crea con esa longitud restada y sin las cartas
			 * robadas. En caso contrario se reciclan las cartas descartadas ya barajadas, se repone el mazo y la mano con las cartas restantes del mazo con 
			 * el paso intermedio de eliminar de descartes las cartas "recicladas". NO PROBADA
			 */
			
			if (terreno.getMazoRestante().length <= numCartas) {
				
				mazoAux = new Carta[terreno.getDescartes().length - terreno.getMazoRestante().length];
				
				for (int i = 0; i < terreno.getMazoRestante().length; i++) {
					mano[i] = terreno.getMazoRestante()[i];
					
				}

				for (int i = terreno.getMazoRestante().length-1; i < numCartas - terreno.getMazoRestante().length; i++ ) {
					mano[i] = terreno.getDescartes()[i];
				}
				
				for (int i = 0; i < mazoAux.length; i++ ) {
					mazoAux[i] = terreno.getDescartes()[i+terreno.getMazoRestante().length];
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

			String opciones[] = new String[terreno.getMano().length+2];
			ArrayList <Carta> cartasMano = new ArrayList<Carta>();
			
			
			for (int i = 0; i < opciones.length-2; i++) {

				opciones[i] = terreno.getMano()[i].getNombre();
				cartasMano.add(terreno.getMano()[i]);
				
			}
			
			opciones[opciones.length-2] = "Finalizar turno";
			opciones[opciones.length-1] = "?";
			

			int eleccion = JOptionPane.showOptionDialog(null, Interfaz.creaInterfazBatalla(jugador, NPC, terreno),
					"Combate contra " + NPC.getNombre(), 0, 0, null, opciones, "Preseleccionado");
			
			// Falta llevar a un JOption Pane con la ejecucion de cada eleccion
			
			Carta.ejecutarCarta(cartasMano.get(eleccion));
			
			terreno.setDescartes(barajeo(terreno.getDescartes()));

		} while (finCombate);

	}

}
