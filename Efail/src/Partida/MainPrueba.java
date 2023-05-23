package Partida;

import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Combate.*;
import Movimientos.*;

public class MainPrueba {

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

		int i = 7;
		double j = 1.5;
		int k = (int) (i*j);
		System.out.println(k);
		
	}

}