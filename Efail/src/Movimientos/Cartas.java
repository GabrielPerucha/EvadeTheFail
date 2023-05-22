package Movimientos;

import javax.swing.Icon;

import ClasesEntidades.*;
import Efectos.*;
import Combate.*;
import Partida.*;


public class Cartas {

	//	public Carta(int ID, String nombre, String descripcion, String elemento, int coste, String clase,
	//	EfectoSobreEstadisticas efecto1) 
	
	
	/*
	 * public Jugable(String nombre, int nivel, int vida, int vidaRestante, int ataque, int defensa, int velocidad, int probCritico,
			int dañoCritico, int bloqueo, int mana, String clase, Icon iconoJugador, Carta[] mazo) {
	 */
	Jugable jugador = new Jugable("Default", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null);
	Enemigo enemigo = new Enemigo("Default", 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
	Combate combate = new Combate();
	
	int id=0;

	
	//Cartas de ejemplo, una de ataque y una de defensa.
	
	Carta ofensa = new Carta(id++, "Ofensa", "Ataca con fiereza al rival\nDaño: " + Combate.formulaDaño(jugador, enemigo) + 1, "Neutro", 1, "Neutro", new daño(Combate.formulaDaño(jugador, enemigo), 1));
	Carta defensa = new Carta(id++, "Defensa", "Defiende la fiereza del rival\nBloqueo: " + jugador.getDefensa()/5 + 2, "Neutro", 1, "Neutro", new bloqueo((jugador.getDefensa()/5 + 2), 1));
	
	//Añadir más cartas
	//Pasable a otra clase si es necesario
	
	
	
}