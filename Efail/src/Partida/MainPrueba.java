package Partida;

import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Combate.*;
import Movimientos.*;

public class MainPrueba {
	static Ataque[] ataques = new Ataque[] { golpe };

	Cartas c = new Cartas();

	static Carta[] mazo = new Carta[] { Cartas.ofensa, c2, c3, c4, c5 };
	
	static Enemigo NPC1 = new Enemigo("Goblin", 20, 50, 40, 10, 20, 15, 0, 1, 5, "Agua", "Pruebadesc", ataques, null,
			ataques[0]);
	static Enemigo NPC2 = new Enemigo("Slime", 20, 50, 40, 10, 20, 15, 0, 1, 5, "Agua", "Pruebadesc", ataques, null,
			ataques[0]);
	static Enemigo NPC3 = new Enemigo("Wyvern", 20, 50, 40, 10, 20, 15, 0, 1, 5, "Agua", "Pruebadesc", ataques, null,
			ataques[0]);
	static Jugable jugador = new Jugable("Héroe", 60, 30, 20, 10, 30, 20, 0, 1, 5, 5, "Caballero", null, mazo);

	public static void main(String[] args) {

		/*
		 * public Jugable(String nombre, int vida, int velocidad, int ataque, int
		 * defensa, int bloqueo, int probCritico, int danoCritico, int nivel, int mana,
		 * String clase, Icon iconoJugador, Carta[] mazo) {
		 * 
		 */
		
		/*
		for (int i = 0; i < mazo.length; i++) {

			System.out.println(mazo[i].getNombre() + "\n");

		}

		mazo = Combate.barajeo(mazo);
		System.out.println();
		for (int i = 0; i < mazo.length; i++) {

			System.out.println(mazo[i].getNombre() + "\n");

		}
		*/
		
		//Combate.menuCombate(jugador, NPC1);
		//Combate.menuCombate(jugador, NPC1, NPC2);
		//Combate.menuCombate(jugador, NPC1, NPC2, NPC3);
		
		String opciones[] = new String[] {"[Carta 1]",};
		
		JOptionPane.showOptionDialog(null, "Contenido", "TÃ­tulo", 0, 0, null, opciones, "Preseleccionado");
		
	}

}